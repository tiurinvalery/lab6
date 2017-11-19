package database;

import org.hibernate.Session;



import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.HibernateUtil;

import java.util.List;

public class Tasks {
    public static void create(Session session){
        Company company = new Company();
        company.setCompanyName("epam");
        TypeOfCompany tof = new TypeOfCompany();
        tof.setType("outsource");
        company.setTypeOfCompany(tof);
        Directory directory = new Directory();
        directory.setDirectoryName("webTeam");
        directory.setCompany(company);

        Office office = new Office();


        directory.setOffice(office);


        Country country  = new Country();
        country.setCountryName("Ukraine");
        office.setCountry(country);

        Worker worker = new Worker();
        worker.setCompany(company);
        worker.setDirectory(directory);
        worker.setWorkerAge(20);
        worker.setWorkerName("Pasha");
        worker.setWorkerPosition("Junior Java Developer");
        company.getDirSet().add(directory);
        company.getWorkerSet().add(worker);
        directory.getWorkerSet().add(worker);
        country.getOfficesInCountry().add(office);
        office.getDirInOffice().add(directory);
        tof.getCompSet().add(company);

        session.save(country);
        session.save(worker);
        session.save(tof);
        session.save(office);
        session.save(directory);
        session.save(company);


    }

   public static void delAll(Session session, List<?> objects) {
       for(Object o: objects) {
           session.delete(o);
       }
       objects.clear();
   }
    public static void dellCompany(Integer id,Session session) {
        Company nC = new Company(id);
        session.delete(session);
    }
    public static void dellCountry(Integer id,String name, Session session) {
        Country nC = new Country(id,name);

        session.delete(nC);
    }
    public static void createCompany(){
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        Transaction tx = null;
        tx=session.beginTransaction();
        Company company = new Company();
        company.setCompanyName("Netckrecker");
        TypeOfCompany tof = new TypeOfCompany();
        tof.setType("outsource");
        company.setTypeOfCompany(tof);

        tof.getCompSet().add(company);
        session.save(tof);
        session.save(company);
        tx.commit();
    }

    public static void save(Object o) {
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        session.save(o);
        tx.commit();
        session.close();
    }

}