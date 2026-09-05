package ar.edu.uns.cs.ed.tdas.ejercicios.tp2.ej3;

import java.util.Stack;

public class Tester {

    public static void main(String[] args) {

        // CASO 1: pilas del mismo tamaño
        Stack<Integer> p1 = new Stack<>();
        Stack<Integer> p2 = new Stack<>();

        p1.push(1);
        p1.push(2);
        p1.push(3);

        p2.push(10);
        p2.push(20);
        p2.push(30);

        System.out.println("===== CASO 1 =====");
        System.out.println("p1 antes: " + p1);
        System.out.println("p2 antes: " + p2);

        Stack<Integer> resultado = ej3.intercalar(p1, p2);

        System.out.println("Resultado: " + resultado);
        System.out.println("p1 después: " + p1);
        System.out.println("p2 después: " + p2);


        // CASO 2: p1 tiene más elementos
        Stack<Integer> p3 = new Stack<>();
        Stack<Integer> p4 = new Stack<>();

        p3.push(1);
        p3.push(2);
        p3.push(3);
        p3.push(4);
        p3.push(5);

        p4.push(10);
        p4.push(20);

        System.out.println("\n===== CASO 2 =====");
        System.out.println("p1 antes: " + p3);
        System.out.println("p2 antes: " + p4);

        Stack<Integer> resultado2 = ej3.intercalar(p3, p4);

        System.out.println("Resultado: " + resultado2);
        System.out.println("p1 después: " + p3);
        System.out.println("p2 después: " + p4);


        // CASO 3: p2 tiene más elementos
        Stack<Integer> p5 = new Stack<>();
        Stack<Integer> p6 = new Stack<>();

        p5.push(1);
        p5.push(2);

        p6.push(10);
        p6.push(20);
        p6.push(30);
        p6.push(40);

        System.out.println("\n===== CASO 3 =====");
        System.out.println("p1 antes: " + p5);
        System.out.println("p2 antes: " + p6);

        Stack<Integer> resultado3 = ej3.intercalar(p5, p6);

        System.out.println("Resultado: " + resultado3);
        System.out.println("p1 después: " + p5);
        System.out.println("p2 después: " + p6);


        // CASO 4: una pila vacía
        Stack<Integer> p7 = new Stack<>();
        Stack<Integer> p8 = new Stack<>();

        p8.push(10);
        p8.push(20);
        p8.push(30);

        System.out.println("\n===== CASO 4 =====");
        System.out.println("p1 antes: " + p7);
        System.out.println("p2 antes: " + p8);

        Stack<Integer> resultado4 = ej3.intercalar(p7, p8);

        System.out.println("Resultado: " + resultado4);
        System.out.println("p1 después: " + p7);
        System.out.println("p2 después: " + p8);


        // CASO 5: ambas vacías
        Stack<Integer> p9 = new Stack<>();
        Stack<Integer> p10 = new Stack<>();

        System.out.println("\n===== CASO 5 =====");

        Stack<Integer> resultado5 = ej3.intercalar(p9, p10);

        System.out.println("Resultado: " + resultado5);
        System.out.println("p1 después: " + p9);
        System.out.println("p2 después: " + p10);
    }
}
