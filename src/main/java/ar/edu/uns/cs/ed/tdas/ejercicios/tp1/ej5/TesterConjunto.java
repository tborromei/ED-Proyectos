package ar.edu.uns.cs.ed.tdas.ejercicios.tp1.ej5;

public class TesterConjunto {

    public static void main(String[] args) {

        Conjunto<Integer> c = new ConjuntoVector<Integer>(5);

        System.out.println(c.size());
        System.out.println(c.capacity());
        System.out.println(c.isEmpty());

        c.put(10);
        c.put(20);
        c.put(30);

        System.out.println(c.size());
        System.out.println(c.get(0));
        System.out.println(c.get(1));
        System.out.println(c.get(2));

        System.out.println(c.pertenece(20));
        System.out.println(c.pertenece(50));
    }
}
