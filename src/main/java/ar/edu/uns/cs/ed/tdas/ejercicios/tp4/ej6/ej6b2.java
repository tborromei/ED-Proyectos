package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej6;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;

public class ej6b2 {
    public static PositionList<Integer> intercalarOrdenadas(
        PositionList<Integer> l1, PositionList<Integer> l2) {

        PositionList<Integer> resultado = new ListaDobleEnlace<>();

        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();

        Integer a = siguiente(it1);
        Integer b = siguiente(it2);

        while (a != null || b != null) {
            Integer elegido;

            // Decisión 1: elegir y avanzar el recorrido correspondiente.
            if (a == null) {
                elegido = b;
                b = siguiente(it2);
            } else if (b == null) {
                elegido = a;
                a = siguiente(it1);
            } else if (a <= b) {
                elegido = a;
                a = siguiente(it1);
            } else {
                elegido = b;
                b = siguiente(it2);
            }

            // Decisión 2: agregar solamente si no es un repetido.
            if (resultado.isEmpty()) {
                resultado.addLast(elegido);
            } else if (!resultado.last().element().equals(elegido)) {
                resultado.addLast(elegido);
            }
        }

        return resultado;
    }

    
    private static Integer siguiente(Iterator<Integer> it) {
        if (it.hasNext()) {
            return it.next();
        } else {
            return null;
        }
    }
    

    public static void main(String[] args) {
        PositionList<Integer> l1 = new ListaDobleEnlace<>();
        PositionList<Integer> l2 = new ListaDobleEnlace<>();

        l1.addLast(1);
        l1.addLast(3);
        l1.addLast(3);
        l1.addLast(8);

        l2.addLast(2);
        l2.addLast(3);
        l2.addLast(6);
        l2.addLast(9);
        l2.addLast(9);

        PositionList<Integer> resultado = intercalarOrdenadas(l1, l2);
    }
}
