package db;

import java.io.*;
import java.util.Properties;

public class DB {



    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch (IOException e){
            throw new DBException(e.getMessage());
        }
    }
}
