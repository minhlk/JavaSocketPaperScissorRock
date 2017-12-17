/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import ChatSample.fServer;
import java.util.HashMap;

/**
 *
 * @author HK
 */
public class ServerBus {
    
    fServer _serverView;
    HashMap<Integer, Room> roomMock;
    public ServerBus(fServer serverView){
        _serverView = serverView;
        roomMock = new HashMap<>();
    }
    
    public boolean StartRoom(int num){
        if(roomMock.containsKey(num)){
            EndRoom(num);
            roomMock.remove(num);
            return false;
        }
        else{
            Room room = new Room(num);

            roomMock.put(num, room);

            (new Thread(room) ).start();
            
            return true;
        }
    }
    public void EndRoom(int num){
    
        if(roomMock.containsKey(num)){
            roomMock.get(num).EndServer();
        }
        
    }
    
    
    
    
    
    
   
}
