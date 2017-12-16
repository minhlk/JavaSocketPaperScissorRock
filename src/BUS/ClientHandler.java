/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import ChatSample.ClientObject;
import ChatSample.fServer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HK
 */
 public class ClientHandler implements Runnable{
    ObjectInputStream reader; 
    ObjectOutputStream writer;
    public long id = 0;
    

    public ClientHandler(Socket socket,ObjectOutputStream out,ObjectInputStream in){
      this.writer = out;
      this.reader = in;
    }
   
    @Override
    public void run() {
           
        try {
                while( true){

                    System.out.println("server is watting");
                    ClientObject client =(ClientObject)reader.readObject();
                    if(!ServerHandler.Contain(client)){
                        System.out.println("online");
                        id = client.id;
                        ServerHandler.players.add(client);
                        System.out.println(client.id +"    "+ServerHandler.players.size());
                    }
                    if(client.message.isEmpty() ){
                        if(client.choose == 0){
                            ServerHandler.chargeCard(client);
                        }
                        if(ServerHandler.isEndgame()){
                            ServerHandler.setDefaultChoice();
                        }
                        if(client.choose != -1){
                            if(ServerHandler.isAllReady() && !ServerHandler.isMessAllSet()){
                                continue;
                            }
                            else{
                                ServerHandler.checkWin();
                            }
                            
                        }
                            //update new players
                             for(ObjectOutputStream write : ServerHandler.GetOOS()){
                                write.writeObject(ServerHandler.players.toArray(new ClientObject[4]));
                                write.reset();
                             }
                            continue;
                        }
                      
                    
                    for(ObjectOutputStream write : ServerHandler.GetOOS()){
                        write.writeObject(client);
                        write.reset();
                    }

//                    tServer.append(client.message + "\n");

                }
        } catch (IOException ex) {
             System.out.println("Can't create thread for client " + ex.getMessage());
             ServerHandler.RemovePlayer(id);
             for(ObjectOutputStream write : ServerHandler.GetOOS()){
                 try {
                     write.writeObject(ServerHandler.players.toArray(new ClientObject[4]));
                     write.reset();
                 } catch (IOException ex1) {
                     System.out.println("client disconnected " + ex.getMessage());
                 }
             }
              ServerHandler.Remove(writer);
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fServer.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
    