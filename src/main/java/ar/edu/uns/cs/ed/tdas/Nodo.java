package ar.edu.uns.cs.ed.tdas;

public class Nodo<E> implements Position<E>{
    private E elemento;
    private Nodo<E> siguiente;
    
    public Nodo(E item, Nodo<E> sig){
        elemento = item;
        siguiente = sig;
    }
    public Nodo(E item){
        this(item,null);
    }

    public void setElemento(E elemento){
        this.elemento = elemento;
    }

    public void setSiguiente(Nodo<E> siguiente){
        this.siguiente=siguiente;
    }

    public E element(){
        return elemento;
    }
    public E getElemento(){
        return elemento;
    }
    public Nodo<E> getSiguiente(){
        return siguiente;
    }
}
