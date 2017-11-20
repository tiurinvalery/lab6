package database;

import org.hibernate.Session;



import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.HibernateUtil;

import java.util.List;

public class Tasks {
    public static void delAll(List<?> objects) {
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        Transaction tx = session.beginTransaction();
       for(Object o: objects) {
           session.delete(o);
       }
       tx.commit();
       session.close();
       objects.clear();
   }

    public static void create(List<?> objects) {
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        Transaction tx = session.beginTransaction();
        for(Object o: objects) {
            session.save(o);
        }
        tx.commit();
        session.close();
    }

}