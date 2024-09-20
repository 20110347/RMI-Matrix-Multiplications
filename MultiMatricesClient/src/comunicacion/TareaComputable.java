/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;
import java.io.Serializable;
import java.util.Arrays;



/**
 *
 * @author Saul
 */
public class TareaComputable implements Serializable{    
    private Matriz matrizFilas;
    private int filaCero;
    private int tamano;   

    public TareaComputable(Matriz matrizFilas, int filaCero, int tamano) {
        this.matrizFilas = matrizFilas;
        this.filaCero = filaCero;
        this.tamano = tamano;
    }

    public Matriz getMatrizFilas() {
        return matrizFilas;
    }

    public void setMatrizFilas(Matriz matrizFilas) {
        this.matrizFilas = matrizFilas;
    }

    public int getFilaCero() {
        return filaCero;
    }

    public void setFilaCero(int filaCero) {
        this.filaCero = filaCero;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void imprimirTareaComputable() {
        //System.out.println("Imprimiendo Tarea");
        System.out.println(this.filaCero);
        System.out.println(this.tamano);
        for (int i = 0; i < matrizFilas.getNumFilas(); i++) {   
            System.out.println(Arrays.toString(matrizFilas.getFila(i)));
        }
    }
}
