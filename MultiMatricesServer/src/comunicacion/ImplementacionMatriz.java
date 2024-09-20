/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList; 

/**
 *
 * @author Saul
 */
public class ImplementacionMatriz extends UnicastRemoteObject implements MiInterface, Serializable {

    List<User> users = new ArrayList<>();
    List<TareaComputable> bufferComputable = new LinkedList<>();    
    List<ElementoMatriz> bufferResultados = new LinkedList<>();
    Matriz matrizB = null;
    int bCSize = 0;
    int bRSize = 0;
    int estatus = -1;

    public ImplementacionMatriz() throws RemoteException {
        super();
    }

    @Override
    public void login(User user) throws RemoteException {        
        if (!users.isEmpty()) {
            if(!users.contains(user)){
              users.add(user);
            }
        }else{
            users.add(user);
        }       
    }
    
    @Override
    public void logout(User user) throws RemoteException {
       if(this.users.isEmpty())
            System.out.println("No hay usuarios conectados"); 
       else{
           users.remove(0);
       }
    }

    @Override
    public void sendMatrix(Matriz matrizB) throws RemoteException {
        this.matrizB = matrizB;
    }
    
    public synchronized Matriz getMatrix() throws RemoteException, InterruptedException{
         return matrizB;
    }

    @Override
    public List<User> getAllUsers() throws RemoteException {
        if (users.isEmpty()) {
            return null;
        } else {
            return users;
        }
    }

    public synchronized void setElementoMatriz(ElementoMatriz nextElement) throws RemoteException, InterruptedException {        
        bufferResultados.add(nextElement);       
    }

    public synchronized ElementoMatriz getElementoMatriz() throws RemoteException, InterruptedException {
        ElementoMatriz elementoMatriz;
        elementoMatriz = bufferResultados.get(0);
        bufferResultados.remove(0);
        return elementoMatriz;
    }

    public synchronized void setTareaComputable(LinkedList<TareaComputable> nextTarea) throws RemoteException, InterruptedException {   
        bufferComputable.addAll(nextTarea);
    }

    @Override
    public synchronized TareaComputable getTareaComputable() throws RemoteException, InterruptedException {
        estatus--;
        TareaComputable tareaComputable;
        tareaComputable = bufferComputable.get(0);
        bufferComputable.remove(0);
        return tareaComputable;
    }

    public boolean vacioBufferComputable() throws RemoteException {
        return (bufferComputable.isEmpty());
    }

    public boolean vacioBufferResultados() throws RemoteException {
        return (bufferResultados.isEmpty());
    }

    public int lengthBufferComputable() throws RemoteException {
        return (bufferComputable.size());
    }

    public int lengthBufferResultados() throws RemoteException {
        return (bufferResultados.size());
    }

    public int getSizeBufferComputable() throws RemoteException {
        return (bCSize);
    }

    public int getSizeBufferResultados() throws RemoteException {
        return (bRSize);
    }

    @Override
    public boolean vacioUsers() throws RemoteException {
       if(users.isEmpty())
           return true;
       else
           return false;
    }

    @Override
    public synchronized void setEstatusProceso(int estatus) throws RemoteException, InterruptedException {
            this.estatus=estatus;
    }
    
    @Override
    public synchronized int getEstatusProceso() throws RemoteException, InterruptedException {
           return estatus;
    }
}
