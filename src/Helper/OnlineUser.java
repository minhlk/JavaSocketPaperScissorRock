/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.HashMap;

/**
 *
 * @author HK
 */
public class OnlineUser {
    public static HashMap<Long,Integer> Users = new HashMap<>();
    
    public static boolean AddUser(Long Id){
        if(Users.containsKey(Id))
            return false;
        
        Users.put(Id, 0);
        return true;
    }
     public static boolean RemoveUser(Long Id){
        if(Users.containsKey(Id)){
            Users.remove(Id);
            return true;
        }
        return false;
    }
}
