import org.hibernate.Session;
import org.junit.Test;
import utill.HibernateUtil;
import static junit.framework.TestCase.assertFalse;

public class ShutdownSessionTest {
    @Test
    public void shutdownSessionTest(){
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        if(session.isOpen()){
            HibernateUtil.shutdown();
            assertFalse(session.isOpen());
        }
    }
}
