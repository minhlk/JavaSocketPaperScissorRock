/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSample;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author HK
 */
public class Server implements Runnable{
    int port;
    boolean isRunning = false;
    ServerSocket server;
    
    public Server(int port){
        this.port = port;
    }
    private void StartServer(){
        try {
            isRunning = true;
            server = new ServerSocket(port);
            while(true){
                System.out.println("Server's starting");
                // create thread for handle new client connect to server
                Thread thread = new Thread(
                        new ClientHandler(server.accept())
                );
                thread.start();
                
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

    @Override
    public void run() {
       StartServer();
    }
}
