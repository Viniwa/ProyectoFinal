/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Vini
 */
public class Usuario {

    private static Usuario instance;
    private int id;
    private String correo;
    private String clave;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String ciudad;
    private String provincia;
    private int c_postal;
    private int telefono;
    
    private Usuario() {}
    
    public static synchronized Usuario getInstance() {
        if (instance == null) {
            instance = new Usuario();
        }
        return instance;
    }

    public Usuario(int id, String correo, String clave, String nombre, String apellidos, String direccion, String ciudad, String provincia, int c_postal, int telefono) {
        //correo, nombre, apellidos, direccion, ciudad, provincia, c_postal, telefono

        this.id = id;
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.c_postal = c_postal;
        this.telefono = telefono;

    }

    public int getId() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getC_postal() {
        return c_postal;
    }

    public void setC_postal(int c_postal) {
        this.c_postal = c_postal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
