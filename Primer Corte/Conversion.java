import java.util.*;

public class Conversion {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        while (true) {
            System.out.println("1. Convertir de Celsius a Fahrenheit");
            System.out.println("2. Convertir de Fahrenheit a Celsius");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la temperatura en Celsius: ");
                    double celsius = leer.nextDouble();
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.println("La temperatura en Fahrenheit es: " + fahrenheit);
                    break;
                case 2:
                    System.out.print("Ingrese la temperatura en Fahrenheit: ");
                    fahrenheit = leer.nextDouble();
                    celsius = (fahrenheit - 32) * 5 / 9;
                    System.out.println("La temperatura en Celsius es: " + celsius);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
