package ar.edu.uns.cs.ed.tdas.ejercicios.tp3.ej8;

import ar.edu.uns.cs.ed.tdas.tdapila.PilaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdapila.Stack;

public class TesterEJ3 {
    public static void main(String[] args) {

        // CASO 1: pilas del mismo tamaño
        Stack<Integer> p1 = new PilaConArreglo<>();
        Stack<Integer> p2 = new PilaConArreglo<>();

        p1.push(1);
        p1.push(2);
        p1.push(3);

        p2.push(10);
        p2.push(20);
        p2.push(30);

        System.out.println("===== CASO 1 =====");
        TesterEJ3.mostrarPila("p1 antes: ",p1);
        TesterEJ3.mostrarPila("p2 antes: ",p2);

        Stack<Integer> resultado = ej3.intercalar(p1, p2);

        TesterEJ3.mostrarPila("Resultado: ",resultado);
        TesterEJ3.mostrarPila("p1 despues: ",p1);
        TesterEJ3.mostrarPila("p2 despues: ",p2);


        // CASO 2: p1 tiene más elementos
        Stack<Integer> p3 = new PilaConArreglo<>();
        Stack<Integer> p4 = new PilaConArreglo<>();

        p3.push(1);
        p3.push(2);
        p3.push(3);
        p3.push(4);
        p3.push(5);

        p4.push(10);
        p4.push(20);

        System.out.println("\n===== CASO 2 =====");
        TesterEJ3.mostrarPila("p3 antes: ",p3);
        TesterEJ3.mostrarPila("p4 antes: ",p4);

        Stack<Integer> resultado2 = ej3.intercalar(p3, p4);

        TesterEJ3.mostrarPila("Resultado2: ",resultado2);
        TesterEJ3.mostrarPila("p3 despues: ",p3);
        TesterEJ3.mostrarPila("p4 despues: ",p4);


        // CASO 3: p2 tiene más elementos
        Stack<Integer> p5 = new PilaConArreglo<>();
        Stack<Integer> p6 = new PilaConArreglo<>();

        p5.push(1);
        p5.push(2);

        p6.push(10);
        p6.push(20);
        p6.push(30);
        p6.push(40);

        System.out.println("\n===== CASO 3 =====");
        TesterEJ3.mostrarPila("p5 antes: ",p5);
        TesterEJ3.mostrarPila("p6 antes: ",p6);

        Stack<Integer> resultado3 = ej3.intercalar(p5, p6);

        TesterEJ3.mostrarPila("Resultado3: ",resultado3);
        TesterEJ3.mostrarPila("p5 despues: ",p5);
        TesterEJ3.mostrarPila("p6 despues: ",p6);


        // CASO 4: una pila vacía
        Stack<Integer> p7 = new PilaConArreglo<>();
        Stack<Integer> p8 = new PilaConArreglo<>();

        p8.push(10);
        p8.push(20);
        p8.push(30);

        System.out.println("\n===== CASO 4 =====");
        TesterEJ3.mostrarPila("p7 antes: ",p7);
        TesterEJ3.mostrarPila("p8 antes: ",p8);

        Stack<Integer> resultado4 = ej3.intercalar(p7, p8);

        TesterEJ3.mostrarPila("Resultado4: ",resultado4);
        TesterEJ3.mostrarPila("p7 despues: ",p7);
        TesterEJ3.mostrarPila("p8 despues: ",p8);


        // CASO 5: ambas vacías
        Stack<Integer> p9 = new PilaConArreglo<>();
        Stack<Integer> p10 = new PilaConArreglo<>();

        System.out.println("\n===== CASO 5 =====");

        Stack<Integer> resultado5 = ej3.intercalar(p9, p10);

        TesterEJ3.mostrarPila("Resultado5: ",resultado5);
        TesterEJ3.mostrarPila("p9 despues: ",p9);
        TesterEJ3.mostrarPila("p10 despues: ",p10);
    }

    private static <E> void mostrarPila(String nombre, Stack<E> pila) {

        Stack<E> auxiliar = new PilaConArreglo<>();

        System.out.print(nombre + ": [");

        boolean primero = true;

        while (!pila.isEmpty()) {
            E elemento = pila.pop();

            if (!primero) {
                System.out.print(", ");
            }

            System.out.print(elemento);
            primero = false;

            auxiliar.push(elemento);
        }

        System.out.println("]");

        // Restauramos la pila original.
        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }
    }
}
