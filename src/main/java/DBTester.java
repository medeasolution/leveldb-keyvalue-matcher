import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class DBTester {
    public String execute (String [ ] args)  throws IOException {
        Unzipper unzipper = new Unzipper();
        DbReader dbReader = new DbReader();
        String zipPath = args[0];
        String key = args[1];
        String expectedValue = args[2];
        boolean unzipped = new File("unzipped").mkdirs();
        unzipper.unzip(Paths.get(zipPath), Paths.get("unzipped"));
        String value = dbReader.readValueFromDB("unzipped/evcs.db", key);
        FileUtils.deleteDirectory(new File("unzipped"));
        if(value.equals(expectedValue)){
            return "true";
        }else{
            return "false";
        }
    }
}
