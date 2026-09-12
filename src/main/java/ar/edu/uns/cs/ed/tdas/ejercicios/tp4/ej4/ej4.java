package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej4;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;

public class ej4 {
    public static<E> PositionList<E> listaRepetidos(PositionList<E> l){
        PositionList<E> lnueva = new ListaDobleEnlace<>();

        for ( E elem: l ){
            lnueva.addLast(elem);
            lnueva.addLast(elem);
        }
        return lnueva;
    }
}
