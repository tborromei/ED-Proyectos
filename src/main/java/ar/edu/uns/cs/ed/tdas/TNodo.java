package ar.edu.uns.cs.ed.tdas;

import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;



public class TNodo<E> implements Position<E> {
    private E elemento;
    private TNodo<E> padre;
    private PositionList<TNodo<E>> hijos;


    public TNodo(E elem, TNodo<E> padre){
        elem = elemento;
        this.padre = padre;
        hijos = new ListaDobleEnlace<TNodo<E>>();
    }
    public TNodo(E elemento){
        this(elemento,null);
    }
    
    public TNodo<E> getPadre(){
        return padre;
    }
    public E element(){
        return elemento;
    }
    public PositionList<TNodo<E>> getHijos(){
        return hijos;
    }

    public void setElemento(E elem){
        elemento = elem;
    }
    public void setPadre(TNodo<E> padre){
        this.padre = padre;
    }

}
