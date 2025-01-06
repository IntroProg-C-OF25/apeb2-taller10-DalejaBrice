
/**
 * Dadas dos matrices (cuadradas y/o rectangulares) de valores enteros aleatorios, desarrollar su procesamiento para calcular y presentar:
 * La suma de las dos matrices (considerar las restricciones matemáticas para ello).
 * La multiplicación de las dos matrices (considerar las reglas matemáticas para ello).
 *
 * @author Daniela Briceño
 */
import java.util.Scanner;

public class SumayMultiplicacionMatrices {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int fila1, fila2, columna1, columna2;
        System.out.print("Ingrese el tamano de filas y columnas de la martiz 1: ");
        fila1 = tcl.nextInt();
        columna1 = tcl.nextInt();
        System.out.print("Ingrese el tamano de filas y columnas de la matriz 2: ");
        fila2 = tcl.nextInt();
        columna2 = tcl.nextInt();
        int[][] matriz1 = new int[fila1][columna1];
        int[][] matriz2 = new int[fila2][columna2];
        int[][] suma = new int[fila1][columna1];
        int[][] multiplicacion = new int [fila1][columna2];
        System.out.println("\nPrimera Matriz");
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                matriz1[i][j] = (int) (Math.random() * 10)+ 1;
                System.out.print("[ " + matriz1[i][j] + " ]\t" );
            }
            System.out.println(" ");
        }
        System.out.println("\nSegunda Matriz");
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                matriz2[i][j] = (int) (Math.random() * 10);
                System.out.print("[" + matriz2[i][j] + " ]\t");
            }
            System.out.println(" ");
        }
        if (fila1 == fila2 && columna1 == columna2 ) {
            System.out.println("\nSuma de Matrices");
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[0].length; j++) {
                    suma[i][j] = matriz1[i][j] + matriz2[i][j];
                    System.out.print("[ "+ suma[i][j] + " ]\t");
                }
                System.out.println(" ");
            }
        } else {
            System.out.println("No se pueden sumar");
        }
        if (columna1 == fila2) {
            System.out.println("\nMultiplicacion de Matrices");
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz2[0].length; j++) {
                    for (int k = 0; k < matriz1[0].length; k++) {
                        multiplicacion[i][j] += matriz1[i][k] * matriz2[k][j];
                    }
                    System.out.print("[ " + multiplicacion[i][j] + " ]\t");
                }
                System.out.println(" ");
            }
        } else {
            System.out.println("No se pueden multiplicar");
        }
    }
}
/**
 * run: 
 * Ingrese el tamano de filas y columnas de la martiz 1: 3 3
 * Ingrese el tamano de filas y columnas de la matriz 2: 3 3
 * Primera Matriz
 * [ 3 ]	[ 5 ]	[ 1 ]	 
 * [ 8 ]	[ 3 ]	[ 1 ]	 
 * [ 4 ]	[ 8 ]	[ 1 ]	 

 * Segunda Matriz
 * [7 ]	[1 ]	[2 ]	 
 * [0 ]	[5 ]	[0 ]	 
 * [0 ]	[0 ]	[8 ]	 

 * Suma de Matrices
 * [ 10 ]	[ 6 ]	[ 3 ]	 
 * [ 8 ]	[ 8 ]	[ 1 ]	 
 * [ 4 ]	[ 8 ]	[ 9 ]

 * Multiplicacion de Matrices
 * [ 21 ]	[ 28 ]	[ 14 ]	 
 * [ 56 ]	[ 23 ]	[ 24 ]	 
 * [ 28 ]	[ 44 ]	[ 16 ]	 
 * BUILD SUCCESSFUL (total time: 4 seconds)
 */