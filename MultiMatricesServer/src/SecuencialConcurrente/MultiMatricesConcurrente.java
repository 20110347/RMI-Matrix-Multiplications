package SecuencialConcurrente;

import java.awt.List;
import java.util.ArrayList;
import comunicacion.Matriz;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author night
 */
public class MultiMatricesConcurrente {

    public void multiplicar(Matriz matrizA, Matriz matrizB, Matriz matrizC) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MultiConTask(matrizC, matrizC, matrizC, -1));
    }

    public class MultiConTask extends RecursiveAction {

        private Matriz matrizA;
        private Matriz matrizB;
        private Matriz matrizC;
        private int row;

        /*public MultiConTask(Matriz matrizA, Matriz matrizB, Matriz matrizC) {
            this(Matriz matrizA, Matriz matrizB, Matriz matrizC, -1);
        }*/

        /*public MultiConTask(int size, int[][] a, int[][] b) {
            this.size = size;
            this.a = a;
            this.b = b;
        }*/
        public MultiConTask(Matriz matrizA, Matriz matrizB, Matriz matrizC, int row) {
            this.matrizA = matrizA;
            this.matrizB = matrizB;
            this.matrizC = matrizC;
            this.row = row;
        }

        @Override
        protected void compute() {
            //System.out.println("1");
            if (row == -1) {
                ArrayList<MultiConTask> tasks = new ArrayList<>();
                for (int row = 0; row < matrizA.getNumFilas(); row++) {
                    //System.out.println("2");
                    tasks.add(new MultiConTask(matrizA, matrizB, matrizC, row));
                }
                invokeAll(tasks);
            } else {
                //System.out.println("3");
                multiplicarTask(matrizA, matrizB, matrizC, row);
            }
        }

        public void multiplicarTask(Matriz matrizA, Matriz matrizB, Matriz matrizC, int row) {
            int valor = 0;
            for (int j = 0; j < matrizB.getNumColumnas(); j++) {
                for (int k = 0; k < matrizA.getNumColumnas(); k++) {
                    valor += (matrizA.getValue(row, k) * matrizB.getValue(k, j));
                }
                matrizC.setValue(row, j, valor);
            }

            //Multiplicar matrices
            /*for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        // Efectuar multiplicación
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }*/
        }

        /*public void mostrarMatriz (){
                       //Dibujar matriz resultante
            System.out.println("\nMatriz Resultante:");
            for (int fila = 0; fila < this.a.length; ++fila) {
                for (int columna = 0; columna < this.a[0].length; ++columna) {
                    System.out.print(this.c[fila][columna] + " ");
                }
                System.out.println();
            }
        }*/
    }
}
