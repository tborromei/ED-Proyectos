package ar.edu.uns.cs.ed.tdas.ejercicios.tp1.ej4;

public interface Conjunto<E> {
    public abstract int size();

    public abstract int capacity();  

    public abstract boolean isEmpty();

    public abstract E get(int i);

    public abstract void put(E elem);

    public abstract boolean pertenece(E elem);

    public abstract Conjunto<E> interseccion(Conjunto<E> c);
}
