package ar.edu.uns.cs.ed.tdas.ejercicios.tp2.ej2;
import java.util.Queue;
import java.util.LinkedList;
public class ej2 {

    public static Queue<Integer> obtenerImpares(Queue<Integer> cola){
        Queue<Integer> impares = new LinkedList<>();
        while (!cola.isEmpty()){

            int numero = cola.poll();
            if (numero % 2 != 0){
                impares.offer(numero);
            }
        }

        return impares;


    }
}
