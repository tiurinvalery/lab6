package database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.HibernateUtil;

public class ManageCompany {

    public Integer addCompany(String compN, Integer tof0){
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();

        Transaction tx =null;
        Integer companyID = null;
        try {
            tx = session.beginTransaction();
            TypeOfCompany tof1 = session.get(TypeOfCompany.class, tof0);
            Company company = new Company(compN,tof1);
            companyID = (Integer)session.save(company);
            tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if(tx!=null) tx.rollback();
        } finally {
            session.close();
        }
        return companyID;
    }
    public void updateCompany(Integer comId, String comN) {
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            Company company = (Company)session.get(Company.class, comId);
            company.setCompanyName(comN);
            session.update(company);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null) tx.rollback();
            ex.printStackTrace();

        }
        finally {
            session.close();
        }
    }
    public void deleteCompany(Integer ID) {
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Company company = (Company) session.get(Company.class, ID);
            session.delete(company);
            tx.commit();
        } catch (HibernateException he) {
            if(tx!=null) tx.rollback();
            he.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}

