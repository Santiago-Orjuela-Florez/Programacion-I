import java.util.Scanner;

public class Primos {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numero;
        double raiz;
        System.out.print("Ingrese un numero: ");
        numero = leer.nextInt();
        for (int i = 2; i <= numero; i++) {
            raiz = Math.sqrt(i);
            boolean Primo = true;
            for (int j = 2; j <= raiz; j++) {
                if (i % j == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (Primo) {
                System.out.println(i);
            }
        }
    }
}
