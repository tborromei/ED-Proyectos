package ar.edu.uns.cs.ed.tdas.ejercicios.ejparciales;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdapila.Stack;
import ar.edu.uns.cs.ed.tdas.tdacola.ArrayQueue;
import ar.edu.uns.cs.ed.tdas.tdacola.ColaEnlazada;
import ar.edu.uns.cs.ed.tdas.tdapila.PilaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdapila.PilaEnlazada;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
import ar.edu.uns.cs.ed.tdas.ElementIterator;

public class ej3parcialactual {
    //metodo de dada una cola [a,b,c,d,(,a,a,a,a),d,f,a] dar vuelta lo de entre parentesis
    public static void invertir(Queue<Character> q){
        Queue<Character> cola = new ColaEnlazada<>();
        Stack<Character> pila = new PilaEnlazada<>();

        while (!q.isEmpty()){
            //desencola y encola
            Character actual = q.dequeue();
            cola.enqueue(actual);

            //si llegamos al parentesis:
            if (actual == '('){

                //chequeo por las dudas
                if (!q.isEmpty()){

                    
                    actual = q.dequeue(); // pasa a lo siguiente del parentesis

                    while (!q.isEmpty() && actual != ')'){ // recorre hasta llegar al parentesis
                        pila.push(actual); // agrega a la pila
                        actual = q.dequeue(); // pasa a la siguiente
                    }
                    
                    while (!pila.isEmpty()){
                        cola.enqueue(pila.pop()); //encola todo lo que saca de la pila
                    }

                    //el actual es el parentesis
                    
                    cola.enqueue(actual); // encola el parentesis

                }
            }
        }

        while (!cola.isEmpty()){
            q.enqueue(cola.dequeue());
        }
    }

    public static void main(String[] args){
        ArrayQueue<Character> q = new ArrayQueue<>();
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        q.enqueue('(');
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        q.enqueue('d');
        q.enqueue('e');
        q.enqueue('f');
        q.enqueue(')');
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');


        invertir(q);

        while (!q.isEmpty()){
            System.out.print(q.dequeue());
        }

    }
}
