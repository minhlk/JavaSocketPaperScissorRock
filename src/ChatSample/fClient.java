package ChatSample;

import BUS.ClientBus;
import Model.Player;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author HK
 */
public class fClient extends javax.swing.JFrame {
    Thread timer;

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    public JButton getjButton5() {
        return jButton5;
    }

    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
    }

    public JButton getjButton6() {
        return jButton6;
    }

    public void setjButton6(JButton jButton6) {
        this.jButton6 = jButton6;
    }

    public JButton getjButton7() {
        return jButton7;
    }

    public void setjButton7(JButton jButton7) {
        this.jButton7 = jButton7;
    }

    public Thread getTimer() {
        return timer;
    }

    public void setTimer(Thread timer) {
        this.timer = timer;
    }

    public JLabel[] getLabels() {
        return labels;
    }

    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }

    public JLabel[] getUserNames() {
        return userNames;
    }

    public void setUserNames(JLabel[] userNames) {
        this.userNames = userNames;
    }

    public Icon getScissor() {
        return scissor;
    }

    public void setScissor(Icon scissor) {
        this.scissor = scissor;
    }

    public Icon getRock() {
        return rock;
    }

    public void setRock(Icon rock) {
        this.rock = rock;
    }

    public Icon getPaper() {
        return paper;
    }

    public void setPaper(Icon paper) {
        this.paper = paper;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JLabel getLAmount() {
        return LAmount;
    }

    public void setLAmount(JLabel LAmount) {
        this.LAmount = LAmount;
    }

    public JLabel getLChoose1() {
        return LChoose1;
    }

    public void setLChoose1(JLabel LChoose1) {
        this.LChoose1 = LChoose1;
    }

    public JLabel getLChoose2() {
        return LChoose2;
    }

    public void setLChoose2(JLabel LChoose2) {
        this.LChoose2 = LChoose2;
    }

    public JLabel getLChoose3() {
        return LChoose3;
    }

    public void setLChoose3(JLabel LChoose3) {
        this.LChoose3 = LChoose3;
    }

    public JLabel getLChoose4() {
        return LChoose4;
    }

    public void setLChoose4(JLabel LChoose4) {
        this.LChoose4 = LChoose4;
    }

    public JLabel getLTimer() {
        return LTimer;
    }

    public void setLTimer(JLabel LTimer) {
        this.LTimer = LTimer;
    }

    public JLabel getLUserName1() {
        return LUserName1;
    }

    public void setLUserName1(JLabel LUserName1) {
        this.LUserName1 = LUserName1;
    }

    public JLabel getLUserName2() {
        return LUserName2;
    }

    public void setLUserName2(JLabel LUserName2) {
        this.LUserName2 = LUserName2;
    }

    public JLabel getLUserName3() {
        return LUserName3;
    }

    public void setLUserName3(JLabel LUserName3) {
        this.LUserName3 = LUserName3;
    }

    public JLabel getLUserName4() {
        return LUserName4;
    }

    public void setLUserName4(JLabel LUserName4) {
        this.LUserName4 = LUserName4;
    }

    public JLabel getlUser1() {
        return lUser1;
    }

    public void setlUser1(JLabel lUser1) {
        this.lUser1 = lUser1;
    }

    public JLabel getlUser2() {
        return lUser2;
    }

    public void setlUser2(JLabel lUser2) {
        this.lUser2 = lUser2;
    }

    public JLabel getlUser3() {
        return lUser3;
    }

    public void setlUser3(JLabel lUser3) {
        this.lUser3 = lUser3;
    }

    public JLabel getlUser4() {
        return lUser4;
    }

    public void setlUser4(JLabel lUser4) {
        this.lUser4 = lUser4;
    }
    ClientBus client;
    JLabel[] labels = new JLabel[3];
    JLabel[] userNames = new JLabel[3];
    JLabel[] choose = new JLabel[3];

    public void setVisiblez(boolean rs){
        this.setVisible(rs);
    }
    
    public JLabel[] getChoose() {
        return choose;
    }

    public void setChoose(JLabel[] choose) {
        this.choose = choose;
    }

    public JTextField gettClient() {
        return tClient;
    }

    public void settClient(JTextField tClient) {
        this.tClient = tClient;
    }
    Icon scissor ,rock,paper;
    
    public fLogin flogin;
    public fClient(int port,Player user, fLogin flogin) {
        initComponents();
        setupframe();
        this.flogin = flogin;
        client = new ClientBus(user,"localhost",port,this);
        (new Thread(client)).start();
        
                labels[0] = lUser2;
                labels[1] = lUser3;
                labels[2] = lUser4;
                
                userNames[0] = LUserName2;
                userNames[1] = LUserName3;
                userNames[2] = LUserName4;
                
                choose[0]=LChoose2;
                choose[1]=LChoose3;
                choose[2]=LChoose4;

                scissor = jButton4.getIcon();
                rock = jButton5.getIcon();
                paper = jButton6.getIcon();
                LChoose1.setVisible(false);
                LChoose2.setVisible(false);
                LChoose3.setVisible(false);
                LChoose4.setVisible(false);
                
                this.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void setupframe(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tClient = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lUser1 = new javax.swing.JLabel();
        lUser3 = new javax.swing.JLabel();
        lUser4 = new javax.swing.JLabel();
        LUserName1 = new javax.swing.JLabel();
        LUserName3 = new javax.swing.JLabel();
        LUserName4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LAmount = new javax.swing.JLabel();
        LTimer = new javax.swing.JLabel();
        LChoose1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lUser2 = new javax.swing.JLabel();
        LUserName2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        LChoose2 = new javax.swing.JLabel();
        LChoose3 = new javax.swing.JLabel();
        LChoose4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 80, 50));

        jButton3.setText("Send");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Send(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, -1, 30));

        tClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tClientActionPerformed(evt);
            }
        });
        getContentPane().add(tClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 128, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Layer2.png"))); // NOI18N
        buttonGroup1.add(jButton4);
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scissor_choose(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 101, -1));

        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Layer3.png"))); // NOI18N
        buttonGroup1.add(jButton5);
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rock_choose(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 210, 81));

        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Layer4.png"))); // NOI18N
        buttonGroup1.add(jButton6);
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paper_choose(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 100, 81));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, 72));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        lUser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lUser1.setForeground(new java.awt.Color(255, 51, 102));
        lUser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lUser1.setText("Sẵn sàng");
        lUser1.setEnabled(false);
        jPanel1.add(lUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 150, 25));
        lUser1.getAccessibleContext().setAccessibleName("lUser1");

        lUser3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lUser3.setForeground(new java.awt.Color(255, 51, 102));
        lUser3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lUser3.setText("Sẵn sàng");
        lUser3.setEnabled(false);
        jPanel1.add(lUser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 150, 25));

        lUser4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lUser4.setForeground(new java.awt.Color(255, 51, 102));
        lUser4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lUser4.setText("Sẵn sàng");
        lUser4.setEnabled(false);
        jPanel1.add(lUser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 150, 25));

        LUserName1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LUserName1.setForeground(new java.awt.Color(255, 0, 0));
        LUserName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LUserName1.setText("UserName");
        LUserName1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LUserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 150, 25));

        LUserName3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LUserName3.setForeground(new java.awt.Color(255, 0, 0));
        LUserName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LUserName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 150, 25));

        LUserName4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LUserName4.setForeground(new java.awt.Color(255, 0, 0));
        LUserName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LUserName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 150, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Số tiền hiện có : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        LAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LAmount.setText("0");
        jPanel1.add(LAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 71, 30));

        LTimer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LTimer.setForeground(new java.awt.Color(255, 51, 51));
        LTimer.setText("Đang chờ người chơi");
        jPanel1.add(LTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        LChoose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Layer2.png"))); // NOI18N
        jPanel1.add(LChoose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 50, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        lUser2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lUser2.setForeground(new java.awt.Color(255, 51, 102));
        lUser2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lUser2.setText("Sẵn sàng");
        lUser2.setEnabled(false);
        jPanel1.add(lUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, 25));

        LUserName2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LUserName2.setForeground(new java.awt.Color(255, 0, 0));
        LUserName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LUserName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 150, 25));

        jButton7.setText("Nạp tiền");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7Client_Ready(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 50));

        LChoose2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Layer2.png"))); // NOI18N
        jPanel1.add(LChoose2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 50, 80));

        LChoose3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Layer2.png"))); // NOI18N
        jPanel1.add(LChoose3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 50, 80));

        LChoose4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Layer2.png"))); // NOI18N
        jPanel1.add(LChoose4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 50, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 66, 190, 400));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 520, 940, 10));

        jButton1.setText("Sẵn sàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Client_Ready(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 110, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(operation); //To change body of generated methods, choose Tools | Templates.
    }

    private void Send(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Send
       
        
        
        
        if(!tClient.getText().isEmpty()){
            client.SendMessage(tClient.getText(),false);
            String mess =  "You : " + tClient.getText();
            client.ReceiveMessage(mess);
            tClient.setText("");
        }
        
    }//GEN-LAST:event_Send

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        client.SendMessage(client.currentUser.name + " đã thoát khỏi phòng",true);
        try {
            this.dispose();
            client.socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(fClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
//        client.SendMessage(client.currentUser.name + " đã thoát khỏi phòng",true);
//          try {
//            client.socket.close();
//        } catch (IOException ex) {
//            Logger.getLogger(fClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }//GEN-LAST:event_formWindowClosing

    private void scissor_choose(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scissor_choose
//      choose = 1;
       client.currentUser.choose = 1;
       LChoose1.setIcon(scissor);
    }//GEN-LAST:event_scissor_choose

    private void rock_choose(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rock_choose
//        choose = 2;
        client.currentUser.choose = 2;
        LChoose1.setIcon(rock);
        
    }//GEN-LAST:event_rock_choose

    private void paper_choose(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paper_choose
//       choose = 3;
        client.currentUser.choose = 3;
        LChoose1.setIcon(paper);
    }//GEN-LAST:event_paper_choose

    private void tClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tClientActionPerformed

    private void Client_Ready(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Client_Ready

        //        if(lUser1.isEnabled()){
            //            lUser1.setEnabled(false);
            //            client.currentUser.choose = -1;
            //            client.Ready(false);
            //            LTimer.setText("Đang chờ người chơi");
            //
            //        }
        //        else{
        if(userNames[0].getText().compareTo("")==0 && userNames[1].getText().compareTo("")==0 && userNames[2].getText().compareTo("")==0){
            JOptionPane.showMessageDialog( null,"Cần tối thiểu 2 người để chơi!");
        }
        else if(client.currentUser.amount>=10){
            lUser1.setEnabled(true);
            client.SendMessage("",true);
            jButton1.setEnabled(false);
        }
        else
            JOptionPane.showMessageDialog(null,"Bạn không đủ coin để tham gia, hãy nạp thêm!");

        //        }
    }//GEN-LAST:event_Client_Ready

    private void jButton7Client_Ready(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7Client_Ready
        client.chargeCard();
    }//GEN-LAST:event_jButton7Client_Ready

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed
    
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LAmount;
    private javax.swing.JLabel LChoose1;
    private javax.swing.JLabel LChoose2;
    private javax.swing.JLabel LChoose3;
    private javax.swing.JLabel LChoose4;
    private javax.swing.JLabel LTimer;
    private javax.swing.JLabel LUserName1;
    private javax.swing.JLabel LUserName2;
    private javax.swing.JLabel LUserName3;
    private javax.swing.JLabel LUserName4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lUser1;
    private javax.swing.JLabel lUser2;
    private javax.swing.JLabel lUser3;
    private javax.swing.JLabel lUser4;
    private javax.swing.JTextField tClient;
    // End of variables declaration//GEN-END:variables
}
