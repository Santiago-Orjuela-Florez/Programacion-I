import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    String nombre;
    int cantidad;
    double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void aumentarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void disminuirCantidad(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("No hay suficiente cantidad para disminuir.");
        }
    }

    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: " + precio);
    }
}

public class Inventario {
    static Scanner leer = new Scanner(System.in);
    ArrayList<Producto> productos = new ArrayList<>();

    public static int leer_entero(String mensaje) {
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

    public static float leer_decimal(String mensaje) {
        float numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = leer.nextFloat();
                if (numero < 0) {
                    System.out.println("Error, el valor ingresado no puede ser negativo");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("Error, el valor ingresado no es un numero");
                leer.next(); 
            }
        }
        return numero;
    }

    public void añadirProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = leer.next();
        leer.nextLine();
        int cantidad = leer_entero("Ingrese la cantidad del producto: ");
        float precio = leer_decimal("Ingrese el precio del producto: ");
        productos.add(new Producto(nombre, cantidad, precio));
    }

    public void mostrarInventario() {
        for (Producto producto : productos) {
            producto.mostrarDetalles();
            System.out.println();
        }
    }

    public void buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                producto.mostrarDetalles();
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void modificarCantidadProducto() {
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = leer.next();
        for (Producto producto : productos) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("1. Aumentar cantidad");
                System.out.println("2. Disminuir cantidad");
                System.out.print("Opción: ");
                int opcion = leer.nextInt();
                if (opcion == 1) {
                    int cantidad = leer_entero("Ingrese la cantidad a aumentar: ");
                    producto.aumentarCantidad(cantidad);
                } else if (opcion == 2) {
                    int cantidad = leer_entero("Ingrese la cantidad a disminuir: ");
                    producto.disminuirCantidad(cantidad);
                } else {
                    System.out.println("Opción no válida.");
                }
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        while (true) {
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto");
            System.out.println("4. Modificar cantidad de producto");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    inventario.añadirProducto();
                    break;
                case 2:
                    inventario.mostrarInventario();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String nombre = leer.next();
                    inventario.buscarProducto(nombre);
                    break;
                case 4:
                    inventario.modificarCantidadProducto();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
