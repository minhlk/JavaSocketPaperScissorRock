package ChatSample;

import Model.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author HK
 */
public class fClient extends javax.swing.JFrame {
    Thread timer;
    Client client;
    JLabel[] labels = new JLabel[3];
    JLabel[] userNames = new JLabel[3];
    Icon scissor ,rock,paper;
    boolean isActive = true;
    public fLogin flogin;
    public fClient(int port,User user,fLogin flogin) {
        initComponents();
        this.flogin = flogin;
         client = new Client(user,"localhost",port);
        (new Thread(client)).start();
        
                labels[0] = lUser2;
                labels[1] = lUser3;
                labels[2] = lUser4;
                
                userNames[0] = LUserName2;
                userNames[1] = LUserName3;
                userNames[2] = LUserName4;


                scissor = jButton4.getIcon();
                rock = jButton5.getIcon();
                paper = jButton6.getIcon();
                LChoose.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
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
        LChoose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lUser2 = new javax.swing.JLabel();
        LUserName2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Sẵn sàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Client_Ready(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 11, 110, 50));

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

        LUserName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LUserName1.setText("UserName");
        LUserName1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LUserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 150, 25));
        jPanel1.add(LUserName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 150, 25));
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

        LChoose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Layer2.png"))); // NOI18N
        jPanel1.add(LChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 50, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        lUser2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lUser2.setForeground(new java.awt.Color(255, 51, 102));
        lUser2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lUser2.setText("Sẵn sàng");
        lUser2.setEnabled(false);
        jPanel1.add(lUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, 25));
        jPanel1.add(LUserName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 150, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 66, 190, 400));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 520, 940, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Client_Ready(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Client_Ready
    
//        if(lUser1.isEnabled()){
//            lUser1.setEnabled(false);
//            client.currentUser.choose = -1;
//            client.Ready(false);
//            LTimer.setText("Đang chờ người chơi");
//            
//        }
//        else{
            lUser1.setEnabled(true);
            client.SendMessage("",true);
            jButton1.setEnabled(false);
            
//        }
    }//GEN-LAST:event_Client_Ready

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
        
        client.SendMessage(client.currentUser.name + " đã thoát khỏi phòng",true);
          try {
            client.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(fClient.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_formWindowClosing

    private void scissor_choose(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scissor_choose
//      choose = 1;
       client.currentUser.choose = 1;
       LChoose.setIcon(scissor);
    }//GEN-LAST:event_scissor_choose

    private void rock_choose(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rock_choose
//        choose = 2;
        client.currentUser.choose = 2;
        LChoose.setIcon(rock);
        
    }//GEN-LAST:event_rock_choose

    private void paper_choose(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paper_choose
//       choose = 3;
        client.currentUser.choose = 3;
        LChoose.setIcon(paper);
    }//GEN-LAST:event_paper_choose
    
    public class Client implements Runnable,IClient {
    
    private ObjectInputStream reader ;
    private ObjectOutputStream writer;
    private Socket socket;
    private final String address;
    private final int port;
    private ClientObject[] users ;
    private ClientObject currentUser;
    private User user;
    public Client(User user,String address, int port){
        this.address = address;
        this.port = port;
        this.user = user;
       
        
    }
    
    @Override
    public void SendMessage( String message,boolean isReady) {
       
        try {
            currentUser.message = message;
            currentUser.isReady = isReady;
            
            ClientObject client = currentUser;
            writer.writeObject(client);
            writer.reset();
           
        } catch (IOException ex) {
            Logger.getLogger(fClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void ReceiveMessage(String message) {
        jTextArea1.append( message + "\n");
    }
    
    @Override
    public boolean isAllReady(){
        for(ClientObject user : users){
            if(user != null)
            if(!user.isReady) return false;
        }
        return true;
    }

    @Override
    public void run() {
             try {
            socket = new Socket(address, port);
                 InputStream is = socket.getInputStream();
                 OutputStream out = socket.getOutputStream();
            if(is.read() == 1){
                JOptionPane.showMessageDialog( null,"phòng đầy ");
                System.exit(0);
                return;
                
            }
            // to read from server
            reader = new ObjectInputStream(socket.getInputStream());
            // to write to server
            writer = new ObjectOutputStream(socket.getOutputStream());
            
            writer.writeObject(user);
//            int loginRs = is.read();
            User loginRs = (User) reader.readObject();
            if(loginRs == null){
                //fail to login
                 JOptionPane.showMessageDialog( null,"Sai tài khoản hoặc mật khẩu");
                 return;
                 
            }
            else{
                 JOptionPane.showMessageDialog( null,"Đăng nhập thành công");
                 this.user = loginRs;
                currentUser = new ClientObject(user.getId(), "", user.getUserName().trim(), false);
                currentUser.amount = user.getAmount();
                LUserName1.setText(currentUser.name.trim());
               LAmount.setText(currentUser.amount + " Coin");
               fClient.this.setVisible(true);
               fClient.this.flogin.setVisible(false);
            }
            
            
            
            writer.writeObject(currentUser);
            writer.reset();
            currentUser.message = currentUser.name + " vừa vào phòng";
            writer.writeObject(currentUser);
            
            String mess;
            while(true){
                System.out.println("client is watting");
                Object object = reader.readObject();
                
                if(object instanceof ClientObject){
                    
                    ClientObject user = (ClientObject)object;
                    //receive message from other players
                    if(!user.message.isEmpty() && user.id != currentUser.id){
                    mess = user.name + " : " + user.message;
                    ReceiveMessage(mess);
                    }
                }
                else if(object instanceof ClientObject[]){
                    users =(ClientObject[])object;
                  
                    long winAmount = 0;
                    for(ClientObject user : users){
                        if(user != null)
                        if(user.id == currentUser.id){
                            winAmount = user.amount - currentUser.amount;
                            currentUser = user;
                            break;
                        }
                    }
                       LAmount.setText(currentUser.amount + " Coin");
                        //receive new amount after play game
                        //if win
                        if(winAmount > 0){
                            JOptionPane.showMessageDialog(null ,"Bạn thắng");
                        }
                        //if lose
                        else if(winAmount < 0){
                            JOptionPane.showMessageDialog(null ,"Bạn thua");
                        }
                    int i = 0;
                    int j = 0;
                   for(JLabel label : labels){
                       if(users[i] == null) {
                           labels[j].setEnabled(false);
                           userNames[j].setText("");
                       }
                       else if(users[i].id != currentUser.id){
                           labels[j].setEnabled(users[i].isReady);
                           userNames[j].setText(users[i].name);
                           j++;
                       }
                      i++;
                   }
                   //everyone isready
                    if(isAllReady()){                  
                            timer = new Thread(new CountdownTimer(this));
                            timer.start();   
                   }
                }
            }
        } catch (IOException ex) {
            System.out.println("Can't connect "+ ex.getMessage());
            System.exit(0);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(fClient.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
  
}
    public class CountdownTimer implements Runnable{
        Client client;
        public CountdownTimer(Client client){
            this.client = client;
        }
        @Override
        public void run() {   
            LChoose.setIcon(scissor);
            LChoose.setVisible(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jButton4.setEnabled(true);
            for(int i = 15 ; i >= 0; i--){
               
                try {
                     LTimer.setText(i+" giây");
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    return;
                }
            }
            //send choose to server
            System.out.println("player choose " + client.currentUser.choose);
            if(client.currentUser.choose == -1)
                client.currentUser.choose = 1;
            lUser1.setEnabled(false);
            client.SendMessage("", true);
            jButton1.setEnabled(true);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            jButton4.setEnabled(false);
             LChoose.setVisible(false);
            LTimer.setText("Đang chờ người chơi");
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LAmount;
    private javax.swing.JLabel LChoose;
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
