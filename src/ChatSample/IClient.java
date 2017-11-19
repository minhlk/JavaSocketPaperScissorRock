/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSample;

/**
 *
 * @author HK
 */
interface IClient {
    
    void SendMessage(String message);
    void UpdateChat(String message);
//    boolean Connect(String address, int port);
    boolean Disconnect();
    
}
