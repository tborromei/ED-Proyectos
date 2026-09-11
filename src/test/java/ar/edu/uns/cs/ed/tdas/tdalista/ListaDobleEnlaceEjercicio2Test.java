package ar.edu.uns.cs.ed.tdas.tdalista;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;

public class ListaDobleEnlaceEjercicio2Test {

    @Test
    public void agregaEnUnaListaVacia() {
        ListaDobleEnlace<String> lista = new ListaDobleEnlace<String>();

        lista.agregarSegundoYAnteultimo("e1", "e2");

        assertContenido(lista, "e2", "e1");
    }

    @Test
    public void rechazaUnaListaConUnElementoSinModificarla() {
        ListaDobleEnlace<String> lista = new ListaDobleEnlace<String>();
        lista.addLast("A");

        try {
            lista.agregarSegundoYAnteultimo("e1", "e2");
        } catch (InvalidOperationException e) {
            assertContenido(lista, "A");
            return;
        }

        throw new AssertionError("Debia lanzar InvalidOperationException.");
    }

    @Test
    public void agregaEnUnaListaConDosElementos() {
        ListaDobleEnlace<String> lista = new ListaDobleEnlace<String>();
        lista.addLast("A");
        lista.addLast("B");

        lista.agregarSegundoYAnteultimo("e1", "e2");

        assertContenido(lista, "A", "e1", "e2", "B");
    }

    @Test
    public void agregaEnUnaListaConVariosElementos() {
        ListaDobleEnlace<String> lista = new ListaDobleEnlace<String>();
        lista.addLast("A");
        lista.addLast("B");
        lista.addLast("C");
        lista.addLast("D");

        lista.agregarSegundoYAnteultimo("e1", "e2");

        assertContenido(lista, "A", "e1", "B", "C", "e2", "D");
    }

    private static <E> void assertContenido(ListaDobleEnlace<E> lista, E... esperado) {
        List<E> obtenido = new ArrayList<E>();
        for (E elemento : lista) {
            obtenido.add(elemento);
        }

        assertEquals(esperado.length, lista.size());
        assertArrayEquals(esperado, obtenido.toArray());
    }
}
