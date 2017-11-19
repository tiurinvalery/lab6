import database.Worker;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class WorkerGetSetTest {
    @Test
    public void testWorkerGetSet(){
        Worker execute = new Worker(1,null,null,10,"100","200");
        Worker test = new Worker();
        test.setWorkerId(1);
        test.setCompany(null);
        test.setDirectory(null);
        test.setWorkerAge(10);
        test.setWorkerName("100");
        test.setWorkerPosition("200");
        assertTrue(test.equals(execute));
    }

}
