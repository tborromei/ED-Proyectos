package ar.edu.uns.cs.ed.tdas.tdadiccionario;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.Entrada;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidEntryException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class DiccionarioConHash<K,V> implements Dictionary<K,V> {

    private Dictionary<K,V>[] tabla;
    private int cantidad;
    private int N;

    @SuppressWarnings("unchecked")
    public DiccionarioConHash() {
        N = 13;
        cantidad = 0;

        tabla = (Dictionary<K,V>[]) new Dictionary[N];

        for (int i = 0; i < N; i++) {
            tabla[i] = new DiccionarioConLista<K,V>();
        }
    }

    private int hash(K key) {
        if (key == null) {
            throw new InvalidKeyException("Clave nula.");
        }

        return Math.floorMod(key.hashCode(), N);
    }

    @Override
    public int size() {
        return cantidad;
    }

    @Override
    public boolean isEmpty() {
        return cantidad == 0;
    }

    @Override
    public Entry<K,V> find(K key) {
        return tabla[hash(key)].find(key);
    }

    @Override
    public Iterable<Entry<K,V>> findAll(K key) {
        return tabla[hash(key)].findAll(key);
    }

    @Override
    public Entry<K,V> insert(K key, V value) {
        Entry<K,V> nueva = tabla[hash(key)].insert(key, value);
        cantidad++;
        return nueva;
    }

    @Override
    public Entry<K,V> remove(Entry<K,V> e) {
        if (e == null || e.getKey() == null) {
            throw new InvalidEntryException("Entrada inválida.");
        }

        Entry<K,V> eliminada = tabla[hash(e.getKey())].remove(e);
        cantidad--;
        return eliminada;
    }

    @Override
    public Iterable<Entry<K,V>> entries() {
        PositionList<Entry<K,V>> resultado = new ListaDobleEnlace<>();

        for (int i = 0; i < N; i++) {
            for (Entry<K,V> e : tabla[i].entries()) {
                resultado.addLast(e);
            }
        }

        return resultado;
    }
}
