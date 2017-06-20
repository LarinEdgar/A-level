import java.sql.*;

/**
 * Created by Shleck on 6/20/2017.
 */
public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        addMySQLToClassPath();
        createDbUserTable();
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    private static void addMySQLToClassPath() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createDbUserTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS dbuser("
                + "USER_ID INT(5) NOT NULL, "
                + "USER_NAME VARCHAR(20) NOT NULL, "
                + "LAST_NAME VARCHAR(20) NOT NULL, "
                + "PRIMARY KEY (USER_ID) "
                + ")";
        try (Connection dbConnection = getConnection();
             Statement statement = dbConnection.createStatement()) {
            // ????????? SQL ??????
            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
