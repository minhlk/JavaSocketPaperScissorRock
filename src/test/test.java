/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

//import net.sf.ehcache.hibernate.HibernateUtil;
//
//import Model.Card;
import DAO.UserDAO;
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
        UserDAO dao = new UserDAO();
        dao.EditAmount(100, 2);
    }
    
}
