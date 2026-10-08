package ar.edu.uns.cs.ed.tdas.tdamapeo;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;
import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.Entrada;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;

public class MapeoConHash<K,V> implements Map<K,V> {

    private Map<K,V>[] tabla;
    private int cantidad;
    private int N;

    @SuppressWarnings("unchecked")
    public MapeoConHash() {
        N = 13;
        cantidad = 0;

        tabla = (Map<K,V>[]) new Map[N];

        for (int i = 0; i < N; i++) {
            tabla[i] = new MapeoConLista<K,V>();
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
    public V get(K key) {
        return tabla[hash(key)].get(key);
    }

    private boolean contieneClave(Map<K,V> cubeta, K key) {
        for (Entry<K,V> e : cubeta.entries()) {
            if (e.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public V put(K key, V value) {
        int i = hash(key);
        boolean existia = contieneClave(tabla[i], key);

        V anterior = tabla[i].put(key, value);

        if (!existia) {
            cantidad++;
        }

        return anterior;
    }

    @Override
    public V remove(K key) {
        int i = hash(key);

        if (!contieneClave(tabla[i], key)) {
            return null;
        }

        V eliminado = tabla[i].remove(key);
        cantidad--;
        return eliminado;
    }

    @Override
    public Iterable<K> keys() {
        PositionList<K> resultado = new ListaDobleEnlace<>();

        for (int i = 0; i < N; i++) {
            for (Entry<K,V> e : tabla[i].entries()) {
                resultado.addLast(e.getKey());
            }
        }

        return resultado;
    }

    @Override
    public Iterable<V> values() {
        PositionList<V> resultado = new ListaDobleEnlace<>();

        for (int i = 0; i < N; i++) {
            for (Entry<K,V> e : tabla[i].entries()) {
                resultado.addLast(e.getValue());
            }
        }

        return resultado;
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
