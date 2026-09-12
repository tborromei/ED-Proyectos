package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej3;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;

public class ej3c {
    public static<E> boolean estaNVeces(PositionList<E> l, E x, int n){
        boolean estaNVeces = false;
        Iterator<E> ite = l.iterator();
        int contador = 0;
        while (ite.hasNext() && !estaNVeces){
            if (ite.next() == x){
                contador++;
            }
            if (contador==n){
                estaNVeces=true;
            }
        }
        
        return estaNVeces;
    }
}
