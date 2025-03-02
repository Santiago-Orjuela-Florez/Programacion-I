import java.util.Scanner;

public class Inventario {
    static Scanner leer = new Scanner(System.in);

    public static int leer_entero(String mensaje) {
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

    public static float leer_decimal(String mensaje) {
        float numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = leer.nextFloat();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error, el valor ingresado no es un numero");
                leer.next(); 
            }
        }
        return numero;
    }

    String nombre;
    int cantidad;
    double precio;

    public Inventario() {
        System.out.print("Ingrese el nombre del producto: ");
        nombre = leer.nextLine();
        cantidad = leer_entero("Ingrese la cantidad del producto: ");
        precio = leer_decimal("Ingrese el precio del producto: ");
    }

    public static void main(String[] args) {
        Inventario producto = new Inventario();
        System.out.println("Producto: " + producto.nombre);
        System.out.println("Cantidad: " + producto.cantidad);
        System.out.println("Precio: " + producto.precio);
    }
}
