package ar.edu.uns.cs.ed.tdas.tdacola;
import ar.edu.uns.cs.ed.tdas.Nodo;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;
public class ColaEnlazada<E> implements Queue<E> {
    protected Nodo<E> front;
    protected Nodo<E> tail;
    protected int tamanio;

    public ColaEnlazada(){
        front = null;
        tail = null;
        tamanio = 0;
    }

    public E front(){
        return front.getElemento();
    }
    public boolean isEmpty(){
        return tamanio==0;
    }
    public int size(){
        return tamanio;
    }
    public void enqueue(E elem){
        Nodo<E> nodo = new Nodo<E>(elem);
        if (front == null){
            front = nodo;
        }
        else{ 
            tail.setSiguiente(nodo);
        }
        tail = nodo;
        tamanio++;
    }
    public E dequeue(){
        if (isEmpty()) throw new EmptyQueueException("La cola enlazada está vacía.");
        E temporal = front.getElemento();
        front = front.getSiguiente();
        tamanio--;
        if ( front == null ) tail = null;
        return temporal;
    }


}
