package pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {

    private Database() { // new에서 인스턴스를 생성시키지 않기 위한 private 선언
    }

    public static Properties getProperties(String dbName){
        //데이터베이스 이름에서 Properties를 얻는다.

        String filename = dbName + ".txt";
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }
}
