package employees.basic;

import employees.common.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exercise5 {

    final static String query = "SELECT emp_no, first_name FROM employees " +
            "WHERE last_name = ?";

    public static void main(String[] args) throws SQLException {
        printEmployees("Maliniak");
    }

    static void printEmployees(String lastName) throws SQLException {
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, lastName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("emp_no") + " " +
                        rs.getString("first_name"));
            }
            rs.close();
        }
    }
}
