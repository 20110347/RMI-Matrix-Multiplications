/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.io.Serializable;


/**
 *
 * @author Saul
 */
public class ElementoMatriz implements Serializable{
    int filaCero, tamano;
    Matriz matrizResultados;

    public ElementoMatriz(int filaCero, int tamano, Matriz matrizResultados) {
        this.filaCero = filaCero;
        this.tamano = tamano;
        this.matrizResultados = matrizResultados;
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

    public Matriz getMatrizResultados() {
        return matrizResultados;
    }

    public void setMatrizResultados(Matriz matrizResultados) {
        this.matrizResultados = matrizResultados;
    }
}
