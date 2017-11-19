import database.Directory;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class DirectoryGetSetTest {
    @Test
    public void directoryGetSetTest() {
        Directory execute = new Directory(1,null,"1",null,null);
        Directory test = new Directory();
        test.setOffice(null);
        test.setCompany(null);
        test.setDirectoryName("1");
        test.setDirectoryId(1);
        test.setWorkerSet(null);
        assertTrue(test.equals(execute));
    }
}
