package tp3.ej8;
import TDAPila.PilaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdapila.Stack;

public class ej1 {

    public static void invertir(Persona[] A){

        Stack<Persona> pila = new PilaConArreglo<>();

        for (int i = 0; i < A.length; i++){
            pila.push(A[i]);
        }

        for (int i =0; i < A.length; i++){
            A[i] = pila.pop();
        }

    }
}