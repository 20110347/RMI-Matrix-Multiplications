/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package conexion;

import comunicacion.*;
import java.util.concurrent.ForkJoinPool;
import comunicacion.MiInterface;
import SecuencialConcurrente.*;
import java.awt.Color;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Saul
 */
public class Servidor extends javax.swing.JFrame {

    long stopTimePar;
    List<User> users;
    long startTimePar;
    int banderaGay = 0;
    long elapsedTimePar;
    int elementoTotal = -1;
    Thread thread1, thread2;
    int clientesActivos = -1;
    TareaComputable tempComputable;
    Matriz matrizA, matrizB, matrizC;
    MiInterface chatServer1, chatServer2;
    int bloque, filasMA, columasMA, filasMB, columnasMB, matrizSuccess, numTask;

    /**
     * Creates new form servidor
     */
    public Servidor() throws RemoteException, UnknownHostException, AccessException, NotBoundException {
        initComponents();        
        Color lblEstadoA = new Color(98, 181, 67);
        Color lblClientDesconectado = new Color(255,82,103);
        Color lblClientConectado = new Color(72,236,72);
        
        txtIPServer.setText(InetAddress.getLocalHost().getHostAddress());
        
        lblTarea.setText("Iniciando Servidor");
        Registry registry = LocateRegistry.createRegistry(1234);
        registry.rebind("chatServer", new ImplementacionMatriz());
        lblEstado.setForeground(lblEstadoA);
        lblEstado.setText("Servidor [  Activo  ]");
        chatServer1 = (MiInterface) registry.lookup("chatServer");
        chatServer2 = (MiInterface) registry.lookup("chatServer");
        users = new ArrayList<>();

        thread1 = new Thread(new Runnable() {
            int index = -1;
            public void run() {
                while (true) {
                    try {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (!chatServer1.vacioUsers()) {
                            users = chatServer1.getAllUsers();
                            index = users.size();
                        } else {
                            index = 0;

                        }
                        switch (index) {
                            case 1:
                                pnlClient1.setBackground(lblClientConectado);
                                pnlClient2.setBackground(lblClientDesconectado);
                                pnlClient3.setBackground(lblClientDesconectado);
                                pnlClient4.setBackground(lblClientDesconectado);
                                pnlClient5.setBackground(lblClientDesconectado);
                                pnlClientes.repaint();
                                break;
                            case 2:
                                pnlClient1.setBackground(lblClientConectado);
                                pnlClient2.setBackground(lblClientConectado);
                                pnlClient3.setBackground(lblClientDesconectado);
                                pnlClient4.setBackground(lblClientDesconectado);
                                pnlClient5.setBackground(lblClientDesconectado);
                                pnlClientes.repaint();
                                break;
                            case 3:
                                pnlClient1.setBackground(lblClientConectado);
                                pnlClient2.setBackground(lblClientConectado);
                                pnlClient3.setBackground(lblClientConectado);
                                pnlClient4.setBackground(lblClientDesconectado);
                                pnlClient5.setBackground(lblClientDesconectado);
                                pnlClientes.repaint();

                                break;
                            case 4:
                                pnlClient1.setBackground(lblClientConectado);
                                pnlClient2.setBackground(lblClientConectado);
                                pnlClient3.setBackground(lblClientConectado);
                                pnlClient4.setBackground(lblClientConectado);
                                pnlClient5.setBackground(lblClientDesconectado);
                                pnlClientes.repaint();

                                break;
                            case 5:
                                pnlClient1.setBackground(lblClientConectado);
                                pnlClient2.setBackground(lblClientConectado);
                                pnlClient3.setBackground(lblClientConectado);
                                pnlClient4.setBackground(lblClientConectado);
                                pnlClient5.setBackground(lblClientConectado);
                                pnlClientes.repaint();
                                break;

                            default:
                                if (index == 0) {
                                    pnlClient1.setBackground(lblClientDesconectado);
                                    pnlClient2.setBackground(lblClientDesconectado);
                                    pnlClient3.setBackground(lblClientDesconectado);
                                    pnlClient4.setBackground(lblClientDesconectado);
                                    pnlClient5.setBackground(lblClientDesconectado);
                                } else {
                                    JOptionPane.showMessageDialog(null, index + "Se han Conectado Usuarios");
                                }

                                break;
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread1.start();

        thread2 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        lblTarea.setText("Usuarios Conectados al Servidor");
                        pnlBackground.repaint();
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        thread2.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblSecuencial = new javax.swing.JLabel();
        lblConcurrente = new javax.swing.JLabel();
        lblParalelo = new javax.swing.JLabel();
        lblTimeSecuencial = new javax.swing.JLabel();
        lblTimeConcurrente = new javax.swing.JLabel();
        lblTimeParalelo = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        lblSizeMatriz = new javax.swing.JLabel();
        txtSizeMatriz = new javax.swing.JTextField();
        lblIP = new javax.swing.JLabel();
        txtIPServer = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        btnRellenarMatrices = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblTarea = new javax.swing.JLabel();
        pnlBloques = new javax.swing.JPanel();
        lblBlockSize = new javax.swing.JLabel();
        txtSizeBlock = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        pnlClientes = new javax.swing.JPanel();
        pnlClient1 = new javax.swing.JPanel();
        lblClient1 = new javax.swing.JLabel();
        pnlClient2 = new javax.swing.JPanel();
        lblClient2 = new javax.swing.JLabel();
        pnlClient3 = new javax.swing.JPanel();
        lblClient3 = new javax.swing.JLabel();
        pnlClient4 = new javax.swing.JPanel();
        lblClient4 = new javax.swing.JLabel();
        pnlClient5 = new javax.swing.JPanel();
        lblClient5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(153, 153, 153));

        lblSecuencial.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblSecuencial.setText("Tiempo Secuencial:");

        lblConcurrente.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblConcurrente.setText("Tiempo Concurrente:");

        lblParalelo.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblParalelo.setText("Tiempo Paralelo:");

        lblTimeSecuencial.setFont(new java.awt.Font("Mohave Light", 3, 18)); // NOI18N
        lblTimeSecuencial.setForeground(new java.awt.Color(30, 75, 114));
        lblTimeSecuencial.setText("Tiempo Secuencial...");

        lblTimeConcurrente.setFont(new java.awt.Font("Mohave Light", 3, 18)); // NOI18N
        lblTimeConcurrente.setForeground(new java.awt.Color(0, 155, 25));
        lblTimeConcurrente.setText("Tiempo Concurrente...");

        lblTimeParalelo.setFont(new java.awt.Font("Mohave Light", 3, 18)); // NOI18N
        lblTimeParalelo.setForeground(new java.awt.Color(130, 25, 30));
        lblTimeParalelo.setText("Tiempo Paralelo...");

        pnlDatos.setBackground(new java.awt.Color(51, 51, 51));

        lblSizeMatriz.setForeground(new java.awt.Color(204, 204, 204));
        lblSizeMatriz.setText("<html>Escribe el Tamaño que Quieres Para las Matrices:</html>");

        lblIP.setForeground(new java.awt.Color(204, 204, 204));
        lblIP.setText("<html>Escribe la IP del Servidor:</html>");

        lblEstado.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(202, 42, 27));
        lblEstado.setText("Servidor [  Inactivo  ]");

        btnRellenarMatrices.setText("Rellenar");
        btnRellenarMatrices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRellenarMatricesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIPServer, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSizeMatriz, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(15, 15, 15))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(lblSizeMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblEstado)
                        .addGap(39, 39, 39))))
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnRellenarMatrices, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSizeMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSizeMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRellenarMatrices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIPServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(lblEstado)
                .addContainerGap())
        );

        lblTitle.setFont(new java.awt.Font("Arial Narrow", 3, 36)); // NOI18N
        lblTitle.setText("Server");

        lblTarea.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblTarea.setText("Esperando Iniciar");

        pnlBloques.setBackground(new java.awt.Color(51, 51, 51));

        lblBlockSize.setForeground(new java.awt.Color(204, 204, 204));
        lblBlockSize.setText("<html>Escribe el Tamaño del Bloque quieres Enviar al Cliente:</html>");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBloquesLayout = new javax.swing.GroupLayout(pnlBloques);
        pnlBloques.setLayout(pnlBloquesLayout);
        pnlBloquesLayout.setHorizontalGroup(
            pnlBloquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBloquesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBloquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBloquesLayout.createSequentialGroup()
                        .addComponent(txtSizeBlock)
                        .addGap(15, 15, 15))
                    .addGroup(pnlBloquesLayout.createSequentialGroup()
                        .addComponent(lblBlockSize, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 36, Short.MAX_VALUE))))
            .addGroup(pnlBloquesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlBloquesLayout.setVerticalGroup(
            pnlBloquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBloquesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBlockSize, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSizeBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnlClientes.setBackground(new java.awt.Color(153, 153, 153));

        pnlClient1.setPreferredSize(new java.awt.Dimension(60, 60));

        lblClient1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comunicacion/client.png"))); // NOI18N

        javax.swing.GroupLayout pnlClient1Layout = new javax.swing.GroupLayout(pnlClient1);
        pnlClient1.setLayout(pnlClient1Layout);
        pnlClient1Layout.setHorizontalGroup(
            pnlClient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClient1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(lblClient1)
                .addContainerGap())
        );
        pnlClient1Layout.setVerticalGroup(
            pnlClient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClient1)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pnlClient2.setPreferredSize(new java.awt.Dimension(60, 60));

        lblClient2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comunicacion/client.png"))); // NOI18N

        javax.swing.GroupLayout pnlClient2Layout = new javax.swing.GroupLayout(pnlClient2);
        pnlClient2.setLayout(pnlClient2Layout);
        pnlClient2Layout.setHorizontalGroup(
            pnlClient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClient2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(lblClient2)
                .addContainerGap())
        );
        pnlClient2Layout.setVerticalGroup(
            pnlClient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClient2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClient2)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pnlClient3.setPreferredSize(new java.awt.Dimension(60, 60));

        lblClient3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comunicacion/client.png"))); // NOI18N

        javax.swing.GroupLayout pnlClient3Layout = new javax.swing.GroupLayout(pnlClient3);
        pnlClient3.setLayout(pnlClient3Layout);
        pnlClient3Layout.setHorizontalGroup(
            pnlClient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClient3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblClient3)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        pnlClient3Layout.setVerticalGroup(
            pnlClient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClient3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblClient3)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnlClient4.setPreferredSize(new java.awt.Dimension(60, 60));

        lblClient4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comunicacion/client.png"))); // NOI18N

        javax.swing.GroupLayout pnlClient4Layout = new javax.swing.GroupLayout(pnlClient4);
        pnlClient4.setLayout(pnlClient4Layout);
        pnlClient4Layout.setHorizontalGroup(
            pnlClient4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClient4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(lblClient4)
                .addContainerGap())
        );
        pnlClient4Layout.setVerticalGroup(
            pnlClient4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClient4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClient4)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pnlClient5.setPreferredSize(new java.awt.Dimension(60, 60));

        lblClient5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comunicacion/client.png"))); // NOI18N

        javax.swing.GroupLayout pnlClient5Layout = new javax.swing.GroupLayout(pnlClient5);
        pnlClient5.setLayout(pnlClient5Layout);
        pnlClient5Layout.setHorizontalGroup(
            pnlClient5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClient5Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(lblClient5)
                .addContainerGap())
        );
        pnlClient5Layout.setVerticalGroup(
            pnlClient5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClient5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClient5)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlClientesLayout = new javax.swing.GroupLayout(pnlClientes);
        pnlClientes.setLayout(pnlClientesLayout);
        pnlClientesLayout.setHorizontalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlClientesLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlClientesLayout.createSequentialGroup()
                            .addComponent(pnlClient4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlClient5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlClientesLayout.createSequentialGroup()
                            .addComponent(pnlClient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pnlClient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pnlClient3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        pnlClientesLayout.setVerticalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlClientesLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlClient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlClient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlClient3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlClient4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlClient5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlClient1.getAccessibleContext().setAccessibleName("");
        pnlClient1.getAccessibleContext().setAccessibleDescription("");
        pnlClient1.getAccessibleContext().setAccessibleParent(txtSizeMatriz);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblTitle))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSecuencial)
                            .addComponent(lblConcurrente)
                            .addComponent(lblParalelo)
                            .addComponent(lblTimeSecuencial)
                            .addComponent(lblTimeConcurrente)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lblTarea))))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTimeParalelo)))
                .addGap(34, 34, 34)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBloques, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(pnlBloques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(126, 126, 126))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSecuencial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTimeSecuencial, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblConcurrente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTimeConcurrente)
                                .addGap(18, 18, 18)
                                .addComponent(lblParalelo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTimeParalelo)
                                .addGap(31, 31, 31)
                                .addComponent(lblTarea)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(101, 101, 101))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if (matrizSuccess == 0) {
            JOptionPane.showMessageDialog(null, "Las Matrices NO se han Rellenado!");
        } else {
            Color lblColorSerial = new Color(30, 75, 114);
            Color lblColorConcurrente = new Color(0, 155, 25);
            
            MultiMatricesSecuencial multiSec = new MultiMatricesSecuencial(matrizA, matrizB, matrizC);
            MultiMatricesConcurrente multiCon = new MultiMatricesConcurrente();

            //TiempoSecuencial
            long startTimeS = System.currentTimeMillis();
            multiSec.multiplicar();
            lblTarea.setForeground(lblColorSerial);
            lblTarea.setText("Haciendo la Forma Secuencial");
            long endTimeS = System.currentTimeMillis() - startTimeS;
            System.out.printf("Multiplicación de Matrices Secuencial -> Tiempo de Ejecucion: %dms", endTimeS);
            lblTimeSecuencial.setText(endTimeS + " ms");

            //TiempoConcurrente
            long startTimeC = System.currentTimeMillis();
            lblTarea.setForeground(lblColorConcurrente);
            lblTarea.setText("Haciendo la Forma Concurrente");
            multiCon.multiplicar(matrizA, matrizB, matrizC);
            long endTimeC = System.currentTimeMillis() - startTimeC;
            System.out.printf("Multiplicación de Matrices Concurrente -> Tiempo de Ejecucion: %dms", endTimeC);
            lblTimeConcurrente.setText(endTimeC + " ms");
            
            //Tiempo Paralelo
            try {
                LinkedList<TareaComputable> tempTareasComputable = new LinkedList<>();
                bloque = Integer.parseInt(txtSizeBlock.getText());
                pnlDatos.repaint();
                pnlBloques.repaint();
                startTimePar = System.currentTimeMillis();
                Matriz matrizATemp2;
                numTask = 0;
                int iteracionesCompletas = (matrizA.getNumFilas() / bloque);
                int ultimaIteracion = (matrizA.getNumFilas() % bloque);
                int fila = 0;
                int filaInicio;
                int iteracion = 0;
                Matriz matrizATemp1 = new Matriz(bloque, matrizA.getNumColumnas());
                while (iteracion < iteracionesCompletas) {
                    filaInicio = fila;
                    for (int i = 0; i < bloque; i++) {
                        matrizATemp1.setFila(i, matrizA.getFila(fila));
                        fila++;
                    }
                    tempComputable = new TareaComputable(matrizATemp1, filaInicio, bloque);
                    tempTareasComputable.add(tempComputable);
                    iteracion++;
                    numTask++;
                }
                if (ultimaIteracion != 0) {
                    matrizATemp2 = new Matriz(ultimaIteracion, matrizATemp1.getNumColumnas());
                    for (int i = 0; i < ultimaIteracion; i++) {
                        matrizATemp2.setFila(i, matrizA.getFila(fila));
                        fila++;
                    }
                    tempComputable = new TareaComputable(matrizATemp2, fila, ultimaIteracion);
                    tempTareasComputable.add(tempComputable);
                    numTask++;
                }
                chatServer2.setTareaComputable(tempTareasComputable);
                chatServer2.sendMatrix(matrizB);
                chatServer2.setEstatusProceso(numTask);

                while (banderaGay < elementoTotal) {
                    try {
                        if (chatServer1.vacioBufferResultados()) {
                            System.out.print("");
                        } else {
                            ElementoMatriz tempElementoMatriz;
                            int filaCero;
                            int tamano;
                            Matriz tempMatriz;
                            tempElementoMatriz = chatServer1.getElementoMatriz();
                            tempMatriz = tempElementoMatriz.getMatrizResultados();
                            filaCero = tempElementoMatriz.getFilaCero();
                            tamano = tempElementoMatriz.getTamano();

                            for (int i = 0; i < tempMatriz.getNumFilas(); i++) {
                                for (int j = 0; j < tempMatriz.getNumColumnas(); j++) {
                                    matrizC.setValue((i + filaCero), j, tempMatriz.getValue(i, j));
                                    banderaGay++;
                                }
                            }
                        }
                    } catch (RemoteException | InterruptedException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                stopTimePar = System.currentTimeMillis();
                elapsedTimePar = (stopTimePar - startTimePar);
                lblTimeParalelo.setText(String.valueOf(elapsedTimePar + " ms"));
                lblTarea.setForeground(Color.BLACK);
                lblTarea.setText("Acabo");
                pnlBackground.repaint();
            } catch (RemoteException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnRellenarMatricesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRellenarMatricesActionPerformed
        int size = Integer.parseInt(txtSizeMatriz.getText());
        matrizA = new Matriz(size, size);
        matrizB = new Matriz(size, size);
        matrizC = new Matriz(size, size);

        elementoTotal = (size * size);

        matrizA.rellenarMatriz();
        matrizB.rellenarMatriz();

        lblTarea.setText("Matrices Generadas");
        pnlBackground.repaint();
        matrizSuccess = 1;
    }//GEN-LAST:event_btnRellenarMatricesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Servidor().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnRellenarMatrices;
    private javax.swing.JLabel lblBlockSize;
    private javax.swing.JLabel lblClient1;
    private javax.swing.JLabel lblClient2;
    private javax.swing.JLabel lblClient3;
    private javax.swing.JLabel lblClient4;
    private javax.swing.JLabel lblClient5;
    private javax.swing.JLabel lblConcurrente;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblParalelo;
    private javax.swing.JLabel lblSecuencial;
    private javax.swing.JLabel lblSizeMatriz;
    private javax.swing.JLabel lblTarea;
    private javax.swing.JLabel lblTimeConcurrente;
    public javax.swing.JLabel lblTimeParalelo;
    private javax.swing.JLabel lblTimeSecuencial;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBloques;
    private javax.swing.JPanel pnlClient1;
    private javax.swing.JPanel pnlClient2;
    private javax.swing.JPanel pnlClient3;
    private javax.swing.JPanel pnlClient4;
    private javax.swing.JPanel pnlClient5;
    private javax.swing.JPanel pnlClientes;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JTextField txtIPServer;
    private javax.swing.JTextField txtSizeBlock;
    private javax.swing.JTextField txtSizeMatriz;
    // End of variables declaration//GEN-END:variables
}
