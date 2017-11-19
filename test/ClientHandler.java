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
import java.net.Socket;

/**
 *
 * @author HK
 */
public class ClientHandler implements Runnable{
    BufferedReader reader; 
    PrintWriter writer;
    Socket socket;
    public ClientHandler(Socket socket){
      this.socket  = socket;
    }
    @Override
    public void run() {
           try {
            String message;
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while( (message = reader.readLine() ) != null){
                System.out.println(message);
                writer.println("Receive message : " + message);
                
            }
               System.out.println("error input");
        } catch (IOException ex) {
            System.out.println("Can't create thread for client " + ex.getMessage());
        }
        
    }
    
}
