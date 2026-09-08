package ar.edu.uns.cs.ed.tdas;

public class DNodo<E> implements Position<E> {
    private E elemento;
    private DNodo<E> siguiente;
    private DNodo<E> anterior;
    
    public DNodo(DNodo<E> ant, E item, DNodo<E> sig){
        anterior = ant;
        elemento = item;
        siguiente = sig;
    }
    public DNodo(E item){
        this(null,item,null);
    }

    public void setElemento(E elemento){
        this.elemento = elemento;
    }

    public void setSiguiente(DNodo<E> siguiente){
        this.siguiente=siguiente;
    }

    public void setAnterior(DNodo<E> anterior){
        this.anterior = anterior;
    }

    public E element(){
        return elemento;
    }
    public DNodo<E> getSiguiente(){
        return siguiente;
    }
    public DNodo<E> getAnterior(){
        return anterior;
    }
}
