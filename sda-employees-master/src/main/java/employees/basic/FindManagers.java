package employees.basic;

import employees.common.ConnectionFactory;

import java.sql.*;

public class FindManagers {
    static final String query = "SELECT e.first_name, e.last_name FROM employees e , departments d , dept_manager dm WHERE e.emp_no = dm.emp_no AND dm.dept_no = d.dept_no AND d.dept_name = ?";

    public static void main(String[] args) throws SQLException {
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "development");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
        }
    }
}
