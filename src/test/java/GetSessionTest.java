import org.hibernate.Session;
import org.junit.Test;
import utill.HibernateUtil;

import static org.junit.Assert.assertTrue;
public class GetSessionTest {
    @Test
    public void getNotNullSessionTest(){
        Session session = HibernateUtil.buildSessionAnnotationFactory().openSession();
        assertTrue(session!=null && session.isOpen());
    }
}
