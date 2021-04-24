package ua.nure.danylenko.practice10;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    private static final String CONNECTION_URL_MYSQL =
            "jdbc:mysql://localhost:3306/testDB" +
                    "?user=testUser&password=testPass";

    private static final String CONNECTION_URL_DERBY =
            "jdbc:derby://localhost/testDB;create=true" +
                    ";user=testUser;password=testPass";

    public static void main(String[] args) throws SQLException {
        // MySQL
        Connection con =
                DriverManager.getConnection(CONNECTION_URL_MYSQL);
        System.out.println(con);

        // Derby
        Connection con2 =
                DriverManager.getConnection(CONNECTION_URL_DERBY);
        System.out.println(con2);
    }
}
