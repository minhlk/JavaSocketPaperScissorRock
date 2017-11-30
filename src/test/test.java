/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

//import net.sf.ehcache.hibernate.HibernateUtil;
//
//import Model.Card;
import Model.Card;
import Model.Deposit;
import Model.User;
//import Model.User;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author HK
 */
public class test {
    
    
    
    
    
    public static void main(String[] args){
        NewHibernateUtil util = new NewHibernateUtil();
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = ss.beginTransaction();
//        Query q = ss.createQuery("from Deposit");
        List<User> des = ss.createCriteria(User.class).list();
            
        
        tx.commit();
        ss.close();
//        List<Deposit> users = (List<Deposit>)q.list();
        for(User de : des){
            System.out.println(de.getUserName());
        }
//        ss.close();
    }
    
}
