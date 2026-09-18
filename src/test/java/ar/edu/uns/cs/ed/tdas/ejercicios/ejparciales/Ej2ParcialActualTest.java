package ar.edu.uns.cs.ed.tdas.ejercicios.ejparciales;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Ej2ParcialActualTest {

    @Test
    public void rechazaElEjemploConLaErrataCorregida() {
        assertFalse(ej2parcialactual.estaContenidaOrdenadamente(
                listaCon("a", "c", "b"), listaCon("a", "x", "b", "y", "c")));
    }

    @Test
    public void rechazaCuandoLaUltimaCoincidenciaQuedoAtras() {
        assertFalse(ej2parcialactual.estaContenidaOrdenadamente(
                listaCon("a", "b", "c"), listaCon("a", "x", "c", "y", "b")));
    }

    @Test
    public void aceptaRepetidosCuandoHayUnaCoincidenciaParaCadaUno() {
        assertTrue(ej2parcialactual.estaContenidaOrdenadamente(
                listaCon("a", "a", "b"), listaCon("a", "x", "y", "a", "c", "b")));
    }

    @Test
    public void rechazaCuandoUnElementoSoloApareceAntesDelAnterior() {
        assertFalse(ej2parcialactual.estaContenidaOrdenadamente(
                listaCon("a", "b", "c"), listaCon("x", "b", "a", "c")));
    }

    @Test
    public void aceptaCoincidenciasConSaltosSinModificarLasListas() {
        PositionList<String> l1 = listaCon("a", "b", "c");
        PositionList<String> l2 = listaCon("x", "a", "y", "b", "z", "c", "w");

        assertTrue(ej2parcialactual.estaContenidaOrdenadamente(l1, l2));

        assertContenido(l1, "a", "b", "c");
        assertContenido(l2, "x", "a", "y", "b", "z", "c", "w");
    }

    @Test
    public void aceptaUnaPrimeraListaVacia() {
        assertTrue(ej2parcialactual.estaContenidaOrdenadamente(
                Ej2ParcialActualTest.<String>listaCon(), listaCon("a", "b")));
    }

    @Test
    public void aceptaDosListasVacias() {
        assertTrue(ej2parcialactual.estaContenidaOrdenadamente(
                Ej2ParcialActualTest.<String>listaCon(), Ej2ParcialActualTest.<String>listaCon()));
    }

    @Test
    public void rechazaUnaSegundaListaVaciaSiLaPrimeraTieneElementos() {
        assertFalse(ej2parcialactual.estaContenidaOrdenadamente(
                listaCon("a"), Ej2ParcialActualTest.<String>listaCon()));
    }

    @Test
    public void aceptaListasConElMismoContenido() {
        assertTrue(ej2parcialactual.estaContenidaOrdenadamente(
                listaCon("a", "b", "b", "c"), listaCon("a", "b", "b", "c")));
    }

    @Test
    public void aceptaLaMismaInstanciaEnAmbosParametros() {
        PositionList<String> lista = listaCon("a", "a", "b", "c");

        assertTrue(ej2parcialactual.estaContenidaOrdenadamente(lista, lista));

        assertContenido(lista, "a", "a", "b", "c");
    }

    @Test
    public void rechazaUnaPrimeraListaMasLarga() {
        assertFalse(ej2parcialactual.estaContenidaOrdenadamente(
                listaCon("a", "b", "c"), listaCon("a", "b")));
    }

    @Test
    public void rechazaRepeticionesInsuficientesAunqueLaSegundaListaSeaMasLarga() {
        assertFalse(ej2parcialactual.estaContenidaOrdenadamente(
                listaCon("a", "a", "b"), listaCon("a", "x", "b", "y", "c")));
    }

    @Test
    public void comparaPorEqualsAunqueLosObjetosSeanDistintos() {
        assertTrue(ej2parcialactual.estaContenidaOrdenadamente(
                listaCon(new String("a"), new String("b")),
                listaCon(new String("a"), new String("x"), new String("b"))));
    }

    @Test
    public void conservaLasListasCuandoFaltaUnElemento() {
        PositionList<String> l1 = listaCon("a", "b", "c");
        PositionList<String> l2 = listaCon("a", "x", "b", "y", "d");

        assertFalse(ej2parcialactual.estaContenidaOrdenadamente(l1, l2));

        assertContenido(l1, "a", "b", "c");
        assertContenido(l2, "a", "x", "b", "y", "d");
    }

    @SafeVarargs
    private static <E> PositionList<E> listaCon(E... elementos) {
        PositionList<E> lista = new ListaDobleEnlace<E>();
        for (E elemento : elementos) {
            lista.addLast(elemento);
        }
        return lista;
    }

    @SafeVarargs
    private static <E> void assertContenido(PositionList<E> lista, E... esperado) {
        List<E> obtenido = new ArrayList<E>();
        for (E elemento : lista) {
            obtenido.add(elemento);
        }

        assertEquals(esperado.length, lista.size());
        assertArrayEquals(esperado, obtenido.toArray());
    }
}
