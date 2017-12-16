package ChatSample;

import BUS.ServerBus;
import DAO.PlayerDAO;
import Model.Player;
import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
 * @author MinhLK
 */
public class fServer extends javax.swing.JFrame {

    ServerBus server;
    static public boolean isActive = false;
    public fServer() {
        initComponents();
        server = new ServerBus(this);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Start All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_Start(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 170, 60));

        jButton2.setText("End All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_End(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 170, 60));

        b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room.png"))); // NOI18N
        b8.setText("Room 8");
        getContentPane().add(b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, 60));

        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room.png"))); // NOI18N
        b3.setText("Room 3");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        getContentPane().add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, 60));

        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room.png"))); // NOI18N
        b2.setText("Room 2");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, 60));

        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room.png"))); // NOI18N
        b1.setText("Room 1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 60));

        b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room.png"))); // NOI18N
        b4.setText("Room 4");
        getContentPane().add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, 60));

        b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room.png"))); // NOI18N
        b5.setText("Room 5");
        getContentPane().add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 60));

        b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room.png"))); // NOI18N
        b6.setText("Room 6");
        getContentPane().add(b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 60));

        b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room.png"))); // NOI18N
        b7.setText("Room 7");
        getContentPane().add(b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Server_Start(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_Start
       
    }//GEN-LAST:event_Server_Start

    private void Server_End(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_End
        
       
    }//GEN-LAST:event_Server_End

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        if( server.StartRoom(1))
        {
            //start server
            b1.setBackground(Color.RED);
        }
        else{
            // end server
            b1.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        if(server.StartRoom(2))
        {
            //start server
              b2.setBackground(Color.RED);
        }
        else{
            // end server
            b2.setBackground(Color.WHITE);
          
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
         if( server.StartRoom(3))
        {
            //start server
            b3.setBackground(Color.RED);
            
        }
        else{
            // end server
            b3.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_b3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fServer().setVisible(true);
            }
        });
    }
    /*
    public static boolean checkOnline(String name){
        System.out.println("coming "+ ServerHandler.Contain(name));
        return ServerHandler.Contain(name);
    }*/
    
    
    
  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
