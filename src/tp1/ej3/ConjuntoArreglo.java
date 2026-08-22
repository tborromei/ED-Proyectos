package tp1.ej3;

public class ConjuntoArreglo<E> implements Conjunto<E> {
    //atributos de instancia
    private E[] arreglo;
    private int size;

    public ConjuntoArreglo(int length){
        arreglo = (E[]) new Object[length];
        size = 0;
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return arreglo.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int i){
        E elem = null;
        if (i>=0 && i<size){
            elem = arreglo[i];
        }
        return elem;
    }

    public void put(E elem){
        if (elem!=null && size <= arreglo.length && !pertenece(elem)){
            arreglo[size] = elem;
            size++;
        }
    }

    public boolean pertenece(E elem){
        boolean pertenece = false;
        for (int i=0; i<size && !pertenece; i++){
            if (arreglo[i].equals(elem)){
                pertenece = true;
            }
        }
        return pertenece;
    }

    public Conjunto<E> interseccion(Conjunto<E> c){
        ConjuntoArreglo<E> interseccion=null;
        if (c!=null){
            int tamanio = Math.min(arreglo.length, c.size());
            interseccion = new ConjuntoArreglo<E>(tamanio);

            for (int i=0; i < arreglo.length; i++){
                E elem = this.get(i);
                if (c.pertenece(elem)) {
                    interseccion.put(elem);
                }
            }

        }
        return interseccion;
    }

    
}
