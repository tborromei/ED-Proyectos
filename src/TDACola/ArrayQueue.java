package TDACola;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
/**
 * Class ArrayQueue
 * @author Ary Othaz y Camila Veroni
 */

public class ArrayQueue<E> implements Queue<E> {
		
	private E[] cola;
	private int i;
	private int f;
	private static int longitud=10;
	
	/**
	 * Construye una cola vac�a
	 */
	
	public ArrayQueue() {
		cola= (E[])new Object[longitud];
		i=0;
		f=0;
	}
	
	public boolean isEmpty() {
		return (i==f);
	}
	public int size() {
		return((cola.length - i + f)%cola.length);
	}
	
	public void enqueue(E e) {
		if (cola.length -1 ==size()){
			E[] aux=copiar(i);
			f=size();
			i=0;
			cola=aux;}
		cola[f]=e;
		f=(f+1)%cola.length;
	}
	public E dequeue() throws EmptyQueueException{
		if (isEmpty())
			throw new EmptyQueueException("Cola Vacia");
		else{
			E aux=cola[i];
			cola[i]=null;
			i=(i+1)%cola.length;
			return aux;}
		
	}
	public E front() throws EmptyQueueException{
		if (isEmpty())
			throw new EmptyQueueException("Cola Vacia");
		else
			return cola[i];
	}
	
	private E[] copiar(int m) {
		E[] aux= (E[])new Object[2*cola.length];
		for (int j=0; j<size();j++){
			aux[j]=cola[m];
			m=(m+1)%cola.length;}
		return aux;
		}
	
}


