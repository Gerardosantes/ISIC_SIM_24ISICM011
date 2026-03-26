
package principal;

public class Main {

    public static void main(String[] args) {
        
        int m = 16;
        int a = 5;
        int c = 3;
        int X = 4; 

        System.out.println("Secuencia LCG:");

        for (int i = 0; i < 5; i++) {
            X = (a * X + c) % m;
            System.out.println("X" + (i+1) + " = " + X);
        }
    }
}
