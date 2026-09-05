package ar.edu.uns.cs.ed.tdas.ejercicios.tp3.ej8;

import java.util.Arrays;

import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;
import ar.edu.uns.cs.ed.tdas.tdacola.ArrayQueue;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;

public class TesterEJ4 {
    public static void main(String[] args) {
        probarCaso("valores positivos", new int[]{3, 2, 4, 5, 4, 6}, 6);
        probarCaso("valores negativos", new int[]{-8, -3, -15, -6}, -3);
        probarCaso("un único elemento", new int[]{42}, 42);
        probarCaso(
            "redimensionamiento y recorrido circular",
            new int[]{8, 1, 14, -2, 30, 7, 6, 5, 4, 3, 2, 1},
            30
        );

        probarColaVacia();

        System.out.println("Todos los casos pasaron correctamente.");
    }

    private static void probarCaso(String nombre, int[] valores, int esperado) {
        Queue<Integer> cola = new ArrayQueue<>();

        for (int valor : valores) {
            cola.enqueue(valor);
        }

        verificarContenido(cola, valores);

        int obtenido = ej4.mayor(cola);

        if (obtenido != esperado) {
            throw new AssertionError(
                nombre + ": se esperaba " + esperado + " pero se obtuvo " + obtenido
            );
        }

        verificarContenido(cola, valores);

        System.out.println(
            nombre + " -> mayor = " + obtenido
            + ", cola conservada = " + Arrays.toString(valores)
        );
    }

    private static void verificarContenido(Queue<Integer> cola, int[] esperado) {
        if (cola.size() != esperado.length) {
            throw new AssertionError(
                "Se esperaba tamaño " + esperado.length + " pero se obtuvo " + cola.size()
            );
        }

        for (int valorEsperado : esperado) {
            int valorObtenido = cola.dequeue();

            if (valorObtenido != valorEsperado) {
                throw new AssertionError(
                    "Se esperaba " + valorEsperado + " pero se obtuvo " + valorObtenido
                );
            }

            cola.enqueue(valorObtenido);
        }
    }

    private static void probarColaVacia() {
        Queue<Integer> vacia = new ArrayQueue<>();

        try {
            ej4.mayor(vacia);
            throw new AssertionError("La cola vacía debía lanzar EmptyQueueException");
        } catch (EmptyQueueException e) {
            System.out.println("cola vacía -> EmptyQueueException correcta");
        }
    }
}
