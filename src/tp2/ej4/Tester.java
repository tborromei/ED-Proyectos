package tp2.ej4;
import java.util.Queue;
import java.util.LinkedList;

public class Tester {
    public static void main(String[] args){

        Queue<Integer> p1 = new LinkedList<>();
        p1.add(43);
        p1.add(123);
        p1.add(13);
        p1.add(17);
        p1.add(12);
        p1.add(185);
        p1.add(1949);

        int mayor_valor = ej4.mayor(p1);
    }
}
