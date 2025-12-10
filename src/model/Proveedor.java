package model;

public class Proveedor implements Registrable {
    private String empresa;
    private String rutEmpresa;
    private String giro;
    private Direccion direccion;
    private String servicio;
    private String infoAdicional;

    // Constructor recibe un objeto Direccion
    public Proveedor(String empresa, String rutEmpresa, String giro, Direccion direccion, String servicio, String infoAdicional) {
        this.empresa = empresa;
        this.rutEmpresa = rutEmpresa;
        this.giro = giro;
        this.direccion = direccion;
        this.servicio = servicio;
        this.infoAdicional = infoAdicional;
    }

    @Override
    public void mostrarResumen() {
        System.out.println(">>> PROVEEDOR EXTERNO <<<");
        System.out.println("Empresa: " + this.empresa);
        System.out.println("RUT: " + this.rutEmpresa);
        System.out.println("Giro: " + this.giro);
        System.out.println("Dirección: " + this.direccion.toString());
        System.out.println("Servicio: " + this.servicio);

        if (this.infoAdicional != null && !this.infoAdicional.isEmpty()) {
            System.out.println("Observaciones: " + this.infoAdicional);
        }
        System.out.println("---------------------------");
    }
}