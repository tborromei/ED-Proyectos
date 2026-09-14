package ar.edu.uns.cs.ed.tdas.ejercicios.ejparciales.parcial1_1;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDobleEnlace;

public class ej2 {
    public static<E> boolean submulticonjunto(PositionList<Character> l1, PositionList<Character> l2){

        if (l1.size()>l2.size()) return false;

        boolean verificado = false;
        for (Character actual : l1){
            verificado = true;
            int cont1=0; 
            int cont2=0;

            for (Character c : l1){
                if (actual.equals(c)){
                    cont1++;
                }
            }
            for (Character c : l2){
                if (actual.equals(c)){
                    cont2++;
                }
            }

            if (cont1<cont2){
                verificado = false;
                break;
            }

        }

        return verificado;
    }
    public static void main(String[] args){
        PositionList<Character> lista1 = new ListaDobleEnlace<>();
        PositionList<Character> lista2 = new ListaDobleEnlace<>();

        lista1.addLast('a');
        lista1.addLast('b');
        lista1.addLast('a');

        lista2.addLast('a');
        lista2.addLast('a');
        lista2.addLast('b');
        lista2.addLast('c');
        lista2.addLast('a');

        boolean godeto = submulticonjunto(lista1, lista2);

        PositionList<Character> lista3 = new ListaDobleEnlace<>();
        PositionList<Character> lista4 = new ListaDobleEnlace<>();

        

        lista3.addLast('a');
        lista3.addLast('a');
        lista3.addLast('b');
        lista3.addLast('c');
        lista3.addLast('a');

        godeto = submulticonjunto(lista4, lista3);

        PositionList<Character> lista5 = new ListaDobleEnlace<>();
        PositionList<Character> lista6 = new ListaDobleEnlace<>();

        lista5.addLast('a');
        lista5.addLast('b');
        lista5.addLast('a');

        lista6.addLast('a');
        lista6.addLast('a');
        lista6.addLast('b');
        lista6.addLast('c');
        lista6.addLast('p');

        godeto = submulticonjunto(lista5, lista6);
    }
}
