import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SingletonDB {
    private static SingletonDB instance;
    private Connection connection;

    private SingletonDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/motoDb", "root", "qwe12345");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static SingletonDB getInstance() {
        if (instance == null) {
            instance = new SingletonDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}