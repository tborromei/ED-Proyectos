package ar.edu.uns.cs.ed.tdas.ejercicios.tp2.ej1;
import java.util.Stack;

public class ej1 {

    public static void invertir(Persona[] A){

        Stack<Persona> pila = new Stack<>();

        for (int i = 0; i < A.length; i++){
            pila.push(A[i]);
        }

        for (int i =0; i < A.length; i++){
            A[i] = pila.pop();
        }

    }
}