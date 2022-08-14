package com.reto5.view;

import com.reto5.controller.*;
import java.util.List;

import com.reto5.model.vo.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;


public class ReportesView extends JFrame implements ActionListener{
    private static ReportesController controller;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem primerInf, segundoInf, tercerInf;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;


    public ReportesView(){
        controller = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
    }

    public void tabla(){
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500,200));
        add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);   
    }

    public void etiqueta1(){
        lblTitulo = new JLabel("* *******  CONSULTAS RETO 5 ********* *\n");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial black", Font.BOLD, 20));
        add(lblTitulo);
    }
    public void etiqueta2(){
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new Dimension(500, 30)); 
        lblConsulta.setFont(new Font("Arial black", Font.BOLD, 16));
        add(lblConsulta);
    }

    public void menu(){
        menuBar = new JMenuBar();   
        setJMenuBar(menuBar);
        menu = new JMenu("Informes");
        menuBar.add(menu);
        primerInf = new JMenuItem("Primer informe");
        segundoInf = new JMenuItem("Segundo informe");
        tercerInf = new JMenuItem("Tercer informe");
        menu.add(primerInf);
        menu.add(segundoInf);
        menu.add(tercerInf);
        primerInf.addActionListener(this);
        segundoInf.addActionListener(this);
        tercerInf.addActionListener(this);
    }

    
    public void segundoInforme() {
            try{
                List<Proyectos> proyectos = controller.listarProyectos();
                modelo = new DefaultTableModel();
                modelo.addColumn("Id proyecto");
                modelo.addColumn("Constructora");
                modelo.addColumn("Habitaciones");
                modelo.addColumn("Ciudad");
                for(Proyectos proyecto: proyectos){
                    Object[] fila = new Object[4];
                    fila[0]= proyecto.getId();
                    fila[1]= proyecto.getConstructora();
                    fila[2]= proyecto.getNumeroHabitaciones();
                    fila[3]= proyecto.getCiudad();   
                    modelo.addRow(fila);                 
                }
                tabla.setModel(modelo);
                modelo.fireTableDataChanged();
                
            }
            catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        
    }
    public void tercerInforme() {
            try{
                List<Compras> compras = controller.listarCompras();
                modelo = new DefaultTableModel();
                modelo.addColumn("Id compra");
                modelo.addColumn("Constructora");
                modelo.addColumn("Banco Vinculado");
                
                for(Compras compra: compras){
                    Object[] fila = new Object[4];
                    fila[0]= compra.getId();
                    fila[1]= compra.getConstructora();
                    fila[2]= compra.getBancoVinculado();
                    modelo.addRow(fila);                 
                }
                tabla.setModel(modelo);
                modelo.fireTableDataChanged();
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        
    }
    public void primerInforme() {
        try{
            List<Lideres> lideres = controller.listarLideres();
            //Creeación del modelo:
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Lider");
            modelo.addColumn("Nombre ");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for(Lideres lider: lideres){
                Object[] fila = new Object[4];
                fila[0]= lider.getId();
                fila[1]= lider.getNombre();
                fila[2]= lider.getApellido();   
                fila[3]= lider.getCiudadResidencia();
                modelo.addRow(fila);                 
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); //actualizo el modelo de la tabla
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == primerInf){
                primerInforme();
                lblConsulta.setText(" Consulta de líderes");
            }
            if(e.getSource() == segundoInf){
                segundoInforme();
                lblConsulta.setText("Consulta de proyectos");
            }
            if(e.getSource() == tercerInf){
                tercerInforme();
                lblConsulta.setText("Consulta de compras");
            }
    }
}