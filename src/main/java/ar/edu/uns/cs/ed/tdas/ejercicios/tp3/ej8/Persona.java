package ar.edu.uns.cs.ed.tdas.ejercicios.tp3.ej8;

public class Persona {

    private String nombre;
    private int dni;

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerDNI() {
        return dni;
    }

    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    public void establecerDNI(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre + " - DNI: " + dni;
    }
}
