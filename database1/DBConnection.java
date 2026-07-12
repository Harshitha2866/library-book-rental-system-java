package database1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() {

        try {

            Properties properties = new Properties();

            properties.load(new FileInputStream("config.properties"));

            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully!");

            return connection;

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }

    }

}