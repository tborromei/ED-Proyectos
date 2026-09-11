package ar.edu.uns.cs.ed.tdas;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class ElementIterator<E> implements Iterator<E> {
    
    protected PositionList<E> list;
    protected Position<E> cursor;

    public ElementIterator(PositionList<E> poslist){
        list = poslist;
        if (list.isEmpty()){
            cursor=null;
        }else{
            try{
                cursor = list.first();
            }catch (EmptyListException e){
                e.printStackTrace();
            }
        }
    }

    public boolean hasNext(){
        return cursor != null;
    }

    public E next() throws NoSuchElementException {
        if (cursor == null){
            throw new NoSuchElementException("No existe el siguiente elemento.");
        }
        E elem = cursor.element();
        try{
            if (cursor == list.last()){
                cursor = null;
            }else{
                cursor = list.next(cursor);
            }
        }catch (InvalidPositionException | BoundaryViolationException | EmptyListException e){
            e.printStackTrace();
        }
        return elem;
    }

}
