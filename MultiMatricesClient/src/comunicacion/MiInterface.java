/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Saul
 */
public interface MiInterface extends Remote{
    public void login(User user) throws RemoteException;
    public void logout(User user) throws RemoteException;
    public void sendMatrix(Matriz matrizB) throws RemoteException;
    public Matriz getMatrix() throws RemoteException , InterruptedException;
    public void setEstatusProceso(int estatus) throws RemoteException, InterruptedException;
    public int getEstatusProceso() throws RemoteException, InterruptedException;
    public List<User> getAllUsers() throws RemoteException;
    public TareaComputable getTareaComputable() throws RemoteException, InterruptedException;
    public void setTareaComputable(LinkedList<TareaComputable> nextTarea) throws RemoteException, InterruptedException;
    public ElementoMatriz getElementoMatriz() throws RemoteException, InterruptedException;
    public void setElementoMatriz(ElementoMatriz nextElement) throws RemoteException, InterruptedException;
    public boolean vacioBufferComputable() throws RemoteException;
    public boolean vacioBufferResultados() throws RemoteException;
    public boolean vacioUsers() throws RemoteException;
    public int lengthBufferComputable() throws RemoteException;
    public int lengthBufferResultados() throws RemoteException;
    public int getSizeBufferComputable() throws RemoteException;
    public int getSizeBufferResultados() throws RemoteException;
}
