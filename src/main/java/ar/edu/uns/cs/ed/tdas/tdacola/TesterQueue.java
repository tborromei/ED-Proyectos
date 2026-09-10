package ar.edu.uns.cs.ed.tdas.tdacola;

public class TesterQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);



        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(1);
    }
}
