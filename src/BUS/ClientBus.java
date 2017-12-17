/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import ChatSample.ClientObject;
import ChatSample.fClient;
import Helper.OnlineUser;
import Model.Player;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author HK
 */
 public class ClientBus implements Runnable,IClient {
    
    private ObjectInputStream reader ;
    private ObjectOutputStream writer;
    public Socket socket;
    private String address;
    private int port;
    private ClientObject[] users ;
    public ClientObject currentUser;
    private Player user;
    private boolean isActive = false;
    private fClient fclient;
    
    boolean isPlaying = false;
    public ClientBus(Player user,String address, int port, fClient fclient){
        this.address = address;
        this.port = port;
        this.user = user;
        this.fclient = fclient;
        
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
    public void chargeCard() {
       
        try {
            currentUser.choose=0;
            ClientObject client = currentUser;
            writer.writeObject(client);
            writer.reset();
            fclient.getLAmount().setText(currentUser.amount+ " Coin");
           
        } catch (IOException ex) {
            Logger.getLogger(fClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void ReceiveMessage(String message) {
         fclient.getjTextArea1().append( message + "\n");
    }
    
    @Override
    public boolean isAllReady(){
        for(ClientObject user : users){
            if(user != null)
            if(!user.isReady) return false;
        }
        return true;
    }
    public boolean isEndgame(){
        for(ClientObject user : users){
            if(user != null)
            if(user.choose>=4) return true;
        }
        return false;
    }
    

    @Override
    public void run() {
            try {
            socket = new Socket("localhost", port);
                 InputStream is = socket.getInputStream();
//                 OutputStream out = socket.getOutputStream();
            while(is.read() == 1){
                
                //new line of code start
                 socket = new Socket(address, ++port);
                 is = socket.getInputStream();
                //new line of code end
            }
            isActive = true;
            // to read from server
            reader = new ObjectInputStream(socket.getInputStream());
            // to write to server
            writer = new ObjectOutputStream(socket.getOutputStream());
            
            writer.writeObject(user);
            Player loginRs = (Player) reader.readObject();
            if(loginRs == null){
                //fail to login
                 JOptionPane.showMessageDialog( null,"Sai tài khoản hoặc mật khẩu");
                 return;
                 
            }
            else{
                 if(loginRs.getId() == -1){
                     JOptionPane.showMessageDialog( null,"tai khoan da duoc dang nhap");
                     return;
                 }
                  JOptionPane.showMessageDialog( null,"Đăng nhập thành công");
                this.user = loginRs;
               
                currentUser = new ClientObject(user.getId(), "", user.getPlayerName().trim(), false);
                currentUser.amount = user.getAmount();
                 fclient.getLUserName1().setText(currentUser.name.trim());
                 fclient.getLAmount().setText(currentUser.amount + " Coin");
                
                fclient.setVisible(true);
                fclient.flogin.setVisible(false);
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
                    //everyone isready
                    
                        fclient.getLAmount().setText(currentUser.amount + " Coin");
                        //receive new amount after play game
                        //if win
                        if(isPlaying){
                            if(winAmount > 0){
                                JOptionPane.showMessageDialog(null ,"Bạn thắng");
                            }
                            //if lose
                            else if(winAmount < 0)
                                JOptionPane.showMessageDialog(null ,"Bạn thua");
                            else JOptionPane.showMessageDialog(null ,"Hòa");
                            isPlaying=false;
                            fclient.isReady = false;
                        }
                        
                    int i = 0;
                    int j = 0;
                    for(JLabel label : fclient.getLabels()){
                        if(users[i] == null) {
                            
                           
                            
                            fclient.getLabels()[j].setEnabled(false);
                            fclient.getUserNames()[j].setText("");
                        }
                        else if(users[i].id != currentUser.id){
                            fclient.getLabels()[j].setEnabled(users[i].isReady);
                            fclient.getUserNames()[j].setText(users[i].name);
                            j++;
                        }
                        i++;
                    }
                    if(isAllReady() && !isPlaying){   
                            isPlaying=true;
                         fclient.getLChoose2().setVisible(false);
                         fclient.getLChoose3().setVisible(false);
                         fclient.getLChoose4().setVisible(false);
                        fclient.setTimer( 
                                new Thread(
                                        new CountdownTimer(this,fclient)
                                ));
                        fclient.getTimer().start();
                    }
                    if(isEndgame()){
                        int a = 0;
                        int b = 0;
                        for(JLabel label :   fclient.getChoose()){
                        if(users[a] == null) {
                        }
                        else if(users[a].id != currentUser.id){
                            fclient.getChoose()[b].setVisible(true);
                            setEndgame(users[a].choose,fclient.getChoose()[b]);
                            b++;
                        }
                        a++;
                    }
                    }
                    
                        
                }
            }
        } catch (IOException ex) {
            System.out.println("Can't connect "+ ex.getMessage());
            if(!isActive)
                JOptionPane.showMessageDialog( null,"phòng đầy ");
//            else
//                OnlineUser.RemoveUser(currentUser.id);
            System.exit(0);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(fClient.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    private void setEndgame(byte choose, JLabel Lchoose){
        switch(choose){
            case 4:
                Lchoose.setIcon( fclient.getScissor());
                break;
            case 5:
                Lchoose.setIcon( fclient.getRock());
                break;
            case 6:
                Lchoose.setIcon( fclient.getPaper());
                break;
            default:
                break;
        }
        System.out.println(choose);
    }
  
}
