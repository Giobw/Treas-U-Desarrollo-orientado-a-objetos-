package model;

public class Direccion {

    private String calle;
    private int numero;      // Cambiado a int para que coincida con el menú
    private String ciudad;
    private String region;   // Nuevo campo necesario

    // Constructor actualizado para recibir 4 datos
    public Direccion(String calle, int numero, String ciudad, String region) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.region = region;
    }

    // Getters y Setters
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    @Override
    public String toString() {
        return calle + " #" + numero + ", " + ciudad + ", " + region;
    }
}