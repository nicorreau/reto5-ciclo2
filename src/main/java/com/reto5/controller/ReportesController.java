package com.reto5.controller;

import java.sql.SQLException;
import java.util.List;

import com.reto5.model.dao.ComprasDao;
import com.reto5.model.dao.LideresDao;
import com.reto5.model.dao.ProyectosDao;
import com.reto5.model.vo.Compras;
import com.reto5.model.vo.Lideres;
import com.reto5.model.vo.Proyectos;

public class ReportesController {
    private ProyectosDao proyectosDao;
    private LideresDao lideresDao;
    private ComprasDao comprasDao;


    public ReportesController () {
        proyectosDao = new ProyectosDao();
        lideresDao = new LideresDao();
        comprasDao = new ComprasDao();
    }

    //METODOS PARA COMPRAS, LIDERES Y PROYECTOS

    public List <Compras> listarCompras() throws SQLException {
        return comprasDao.listar();
        }

    public List<Lideres> listarLideres() throws SQLException {
        return lideresDao.listar();  
    }
    
    public List <Proyectos> listarProyectos() throws SQLException { 
        return proyectosDao.listar();
    }
}


