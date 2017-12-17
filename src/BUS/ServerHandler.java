/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import ChatSample.ClientObject;
import DAO.PlayerDAO;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author HK
 */
public class ServerHandler{
    private  ArrayList<ObjectOutputStream> oos = new ArrayList<>();
    public   ArrayList<ClientObject> players = new ArrayList<ClientObject>();
    private  PlayerDAO playerDao = new PlayerDAO();
    public  ArrayList<ObjectOutputStream> GetOOS(){
         return oos;
         
     }
    public synchronized  void Remove(ObjectOutputStream os){
       oos.remove(os);
    }
    public synchronized  void Add(ObjectOutputStream os){
       oos.add(os);
    }
    public synchronized  boolean Contain(ClientObject client){
            for(int i = 0 ; i < players.size() ; i++){
            if(players.get(i).id == client.id){
               ClientObject player = client;
               players.set(i, player);
               return true;
           }
        }
    return false;
    }
    public synchronized  void RemovePlayer(long id){
        for(int i = 0 ; i < players.size() ; i++){
            if(players.get(i).id == id){
               players.remove(i);
            }
        }     
    }  
    public synchronized  boolean isAllReady(){
        for(ClientObject player : players){
            if(!player.isReady ) return false;
        }
        return true;
    }
    public synchronized  boolean isMessAllSet(){
          
       
               for(int i = 0 ; i < players.size() ; i++){
                   if(players.get(i).choose == -1)
                       return false;
               }
           return true;
      }
    public synchronized  boolean isEndgame(){
        for(ClientObject player : players){
            if(player.choose>=4 ) return true;
        }
        return false;
    }
        public  void setDefaultChoice(){
            for(int i = 0 ; i < players.size() ; i++){
                    ClientObject player = players.get(i);
                    player.choose = -1;
                    players.set(i, player);
               }
        }
        private  void setEndgame(){
            for(int i = 0 ; i < players.size() ; i++){
                    ClientObject player = players.get(i);
                    player.choose +=3;
                    player.isReady = false;
                       players.set(i, player);
               }
        }
        public  void checkWin(){
            //edit calculate winner algorithm again @@
            /*boolean[] rs = new boolean[players.size()];
                for(int i = 0 ; i < players.size() - 1;i++){
                    for(int j = i+ 1; j < players.size();j++){
                        ClientObject player1 = players.get(i);
                        ClientObject player2 = players.get(j);
                        byte one = player1.choose;
                        byte two = player2.choose;
                        if(one  -  two == 1 || two - one == 2 ){
                            rs[i] = true;
                            rs[j] = false;
                        }
                        else if(one  -  two == -1 || two - one == -2 ){
                            rs[i] = false;
                            rs[j] = true;
                         }
                    }
                  }*/
            
            
                  //count different choices
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0;i<players.size();i++)
                if(!list.contains((int)players.get(i).choose)){
                    list.add((int)players.get(i).choose);
                    System.out.println(players.get(i).choose);
                    if(list.size()>=3) break;
                    }
            byte winchoice=0;
            if(list.size()==2){
                byte a=list.get(0).byteValue();
                byte b=list.get(1).byteValue();
                System.out.println(a);
                System.out.println(b);
                if((a==1&&b==3)||(a==3&&b==1)) winchoice=1;
                else if(a>b) winchoice=a;
                else winchoice = b;
                int numOfWin = 0;
                int numOfLose = 0;
                for(int i = 0 ; i < players.size(); i++)
                   if(players.get(i).choose==winchoice)
                       numOfWin++;
                   else numOfLose++;
                for(int i = 0 ; i < players.size(); i++){
                    ClientObject temp = players.get(i);
                    //win
                    if(players.get(i).choose==winchoice)
                        temp.amount = temp.amount + numOfLose*30/numOfWin;
                    else
                        temp.amount -= 30;
                    playerDao.EditAmount(temp.amount, temp.id);
                    players.set(i, temp);
                }    
            }
            System.out.println(list.size()+"       "+winchoice);
            setEndgame();
        }   
        public  void chargeCard(ClientObject client){
            client.amount=client.amount+100;
            playerDao.EditAmount(client.amount, client.id);
            setDefaultChoice();
        }
    }
    
