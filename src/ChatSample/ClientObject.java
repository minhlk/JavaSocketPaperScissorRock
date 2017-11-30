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
    
    public long id;
    
    public String message;

    public String name;
    
    public long amount;
    
    public boolean isReady;
    
    //1 scisscor
    //2 rock
    //3 paper
    
    public byte choose = -1;
    
    public ClientObject(long id,String message, String name, boolean isReady) {
        this.id = id;
        this.message = message;
        this.name = name;
        this.isReady = isReady;
    }
    
    
}
