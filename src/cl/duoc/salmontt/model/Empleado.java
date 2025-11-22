package cl.duoc.salmontt.model;

/**
 * Clase que hereda de Persona.
 * Representa un Empleado de Salmontt.
 */
public class Empleado extends Persona {

    // Atributos propios de Empleado
    private String idEmpleado;
    private String cargo;

    /**
     * Constructor que incluye los atributos de la clase padre (Persona).
     * Llama al constructor de Persona usando "super()".
     */
    public Empleado(String rut, String nombre, String apellido, Direccion direccion, String idEmpleado, String cargo) {
        // "super" llama al constructor de la clase padre (Persona)
        super(rut, nombre, apellido, direccion);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
    }

    // Getters y Setters para atributos propios
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Sobrescribimos toString() para incluir la info del Empleado
    // y reutilizamos el toString() de Persona con "super.toString()"
    @Override
    public String toString() {
        return "Empleado [" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", datos=" + super.toString() + // Llama al toString() de Persona
                ']';
    }
}