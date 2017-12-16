/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Player;
import Util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HK
 */
public class PlayerDAO {
    
    
    public void EditAmount(long newAmount,long Id){
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();	
        Player s = (Player) session.get(Player.class, Id);
        s.setAmount(newAmount);
        session.update(s);
        session.getTransaction().commit();
        session.close();
        
    }
    public Player Login(Player player){
        Query query= NewHibernateUtil.getSessionFactory().openSession().
        createQuery("from Player where playerName=:playerName and password=:password");
        query.setParameter("playerName", player.getPlayerName());
        query.setParameter("password", player.getPassword());
        Player rs = (Player) query.uniqueResult();
        return rs;
    }
    
      public boolean AddPlayer(Player player){
          Session session = NewHibernateUtil.getSessionFactory().openSession();
          Transaction tx = null;
        try{
        tx = session.beginTransaction();
        session.save(player);
        tx.commit();
        }
        catch(HibernateException e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
             return false;
        }
        finally{
            session.close();
        }
    
       return true;
    }
      public Player uniquePlayername(String name){
          Query query= NewHibernateUtil.getSessionFactory().openSession().
        createQuery("from Player where playerName=:playerName");
        query.setParameter("playerName", name);
        Player rs = (Player) query.uniqueResult();
        return rs;
      }
      
}
