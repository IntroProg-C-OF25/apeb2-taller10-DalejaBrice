/**
 * Crea un juego de tres en raya utilizando una matriz bidimensional de 3x3. 
 * Permita a dos jugadores marcar sus movimientos alternativamente. El juego 
 * debe verificar si alguno de los jugadores ha ganado o si hay un empate.
 * @author Daniela Briceño
 */
import java.util.Scanner;
public class TresenRaya {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        char[][] tablero = new char[3][3];
        boolean juegoTerminado = false;
        char jugadorActual = 'X';
        int fila, columna;
        boolean movimientoValido;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }

        while (!juegoTerminado) {

            System.out.println("Tablero:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Jugador " + jugadorActual + ", ingrese fila y columna (0-2): ");
            movimientoValido = false;


            while (!movimientoValido) {
                fila = tcl.nextInt();
                columna = tcl.nextInt();

                if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == '-') {

                    tablero[fila][columna] = jugadorActual;
                    movimientoValido = true;
                } else {
                    System.out.println("Movimiento invalido. Intente de nuevo.");
                }
            }

            for (int i = 0; i < 3; i++) {
                if ((tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) || 
                    (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)) { 
                    System.out.println("¡Jugador " + jugadorActual + " ha ganado!");
                    juegoTerminado = true;
                    break;
                }
            }


            if (!juegoTerminado) {
                if ((tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) ||
                    (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)) {
                    System.out.println("¡Jugador " + jugadorActual + " ha ganado!");
                    juegoTerminado = true;
                }
            }

            if (!juegoTerminado) {
                boolean empate = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (tablero[i][j] == '-') {
                            empate = false;
                            break;
                        }
                    }
                }

                if (empate) {
                    System.out.println("Es un empate");
                    juegoTerminado = true;
                }
            }

            if (!juegoTerminado) {
                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
            }
        }

        System.out.println("Tablero final:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/**
 * run:
* Tablero:
* - - - 
* - - - 
* - - - 
* Jugador X, ingrese fila y columna (0-2): 
* 0 1
* Tablero:
* - X - 
* - - - 
* - - - 
* Jugador O, ingrese fila y columna (0-2): 
* 2 3
* Movimiento invalido. Intente de nuevo.
* 2 1
* Tablero:
* - X - 
* - - - 
* - O - 
* Jugador X, ingrese fila y columna (0-2): 
* 0 0
* Tablero:
* X X - 
* - - - 
* - O - 
* Jugador O, ingrese fila y columna (0-2): 
* 0 3
* Movimiento invalido. Intente de nuevo.
* 0 2
* Tablero:
* X X O 
* - - - 
* - O - 
* Jugador X, ingrese fila y columna (0-2): 
* 1 1
* Tablero:
* X X O 
* - X - 
* - O - 
* Jugador O, ingrese fila y columna (0-2): 
* 2 2
* Tablero:
* X X O 
* - X - 
* - O O 
* Jugador X, ingrese fila y columna (0-2): 
* 1 2
* Tablero:
* X X O 
* - X X 
* - O O 
* Jugador O, ingrese fila y columna (0-2): 
* 1 0
* Tablero:
* X X O 
* O X X 
* - O O 
* Jugador X, ingrese fila y columna (0-2): 
* 2 0
* Es un empate
* Tablero final:
* X X O 
* O X X 
* X O O 
* BUILD SUCCESSFUL (total time: 56 seconds)
 */