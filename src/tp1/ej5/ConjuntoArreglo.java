package tp1.ej5;
import java.util.AbstractCollection;
import java.util.Vector;

public class ConjuntoArreglo<E> implements Conjunto<E> {
    //atributos de instancia
    private Vector<E> arreglo;
    private int cant;

    public ConjuntoArreglo(int length){
        arreglo = new Vector<E>(length);
        cant = length;
    }

    public int size(){
        return arreglo.size();

        /*  Go to Super Implementation
            int java.util.Vector.size()
            Returns the number of components in this vector.
            Specified by: size() in List, Overrides: size() in AbstractCollection
            Returns:
            the number of components in this vector
        */
    }

    public int capacity(){
        return cant;
    }

    public boolean isEmpty(){
        return arreglo.isEmpty();
        /*  Go to Super Implementation
            boolean java.util.Vector.isEmpty()
            Tests if this vector has no components.
            Specified by: isEmpty() in List, Overrides: isEmpty() in AbstractCollection
            Returns:
            true if and only if this vector has no components, that is, its size is zero; false otherwise.
         */
    }

    public E get(int i){
        return arreglo.get(i);
        //.get de la clase Vector
    }

    public void put(E elem){
        arreglo.add(elem);
        //.add de la clase Vector
    }

    public boolean pertenece(E elem){
        return arreglo.contains(elem);
        //.contains de la clase Vector
    }

    public Conjunto<E> interseccion(Conjunto<E> c) {
        Conjunto<E> resultado = null;
        if (c!=null){
            resultado = 
            new ConjuntoArreglo<E>(Math.min(this.size(), c.size()));

            for (int i = 0; i < this.size(); i++) {

                E elem = this.get(i);

                if (c.pertenece(elem)) {
                    resultado.put(elem);
                }
            }
        }
        return resultado;
    }

    
}
