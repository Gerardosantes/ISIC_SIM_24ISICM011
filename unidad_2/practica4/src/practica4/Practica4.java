
package practica4;

public class Practica4 {

    public static void main(String[] args) {

        // =========================================================
        // PRUEBA 1 -> MUESTRA UNIFORME
        // =========================================================

        double[] muestra = {
            0.15, 0.22, 0.89, 0.45, 0.56, 0.78, 0.12, 0.34, 0.90, 0.67,
            0.44, 0.21, 0.99, 0.81, 0.55, 0.32, 0.11, 0.29, 0.61, 0.73,
            0.84, 0.92, 0.05, 0.49, 0.51, 0.66, 0.38, 0.19, 0.77, 0.25
        };

        // =========================================================
        // PRUEBA 2 -> MUESTRA SESGADA
        // Descomenta esta muestra y comenta la anterior
        // =========================================================

        /*
        double[] muestra = {
            0.01, 0.02, 0.03, 0.04, 0.05,
            0.06, 0.07, 0.08, 0.09, 0.10,
            0.11, 0.12, 0.13, 0.14, 0.15,
            0.16, 0.17, 0.18, 0.19, 0.05,
            0.04, 0.03, 0.02, 0.01, 0.06,
            0.07, 0.08, 0.09, 0.10, 0.11
        };
        */

        // =========================================================
        // PRUEBA 3 -> TODOS EN UN SOLO INTERVALO
        // =========================================================

        /*
        double[] muestra = {
            0.01, 0.02, 0.03, 0.04, 0.05,
            0.06, 0.07, 0.08, 0.09, 0.10,
            0.11, 0.12, 0.13, 0.14, 0.15,
            0.16, 0.17, 0.18, 0.19, 0.01,
            0.02, 0.03, 0.04, 0.05, 0.06,
            0.07, 0.08, 0.09, 0.10, 0.11
        };
        */

        // Tamaño de muestra
        int n = muestra.length;

        // Número de intervalos
        int k = 5;

        // Frecuencia esperada
        double esperado = (double) n / k;

        // Frecuencias observadas
        int[] observados = new int[k];

        // Límites
        double[] limites = {0.0, 0.2, 0.4, 0.6, 0.8, 1.0};

        // =========================================================
        // CALCULO DE FRECUENCIAS
        // =========================================================

        for (double num : muestra) {

            int intervalo = (int) (num * k);

            if (intervalo == k) {
                intervalo--;
            }

            observados[intervalo]++;
        }

        // =========================================================
        // IMPRESION
        // =========================================================

        System.out.println("====================================================");
        System.out.println("PRUEBA CHI-CUADRADA DE UNIFORMIDAD");
        System.out.println("====================================================");

        System.out.println("Tamano de muestra (n): " + n);
        System.out.println("Numero de intervalos (k): " + k);
        System.out.println("Frecuencia esperada: " + esperado);

        System.out.println("====================================================");

        System.out.printf("%-15s %-15s %-15s %-20s\n",
                "INTERVALO",
                "OBSERVADO",
                "ESPERADO",
                "CALCULO");

        System.out.println("====================================================");

        double chiCuadrada = 0;

        for (int i = 0; i < k; i++) {

            String rango = String.format("[%.1f - %.1f)",
                    limites[i],
                    limites[i + 1]);

            int o_i = observados[i];

            double parcial =
                    Math.pow(o_i - esperado, 2) / esperado;

            chiCuadrada += parcial;

            System.out.printf("%-15s %-15d %-15.1f %-20.4f\n",
                    rango,
                    o_i,
                    esperado,
                    parcial);
        }

        System.out.println("====================================================");

        System.out.printf("ESTADISTICO CHI-CUADRADA = %.4f\n",
                chiCuadrada);

        // =========================================================
        // CONCLUSION
        // =========================================================

        double valorCritico = 9.4877;

        System.out.println("Valor critico: " + valorCritico);

        System.out.println("====================================================");

        if (chiCuadrada <= valorCritico) {

            System.out.println("NO SE RECHAZA H0");
            System.out.println("La distribucion parece uniforme.");

        } else {

            System.out.println("SE RECHAZA H0");
            System.out.println("La distribucion NO es uniforme.");
        }

    }
}