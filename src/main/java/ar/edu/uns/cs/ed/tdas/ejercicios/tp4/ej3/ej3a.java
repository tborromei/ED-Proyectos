package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej3;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;

public class ej3a {
    public static<E> boolean estaElem(PositionList<E> l, E e1){
        boolean esta = false;
        Iterator<E> iterador = l.iterator();
        while (iterador.hasNext() && !esta){
            E elemento = iterador.next();

            if (elemento.equals(e1)){
                esta = true;
            }
        }
        return esta;
    }
    public static void main(String[] args) {
        PositionList<Integer> l = new ListaDobleEnlace<>();

        l.addLast(4);
        l.addLast(8);
        l.addLast(15);

        Integer e1 = 8;

        boolean resultado = estaElem(l, e1);
    }
}
