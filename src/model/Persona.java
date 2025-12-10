package model;

public class Persona {

    protected String rut;
    protected String nombre;
    protected String apellido;
    protected Direccion direccion;

    public Persona(String rut, String nombre, String apellido, Direccion direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    // Método útil para mostrar el nombre completo en el reporte
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Getters y Setters básicos
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return "RUT: " + rut + " | Nombre: " + getNombreCompleto();
    }
}