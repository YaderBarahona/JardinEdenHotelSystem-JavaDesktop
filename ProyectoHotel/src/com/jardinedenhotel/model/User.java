/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jardinedenhotel.model;

/**
 *
 * @author Estudiantes UNA
 */
public class User {

    int id_usuario;
    String nombre;
    String username;
    String password;
    String email;
    int telefono;
    String estado;
    String registrado_por;
    String permisos;

    public User() {
    }

    public User(int id_usuario, String nombre, String username, String password, String email, int telefono, String estado, String registrado_por, String permisos) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.registrado_por = registrado_por;
        this.permisos = permisos;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegistrado_por() {
        return registrado_por;
    }

    public void setRegistrado_por(String registrado_por) {
        this.registrado_por = registrado_por;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return "Users{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", username=" + username + ", password=" + password + ", email=" + email + ", telefono=" + telefono + ", estado=" + estado + ", registrado_por=" + registrado_por + ", permisos=" + permisos + '}';
    }

}
