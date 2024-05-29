package TA22_MVC.Models;

import java.util.Date;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private int dni;
    private Date fecha;

    public Cliente(int id, String nombre, String apellido, String direccion, int dni, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.fecha = fecha;
    }

    public Cliente(String nombre, String apellido, String direccion, int dni, Date fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.fecha = fecha;
    }
    
    public Cliente() {
        // Lógica del constructor
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
