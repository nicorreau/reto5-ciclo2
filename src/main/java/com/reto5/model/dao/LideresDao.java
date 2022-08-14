package com.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reto5.model.vo.Lideres;
import com.reto5.util.JDBCUtilities;

public class LideresDao {
    public List<Lideres> listar() throws SQLException {
        List<Lideres> respuesta = new ArrayList<Lideres>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = 
                "SELECT ID_Lider,Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider l ORDER BY Ciudad_Residencia ASC";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery (consulta);
            while(rs.next()){
                Lideres objeto = new Lideres();
                objeto.setId(rs.getInt("ID_Lider"));
                objeto.setNombre(rs.getString("nombre"));
                objeto.setApellido(rs.getString("Primer_Apellido"));
                objeto.setCiudadResidencia(rs.getString("Ciudad_Residencia"));       
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
