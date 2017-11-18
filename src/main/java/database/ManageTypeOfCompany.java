package database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.HibernateUtil;

public class ManageTypeOfCompany {
    public Integer addTypeOfCOmpany(String t) {
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        Transaction tx = null;
        Integer tofID = null;
        try {
            tx=session.beginTransaction();
            TypeOfCompany tof = new TypeOfCompany(t);
            tofID = (Integer) session.save(tof);
            tx.commit();

        } catch (HibernateException he) {
            if(tx!=null) tx.rollback();;
            he.printStackTrace();
        } finally {
            session.close();
        }
        return tofID;
    }
    public void updateType(Integer tId, String newType) {
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            TypeOfCompany tof = (TypeOfCompany) session.get(TypeOfCompany.class,tId);
            tof.setType(newType);
            session.update(tof);
            tx.commit();
        } catch (HibernateException he) {
            if(tx!=null) tx.rollback();
            he.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void deleteType(Integer id) {
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            TypeOfCompany tof = (TypeOfCompany) session.get(TypeOfCompany.class,id);
            session.delete(tof);
            tx.commit();
        } catch (HibernateException he) {
            if(tx!=null) tx.rollback();
            he.printStackTrace();
        } finally {
            session.close();
        }
    }
}
