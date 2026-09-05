package ar.edu.uns.cs.ed.tdas.tdacola;

import java.util.Stack;

import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;

public class ColaConPila<E> implements Queue<E> {

    private Stack<E> pila;

    public ColaConPila() {
        pila = new Stack<E>();
    }

    public int size() {
        return pila.size();
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public E front() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía");
        }

        return pila.peek();
    }

    public void enqueue(E element) {
        insertarEnFondo(element);
    }

    /*
     * Inserta el elemento abajo de todos los elementos existentes.
     * De esta forma, el elemento más antiguo permanece en el tope.
     */
    private void insertarEnFondo(E element) {
        if (pila.isEmpty()) {
            pila.push(element);
        } else {
            E temp = pila.pop();

            insertarEnFondo(element);

            pila.push(temp);
        }
    }

    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("La cola está vacía");
        }

        return pila.pop();
    }
}