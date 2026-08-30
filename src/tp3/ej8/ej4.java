package tp3.ej8;

import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;

public class ej4 {

    public static int mayor(Queue<Integer> q) {
        if (q.isEmpty()) {
            throw new EmptyQueueException("No se puede buscar el mayor de una cola vacía");
        }

        int cantidad = q.size();
        int mayor = q.front();

        for (int i = 0; i < cantidad; i++) {
            int actual = q.dequeue();

            if (actual > mayor) {
                mayor = actual;
            }

            q.enqueue(actual);
        }

        return mayor;
    }
}
