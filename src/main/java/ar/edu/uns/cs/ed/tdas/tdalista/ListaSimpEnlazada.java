package ar.edu.uns.cs.ed.tdas.tdalista;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ar.edu.uns.cs.ed.tdas.excepciones.*;
import ar.edu.uns.cs.ed.tdas.DNodo;
import ar.edu.uns.cs.ed.tdas.Nodo;
import ar.edu.uns.cs.ed.tdas.Position;

public class ListaSimpEnlazada <E> implements PositionList <E> {

	protected Nodo<E> head;
	protected int size;
	
	public ListaSimpEnlazada(){
		head=null;
		size=0;
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	
	public Position<E> first() throws EmptyListException{
		if(isEmpty()){
			throw new EmptyListException("Lista vacia");
		}
		return head;
	}

	
	public Position<E> last() throws EmptyListException {
		if(isEmpty()){
			throw new EmptyListException("Lista vacia");
		}
		Nodo<E> aux = head;
		while(aux.getSiguiente()!=null){
			aux = aux.getSiguiente();
		}
		return aux;
	}

	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		Nodo<E> n = checkPosition(p);
		if(n.getSiguiente() == null){
			throw new BoundaryViolationException("limite");
		}
		return n.getSiguiente();
	}

	
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		Nodo<E> n= checkPosition(p);
		if(p == head){
			throw new BoundaryViolationException("Limite");
		}
		
		Nodo<E> aux= head;
		while(aux!= null && aux.getSiguiente() != n  ){
			aux=aux.getSiguiente();
		}
		if(aux==null ){
			throw new InvalidPositionException("Posicion Invalida");
		}
		return aux;
	}

	
	public void addFirst(E element) {
		Nodo<E> nuevo = new Nodo<E>(element,head);
		head=nuevo;
		size++;
	}

	
	public void addLast(E element) {
		if(isEmpty()){
			addFirst(element);
		}
		else{
			Nodo<E> p = head;
			while(p.getSiguiente()!=null){
				p=p.getSiguiente();
			}
			p.setSiguiente(new Nodo<E> (element,null));
			size++;
		}
	}

	
	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		Nodo<E> n = checkPosition(p);
		Nodo<E> nuevo=new Nodo<E>(element,n.getSiguiente());
		n.setSiguiente(nuevo);
		size++;
	}

	
	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		Nodo<E> n=checkPosition(p);
		if(n == head){
			Nodo<E> nuevo= new Nodo<E>(element,n);
			head=nuevo;
			size++;
		}
		else{
			Nodo<E> cursor=head;
			while(cursor.getSiguiente()!=n && cursor!=null) {
				cursor=cursor.getSiguiente();
			}
			if(cursor==null)
				throw new InvalidPositionException("Posicion invalida ");
			
			Nodo<E> nuevo= new Nodo<E>(element, n);
			cursor.setSiguiente(nuevo);
			size++;
			
			
		}
	}

	
	public E remove(Position<E> p) throws InvalidPositionException {
		Nodo<E>n=checkPosition(p);
		E aux=n.element();
		if(n == head){
			head=head.getSiguiente();
		}
		else {
		Nodo<E> cursor=head;
		while(cursor!=null && cursor.getSiguiente()!=n) {
			cursor=cursor.getSiguiente();
		}
		if(cursor==null){
			throw new InvalidPositionException("Posicion invalida ");
		}

		cursor.setSiguiente(n.getSiguiente());}
		
		size--;
		
		return aux;
	}

	
	public E set(Position<E> p, E element) throws InvalidPositionException {
		if(isEmpty()){
			throw new InvalidPositionException(" ");
		}
		else{
			Nodo<E>n=checkPosition(p);
			E aux=n.element();
			n.setElemento(element);
			return aux;
		}
		
	}

	
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Nodo<E> actual = head;

			@Override
			public boolean hasNext() {
				return actual != null;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException("No hay más elementos en la lista");
				}

				E elemento = actual.element();
				actual = actual.getSiguiente();
				return elemento;
			}
		};
	}

	
	public Iterable<Position<E>> positions() {
	 PositionList<Position<E>> nueva = new ListaSimpEnlazada<Position<E>>();
	 if(!isEmpty()) {
		Nodo<E> cursor=head;
		while(cursor!=null) {
			nueva.addLast(cursor);
			cursor=cursor.getSiguiente();
		}
		}
		return nueva;
	}
	
	private Nodo<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if(p==null || isEmpty() ){
			throw new InvalidPositionException ("Posicion invalida");
				}
		try{ Nodo<E> n = (Nodo<E>)p;
			return n;
		}catch (ClassCastException e) { throw new ClassCastException(" ");}
	}
	
}
 
