/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author HK
 */
interface IClient {
    
    void SendMessage(String message,boolean isReady);
    void ReceiveMessage(String message);
    boolean isAllReady();
    
}
