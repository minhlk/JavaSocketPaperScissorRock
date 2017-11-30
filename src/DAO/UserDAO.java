/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import Util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HK
 */
public class UserDAO {
    
    
    
    public User Login(User user){
        Query query= NewHibernateUtil.getSessionFactory().openSession().
        createQuery("from User where userName=:userName and password=:password");
        query.setParameter("userName", user.getUserName());
        query.setParameter("password", user.getPassword());
        User rs = (User) query.uniqueResult();
       
       return rs;
    }
    
      public boolean AddUser(User user){
          Session session = NewHibernateUtil.getSessionFactory().openSession();
          Transaction tx = null;
        try{
        tx = session.beginTransaction();
//        User temp = new User();
        session.save(user);
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
      
}
