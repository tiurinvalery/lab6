import org.hibernate.Session;
import org.junit.Test;
import utill.HibernateUtil;

import static org.junit.Assert.assertTrue;
public class ShutdownSessionTest {
    @Test
    public void shutdownSessionTest(){
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        if(session.isOpen()){
            HibernateUtil.shutdown();
            assertTrue(!session.isOpen());
        }
    }
}
