package ar.edu.uns.cs.ed.tdas.ejercicios.tp4.ej3;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;

public class ej3b {

    public static<E> int cuantosElementosHay(PositionList<E> l, E e1){
        int cant = 0;
        Iterator<E> ite = l.iterator();
        while (ite.hasNext()){
            if (ite.next().equals(e1)){
                cant++;
            }
        }
        return cant;
    }
    
    public static void main(String[] args){

        PositionList<Integer> listardium = new ListaDobleEnlace<>();
        listardium.addLast(1);
        listardium.addLast(44);
        listardium.addLast(67);
        listardium.addLast(67);
        listardium.addLast(67);
        listardium.addLast(1);
        listardium.addLast(1);
        listardium.addLast(1);
        
        int probarsianda = cuantosElementosHay(listardium, 67); //3

        int probarsianda2 = cuantosElementosHay(listardium, 1); //4


    }
}
