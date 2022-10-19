/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.model;

/**
 *
 * @author Yader Jr
 */
public class RegisterRoom {

    private int id_renta;
    private String fecha_actual;
    private int id_cliente;
    private int id_habitacion;
    private String forma_pago;
    private int ocupantes_adultos;
    private int ocupantes_ninios;
    private String fecha_inicial;
    private String fecha_final;
    private int numero_dias_hospedaje;
    private double subtotal;
    private String descuento;
    private double total;
    private String estado;

    public RegisterRoom() {
    }

    public RegisterRoom(int id_renta, String fecha_actual, int id_cliente, int id_habitacion, String forma_pago, int ocupantes_adultos, int ocupantes_ninios, String fecha_inicial, String fecha_final, int numero_dias_hospedaje, double subtotal, String descuento, double total, String estado) {
        this.id_renta = id_renta;
        this.fecha_actual = fecha_actual;
        this.id_cliente = id_cliente;
        this.id_habitacion = id_habitacion;
        this.forma_pago = forma_pago;
        this.ocupantes_adultos = ocupantes_adultos;
        this.ocupantes_ninios = ocupantes_ninios;
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
        this.numero_dias_hospedaje = numero_dias_hospedaje;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
        this.estado = estado;
    }

    public int getId_renta() {
        return id_renta;
    }

    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }

    public String getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(String fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public int getOcupantes_adultos() {
        return ocupantes_adultos;
    }

    public void setOcupantes_adultos(int ocupantes_adultos) {
        this.ocupantes_adultos = ocupantes_adultos;
    }

    public int getOcupantes_ninios() {
        return ocupantes_ninios;
    }

    public void setOcupantes_ninios(int ocupantes_ninios) {
        this.ocupantes_ninios = ocupantes_ninios;
    }

    public String getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(String fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getNumero_dias_hospedaje() {
        return numero_dias_hospedaje;
    }

    public void setNumero_dias_hospedaje(int numero_dias_hospedaje) {
        this.numero_dias_hospedaje = numero_dias_hospedaje;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "RegisterRoom{" + "id_renta=" + id_renta + ", fecha_actual=" + fecha_actual + ", id_cliente=" + id_cliente + ", id_habitacion=" + id_habitacion + ", forma_pago=" + forma_pago + ", ocupantes_adultos=" + ocupantes_adultos + ", ocupantes_ninios=" + ocupantes_ninios + ", fecha_inicial=" + fecha_inicial + ", fecha_final=" + fecha_final + ", numero_dias_hospedaje=" + numero_dias_hospedaje + ", subtotal=" + subtotal + ", descuento=" + descuento + ", total=" + total + ", estado=" + estado + '}';
    }

}
