package tp3.ej8;
import TDACola.ArrayQueue;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;

public class ej2 {

    public static Queue<Integer> obtenerImpares(Queue<Integer> cola){
        Queue<Integer> impares = new ArrayQueue<>();
        while (!cola.isEmpty()){
            int aux = cola.dequeue();
            if (aux % 2 != 0){
                impares.enqueue(aux);
            }
        }
        return impares;
    }
}
