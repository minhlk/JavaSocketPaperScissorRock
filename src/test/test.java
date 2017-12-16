package test;

import Model.Card;
import Model.Player;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;

public class test {
   
    public static void main(String[] args){
        
  Card car = (Card) NewHibernateUtil.getSessionFactory().openSession().get(Card.class,(long)1);
//        createQuery("from Card where Id=:playerName");
//        query.setParameter("playerName", "1");
//        List<Card> rs= query.list();
        
    }
}
