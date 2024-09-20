/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Saul
 */
public class Matriz implements Serializable{
  private int numFilas;
    private int numColumnas;
    private int [] vectorFila; //= new int[numColumnas];
    private int[][]mat;
    private Random fill;

    public Matriz(int numFilas, int numColumnas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.mat = new int[numFilas][numColumnas];
        this.vectorFila = new int[numColumnas];     
    }
    
    public void rellenarMatriz (){        
        this.fill = new Random();        
        for (int i=0; i < this.numFilas; i++){
            for(int j=0; j < this.numColumnas; j++)
                this.mat[i][j]=this.fill.nextInt(100);
        }    
    }
    
     public void imprimirMatriz (){        
        for (int i = 0; i < this.numFilas; i++) {
            for (int j = 0; j < this.numColumnas; j++) {
                System.out.print(this.mat[i][j]+" ");
            }
            System.out.println();
        }
     }
    
    public void setMat(int[][] mat){
    this.mat=mat;
    
    }
    
    public int [][] getMat(){
    return mat;
    
    }
    
    public void setValue(int fila, int columna, int valor){        
        this.mat[fila][columna]= valor;        
    }
    
      
    public int getValue(int fila, int columna){        
       return this.mat[fila][columna];        
    }
    
    public int getNumFilas(){
        return this.numFilas;
    }
    
    public int getNumColumnas(){
        return this.numColumnas;
    }
    
    public int[] getFila(int n){
        int[] vectorFilaRetorno = new int[this.getNumColumnas()];
        for (int i = 0; i < this.getNumColumnas(); i++){
            vectorFilaRetorno[i]= this.mat[n][i];
        }
        return vectorFilaRetorno;
    }
    
    public void setFila(int numFila, int[] vectorFila){       
        this.vectorFila=vectorFila;
        this.mat[numFila]=this.vectorFila;
    
    }
    
    public int[] getColumna(int n){
        int[] vectorColumnaRetorno = new int[this.getNumFilas()];
        for (int i = 0; i < this.getNumFilas(); i++){
            vectorColumnaRetorno[i]= this.mat[i][n];
        }
        return vectorColumnaRetorno;
    }
   
    public void multiplicarMatriz (int[][] a, int[][] b){              
        for (int i = 0; i < a.length; i++) {          
            for (int j = 0; j < b[0].length; j++) {            
                for (int k = 0; k < a[0].length; k++) {
                    this.mat[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }  
}
