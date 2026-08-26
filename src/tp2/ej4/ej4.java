package tp2.ej4;
import java.util.Queue;

public class ej4 {

    public static int mayor(Queue<Integer> q) {

        int cantidad = q.size();
        int mayor = q.peek();

        for (int i = 0; i < cantidad; i++) {

            int elem = q.poll();

            if (elem > mayor) {
                mayor = elem;
            }

            q.offer(elem);
        }

        return mayor;
    }
}
