package com.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reto5.model.vo.Proyectos;
import com.reto5.util.JDBCUtilities;

public class ProyectosDao {
    public List<Proyectos> listar() throws SQLException {
        List<Proyectos> respuesta = new ArrayList<Proyectos>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = 
                "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto p WHERE Ciudad IN('Santa Marta', 'Cartagena', 'Barranquilla') AND Clasificacion ='Casa Campestre'";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery (consulta);
            while(rs.next()){
                Proyectos objeto = new Proyectos();
                objeto.setId(rs.getInt("ID_Proyecto"));
                objeto.setConstructora(rs.getString("constructora"));
                objeto.setCiudad(rs.getString("ciudad"));
                objeto.setNumeroHabitaciones(rs.getInt("Numero_Habitaciones"));
                
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
