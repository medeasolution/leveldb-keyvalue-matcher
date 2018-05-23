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
        new File("unzipped").mkdirs();
        String value;
        try{
            unzipper.unzip(Paths.get(zipPath), Paths.get("unzipped"));
            value = dbReader.readValueFromDB("unzipped/evcs.db", key);
        }catch(Exception e){
            return "db_not_found";
        }finally {
            FileUtils.deleteDirectory(new File("unzipped"));
        }
        if(value==null){
            return "key_not_found";
        }
        if(value.equals(expectedValue)){
            return "true";
        }else{
            return "false";
        }
    }
}
