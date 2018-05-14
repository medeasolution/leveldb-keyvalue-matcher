import java.io.IOException;

public class Main {
    public static void main (String [ ] args) throws IOException {
        DBTester dbTester = new DBTester();
        System.out.println(dbTester.execute(args));
    }
}
