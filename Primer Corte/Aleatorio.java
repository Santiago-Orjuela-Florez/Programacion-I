import java.util.*;
public class Aleatorio {
   
   
    public static int leer_entero(String mensaje) {
        Scanner leer = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = leer.nextInt();
                if (numero < 0) {
                    System.out.println("Error, el valor ingresado no puede ser negativo");
                } else {
                    valido = true;      
                }
            } catch (Exception e) {
                System.out.println("Error, el valor ingresado no es un numero entero");
                leer.next(); 
            }
        }
        return numero;
    }

    public static void main(String [] args){
        
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(101);
        int intentos = 0;
        int intento = -1;
        while (intento != numero){
            intento = leer_entero("Ingrese un numero entre 0 y 100: ");
            if (intento < numero){
                System.out.println("El numero es mayor");
            } else if (intento > numero){
                System.out.println("El numero es menor");
            }
            intentos++;
        }
        System.out.println("Felicidades, adivinaste el numero en " + intentos + " intentos");
    }
}
