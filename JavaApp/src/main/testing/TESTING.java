import com.example.sciencerec.User;
import com.example.sciencerec.databaseDAO;
import org.junit.Assert;
import org.junit.Test;

public class TESTING
{
    User u = new User();
    databaseDAO db = u.getDatabase();
    @Test
    public void connectUser()
    {
        Assert.assertEquals(db.connectUser("da","nu"), null);
        Assert.assertEquals(db.connectUser("",""), null);
    }

    @Test
    public void getPassword()
    {
        Assert.assertEquals(db.connectUser("andrei@yahoo.com","andrei").getDatabase().getPassword("andrei@yahoo.com"), "andrei");
    }

    @Test
    public void checkIfListExists()
    {
        Assert.assertEquals(db.checkIfListExists(1,1), true);
        Assert.assertEquals(db.checkIfListExists(1,0), false);
    }

    @Test
    public void checkIfProjectIsInList()
    {
        Assert.assertEquals(db.checkIfProjectIsInList(1,1), false);
        Assert.assertEquals(db.checkIfProjectIsInList(1,2), false);
    }

    @Test
    public void checkIfArticleExists()
    {
        Assert.assertEquals(db.checkIfArticleExists(1), false);
        Assert.assertEquals(db.checkIfArticleExists("title"), false);
    }
}
