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
public class User implements Serializable{    
    String ipAdress;
    String name;
    boolean estatusConectado;

    public User(String ipAdress, String name, boolean estatusConectado) {
        this.ipAdress = ipAdress;
        this.estatusConectado = estatusConectado;        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public void setEstatusConectado(boolean estatusConectado) {
        this.estatusConectado = estatusConectado;
    }

    
    public String getIpAdress() {
        return ipAdress;
    }

    public boolean getEstatusConectado() {
        return estatusConectado;
    }
}
