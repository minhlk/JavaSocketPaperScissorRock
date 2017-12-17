/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import ChatSample.fClient;

/**
 *
 * @author HK
 */
public class CountdownTimer implements Runnable{
        ClientBus client;
        fClient fclient;
        public CountdownTimer(ClientBus client, fClient fclient){
            this.client = client;
            this.fclient = fclient;
        }
        @Override
        public void run() {   
            fclient.getLChoose1().setIcon(fclient.getScissor());
            fclient.getLChoose1().setVisible(true);
            fclient.getjButton5().setEnabled(true);
            fclient.getjButton6().setEnabled(true);
            fclient.getjButton4().setEnabled(true);
            fclient.getjButton2().setEnabled(false);
            fclient.getjButton7().setEnabled(false);
            for(int i = 5 ; i >= 0; i--){
                try {
                     fclient.getLTimer().setText(i+" giây");
                    Thread.sleep(1000);
                } 
                catch (InterruptedException ex) {
                    return;
                }
            }
            fclient.getjButton2().setEnabled(true);
            //send choose to server
            System.out.println("player choose " + client.currentUser.choose);
            if(client.currentUser.choose != 1 && client.currentUser.choose != 2 && client.currentUser.choose != 3)
                client.currentUser.choose = 1;
            fclient.getlUser1().setEnabled(false);
            client.SendMessage("", true);
            fclient.getjButton1().setEnabled(true);
            fclient.getjButton5().setEnabled(false);
            fclient.getjButton6().setEnabled(false);
            fclient.getjButton4().setEnabled(false);
            fclient.getjButton7().setEnabled(true);
            fclient.getLTimer().setText("Đang chờ người chơi");
        }
    }
