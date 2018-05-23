import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(DataProviderRunner.class)
public class DBTesterTests {

    private DBTester sut;

    @Before
    public void setUp(){
        this.sut = new DBTester();
    }

    @DataProvider
    public static Object[][] dataProviderExecute() {
        return new Object[][] {
                { "sampleleveldb.zip", "9999999990007", "9999999990007^1", "true" },
                { "sampleleveldb.zip", "9999999990007", "thisisanincorrectvalue", "false" },
                { "sampleleveldb.zip", "thisisakeythatdoesnotexist", "thisisanincorrectvalue", "key_not_found" },
                { "thisdbdoesnotexist.zip", "9999999990007", "9999999990007^1", "db_not_found" },
        };
    }


    @Test
    @UseDataProvider("dataProviderExecute")
    public void test_execute(String dbPath, String key, String value, String expected) throws IOException {
        String[] params = {dbPath, key, value};
        String actual = this.sut.execute(params);
        Assert.assertEquals(expected, actual);
    }

}
