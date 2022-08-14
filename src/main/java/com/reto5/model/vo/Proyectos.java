package com.reto5.model.vo;

public class Proyectos {
    private Integer id;
    private String constructora;
    private Integer numeroHabitaciones;
    private String ciudad;
    
    //GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getConstructora() {
        return constructora;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }
    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
}
