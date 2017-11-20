package utill;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory buildSessionAnnotationFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure().buildSessionFactory();
            sessionFactory =  configuration.configure().buildSessionFactory();
            return sessionFactory;
        }
        catch (HibernateException he) {
            System.err.println("Initial SessionFactory creation failed." + he);
            throw  new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}