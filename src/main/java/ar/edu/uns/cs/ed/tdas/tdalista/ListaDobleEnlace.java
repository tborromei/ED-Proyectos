package ar.edu.uns.cs.ed.tdas.tdalista;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ar.edu.uns.cs.ed.tdas.DNodo;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.ElementIterator;

import ar.edu.uns.cs.ed.tdas.excepciones.*;

public class ListaDobleEnlace<E> implements PositionList<E> {
    private DNodo<E> header;
    private DNodo<E> trailer;
    private int size;

    public ListaDobleEnlace(){
        header = new DNodo<E>(null);
        trailer = new DNodo<E>(null);

        header.setSiguiente(trailer);
        header.setAnterior(null);

        trailer.setSiguiente(null);
        trailer.setAnterior(header);
        
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Position<E> first(){
        if (size==0){
            throw new EmptyListException("La lista está vacía.");
        }else{
            return header.getSiguiente();
        }
    }

    public Position<E> last(){
        if (size==0){
            throw new EmptyListException("La lista está vacía.");
        }else{
            return trailer.getAnterior();
        }
    }

    public Position<E> next(Position<E> p) {
        DNodo<E> nodo = checkPosition(p);

        if (nodo.getSiguiente() == trailer) {
            throw new BoundaryViolationException(
                "No existe una posición siguiente."
            );
        }

        return nodo.getSiguiente();
    }

    private DNodo<E> checkPosition(Position<E> p) {
        if (size==0) {
            throw new EmptyListException("La lista está vacía.");
        }

        if (p == null) {
            throw new InvalidPositionException("La posición es nula.");
        }

        try {
            DNodo<E> nodo = (DNodo<E>) p;

            if (nodo == header || nodo == trailer) {
                throw new InvalidPositionException("La posición corresponde a un nodo centinela.");
            }

            return nodo;

        } catch (ClassCastException e) {
            throw new InvalidPositionException("La posición no pertenece a una lista doblemente enlazada.");
        }
    }

    public Position<E> prev(Position<E> p){
        DNodo<E> nodo = checkPosition(p);

        if (nodo.getAnterior() == header) {
            throw new BoundaryViolationException(
                "No existe una posición anterior."
            );
        }

        return nodo.getAnterior();
    }

    public void addFirst(E elem){
        DNodo<E> aux = new DNodo<E>(elem);
        aux.setAnterior(header);
        aux.setSiguiente(header.getSiguiente());

        header.getSiguiente().setAnterior(aux);
        header.setSiguiente(aux);
        size++;
    }

    public void addLast(E elem){
        DNodo<E> aux = new DNodo<E>(elem);
        aux.setSiguiente(trailer);
        aux.setAnterior(trailer.getAnterior());

        trailer.getAnterior().setSiguiente(aux);
        trailer.setAnterior(aux);
        size++;
    }

    public void addAfter(Position<E> p, E element){
        DNodo<E> aux = checkPosition(p);
        DNodo<E> nuevo = new DNodo<E>(element);
        nuevo.setAnterior(aux);
        nuevo.setSiguiente(aux.getSiguiente());
        //al nodo nuevo lo ponemos en el medio del nodo pasado por parametro y su siguiente nodo

        aux.getSiguiente().setAnterior(nuevo);
        //al siguiente del nodo pasado por parametro le ponemos como anterior al nuevo nodo
        aux.setSiguiente(nuevo);
        //al nodo pasado por parametro le ponemos como siguiente al nuevo nodo.

        size++;
    }

    public void addBefore(Position<E> p, E element){
        DNodo<E> aux = checkPosition(p);
        DNodo<E> nuevo = new DNodo<E>(element);
        nuevo.setAnterior(aux.getAnterior());
        nuevo.setSiguiente(aux);
        //nodo nuevo: 
        // su siguiente es el nodo pasado por parametro
        // su anterior es el anterior del pasado por parametro


        aux.getAnterior().setSiguiente(nuevo);
        // al nodo anterior al pasado por parametro le ponemos como siguiente al nuevo nodo

        aux.setAnterior(nuevo);
        // al nodo pasado por parametro le ponemos como anterior al nuevo nodo.

        size++;
    }

    public E remove(Position<E> p){
        DNodo<E> aux = checkPosition(p);

        DNodo<E> cursor = header;
        while (cursor!=null && cursor.getSiguiente() != p){
            cursor = cursor.getSiguiente();

        }
        if(cursor==null){
			throw new InvalidPositionException("Posicion invalida ");
		}

        cursor.setSiguiente(aux.getSiguiente());
        aux.getSiguiente().setAnterior(cursor);
        size--;

        return aux.element();
    } 

    public E set(Position<E> p, E element){
        DNodo<E> aux = checkPosition(p);
        E anterior = aux.element();
        aux.setElemento(element);
        return anterior;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<E>(this);
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> posiciones = new ListaDobleEnlace<Position<E>>();
        DNodo<E> actual = header.getSiguiente();

        while (actual != trailer) {
            posiciones.addLast(actual);
            actual = actual.getSiguiente();
        }

        return posiciones;
    }

    /**
     * Agrega e1 como segundo elemento y e2 como anteultimo elemento.
     *
     * @throws InvalidOperationException si la lista tiene exactamente un
     *         elemento, porque la segunda posicion y la anteultima coinciden.
     */
    public void agregarSegundoYAnteultimo(E e1, E e2) {
        if (size == 1) {
            throw new InvalidOperationException(
                "No se pueden agregar dos elementos distintos en la misma posicion."
            );
        }

        if (size == 0) {
            addFirst(e2);
            addLast(e1);
        } else {
            addAfter(header.getSiguiente(), e1);
            addBefore(trailer.getAnterior(), e2);
        }
    }

    /**
     * Elimina hasta k elementos consecutivos a partir de p, incluyendola.
     *
     * @return la cantidad de elementos efectivamente eliminados
     * @throws IllegalArgumentException si k no es mayor que cero
     * @throws InvalidPositionException si p no es una posicion valida
     */
    public int eliminarDesdePosicion(Position<E> p, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException(
                "La cantidad de elementos a eliminar debe ser mayor que cero."
            );
        }

        DNodo<E> primeroAEliminar = checkPosition(p);
        DNodo<E> posteriorAlBloque = primeroAEliminar;
        int eliminados = 0;

        while (eliminados < k && posteriorAlBloque != trailer) {
            posteriorAlBloque = posteriorAlBloque.getSiguiente();
            eliminados++;
        }

        DNodo<E> anteriorAlBloque = primeroAEliminar.getAnterior();
        anteriorAlBloque.setSiguiente(posteriorAlBloque);
        posteriorAlBloque.setAnterior(anteriorAlBloque);
        size -= eliminados;

        return eliminados;
    }

    //modificar la lista que recibe el mensaje dejando solo los elementos en posiciones pares
    public PositionList<E> soloPares(E elem){
        PositionList<E> lista = new ListaDobleEnlace<>();

        DNodo<E> pos = header.getSiguiente();
        int cant = size;
        for (int i=1; i<=cant; i++){
            if (i % 2 == 0){
                if (pos.element().equals(elem)){
                    lista.addLast(pos.element());
                    this.remove(pos);
                }
            }
            pos = pos.getSiguiente();
        }
        return lista;
    }

    


}
