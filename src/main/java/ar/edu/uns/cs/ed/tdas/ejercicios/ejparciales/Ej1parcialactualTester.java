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

public class Ej1parcialactualTester {
    public static void main(String[] args){
        ListaDobleEnlace<Integer> lista = new ListaDobleEnlace<>();
        lista.addLast(1);
        lista.addLast(5);
        lista.addLast(1);
        lista.addLast(5);
        lista.addLast(1);
        lista.addLast(5);

        PositionList<Integer> solopospares = lista.soloPares(5);
    }
}
