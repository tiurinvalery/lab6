package utill;

import java.io.File;
import java.sql.Statement;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.hql.internal.antlr.SqlStatementParser;

import javax.imageio.spi.ServiceRegistry;


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