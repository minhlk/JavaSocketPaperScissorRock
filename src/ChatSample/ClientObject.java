/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSample;

import java.io.Serializable;

/**
 *
 * @author HK
 */
public class ClientObject implements Serializable{
    
    public int id;
    
    public String message;

    public String name;
    
    public int amount;
    
    public boolean isReady;
    
    public ClientObject(int id,String message, String name, boolean isReady) {
        this.id = id;
        this.message = message;
        this.name = name;
        this.isReady = isReady;
        
//        this.amount = 100;
    }
    
    
}
