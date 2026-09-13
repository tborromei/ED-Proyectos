package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej5;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;

public class ej5 {
    public static Iterable<Character> eliminarCoincidentes(PositionList<Character> l1, PositionList<Character> l2) {

        PositionList<Position<Character>> aEliminar = new ListaDobleEnlace<>();

        PositionList<Character> eliminados = new ListaDobleEnlace<>();

        // Buscar las posiciones de l2 cuyos elementos aparecen en l1.
        for (Position<Character> p : l2.positions()) {
            Character elemento = p.element();

            Iterator<Character> it = l1.iterator();
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
        for (Position<Character> p : aEliminar) {
            Character eliminado = l2.remove(p);
            eliminados.addLast(eliminado);
        }

        return eliminados;
    }
}