package ar.edu.uns.cs.ed.tdas.ejercicios.tp1.ej4;

public class TesterConjunto {

    public static void main(String[] args) {

        Conjunto<Integer> c1 = new ConjuntoArreglo<Integer>(5);

        System.out.println("=== CONJUNTO 1 ===");

        System.out.println("Capacidad: " + c1.capacity());
        System.out.println("Tamaño inicial: " + c1.size());
        System.out.println("¿Está vacío?: " + c1.isEmpty());

        c1.put(10);
        c1.put(20);
        c1.put(30);

        System.out.println("\nLuego de agregar 10, 20 y 30:");

        System.out.println("Tamaño: " + c1.size());
        System.out.println("¿Está vacío?: " + c1.isEmpty());

        System.out.println("Elemento 0: " + c1.get(0));
        System.out.println("Elemento 1: " + c1.get(1));
        System.out.println("Elemento 2: " + c1.get(2));

        System.out.println("¿Pertenece 20?: " + c1.pertenece(20));
        System.out.println("¿Pertenece 50?: " + c1.pertenece(50));


        Conjunto<Integer> c2 = new ConjuntoArreglo<Integer>(5);

        c2.put(20);
        c2.put(30);
        c2.put(40);

        System.out.println("\n=== CONJUNTO 2 ===");

        for (int i = 0; i < c2.size(); i++) {
            System.out.println(c2.get(i));
        }


        Conjunto<Integer> interseccion = c1.interseccion(c2);

        System.out.println("\n=== INTERSECCIÓN ===");

        for (int i = 0; i < interseccion.size(); i++) {
            System.out.println(interseccion.get(i));
        }
    }
}
