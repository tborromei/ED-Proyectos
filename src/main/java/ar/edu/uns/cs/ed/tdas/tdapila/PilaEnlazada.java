package ar.edu.uns.cs.ed.tdas.tdapila;
import ar.edu.uns.cs.ed.tdas.Nodo;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyStackException;

public class PilaEnlazada<E> implements Stack<E> {

    protected Nodo<E> head;
    protected int tamanio;

    public PilaEnlazada(){
        head = null;
        tamanio=0;
    }

    public void push(E item){
        head = new Nodo<E>(item, head);
        tamanio++;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public E pop(){
        if (isEmpty()) throw new EmptyStackException("La pila enlazada está vacía.");
        E aux = head.getElemento();
        head = head.getSiguiente();
        tamanio--;
        return aux;
    }

    public E top(){
        return head.getElemento();
    }
    public int size(){
        return tamanio;
    }

}
