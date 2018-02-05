package com.example.paco.projecte_integrat.Model;

/**
 * Created by Paco on 05/02/2018.
 */

public class Usuario {

    private String nombreUsuario, correo, nombre, apellidos;


    public Usuario(String nombreUsuario, String correo, String nombre, String apellidos) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
