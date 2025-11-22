package cl.duoc.salmontt.model;

/**
 * Clase que representa una Dirección.
 * Se utiliza para demostrar la composición (una Persona "tiene una" Dirección).
 */
public class Direccion {

    // Atributos encapsulados (private) [cite: 43]
    private String calle;
    private String numero;
    private String ciudad;

    // Constructor para inicializar el objeto [cite: 46]
    public Direccion(String calle, String numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    // Métodos Getters y Setters (para acceder a los atributos) [cite: 44]
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    // Método toString() para mostrar el objeto [cite: 45]
    @Override
    public String toString() {
        return calle + " #" + numero + ", " + ciudad;
    }
}