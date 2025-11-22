package cl.duoc.salmontt.model;

/**
 * Clase Base que representa una Persona.
 * Contiene un objeto Direccion (Composición).
 */
public class Persona {

    // Atributos encapsulados (private) [cite: 43]
    private String rut;
    private String nombre;
    private String apellido;
    private Direccion direccion; // Composición

    // Constructor [cite: 46]
    public Persona(String rut, String nombre, String apellido, Direccion direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    // Getters y Setters [cite: 44]
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // Método toString() [cite: 45]
    @Override
    public String toString() {
        return "Persona [" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + ' ' + apellido + '\'' +
                ", direccion=" + direccion.toString() + // Llama al toString() de Direccion
                ']';
    }
}