/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import ChatSample.fServer;
import DAO.PlayerDAO;
import Model.Player;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HK
 */
 public class Room implements Runnable{
    private int port;
    private boolean isRunning = false;
    private ServerSocket server;
    private ThreadPoolExecutor execute;       
    public Room(int port){
        this.port = port;
    }
    private void StartServer(){
        try {
            isRunning = true;
            server = new ServerSocket(port, 0, InetAddress.getByName("127.0.0.2"));
            execute = new ThreadPoolExecutor(4,4,0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>());       
            while(true){
                System.out.println("Server's starting");
                // create thread for handle new client connect to server
                Socket sock = server.accept();
                if(CountActive() > 3 ){
                    System.out.println("phong da day");
                    sock.getOutputStream().write(1);
                }
                else{
                    sock.getOutputStream().write(0);
                    ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
                    Player player ;
                    if((player = (Player)in.readObject()) instanceof Player){
                        PlayerDAO dao = new PlayerDAO();
                        Player rs = dao.Login(player);
                        out.writeObject(rs);
                        if(rs == null)
                            continue;
                    }
                    ServerHandler.Add(out);
                    ClientHandler handler = new ClientHandler(sock,out,in);
                    execute.execute(handler);
                }
                
            }
            
        } catch (IOException ex) {
            System.out.println("Server can't start " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EndServer(){
        if(isRunning)
        try {
            server.close();
            execute.shutdown();
//            System.exit(0);
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
    
