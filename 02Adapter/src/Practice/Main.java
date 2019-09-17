package Practice;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        FileIO f = new FileProperties();
        try {
            f.readFromFile("file.tet");
            f.setValue("year", "2004");
            f.setValue("month", "4");
            f.setValue("day", "21");
            f.writeToFile("newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
