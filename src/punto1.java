import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class punto1 {
    public static void main(String[] args) {

        /*Cargar una matriz de números decimales (double) A de tamaño MXN y mostrar
        los datos cargados. El tamaño de la matriz debe ser solicitado e ingresado por
        el usuario, indicando un valor entero para las filas y un valor entero para las
        columnas, el valor mínimo valido debe ser de 3x2, crear la matriz y solicitar los
        valores numéricos para cargar de datos en cada posición
         */

        Scanner scanner = new Scanner(System.in);

                int filas, columnas;

                // Solicitar tamaño de la matriz (mínimo 3x2)
                while (true) {
                    System.out.print("Ingrese el número de filas (mínimo 3): ");
                    filas = scanner.nextInt();
                    System.out.print("Ingrese el número de columnas (mínimo 2): ");
                    columnas = scanner.nextInt();

                    if (filas >= 3 && columnas >= 2) {
                        break;
                    } else {
                        System.out.println("El tamaño mínimo es de 3 filas y 2 columnas. Intente de nuevo.");
                    }
                }

                // Crear la matriz de tipo double
                double[][] matriz = new double[filas][columnas];

                // Llenar la matriz con valores ingresados por el usuario
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                        matriz[i][j] = scanner.nextDouble();
                    }
                }

                // Mostrar la matriz cargada
                System.out.println("\nMatriz cargada:");
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        System.out.print(matriz[i][j] + "    ");
                    }
                    System.out.println();
                }



        // Crear una nueva matriz de N filas y 1 columna para las sumatorias
        double[][] sumatoriaMatriz = new double[filas][1];

        // Calcular la sumatoria de cada fila y guardarla en la nueva matriz
        for (int i = 0; i < filas; i++) {
            double sumaFila = 0;
            for (int j = 0; j < columnas; j++) {
                sumaFila += matriz[i][j]; // Sumar los valores de cada fila
            }
            sumatoriaMatriz[i][0] = sumaFila; // Guardar la suma en la matriz de sumatorias
        }

        // Mostrar la matriz de sumatorias
        System.out.println("\nMatriz de sumatorias (N filas x 1 columna):");
        for (int i = 0; i < filas; i++) {
            System.out.println(sumatoriaMatriz[i][0]);
        }



        // Crear la matriz de N filas por 2 columnas para almacenar sumatorias y sus índices
        double[][] matrizOrdenada = new double[filas][2];

        // Llenar la matrizOrdenada con sumatorias y los índices de las filas originales
        for (int i = 0; i < filas; i++) {
            matrizOrdenada[i][0] = sumatoriaMatriz[i][0]; // Suma de la fila
            matrizOrdenada[i][1] = i; // Índice original de la fila
        }

        // Ordenar la matrizOrdenada en base a la primera columna (sumatorias) de mayor a menor
        Arrays.sort(matrizOrdenada, new Comparator<double[]>() {
            //@Override
            public int compare(double[] fila1, double[] fila2) {
                // Comparar la primera columna (sumatorias) en orden descendente
                return Double.compare(fila2[0], fila1[0]);
            }
        });

        // Mostrar la matriz ordenada con sumatorias y los índices originales
        System.out.println("\nMatriz de sumatorias ordenada (Mayor a Menor) con índices originales:");
        for (int i = 0; i < filas; i++) {
            System.out.println(matrizOrdenada[i][0] + "     " + (int)matrizOrdenada[i][1]);
        }



        // Sumar los elementos de la primera columna de la matriz ordenada
        double sumaTotal = 0;
        for (int i = 0; i < filas; i++) {
            sumaTotal += matrizOrdenada[i][0]; // Sumar las sumatorias
        }

        // Mostrar el resultado de la sumatoria
        System.out.println("\nLa suma total de la columna 1 es: " + sumaTotal);

    }
}
