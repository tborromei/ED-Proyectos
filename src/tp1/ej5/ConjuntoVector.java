package tp1.ej5;

import java.util.Vector;

public class ConjuntoVector<E> implements Conjunto<E> {

    private Vector<E> vector;

    public ConjuntoVector(int length) {
        vector = new Vector<E>(length);
    }

    public int size() {
        return vector.size();
    }

    public int capacity() {
        return vector.capacity();
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }

    public E get(int i) {
        E elem = null;

        if (i >= 0 && i < vector.size()) {
            elem = vector.get(i);
        }

        return elem;
    }

    public void put(E elem) {
        if (elem != null && vector.size() < vector.capacity() && !pertenece(elem)) {

            vector.add(elem);
        }
    }

    public boolean pertenece(E elem) {
        return vector.contains(elem);
    }

    public Conjunto<E> interseccion(Conjunto<E> c) {
        Conjunto<E> interseccion = null;
        if (c != null) {
            int tamanio = Math.min(this.size(), c.size());
            interseccion = new ConjuntoVector<E>(tamanio);

            for (int i = 0; i < this.size(); i++) {
                E elem = this.get(i);
                if (c.pertenece(elem)) {
                    interseccion.put(elem);
                }
            }
        }
        return interseccion;
    }
}