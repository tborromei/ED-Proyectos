package ar.edu.uns.cs.ed.tdas.ejercicios.tp3.ej8;

import ar.edu.uns.cs.ed.tdas.tdacola.ArrayQueue;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;

public class TesterEJ2 {

    public static void main(String[] args) {

        Queue<Integer> cola = new ArrayQueue<>();

        cola.enqueue(4);
        cola.enqueue(7);
        cola.enqueue(2);
        cola.enqueue(9);
        cola.enqueue(11);
        cola.enqueue(6);

        mostrarCola("Cola original", cola);

        Queue<Integer> impares = ej2.obtenerImpares(cola);

        mostrarCola("Cola de impares", impares);
        mostrarCola("Cola original después", cola);
    }

    private static <E> void mostrarCola(String nombre, Queue<E> cola) {
        int cantidad = cola.size();

        System.out.print(nombre + ": [");

        for (int i = 0; i < cantidad; i++) {
            E elemento = cola.dequeue();
            System.out.print(elemento);

            if (i < cantidad - 1) {
                System.out.print(", ");
            }

            cola.enqueue(elemento);
        }

        System.out.println("]");
    }
}
