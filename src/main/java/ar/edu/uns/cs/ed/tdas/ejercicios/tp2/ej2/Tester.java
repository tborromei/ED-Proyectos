package ar.edu.uns.cs.ed.tdas.ejercicios.tp2.ej2;

import java.util.Queue;
import java.util.LinkedList;

public class Tester {

    public static void main(String[] args) {

        Queue<Integer> cola = new LinkedList<>();

        cola.offer(4);
        cola.offer(7);
        cola.offer(2);
        cola.offer(9);
        cola.offer(11);
        cola.offer(6);

        System.out.println("Cola original: " + cola);

        Queue<Integer> impares = ej2.obtenerImpares(cola);

        System.out.println("Cola de impares: " + impares);
        System.out.println("Cola original después: " + cola);
    }
}
