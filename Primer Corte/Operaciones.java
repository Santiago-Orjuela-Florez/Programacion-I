import java.util.Scanner;

public class Operaciones {
    static Scanner leer = new Scanner(System.in);

    public static int leer_numero(String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = leer.nextInt();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error, el valor ingresado no es un numero entero");
                leer.next(); 
            }
        }
        return numero;
    }

    public static float calculadora(int num1, int num2, int operacion) {
        float resultado = 0;
        if (operacion == 1) {
            resultado = num1 + num2;
        } else if (operacion == 2) {
            resultado = num1 - num2;
        } else if (operacion == 3) {
            resultado = num1 * num2;
        } else if (operacion == 4) {
            if (num2 != 0) {
                resultado = (float) num1 / num2; 
            } else {
                System.out.println("Error, no se puede dividir por cero");
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int num1 = leer_numero("Ingrese un numero: ");
        int num2 = leer_numero("Ingrese otro numero: ");
        int operacion = leer_numero("Ingrese la operacion a realizar: 1. Suma, 2. Resta, 3. Multiplicacion, 4. Division: ");
        float resultado = calculadora(num1, num2, operacion);
        System.out.println("El resultado de la operacion es: " + resultado);
    }
}