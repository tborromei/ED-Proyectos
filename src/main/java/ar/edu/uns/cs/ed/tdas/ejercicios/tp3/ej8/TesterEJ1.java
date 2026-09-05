package ar.edu.uns.cs.ed.tdas.ejercicios.tp3.ej8;

public class TesterEJ1 {

    public static void main(String[] args) {

        Persona[] personas = {
            new Persona("Juan", 111),
            new Persona("Pedro", 222),
            new Persona("Ana", 333),
            new Persona("Maria", 444)
        };

        System.out.println("Arreglo original:");

        for (Persona persona : personas) {
            System.out.println(persona);
        }

        ej1.invertir(personas);

        System.out.println("\nArreglo invertido:");

        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}