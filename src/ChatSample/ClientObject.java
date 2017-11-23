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
    
    public String message;

    public String name;
    
    public boolean isReady;
    
    public ClientObject(String message, String name, boolean isReady) {
        this.message = message;
        this.name = name;
        this.isReady = isReady;
    }
    
    
}
