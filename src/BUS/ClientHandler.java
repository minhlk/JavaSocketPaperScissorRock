/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import ChatSample.ClientObject;
import Helper.OnlineUser;
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
    ServerHandler serverHandler;

    public ClientHandler(Socket socket,ObjectOutputStream out,ObjectInputStream in ,ServerHandler serverHandler){
      this.writer = out;
      this.reader = in;
      this.serverHandler = serverHandler;
    }
   
    @Override
    public void run() {
           
        try {
                while( true){

                    System.out.println("server is watting");
                    ClientObject client =(ClientObject)reader.readObject();
                    if(!serverHandler.Contain(client)){
                        System.out.println("online");
                        id = client.id;
                        serverHandler.players.add(client);
                        System.out.println(client.id +"    "+serverHandler.players.size());
                    }
                    if(client.message.isEmpty() ){
                        if(client.choose == 0){
                            serverHandler.chargeCard(client);
                        }
                        if(serverHandler.isEndgame()){
                            serverHandler.setDefaultChoice();
                        }
                        if(client.choose != -1){
                            if(serverHandler.isAllReady() && !serverHandler.isMessAllSet()){
                                continue;
                            }
                            else{
                                serverHandler.checkWin();
                            }
                            
                        }
                            //update new players
                             for(ObjectOutputStream write : serverHandler.GetOOS()){
                                write.writeObject(serverHandler.players.toArray(new ClientObject[4]));
                                write.reset();
                             }
                            continue;
                        }
                      
                    
                    for(ObjectOutputStream write : serverHandler.GetOOS()){
                        write.writeObject(client);
                        write.reset();
                    }

//                    tServer.append(client.message + "\n");

                }
        } catch (IOException ex) {
             System.out.println("Can't create thread for client " + ex.getMessage());
             serverHandler.RemovePlayer(id);
             OnlineUser.RemoveUser(id);
             for(ObjectOutputStream write : serverHandler.GetOOS()){
                 try {
                     write.writeObject(serverHandler.players.toArray(new ClientObject[4]));
                     write.reset();
                 } catch (IOException ex1) {
                     System.out.println("client disconnected " + ex.getMessage());
                 }
             }
              serverHandler.Remove(writer);
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fServer.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
    