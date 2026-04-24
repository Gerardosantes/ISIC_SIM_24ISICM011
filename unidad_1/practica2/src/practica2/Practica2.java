
package practica2;


public class Practica2 {
    public static void main(String[] args) {
        int a = 5;
        int m = 11;
        int x = 3; // X0
        int iteraciones = 5;

        System.out.println("Iteracion\tXn\tNormalizado");

        for (int i = 0; i <= iteraciones; i++) {
            double normalizado = (double) x / m;
            System.out.println(i + "\t\t" + x + "\t" + normalizado);

            // Fórmula: Xn+1 = (a * Xn) mod m
            x = (a * x) % m;
        }
    }
}