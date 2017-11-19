/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HK
 */
public class fServer extends javax.swing.JFrame {

    /**
     * Creates new form fServer
     */
    Server server;
    public fServer() {
        initComponents();
        server = new Server(9999);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tServer = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_Start(evt);
            }
        });

        jButton2.setText("End");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_End(evt);
            }
        });

        tServer.setColumns(20);
        tServer.setRows(5);
        jScrollPane1.setViewportView(tServer);
        tServer.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Server_Start(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_Start
      Thread thread = new Thread(server);
      thread.start();
       
        
        
        
        
    }//GEN-LAST:event_Server_Start

    private void Server_End(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_End
        
        server.EndServer();
    }//GEN-LAST:event_Server_End

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
            java.util.logging.Logger.getLogger(fServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fServer().setVisible(true);
            }
        });
    }

    
    
    
    class ClientHandler implements Runnable{
    BufferedReader reader; 
    PrintWriter writer;
    public boolean status = true;
    public Socket socket;
    private ArrayList<Socket> socks;
    private ArrayList<PrintWriter> writers;
    
    public ClientHandler(Socket socket){
      this.socket  = socket;
      writers = new ArrayList<>();
    }
    private void UpdateWriter( ArrayList<Socket> socks){
        this.socks = socks;
        try {
        writers = new ArrayList<>();
            for(Socket sock : socks){

                    writers.add(new PrintWriter(sock.getOutputStream()));

            }
        
         } catch (IOException ex) {
                Logger.getLogger(fServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    @Override
    public void run() {
           try {
            String message;
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while( (message = reader.readLine() ) != null){
                System.out.println(message);
               for(PrintWriter write : writers){
                    write.println(message);
                    write.flush();
               }
                tServer.append(message + "\n");
                
            }
               System.out.println("error input");
        } catch (IOException ex) {
            System.out.println("Can't create thread for client " + ex.getMessage());
            status = false;
        }
        
    }
    
}
    
    public class Server implements Runnable{
    int port;
    boolean isRunning = false;
    ServerSocket server;
    ThreadPoolExecutor execute;
    private ArrayList<ClientHandler> handlers = new ArrayList<>();
    private ArrayList<Socket> socks = new ArrayList<>();
    public Server(int port){
        this.port = port;
    }
    private void StartServer(){
        try {
            isRunning = true;
            server = new ServerSocket(port);
            execute = new ThreadPoolExecutor(4,4,0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>());       
            while(true){
                System.out.println("Server's starting");
                // create thread for handle new client connect to server
                Socket sock = server.accept();
                socks.add(sock);
               ClientHandler handler = new ClientHandler(sock);
                handlers.add(handler);
                //remove user not connect
                for(ClientHandler hand : handlers){
                    if(!hand.status) handlers.remove(hand);
                    else{
                      hand.UpdateWriter(socks);
                    }
                }
                
                
                if(CountActive() <= 3 )
                execute.execute(handler);
                else{
                    System.out.println("phong da day");
//                    sock.getOutputStream().write(2);
                }
            }
            
        } catch (IOException ex) {
            System.out.println("Server can't start " + ex.getMessage());
        }
    }
    public void EndServer(){
        if(isRunning)
        try {
            server.close();
        } catch (IOException ex) {
            System.out.println("Server can't stop " + ex.getMessage());
        }
    }
 
     public int CountActive(){
        return execute.getActiveCount();
    }
    
    @Override
    public void run() {
       StartServer();
    }
}
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tServer;
    // End of variables declaration//GEN-END:variables
}