package model;

// 1. Implementamos la interfaz obligatoria
public class Empleado extends Persona implements Registrable {

    private String cargo;
    private double salario; // Nuevo campo que pide el menú

    // 2. Constructor que calza exacto con el MenuGUI
    public Empleado(String rut, String nombre, String apellido, Direccion direccion, String cargo, double salario) {
        super(rut, nombre, apellido, direccion);
        this.cargo = cargo;
        this.salario = salario;
    }

    // 3. Método obligatorio de la Interfaz
    @Override
    public void mostrarResumen() {
        System.out.println(">>> FICHA EMPLEADO <<<");
        System.out.println("Nombre: " + getNombreCompleto());
        System.out.println("RUT: " + this.rut);
        System.out.println("Cargo: " + this.cargo);
        System.out.println("Sueldo: $" + this.salario);
        System.out.println("Dirección: " + this.direccion.toString());
        System.out.println("-------------------------");
    }

    // Getters
    public String getCargo() { return cargo; }
    public double getSalario() { return salario; }
}