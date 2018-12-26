package employees.basic;

import employees.common.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 {

    final static String query = "SELECT e.first_name, e.last_name FROM employees AS e " +
            "INNER JOIN dept_manager AS dm ON e.emp_no=dm.emp_no " +
            "INNER JOIN departments AS d ON dm.dept_no=d.dept_no " +
            "WHERE d.dept_name= ? ";

    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        findManagers("marketing")
                .forEach(System.out::println);
    }

    static List<String> findManagers(String deptName) throws SQLException {
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, deptName);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> result = new ArrayList<>();
            while(rs.next()) {
                result.add(rs.getString(1) + " " +
                        rs.getString(2));

            }
            rs.close();
            return result;
        }
    }
}
