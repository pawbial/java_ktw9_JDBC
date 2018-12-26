package employees.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/employees?serverTimezone=UTC&allowMultiQueries=true",
                "root",
                "***");
    }
}
