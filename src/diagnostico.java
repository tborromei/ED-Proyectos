public class diagnostico {
    
    public static void main(String[] args) {
        estudiante[] comision = new estudiante[3];
        
        estudiante e1 = new estudiante("Ana", 8);
        estudiante e2 = new estudiante("Juan", 6);
        //comentario de prueba
        //2do comentaqrio prueba
        comision[0] = e1;
        comision[1] = e2;
        
        // Operación clave
        estudiante e3 = comision[0];
        e3.nota = 10;
        
        // Pregunta 1: ¿Qué imprime la siguiente línea?
        System.out.println("La nota de Ana es: " + e1.nota);
        
        // Pregunta 2: ¿Qué sucede si ejecutamos la siguiente línea?
         System.out.println(comision[2].nombre);
    }
    
    // Pregunta 3: Implementar este método
    public static estudiante buscarMejorPromedio(estudiante[] arreglo) {
        // Escribimos entre todos este método
        return null; 
    }
}
