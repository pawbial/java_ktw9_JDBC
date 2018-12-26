package employees.updates;

import employees.common.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDepartment {

    final static String addDeptStmt = "INSERT INTO departments VALUES (?, ?)";
    final static String addEmpStmt = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?)";
    final static String connectDeptEmpStmt = "INSERT INTO dept_emp VALUES " +
            "(?, ?, ?, \"9999-01-01\")";
    final static String addDeptManager = "INSERT INTO dept_manager VALUES " +
            "(?, ?, ?, \"9999-01-01\")";

    public static void main(String[] args) throws SQLException {
        PreparedStatement psAddDept = null;
        PreparedStatement psAddEmp = null;
        PreparedStatement psConnectDeptEmp = null;
        PreparedStatement psAddManager = null;

        try(Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);

            psAddDept = conn.prepareStatement(addDeptStmt);
            psAddDept.setString(1, "d010");
            psAddDept.setString(2, "PR");
            psAddDept.executeUpdate();

            psAddEmp = conn.prepareStatement(addEmpStmt);
            psAddEmp.setString(6, "2018-12-15");

            // First employee
            psAddEmp.setInt(1, 2000000);
            psAddEmp.setString(2, "1990-03-07");
            psAddEmp.setString(3, "Karol");
            psAddEmp.setString(4, "Kowalski");
            psAddEmp.setString(5, "M");
            psAddEmp.executeUpdate();

            // Second employee
            psAddEmp.setInt(1, 2000001);
            psAddEmp.setString(2, "1991-04-13");
            psAddEmp.setString(3, "Magdalena");
            psAddEmp.setString(4, "Nowak");
            psAddEmp.setString(5, "F");
            psAddEmp.executeUpdate();

            // Connect employees and departments
            psConnectDeptEmp = conn.prepareStatement(connectDeptEmpStmt);
            psConnectDeptEmp.setString(2, "d010");
            psConnectDeptEmp.setString(3, "2018-12-15");

            psConnectDeptEmp.setInt(1, 2000000);
            psConnectDeptEmp.executeUpdate();

            psConnectDeptEmp.setInt(1, 2000001);
            psConnectDeptEmp.executeUpdate();

            // Add manager
            psAddManager = conn.prepareStatement(addDeptManager);
            psAddManager.setInt(1, 2000001);
            psAddManager.setString(2, "d010");
            psAddManager.setString(3, "2018-12-15");
            psAddManager.executeUpdate();

            conn.commit();
        }
    }
}
