import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DBTesterTests {

    private DBTester sut;

    @Before
    public void setUp(){
        this.sut = new DBTester();
    }

    @Test
    public void test_execute() throws IOException {
        String[] params = {"evcs-eans.zip", "9999999990007", "9999999990007^1"};
        String actual = this.sut.execute(params);
        String expected = "true";
        Assert.assertEquals(expected, actual);
    }
}
