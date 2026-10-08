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

public class DiccionarioConLista<K,V> implements Dictionary<K,V> {

    private PositionList<Entrada<K,V>> pl;

    public DiccionarioConLista(){
        pl = new ListaDobleEnlace<Entrada<K,V>>();
    }

    @Override
	public int size() {
		return pl.size();
	}

	@Override
	public boolean isEmpty() {
		return pl.isEmpty();
	}

    @Override 
    public Entry<K,V> find(K key) throws InvalidKeyException{
        if (key==null) throw new InvalidKeyException("Clave nula.");
        Iterator<Entrada<K,V>> it = pl.iterator();
		Entry<K,V> retornar = null;
		boolean encontre = false;
        while (it.hasNext() && !encontre){
            Entrada<K,V> actual = it.next();
            if (actual.getKey().equals(key)){
                encontre = true;
                retornar = actual;
            }
        }
        return retornar;
    }

    @Override 
    public Iterable<Entry<K,V>> findAll(K key){
        if (key==null) throw new InvalidKeyException("Clave nula.");
        PositionList<Entry<K,V>> lista = new ListaDobleEnlace<>();
        Iterator<Entrada<K,V>> it = pl.iterator();
        while (it.hasNext()){
            Entrada<K,V> actual = it.next();
            if (actual.getKey().equals(key)){
                lista.addLast(actual);
            }
        }
        return lista;
    }

    @Override 
    public Entry<K,V> insert(K key, V value){
        if (key==null) throw new InvalidKeyException("Clave nula.");
        Entrada<K,V> entrada = new Entrada<>(key,value);
        pl.addLast(entrada);
        return entrada;
    }

    @Override
    public Entry<K, V> remove(Entry<K, V> e) {
        if (e == null) {
            throw new InvalidEntryException("Entrada nula.");
        }

        Iterator<Position<Entrada<K, V>>> it = pl.positions().iterator();

        while (it.hasNext()) {
            Position<Entrada<K, V>> actual = it.next();

            if (actual.element() == e) {
                return pl.remove(actual);
            }
        }

        throw new InvalidEntryException("La entrada no pertenece al diccionario.");
    }

	@Override
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> nueva = new ListaDobleEnlace<>();
		for( Entrada<K,V> e: pl){
			nueva.addLast(e);
        }
		return nueva;
	}
}