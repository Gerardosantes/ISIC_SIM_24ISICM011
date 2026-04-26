
package practica2_2;


public class Practica2_2 {

   
    public static void main(String[] args) {
     
  
        // Configuración inicial
        long semilla = 1234;
        int nDigitos = 4;
        int nNumeros = 10;
        
        long x = semilla;

        long divisorCentro = (long) Math.pow(10, nDigitos / 2);
        long moduloCentro = (long) Math.pow(10, nDigitos);

        System.out.println("Generando " + nNumeros + " numeros usando Cuadrado Medio:");
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < nNumeros; i++) {
            // 1. Elevar al cuadrado
            long cuadrado = x * x;

            // 2. Aplicar función piso (la división entre long en Java ya es piso)
            // y el módulo para obtener los dígitos centrales
            x = Math.floorDiv(cuadrado, divisorCentro) % moduloCentro;

            // 3. Normalizar el número (convertirlo a rango 0-1)
            double u = x / Math.pow(10, nDigitos);

            // Mostrar resultados en consola
            System.out.printf("Iteracion %d: Semilla extraida = %d | Numero U = %.4f%n", (i + 1), x, u);
        }
    }
}
        
      
    
    

