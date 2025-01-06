
/**
 * Crea un programa que gestione el inventario de una tienda, así como la emisión
 * de facturas. Utiliza una matriz bidimensional para almacenar los productos
 * disponibles en la tienda, con información como nombre, precio y cantidad.
 * El programa debe permitir facturar un producto dado su código, y unidades
 * deseadas. Adicional se debe agregar a la factura al 15% del IVA, y si la
 * compra superar los $100, se debe aplicar un descuento.
 * Nota: Considere la alternativa de inexistencias en Stop, para el caso, muestre la alerta respectiva.
 *
 * @author Daniela Briceño
 */
import java.util.Scanner;

public class Facturas {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        String act, nombre, prod, factura;
        String[][] inventario = new String[100][3];
        int opcion, producto = 0;
        boolean encontrado;
        int cantidadFactura, cantidadDisponible;
        double precio, totalFactura, iva, descuento, totalConDescuento;

        do {
            System.out.println("\nGESTION DE INVENTARIO :)");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Facturar productos");
            System.out.println("6. Salir");
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
                    System.out.print("Ingrese el nombre del producto a facturar: ");
                    factura = tcl.nextLine();
                    encontrado = false;

                    for (int i = 0; i < producto; i++) {
                        if (inventario[i][0].equalsIgnoreCase(factura)) {
                            System.out.print("Ingrese la cantidad deseada: ");
                            cantidadFactura = tcl.nextInt();
                            tcl.nextLine(); 

                            precio = Double.parseDouble(inventario[i][1]);
                            cantidadDisponible = Integer.parseInt(inventario[i][2]);

                            if (cantidadFactura <= cantidadDisponible) {
                                totalFactura = precio * cantidadFactura; 
                                iva = totalFactura * 0.15;
                                totalFactura += iva;

                                if (totalFactura > 100) {
                                    descuento = totalFactura * 0.10;
                                    totalConDescuento = totalFactura - descuento;
                                    System.out.println("Total sin descuento: " + totalFactura);
                                    System.out.println("Descuento aplicado: " + descuento);
                                    System.out.println("Total con descuento: " + totalConDescuento);
                                } else {
                                    System.out.println("Total con IVA: " + totalFactura);
                                }

                                inventario[i][2] = String.valueOf(cantidadDisponible - cantidadFactura);
                                System.out.println("Factura generada.");
                                encontrado = true;
                            } else {
                                System.out.println("No hay suficientes existencias.");
                            }
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo :)");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);
    }
}

/**
 * run:

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Facturar productos
 * 6. Salir
 * Ingrese la opcion: 1
 * Nombre del Producto: manzana
 * Precio del producto: 2.5
 * Cantidad del producto: 100
 * Producto agregado exitosamente.

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Facturar productos
 * 6. Salir
 * Ingrese la opcion: 1
 * Nombre del Producto: peras
 * Precio del producto: 3.00
 * Cantidad del producto: 30
 * Producto agregado exitosamente.

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Facturar productos
 * 6. Salir
 * Ingrese la opcion: 1
 * Nombre del Producto: tomates
 * Precio del producto: 1.8
 * Cantidad del producto: 200
 * Producto agregado exitosamente.

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Facturar productos
 * 6. Salir
 * Ingrese la opcion: 3
 * Nombre del producto a buscar: manzana
 * Nombre: manzana
 * Precio: 2.5
 * Cantidad: 100

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Facturar productos
 * 6. Salir
 * Ingrese la opcion: 3
 * Nombre del producto a buscar: uva
 * Producto no encontrado.

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Facturar productos
 * 6. Salir
 * Ingrese la opcion: 5
 * Ingrese el nombre del producto a facturar: manzana
 * Ingrese la cantidad deseada: 30
 * Total con IVA: 86.25
 * Factura generada.

 * GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Facturar productos
 * 6. Salir
 * Ingrese la opcion: 5
 * Ingrese el nombre del producto a facturar: peras
 * Ingrese la cantidad deseada: 40
 * No hay suficientes existencias.
 * Producto no encontrado.

* GESTION DE INVENTARIO :)
 * 1. Agregar producto
 * 2. Actualizar producto
 * 3. Buscar producto
 * 4. Eliminar producto
 * 5. Facturar productos
 * 6. Salir
 * Ingrese la opcion: 6 
 * Saliendo:)
 * BUILD SUCCESSFUL (total time: 57 seconds)
 */