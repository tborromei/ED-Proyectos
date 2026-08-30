package tp3.ej4;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue; 

public class Tester {
    public static void main(String[] args){
        Queue<String> cola = new ColaConPila<String>();

        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");

        System.out.println(cola.dequeue()); // A
        System.out.println(cola.dequeue()); // B
        System.out.println(cola.dequeue()); // C
    }
}
