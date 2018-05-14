import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;
import static org.fusesource.leveldbjni.JniDBFactory.*;

import java.io.File;
import java.io.IOException;

public class DbReader {
    public String readValueFromDB(String dbPath, String key) throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = factory.open(new File(dbPath), options);
        String value;
        try {
            value = asString(db.get(bytes(key)));
        } finally {
            // Make sure you close the db to shutdown the
            // database and avoid resource leaks.
            db.close();
        }
        return value;
    }
}
