package tp1.ej2;

public interface Conjunto<E> {

    public abstract int size();

    public abstract int capacity();  

    public abstract boolean isEmpty();

    public abstract E get(int i);

    public abstract void put(E elem);

    public abstract boolean pertenece(E elem);

    public abstract Conjunto<E> interseccion(Conjunto<E> c);

}
