/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Equipo {

    private int id;
    private String nombre;
    private String modelo;
    private String marca;
    private String numeroSerie;
    private String color;

    public Equipo(int id, String nombre, String modelo, String marca, String numeroSerie, String color) {
        this.id=id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.color = color;
    }
    
    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
     
    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }
    
}
