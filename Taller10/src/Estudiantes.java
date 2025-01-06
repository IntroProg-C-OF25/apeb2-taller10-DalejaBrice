
/**
 * El primer ciclo paralelo C, cuenta con 28 estudiantes, de los cuáles al finalizar
 * el periodo, la Dirección de la carrera de Computación a solicitado las siguientes
 * estadísticas de la materia INTRODUCCIÓN A LA PROGRAMACIÓN en función a los promedios
 * por estudiante, dichos promedios se deben calcular (ponderar, ya que el docente
 * ingresa todo sobre 10pts.)
 * de 3 calificaciones (ACD que representa el 35% de la nota, APE del 35% y la nota del
 * AA con un peso del 30%). En resumen, los requerimientos son los siguientes:
 * Registre los nombres de cada estudiante de dicho paralelo.
 * Genere aleatoriamente las notas ACD, APE, AA, para cada uno de los 28 estudiantes de 0-10 pts.
 * Calcule el promedio de cada uno de los estudiantes del paralelo dada la siguiente ponderación: ACD->35%, APE->35%, y el AA->30%.
 * Obtenga el promedio del curso, del paralelo C.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por encima del promedio del curso.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por debajo del promedio del curso.
 * Muestre el estudiante con su calificación, si es el del mayor promedio (el más alto de la clase).
 * Muestre el estudiante con su calificación, si es el del menor promedio (el más bajo de la clase).
 *
 * @author Daniela Briceño
 */
import java.util.Scanner;

public class Estudiantes {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        String[] nombres = {"Juan", "Maria", "Luis", "Angel", "Carlos", "Damian", "Causa", "Agurto", "Alex", "Alexis", "Ariel", "Andres", "Jorge", "Romina", "Valeria", "Andrea", "Luisa", "Erika", "Amanda", "Diego", "Daniel", "Adrian", "Karol", "Steven", "Luis", "Gary", "Jayce", "Vicktor"};
        double[] acd = new double[nombres.length];
        double[] ape = new double[nombres.length];
        double[] aa = new double[nombres.length];
        double[] promedio = new double[nombres.length];
        double max = 0, min = 10, prom = 0;
        int p = 0, j = 0, cont = 0, cont2 = 0;
        for (int i = 0; i < nombres.length; i++) {
            acd[i] = (double) (Math.random() * 10);
            ape[i] = (double) (Math.random() * 10);
            aa[i] = (double) (Math.random() * 10);
            promedio[i] = (acd[i] * 0.35) + (ape[i] * 0.35) + (aa[i] * 0.35);
            prom += promedio[i];
            if (max < promedio[i]) {
                max = promedio[i];
                p = i;
            }
            if (min > promedio[i]) {
                min = promedio[i];
                j = i;
            }
        }
        prom /= nombres.length;
        for (int i = 0; i < nombres.length; i++) {
            if (promedio[i] < prom) {
                cont++;
            } else {
                cont2++;
            }
        }
        System.out.printf("\nPromedio del curso: %.2f\n", prom);
        System.out.printf("\n%s  | %s  | %s  |  %s  | %s\n", "Nombre", "ACD", "APE", "AA", "Promedio");
        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("%s\t| %.2f | %.2f | %.2f | %.2f \n", nombres[i], acd[i], ape[i], aa[i], promedio[i]);
            if (promedio[i] < prom) {
                System.out.println("El estudiante " + nombres[i] + " esta por debajo del promedio");
            } else {
                System.out.println("El estudiante " + nombres[i] + " esta sobre el promedio");
            }

        }
        System.out.printf("\nEl estudiante " + nombres[p] + " es el mayor promedio con un promedio de: %.2f\n" ,promedio[p]);
        System.out.printf("\nEl estudiante " + nombres[j] + " es el menor promedio con un promedio de: %.2f" ,promedio[j]);
        System.out.println();
    }
}
/**
 * run:

 * Promedio del curso: 5,45

 * Nombre  | ACD  | APE  |  AA  | Promedio
 * Juan	   | 9,38 | 0,40 | 6,82 | 5,81 
 * El estudiante Juan esta sobre el promedio
 * Maria   | 8,87 | 9,92 | 1,12 | 6,97 
 * El estudiante Maria esta sobre el promedio
 * Luis	   | 8,24 | 2,92 | 5,60 | 5,87 
 * El estudiante Luis esta sobre el promedio
 * Angel   | 4,12 | 0,89 | 6,40 | 3,99 
 * El estudiante Angel esta por debajo del promedio
 * Carlos  | 1,46 | 5,82 | 4,68 | 4,19 
 * El estudiante Carlos esta por debajo del promedio
 * Damian  | 1,50 | 6,99 | 2,11 | 3,71 
 * El estudiante Damian esta por debajo del promedio
 * Causa   | 5,21 | 9,62 | 6,87 | 7,60 
 * El estudiante Causa esta sobre el promedio
 * Agurto  | 4,30 | 5,81 | 8,80 | 6,62 
 * El estudiante Agurto esta sobre el promedio
 * Alex    | 4,18 | 7,12 | 1,70 | 4,55 
 * El estudiante Alex esta por debajo del promedio
 * Alexis  | 8,70 | 7,10 | 9,67 | 8,92 
 * El estudiante Alexis esta sobre el promedio
 * Ariel   | 2,99 | 4,58 | 6,61 | 4,96 
 * El estudiante Ariel esta por debajo del promedio
 * Andres  | 8,72 | 0,23 | 6,72 | 5,49 
 * El estudiante Andres esta sobre el promedio
 * Jorge   | 1,55 | 7,93 | 0,34 | 3,44 
 * El estudiante Jorge esta por debajo del promedio
 * Romina  | 7,07 | 9,94 | 5,78 | 7,98 
 * El estudiante Romina esta sobre el promedio
 * Valeria | 2,93 | 0,84 | 9,86 | 4,77 
 * El estudiante Valeria esta por debajo del promedio
 * Andrea  | 9,62 | 7,34 | 6,50 | 8,21 
 * El estudiante Andrea esta sobre el promedio
 * Luisa   | 1,27 | 3,18 | 8,11 | 4,40 
 * El estudiante Luisa esta por debajo del promedio
 * Erika   | 4,19 | 0,19 | 0,20 | 1,60 
 * El estudiante Erika esta por debajo del promedio
 * Amanda  | 2,54 | 9,13 | 0,32 | 4,20 
 * El estudiante Amanda esta por debajo del promedio
 * Diego   | 7,23 | 7,41 | 3,54 | 6,36 
 * El estudiante Diego esta sobre el promedio
 * Daniel  | 3,19 | 4,72 | 3,02 | 3,82 
 * El estudiante Daniel esta por debajo del promedio
 * Adrian  | 7,96 | 6,58 | 6,58 | 7,39 
 * El estudiante Adrian esta sobre el promedio
 * Karol   | 1,97 | 0,30 | 3,18 | 1,91 
 * El estudiante Karol esta por debajo del promedio
 * Steven  | 4,89 | 6,93 | 9,00 | 7,29 
 * El estudiante Steven esta sobre el promedio
 * Luis    | 5,51 | 8,23 | 6,23 | 6,99 
 * El estudiante Luis esta sobre el promedio
 * Gary    | 4,85 | 0,73 | 9,39 | 5,24 
 * El estudiante Gary esta por debajo del promedio
 * Jayce   | 8,83 | 4,36 | 9,14 | 7,81 
 * El estudiante Jayce esta sobre el promedio
 * Vicktor | 0,32 | 0,31 | 6,81 | 2,60 
 * El estudiante Vicktor esta por debajo del promedio

 * El estudiante Alexis es el mayor promedio con un promedio de: 8,92

 * El estudiante Erika es el menor promedio con un promedio de: 1,60
 * BUILD SUCCESSFUL (total time: 0 seconds)

 */