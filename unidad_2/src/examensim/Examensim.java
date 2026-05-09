
package examensim;

public class Examensim {

    public static void main(String[] args) {

        // Generar 50 números
        double[] numeros = generarSecuencia(21435, 50);

        // Mostrar primeros 5 valores
        
        System.out.println("PRIMEROS 5 VALORES:");

        for (int i = 0; i < 5; i++) {

            System.out.printf("R%d = %.5f\n", i + 1, numeros[i]);
        }

        // Mostrar los 50 números
        System.out.println("\nNUMEROS GENERADOS:");

        for (int i = 0; i < numeros.length; i++) {

            System.out.printf("R%d = %.5f\n", i + 1, numeros[i]);
        }

        // Prueba Chi-Cuadrada
        realizarPruebaChi(numeros, 5, 9.488);
    }

    
    // METODO CUADRADO MEDIO
    

    public static double[] generarSecuencia(long semilla, int cantidad) {

        double[] numeros = new double[cantidad];

        long x = semilla;

        // Cantidad de dígitos de la semilla
        int d = String.valueOf(semilla).length();

        for (int i = 0; i < cantidad; i++) {

            // Elevar al cuadrado
            long cuadrado = x * x;

            // Completar con ceros
            String texto = String.format("%0" + (2 * d) + "d", cuadrado);

            // Sacar números del centro
            int inicio = (texto.length() - d) / 2;

            x = Long.parseLong(texto.substring(inicio, inicio + d));

            // Convertir a decimal
            numeros[i] = x / Math.pow(10, d);
        }

        return numeros;
    }

    
    // METODO CHI-CUADRADA
    

    public static void realizarPruebaChi(double[] numeros,
                                         int intervalos,
                                         double valorCritico) {

        int n = numeros.length;

        double esperado = (double) n / intervalos;

        int[] observados = new int[intervalos];

        // Contar frecuencias
        for (double num : numeros) {

            int intervalo = (int) (num * intervalos);

            if (intervalo == intervalos) {

                intervalo--;
            }

            observados[intervalo]++;
        }

        double chi = 0;

        System.out.println("\nTABLA DE FRECUENCIAS");
        System.out.println("Intervalo\tOi\tEi");

        for (int i = 0; i < intervalos; i++) {

            double parcial =
                    Math.pow(observados[i] - esperado, 2) / esperado;

            chi += parcial;

            System.out.printf("%d\t\t%d\t%.2f\n",
                    i,
                    observados[i],
                    esperado);
        }

        // Mostrar resultado
        System.out.printf("\nChi calculada = %.4f\n", chi);

        System.out.printf("Valor critico = %.3f\n", valorCritico);

        // Decisión final
        if (chi <= valorCritico) {

            System.out.println("H0 Aceptada: Distribucion Uniforme");

        } else {

            System.out.println("H0 Rechazada: Distribucion No Uniforme");
        }
    }
}
