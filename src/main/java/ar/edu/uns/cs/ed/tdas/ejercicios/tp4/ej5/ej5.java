package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej5;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;

public class ej5 {
    public static<E> Iterable<E> eliminarCoincidentes(PositionList<E> l1, PositionList<E> l2) {

        PositionList<Position<E>> aEliminar = new ListaDobleEnlace<>();

        PositionList<E> eliminados = new ListaDobleEnlace<>();

        // Buscar las posiciones de l2 cuyos elementos aparecen en l1.
        for (Position<E> p : l2.positions()) {
            E elemento = p.element();

            Iterator<E> it = l1.iterator();
            boolean encontrado = false;

            while (it.hasNext() && !encontrado) {
                if (it.next().equals(elemento)) {
                    encontrado = true;
                }
            }

            if (encontrado) {
                aEliminar.addLast(p);
            }
        }

        // Eliminar esas posiciones y guardar los elementos retirados.
        for (Position<E> p : aEliminar) {
            E eliminado = l2.remove(p);
            eliminados.addLast(eliminado);
        }

        return eliminados;
    }
}