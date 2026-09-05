package ar.edu.uns.cs.ed.tdas.ejercicios.tp3.ej8;
import ar.edu.uns.cs.ed.tdas.tdapila.PilaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdapila.Stack;

public class ej3 {

    public static Stack<Integer> intercalar(Stack<Integer> p1, Stack<Integer> p2){
        
        Stack<Integer> pila_intercalada = new PilaConArreglo<>();
        int iteraciones = Math.max(p1.size(), p2.size());
        for (int i=0; i<iteraciones; i++){
            if (!p1.isEmpty()){
                pila_intercalada.push(p1.pop());
            }
            if (!p2.isEmpty()){
                pila_intercalada.push(p2.pop());
            }
        }
        return pila_intercalada;
    }
}
