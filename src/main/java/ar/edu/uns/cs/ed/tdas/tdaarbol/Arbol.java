package ar.edu.uns.cs.ed.tdas.tdaarbol;

import ar.edu.uns.cs.ed.tdas.TNodo;
import ar.edu.uns.cs.ed.tdas.DNodo;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import java.util.Iterator;

public class Arbol<E> implements Tree<E> {

    protected TNodo<E> raiz;
    protected int size;

    public Arbol(){
        raiz = null;
        size = 0;
    }

    public boolean isEmpty(){
        return raiz==null;
    }

    public Position<E> parent(Position<E> v){
        TNodo<E> nodoparam = checkPosition(v);
        return nodoparam.getPadre();
    }
    public boolean isInternal(Position<E> v){
        TNodo<E> nodoparam = checkPosition(v);
        
    }
    public Position<E> root(){
        if (isEmpty()) throw new EmptyTreeException("Arbol vacío");
        return raiz;
    }

    public boolean isExternal(Position<E> v){
        TNodo<E> nodo = checkPosition(v);
        return nodo.getHijos().isEmpty();
    }

    public Position<E> addFirstChild(Position<E> p, E elem){
        TNodo<E> nodo = checkPosition(p);
        TNodo<E> nuevo = new TNodo<E>(elem, nodo);
        nodo.getHijos().addFirst(nuevo);
        size++;
        return nuevo;
    }

    public Position<E> addBefore(Position<E> p, Position<E> rb, E e){
        TNodo<E> n = checkPosition(p);
        TNodo<E> hd = checkPosition(rb);
        TNodo<E> nuevo = new TNodo<E>(e, n);
        PositionList<TNodo<E>> hijos = n.getHijos();

        boolean encontre = false;
        Position<TNodo<E>> pp = hijos.first();
        while (pp != null && !encontre){
            if (hd==pp.element()){
                encontre = true;
            }else{
                pp = pp!=hijos.last() ? hijos.next(pp) : null;
            }
        }
        if (!encontre) throw new InvalidPositionException("p no es padre de rb");
        hijos.addBefore(pp, nuevo);
        size++;
        return nuevo;
    }

    public void removeExternalNode(Position<E> p){
        if (isEmpty()) throw new InvalidPositionException("Árbol vacío.");
        TNodo<E> n = checkPosition(p);

        if (!n.getHijos().isEmpty()) throw new InvalidPositionException("P no es hoja.");
        if (p==raiz){
            raiz = null;
            size = 0;
            n.setElemento(null);
            return;
        }

        TNodo<E> padre = n.getPadre();
        PositionList<TNodo<E>> hijosPadre = padre.getHijos();
        boolean encontre = false;
        Position<TNodo<E>> pp = null;
        Iterable<Position<TNodo<E>>> posiciones = hijosPadre.positions();
        Iterator<Position<TNodo<E>>> it = posiciones.iterator();
        while (it.hasNext() && !encontre){
            pp = it.next();
            if (pp.element() == n) encontre = true;
        }
        if (!encontre) throw new InvalidPositionException("P no aparece en la lista de hijos de su padre.");
        hijosPadre.remove(pp);
        n.setElemento(null);
        size--;
    }

    public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException{
        TNodo<E> p = checkPosition(v);
        PositionList<Position<E>> lista = new ListaDobleEnlace<>();
        for (TNodo<E> n : p.getHijos()){
            lista.addLast(n);
        }
        return lista;
    }

    public Iterable<Position<E>> positions(){
        PositionList<Position<E>> l = new ListaDobleEnlace<>();
        if (!isEmpty()) pre(raiz, l);
        return l;
    }
    private void pre(TNodo<E> v, PositionList<Position<E>> l){
        l.addLast(v);
        for (TNodo<E> h: v.getHijos()){
            pre(h,l);
        }
    }

    public Iterator<E> iterator(){
        PositionList<E> l = new ListaDobleEnlace<E>();
        for( Position<E> p : positions() )
            l.addLast( p.element() );
        return l.iterator();
    }
    
    private TNodo<E> checkPosition(Position<E> p) {
        if (size==0) {
            throw new EmptyTreeException("El arbol está vacío.");
        }

        if (p == null) {
            throw new InvalidPositionException("La posición es nula.");
        }

        try {
            TNodo<E> nodo = (TNodo<E>) p;
            return nodo;

        } catch (ClassCastException e) {
            throw new InvalidPositionException("La posición no pertenece a un árbol.");
        }
    }
}
