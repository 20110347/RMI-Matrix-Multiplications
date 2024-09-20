/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Saul
 */
public class MatrizTask extends RecursiveAction{
    
    private Matriz a, b, c;
    private int fila;
    
    public MatrizTask(Matriz a, Matriz b, Matriz c, int fila) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fila = fila;
    }

    public MatrizTask(Matriz m1, Matriz m2, Matriz m3) {
        this.a=m1;
        this.b=m2;
        this.c=m3;
        this.fila=-1;
    }
    
    @Override
    public void compute(){
        if(fila==-1){
            List<MatrizTask> task = new ArrayList<>();
            for(int fila = 0; fila < a.getNumFilas(); fila++){
                task.add(new MatrizTask(a, b, c,fila));
            }
            invokeAll(task); 
        }else{
            multiplicarFilaColumna(a,b,c,fila);
        }
    }
    
    public void multiplicarFilaColumna(Matriz a, Matriz b, Matriz c, int fila){
        int valor=0;
        for(int j=0; j<b.getNumColumnas();j++){
            for(int k=0; k<a.getNumColumnas();k++){
              valor+=(a.getValue(fila, k)* b.getValue(k, j));    
            }
            c.setValue(fila, j, valor);
        }
    }   
}
