package cl.duoc.salmontt.app;

// Importamos nuestro servicio nuevo
import cl.duoc.salmontt.service.SalmonttService;

/**
 * Clase principal de ejecución.
 * Demuestra la integración de los módulos para la Evaluación 2.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN SALMONTT (V2.0) ===");
        System.out.println("Cargando sistema...");

        // 1. Instanciamos el servicio (nuestra librería personalizada)
        SalmonttService servicio = new SalmonttService();

        // 2. Cargamos los datos desde el archivo CSV
        // El archivo debe estar en la raíz del proyecto
        servicio.cargarDatosDesdeArchivo("empleados.csv");

        // 3. Listamos todos los datos para verificar que se cargaron en la Colección
        servicio.listarEmpleados();

        // 4. Probamos el filtro por cargo (Requisito de la pauta)
        System.out.println("\n-----------------------------------------");
        System.out.println(">>> Prueba de Búsqueda y Filtros:");

        // Caso 1: Buscar a un Analista
        servicio.filtrarPorCargo("Analista");

        // Caso 2: Buscar a un Gerente
        servicio.filtrarPorCargo("Gerente");

        // Caso 3: Buscar algo que no existe
        servicio.filtrarPorCargo("Astronauta");

        System.out.println("\n=== Fin del programa ===");
    }
}