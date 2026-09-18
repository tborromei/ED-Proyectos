package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej7;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;


public class ej7 {
    public static <E> void eliminar(PositionList<E> l1, PositionList<E> l2) {

    PositionList<Position<E>> aEliminar = new ListaDobleEnlace<>();

    // Buscar todas las posiciones de l1 que debemos eliminar.
    for (Position<E> p : l1.positions()) {
        Iterator<E> it = l2.iterator();
        boolean encontrado = false;

        while (it.hasNext() && !encontrado) {
            if (p.element().equals(it.next())) {
                encontrado = true;
            }
        }

        if (encontrado) {
            aEliminar.addLast(p);
        }
    }

    // Eliminar esas posiciones de l1.
    for (Position<E> p : aEliminar) {
        l1.remove(p);
    }

    // Construir una auxiliar con los elementos de l2 invertidos.
    PositionList<E> invertida = new ListaDobleEnlace<>();

    for (E elemento : l2) {
        invertida.addFirst(elemento);
    }

    // Agregarlos al final de l1.
    for (E elemento : invertida) {
        l1.addLast(elemento);
    }
}
}
