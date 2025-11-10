package app;

// Importamos las clases del paquete "model" para poder usarlas
import model.Direccion;
import model.Empleado;
import model.Persona;

/**
 * Clase principal para probar el modelo de Salmontt.
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando sistema de Salmontt...");
        System.out.println("---------------------------------");

        // 1. Creamos las direcciones
        Direccion dirEmpleado1 = new Direccion("Los Alerces", "123", "Puerto Montt");
        Direccion dirEmpleado2 = new Direccion("Av. Principal", "456", "Valdivia");
        Direccion dirGerente = new Direccion("Costanera", "789", "Puerto Varas");

        // 2. Creamos 3 instancias de objetos
        // (Usamos la clase Empleado que hereda de Persona)
        Empleado empleado1 = new Empleado(
                "11.111.111-1",
                "Juan",
                "Perez",
                dirEmpleado1,
                "E-001",
                "Operario de Cultivo"
        );

        Empleado empleado2 = new Empleado(
                "22.221.222-2",
                "Maria",
                "Gonzalez",
                dirEmpleado2,
                "E-002",
                "Analista de Calidad"
        );

        // También podemos crear una 'Persona' que no sea 'Empleado' (ej. un proveedor)
        // aunque el ejercicio pide 'Empleado', esto es para mostrar la flexibilidad.
        // Usemos un tercer Empleado para ser consistentes.
        Empleado gerente = new Empleado(
                "8.888.888-8",
                "Ricardo",
                "Aros",
                dirGerente,
                "G-001",
                "Gerente de Operaciones"
        );


        // 3. Mostramos los datos por consola [cite: 50, 51]
        System.out.println("Datos del Empleado 1:");
        System.out.println(empleado1.toString());
        System.out.println(""); // Espacio

        System.out.println("Datos del Empleado 2:");
        System.out.println(empleado2.toString());
        System.out.println(""); // Espacio

        System.out.println("Datos del Gerente:");
        System.out.println(gerente.toString());
        System.out.println("---------------------------------");

        // Prueba de Getters y Setters
        System.out.println("Actualizando cargo del Empleado 1...");
        empleado1.setCargo("Supervisor de Cultivo");
        System.out.println("Nuevo cargo: " + empleado1.getCargo());
        System.out.println(empleado1.toString());
    }
}