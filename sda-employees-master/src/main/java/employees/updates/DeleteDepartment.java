package employees.updates;

import employees.common.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDepartment {

    final static String deleteEmployeesStmt = "DELETE FROM employees " +
            "WHERE emp_no IN (SELECT e.emp_no FROM " +
            "employees e INNER JOIN dept_emp dm " +
            "ON e.emp_no = dm.emp_no INNER JOIN departments d " +
            "ON d.dept_no = dm.dept_no WHERE dept_name = ?)";
    final static String deleteDepartment = "DELETE FROM departments " +
            "WHERE dept_name = ?";

    public static void main(String[] args) throws SQLException {
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement psEmp = conn.prepareStatement(deleteEmployeesStmt);
            PreparedStatement psDept = conn.prepareStatement(deleteDepartment)) {
            psEmp.setString(1, "PR");
            psEmp.executeUpdate();
            psDept.setString(1, "PR");
            psDept.executeUpdate();
        }
    }
}
