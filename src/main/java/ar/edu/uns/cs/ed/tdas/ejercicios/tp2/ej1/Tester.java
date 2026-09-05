package ar.edu.uns.cs.ed.tdas.ejercicios.tp2.ej1;

public class Tester {
    public static void main(String[] args){

        Persona[] personas = {
            new Persona("Juan", 111),
            new Persona("Pedro", 111),
            new Persona("Ana", 111),
            new Persona("Maria", 111)
        };

        System.out.println("Arreglo original:");

        for (int i = 0; i < personas.length; i++){
            System.out.println(personas[i]);
        }

        ej1.invertir(personas);

        System.out.println("\nArreglo invertido:");

        for (int i = 0; i < personas.length; i++){
            System.out.println(personas[i]);
        }


    }
}
