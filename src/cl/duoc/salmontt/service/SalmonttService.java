package cl.duoc.salmontt.service;

// Importamos las clases del modelo que vamos a utilizar
import cl.duoc.salmontt.model.Direccion;
import cl.duoc.salmontt.model.Empleado;

// Importamos las librerías necesarias de Java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase SalmonttService
 * * Esta clase actúa como una "librería personalizada" para gestionar la lógica de negocio.
 * Cumple con los requisitos de la evaluación:
 * 1. Uso de Colecciones (ArrayList).
 * 2. Lectura de archivos (BufferedReader).
 * 3. Manejo de excepciones (try-catch).
 */
public class SalmonttService {

    // Atributo: Lista dinámica para guardar los empleados en memoria.
    // Usamos List (interfaz) y ArrayList (implementación).
    private List<Empleado> listaEmpleados;

    // Constructor: Inicializa la lista vacía al crear el servicio.
    public SalmonttService() {
        this.listaEmpleados = new ArrayList<>();
    }

    /**
     * Método para cargar datos desde un archivo CSV o TXT.
     * Lee el archivo línea por línea, crea objetos y los añade a la lista.
     * * @param nombreArchivo El nombre o ruta del archivo a leer (ej: "empleados.csv")
     */
    public void cargarDatosDesdeArchivo(String nombreArchivo) {
        System.out.println(">>> Iniciando carga de datos desde: " + nombreArchivo);

        // Estructura 'try-with-resources': Cierra el archivo automáticamente al terminar o si falla.
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            // Ciclo while: Lee mientras existan líneas en el archivo (no sean null)
            while ((linea = br.readLine()) != null) {

                // Separamos la línea por comas (formato CSV)
                // Formato esperado: RUT,Nombre,Apellido,Calle,Numero,Ciudad,ID,Cargo
                String[] datos = linea.split(",");

                // Validamos que la línea tenga exactamente 8 datos antes de procesar
                if (datos.length == 8) {
                    // Paso 1: Crear el objeto Dirección (Composición)
                    // .trim() elimina espacios en blanco accidentales al inicio o final
                    Direccion dir = new Direccion(
                            datos[3].trim(), // Calle
                            datos[4].trim(), // Número
                            datos[5].trim()  // Ciudad
                    );

                    // Paso 2: Crear el objeto Empleado usando la dirección creada
                    Empleado emp = new Empleado(
                            datos[0].trim(), // Rut
                            datos[1].trim(), // Nombre
                            datos[2].trim(), // Apellido
                            dir,             // Objeto Dirección
                            datos[6].trim(), // ID Empleado
                            datos[7].trim()  // Cargo
                    );

                    // Paso 3: Guardar el empleado en la colección
                    listaEmpleados.add(emp);
                }
            }
            // Mensaje de éxito
            System.out.println(">>> Carga exitosa. Se cargaron " + listaEmpleados.size() + " empleados en memoria.");

        } catch (IOException e) {
            // Captura errores de entrada/salida (ej: archivo no encontrado)
            System.err.println(">>> ERROR CRÍTICO: No se pudo leer el archivo '" + nombreArchivo + "'.");
            System.err.println(">>> Asegúrese de que el archivo esté en la carpeta raíz del proyecto.");
        } catch (Exception e) {
            // Captura cualquier otro error inesperado (ej: formato de datos inválido)
            System.err.println(">>> ERROR: Ocurrió un problema inesperado al procesar los datos.");
            e.printStackTrace(); // Muestra el detalle técnico del error
        }
    }

    /**
     * Método para mostrar todos los empleados cargados en la colección.
     * Recorre la lista e imprime cada objeto.
     */
    public void listarEmpleados() {
        System.out.println("\n--- LISTADO GENERAL DE PERSONAL ---");

        if (listaEmpleados.isEmpty()) {
            System.out.println("(No hay datos cargados en el sistema)");
        } else {
            // Ciclo for-each: Recorre cada 'Empleado' en la 'listaEmpleados'
            for (Empleado emp : listaEmpleados) {
                System.out.println(emp.toString());
            }
        }
    }

    /**
     * Método para buscar y filtrar empleados por su cargo.
     * * @param cargoBuscado El texto del cargo a buscar (ej: "Gerente")
     */
    public void filtrarPorCargo(String cargoBuscado) {
        System.out.println("\n--- FILTRANDO POR CARGO: " + cargoBuscado + " ---");
        boolean encontrado = false;

        for (Empleado emp : listaEmpleados) {
            // Comparamos el cargo ignorando mayúsculas/minúsculas
            // .contains() permite encontrar coincidencias parciales
            if (emp.getCargo().toLowerCase().contains(cargoBuscado.toLowerCase())) {
                System.out.println("RESULTADO: " + emp.toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron empleados con el cargo especificado.");
        }
    }
}