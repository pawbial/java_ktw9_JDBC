package employees.basic;

import java.sql.*;

public class BasicSelect {

    static final String query = "SELECT first_name, last_name FROM employees LIMIT 10";
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/employees?serverTimezone=UTC",
                "root",
                "java");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
