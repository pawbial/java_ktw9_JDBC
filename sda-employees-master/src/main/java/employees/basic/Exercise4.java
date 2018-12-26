package employees.basic;

import employees.common.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exercise4 {
    final static String query = "SELECT e.first_name, e.last_name FROM employees AS e " +
            "INNER JOIN dept_manager AS dm ON e.emp_no=dm.emp_no " +
            "INNER JOIN departments AS d ON dm.dept_no=d.dept_no " +
            "WHERE d.dept_name= ? AND dm.to_date=\"9999-01-01\"";

    public static void main(String[] args) throws SQLException {
        System.out.println(findCurrentManager("Marketing"));
    }

    public static String findCurrentManager(String deptName) throws SQLException {
        try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
            String result;
            ps.setString(1, deptName);
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getString("first_name") + " " +
                    rs.getString("last_name");
            rs.close();
            return result;
        }
    }
}
