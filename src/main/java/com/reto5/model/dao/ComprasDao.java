package com.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.JDBC;

import com.reto5.model.vo.Compras;
import com.reto5.util.JDBCUtilities;

public class ComprasDao {
    public List<Compras> listar() throws SQLException {
        List<Compras> respuesta = new ArrayList<Compras>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = 
                //"SELECT ID_Compra as id, p.Constructora, p.Banco_Vinculado as banco FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
                "SELECT ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c INNER JOIN Proyecto p ON c.ID_Proyecto =p.ID_Proyecto WHERE p.Ciudad ='Salento' AND c.Proveedor ='Homecenter'";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery (consulta);
            while(rs.next()){
                Compras objeto = new Compras();
                objeto.setId(rs.getInt("ID_Compra"));
                objeto.setConstructora(rs.getString("Constructora"));
                objeto.setBancoVinculado(rs.getString("Banco_Vinculado"));
                respuesta.add(objeto);
            }


        } finally {
            if (rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn !=null){
                conn.close();
            } 
        }
        return respuesta;
    }
}
