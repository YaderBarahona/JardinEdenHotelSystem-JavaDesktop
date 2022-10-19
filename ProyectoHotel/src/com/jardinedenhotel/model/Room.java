/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.model;

/**
 *
 * @author Yader Jr
 */
public class Room {

    private int id_habitacion;
    private String descripcion;
    private byte[] imagen;
    private int ninios, adultos;
    private double precio_dia;
    private String estado;

    public Room() {
    }

    public Room(int id_habitacion, String descripcion, byte[] imagen, int ninios, int adultos, double precio_dia, String estado) {
        this.id_habitacion = id_habitacion;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.ninios = ninios;
        this.adultos = adultos;
        this.precio_dia = precio_dia;
        this.estado = estado;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getNinios() {
        return ninios;
    }

    public void setNinios(int ninios) {
        this.ninios = ninios;
    }

    public int getAdultos() {
        return adultos;
    }

    public void setAdultos(int adultos) {
        this.adultos = adultos;
    }

    public double getPrecio_dia() {
        return precio_dia;
    }

    public void setPrecio_dia(double precio_dia) {
        this.precio_dia = precio_dia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Room{" + "id_habitacion=" + id_habitacion + ", descripcion=" + descripcion + ", imagen=" + imagen + ", ninios=" + ninios + ", adultos=" + adultos + ", precio_dia=" + precio_dia + ", estado=" + estado + '}';
    }

}
