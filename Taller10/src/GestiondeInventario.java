
/**
 *Crea un programa que gestione el inventario de una tienda. Utiliza una matriz
 * bidimensional para almacenar los productos disponibles en la tienda, con
 * información como nombre, precio y cantidad. El programa debe permitir agregar
 * nuevos productos, actualizar existencias, buscar productos y eliminarlos.
 *
 * @author Daniela Briceño
 */
import java.util.Scanner;

public class GestiondeInventario {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        String act, nombre, prod;
        String[][] inventario = new String[100][3];
        int opcion, producto = 0;
        boolean encontrado; 

        do {
            System.out.println("\nGESTION DE INVENTARIO :)");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opcion: ");
            opcion = tcl.nextInt();
            tcl.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del Producto: ");
                    inventario[producto][0] = tcl.nextLine();
                    System.out.print("Precio del producto: ");
                    inventario[producto][1] = tcl.nextLine();
                    System.out.print("Cantidad del producto: ");
                    inventario[producto][2] = tcl.nextLine();
                    producto++;
                    System.out.println("Producto agregado exitosamente.");
                    break;

                case 2:
                    System.out.print("Nombre del producto a actualizar: ");
                    act = tcl.nextLine();
                    encontrado = false;
                    for (int i = 0; i < producto; i++) {
                        if (act.equalsIgnoreCase(inventario[i][0])) {
                            System.out.print("Ingrese el nuevo precio: ");
                            inventario[i][1] = tcl.nextLine();
                            System.out.print("Ingrese la nueva cantidad: ");
                            inventario[i][2] = tcl.nextLine();
                            encontrado = true;
                            System.out.println("Producto actualizado exitosamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre del producto a buscar: ");
                    prod = tcl.nextLine();
                    encontrado = false;
                    for (int i = 0; i < producto; i++) {
                        if (prod.equalsIgnoreCase(inventario[i][0])) {
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: " + inventario[i][1]);
                            System.out.println("Cantidad: " + inventario[i][2]);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Nombre del producto a eliminar: ");
                    nombre = tcl.nextLine();
                    encontrado = false;
                    for (int i = 0; i < producto; i++) {
                        if (nombre.equalsIgnoreCase(inventario[i][0])) {
                            for (int j = i; j < producto - 1; j++) {
                                inventario[j][0] = inventario[j + 1][0];
                                inventario[j][1] = inventario[j + 1][1];
                                inventario[j][2] = inventario[j + 1][2];
                            }
                            producto--;
                            encontrado = true;
                            System.out.println("Producto eliminado correctamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo :)");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 5);
    }
}
/**
 * run:

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Salir
 * Ingrese la opcion: 1
 * Nombre del Producto: pan
 * Precio del producto: 0.25
 * Cantidad del producto: 30
 * Producto agregado exitosamente.

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Salir
 * Ingrese la opcion: 1
 * Nombre del Producto: leche
 * Precio del producto: 1.20
 * Cantidad del producto: 30
 * Producto agregado exitosamente.

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Salir
 * Ingrese la opcion: 1
 * Nombre del Producto: galletas
 * Precio del producto: 2.10
 * Cantidad del producto: 15
 * Producto agregado exitosamente.

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Salir
 * Ingrese la opcion: 3
 * Nombre del producto a buscar: leche
 * Nombre: leche
 * Precio: 1.20
 * Cantidad: 30

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Salir
 * Ingrese la opcion: 4
 * Nombre del producto a eliminar: leche
 * Producto eliminado correctamente. 

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Salir
 * Ingrese la opcion: 3
 * Nombre del producto a buscar: leche
 * Producto no encontrado.
 
 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Salir
 * Ingrese la opcion: 5
 * Saliendo :)
 * BUILD SUCCESSFUL (total time: 57 seconds)

 */