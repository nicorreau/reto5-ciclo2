package com.reto5;

import javax.swing.JFrame;

import com.reto5.view.ReportesView;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReportesView reportesView = new ReportesView();
        reportesView.setLayout(new FlowLayout());
        reportesView.setSize(600, 400);
        reportesView.setVisible(true);
        reportesView.setResizable(false);
        reportesView.setTitle("Informes - Reto 5");
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView.setLocationRelativeTo(null); //ubica la ventana en el centro de la pantalla 
    }
}

