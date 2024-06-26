package db;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;
    public static Connection getConnection(){
        if (conn == null){
            try {
            Properties props = loadProperties();
            String url = props.getProperty("dburl");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cousejdbc" , "root","23056623");
            }catch (SQLException | ClassNotFoundException e){
                throw new DBException(e.getMessage());
            }
        }return conn;
    }
    public static void closeConnection(){
        try {
        if (conn != null){
            conn.close();
          }
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }

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
