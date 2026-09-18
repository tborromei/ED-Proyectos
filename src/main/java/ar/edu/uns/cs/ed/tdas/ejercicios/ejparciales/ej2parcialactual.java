package ar.edu.uns.cs.ed.tdas.ejercicios.ejparciales;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class ej2parcialactual {

    /**
     * Indica si los elementos de l1 aparecen en l2 en el mismo orden,
     * aunque haya otros elementos intercalados. No modifica las listas.
     * Compara por equivalencia y supone listas y elementos no nulos.
     */
    public static <E> boolean contieneEnOrden(PositionList<E> l1, PositionList<E> l2) {

        Iterator<E> it2 = l2.iterator();

        for (E buscado : l1) {
            boolean encontrado = false;

            while (it2.hasNext() && !encontrado) {
                E actual = it2.next();
                if (buscado.equals(actual)) {
                    encontrado = true;
                }
            }
            if (!encontrado) {
                return false;
            }

        }
        // Encontramos todos los elementos de l1 (tambien vale si l1 esta vacia).
        
        return true;
    }

    public static <E> boolean contenidaConAuxiliar(
        PositionList<E> l1, PositionList<E> l2) {

        PositionList<E> l3 = new ListaDobleEnlace<>();

        if (l1.isEmpty()) {
            return true;
        }

        Iterator<E> it1 = l1.iterator();
        E buscado = it1.next();

        // 1. Construimos L3 con las coincidencias en orden.
        for (E actual : l2) {
            if (buscado.equals(actual)) {
                l3.addLast(actual);

                if (!it1.hasNext()) {
                    break; // Ya encontramos todo lo que pedia L1.
                }

                buscado = it1.next();
            }
        }

        // 2. Comparamos L1 con L3.
        if (l1.size() != l3.size()) {
            return false;
        }

        Iterator<E> it3 = l3.iterator();

        for (E elemento : l1) {
            if (!elemento.equals(it3.next())) {
                return false;
            }
        }

        return true;
    }

    public static <E> boolean contenidaOrdenadamente(
        PositionList<E> l1, PositionList<E> l2) {

        Iterator<E> it1 = l1.iterator();
        Iterator<E> it2 = l2.iterator();

        while (it1.hasNext()) {
            E buscado = it1.next();
            boolean encontrado = false;

            while (it2.hasNext() && !encontrado) {
                E actual = it2.next();

                if (buscado.equals(actual)) {
                    encontrado = true;
                }
            }

            if (!encontrado) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        PositionList<Character> l1 = new ListaDobleEnlace<>();
        PositionList<Character> l2 = new ListaDobleEnlace<>();

        l1.addLast('a');
        l1.addLast('a');
        l1.addLast('b');

        l2.addLast('a');
        l2.addLast('x');
        l2.addLast('y');
        l2.addLast('a');
        l2.addLast('c');
        l2.addLast('b');

        // Para depurar: poner un breakpoint aqui y entrar al metodo con F11.
        boolean resultado = contieneEnOrden(l1, l2); // Esperado: true.
    }
}
