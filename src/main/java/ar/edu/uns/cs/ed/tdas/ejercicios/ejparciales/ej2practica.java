package ar.edu.uns.cs.ed.tdas.ejercicios.ejparciales;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdapila.Stack;
import ar.edu.uns.cs.ed.tdas.tdacola.ColaEnlazada;
import ar.edu.uns.cs.ed.tdas.tdapila.PilaEnlazada;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
import ar.edu.uns.cs.ed.tdas.ElementIterator;

public class ej2practica {
    public static Iterable<Position<Character>> nPrimerasPos(PositionList<Character> pl, Character c, int n){

        PositionList<Position<Character>> lista = new ListaDobleEnlace<Position<Character>>();

        Iterator<Position<Character>> posiciones = pl.positions().iterator();

        int i = 0;
        while ( posiciones.hasNext() && i<n ){
            Position<Character> pos = posiciones.next();
            if (pos.element().equals(c)){
                lista.addLast(pos);
                i++;
            }
        }
        
        return lista;
    }
}
