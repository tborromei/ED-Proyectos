package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej6;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
public class ej6b {
    public static PositionList<Integer> intercalarOrdenadas(PositionList<Integer> l1, PositionList<Integer> l2) {

        PositionList<Integer> resultado = new ListaDobleEnlace<>();

        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();

        Integer a = it1.hasNext() ? it1.next() : null;
        Integer b = it2.hasNext() ? it2.next() : null;

        while (a != null || b != null) {
            Integer elegido;

            if (b == null || (a != null && a <= b)) {
                elegido = a;
                a = it1.hasNext() ? it1.next() : null;
            } else {
                elegido = b;
                b = it2.hasNext() ? it2.next() : null;
            }

            if (resultado.isEmpty()
                    || !resultado.last().element().equals(elegido)) {
                resultado.addLast(elegido);
            }
        }

        return resultado;
    }
}
