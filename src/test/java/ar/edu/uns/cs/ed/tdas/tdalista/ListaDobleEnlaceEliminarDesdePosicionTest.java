package ar.edu.uns.cs.ed.tdas.tdalista;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;

public class ListaDobleEnlaceEliminarDesdePosicionTest {

    @Test
    public void eliminaLaCantidadPedidaDesdeElMedio() {
        ListaDobleEnlace<String> lista = listaCon("A", "B", "C", "D", "E");
        Position<String> inicio = lista.next(lista.first());

        int eliminados = lista.eliminarDesdePosicion(inicio, 2);

        assertEquals(2, eliminados);
        assertContenido(lista, "A", "D", "E");
        assertEquals("A", lista.prev(lista.next(lista.first())).element());
    }

    @Test
    public void eliminaSoloLosDisponibles() {
        ListaDobleEnlace<String> lista = listaCon("A", "B", "C", "D");
        Position<String> inicio = lista.next(lista.next(lista.first()));

        int eliminados = lista.eliminarDesdePosicion(inicio, 10);

        assertEquals(2, eliminados);
        assertContenido(lista, "A", "B");
    }

    @Test
    public void puedeEliminarLaListaCompleta() {
        ListaDobleEnlace<String> lista = listaCon("A", "B", "C");

        int eliminados = lista.eliminarDesdePosicion(lista.first(), 3);

        assertEquals(3, eliminados);
        assertContenido(lista);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rechazaUnaCantidadNoPositiva() {
        ListaDobleEnlace<String> lista = listaCon("A");

        lista.eliminarDesdePosicion(lista.first(), 0);
    }

    @Test(expected = InvalidPositionException.class)
    public void rechazaUnaPosicionNula() {
        ListaDobleEnlace<String> lista = listaCon("A");

        lista.eliminarDesdePosicion(null, 1);
    }

    @SafeVarargs
    private static <E> ListaDobleEnlace<E> listaCon(E... elementos) {
        ListaDobleEnlace<E> lista = new ListaDobleEnlace<E>();
        for (E elemento : elementos) {
            lista.addLast(elemento);
        }
        return lista;
    }

    @SafeVarargs
    private static <E> void assertContenido(ListaDobleEnlace<E> lista, E... esperado) {
        List<E> obtenido = new ArrayList<E>();
        for (E elemento : lista) {
            obtenido.add(elemento);
        }

        assertEquals(esperado.length, lista.size());
        assertArrayEquals(esperado, obtenido.toArray());
    }
}
