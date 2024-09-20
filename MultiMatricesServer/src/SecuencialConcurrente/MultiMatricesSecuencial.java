package SecuencialConcurrente;

import comunicacion.Matriz;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author night
 */
public class MultiMatricesSecuencial {
   
    Matriz matrizA;
    Matriz matrizB;
    Matriz matrizC;

    public MultiMatricesSecuencial(Matriz matrizA, Matriz matrizB,Matriz matrizC) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.matrizC = matrizC;
    }

    public void multiplicar() {
        
        // Imprimir matriz 1
        /*System.out.println("Matriz 1:");
        for (int fila = 0; fila < size; ++fila) {
            for (int columna = 0; columna < size; ++columna) {
                System.out.print(this.a[fila][columna] + " ");
            }
            System.out.println();
        }

        System.out.println();

        //Imprimir matriz 2
        System.out.println("Matriz 2:");
        for (int fila = 0; fila < size; ++fila) {
            for (int columna = 0; columna < size; ++columna) {
                System.out.print(this.b[fila][columna] + " ");
            }
            System.out.println();
        }*/
        
        //Multiplicar matrices
        matrizC.multiplicarMatriz(matrizA.getMat(), matrizB.getMat());

        // Dibujar matriz resultante 
        /*System.out.println("\nMatriz Resultante:");
        for (int fila = 0; fila < size; ++fila) {
            for (int columna = 0; columna < size; ++columna) {
                System.out.print(this.c[fila][columna] + " ");
            }
            System.out.println();
        }*/
    }
}
