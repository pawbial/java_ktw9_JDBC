package employees.basic;

import java.sql.*;

public class BasicSelectWithResources {

    static final String user = "sda";
    static final String password = "JavaKat_9";
    static final String connString = "jdbc:mysql://localhost/employees";
    static final String query = "SELECT first_name, last_name FROM employees LIMIT 10";

    public static void main(String[] args) throws SQLException {
        try(Connection conn = DriverManager.getConnection(connString, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        }
    }
}
