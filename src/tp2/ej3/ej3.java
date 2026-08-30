package tp2.ej3;
import java.util.Stack;

public class ej3 {

    public static Stack<Integer> intercalar(Stack<Integer> q1, Stack<Integer> q2){

        Stack<Integer> pila_intercalada = new Stack<>();

        int size_de_pila_itercalada = q1.size()+q2.size(); 
        
        for (int i = 0; i < size_de_pila_itercalada; i++){

            if (!q1.isEmpty()) pila_intercalada.add(q1.pop());
              
            if (!q2.isEmpty()) pila_intercalada.add(q2.pop());
            
        }

        return pila_intercalada;
    }
}
