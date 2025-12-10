package data;

import model.Registrable;
import model.Empleado;
import model.Proveedor;
import java.util.ArrayList;

public class GestorEntidades {
    private ArrayList<Registrable> lista = new ArrayList<>();

    public void registrar(Registrable entidad) {
        lista.add(entidad);
    }

    public String generarReporte() {
        if (lista.isEmpty()) return "No hay datos registrados.";

        StringBuilder sb = new StringBuilder();
        for (Registrable r : lista) {
            // REQUERIMIENTO CLAVE: instanceof
            if (r instanceof Empleado) {
                sb.append("[PERSONAL] ");
            } else if (r instanceof Proveedor) {
                sb.append("[PROVEEDOR] ");
            }
            sb.append(" -> Procesado.\n");
            r.mostrarResumen();
        }
        return sb.toString();
    }
}