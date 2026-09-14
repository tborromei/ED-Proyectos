package ar.edu.uns.cs.ed.tdas.ejercicios.ejparciales.parcial1_1;
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

public class ej3 {
    public static Queue<Integer> filtrarYReordenar(PositionList<Integer> lista){
        Queue<Integer> cola = new ColaEnlazada<>();
        Stack<Integer> pila = new PilaEnlazada<>();

        for (Integer t : lista){

            if (t % 2 == 0){

                cola.enqueue(t);

            }else{

                pila.push(t);

            }

        }

        while (!pila.isEmpty()){
            cola.enqueue(pila.pop());
        }

        return cola;
    }

    public static void main(String[] args){
        PositionList<Integer> list = new ListaDobleEnlace<>();
        list.addLast(3);
        list.addLast(5);
        list.addLast(9);
        list.addLast(2);
        list.addLast(11);
        list.addLast(4);
        list.addLast(8);
        list.addLast(7);
        list.addLast(7);

        Queue<Integer> col = filtrarYReordenar(list);
        System.out.print("[ ");
        int cant = col.size();
        for (int i=0; i<cant; i++){
            System.out.print(col.dequeue());
            if (col.size()>0)
            System.out.print(" , ");
        }
        System.out.println(" ]");
    }
}
