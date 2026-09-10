package ar.edu.uns.cs.ed.tdas.ejercicios.tp3.ej1;
import ar.edu.uns.cs.ed.tdas.tdapila.Stack;
public class Tester {
    public static void main(String[] args){

        Stack<Integer> stacksito = new PilaConArreglo<Integer>();
        //declara un stack de strings y le asigna un stack array de strings

        stacksito.push(1111);
        stacksito.push(2222);
        stacksito.push(3333);
        
        stacksito.pop();
        stacksito.pop();
        stacksito.pop();


    }
}
