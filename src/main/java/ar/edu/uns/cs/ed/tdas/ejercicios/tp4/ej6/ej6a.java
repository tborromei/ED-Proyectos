package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej6;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
public class ej6a {
    public static <E> PositionList<E> intercalar(PositionList<E> l1, PositionList<E> l2) {

        PositionList<E> resultado = new ListaDobleEnlace<>();

        Iterator<E> it1 = l1.iterator();
        Iterator<E> it2 = l2.iterator();

        while (it1.hasNext() || it2.hasNext()) {

            if (it1.hasNext()) {
                resultado.addLast(it1.next());
            }

            if (it2.hasNext()) {
                resultado.addLast(it2.next());
            }
        }

        return resultado;
    }
}
