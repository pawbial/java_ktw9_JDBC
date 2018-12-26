package employees.basic;

import java.sql.*;

public class BasicTransaction {

    static final String user = "sda";
    static final String password = "JavaKat_9";
    static final String connString = "jdbc:mysql://localhost/employees";
    static final String addEmployeeInsert = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?)";
    static final String addSalaryInsert = "INSERT INTO salaries VALUES (?, ?, ?, ?)";

    public static void main(String[] args) throws SQLException {
        PreparedStatement addEmployeeStmt = null;
        PreparedStatement addSalaryStmt = null;
        //Connection conn = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connString, user, password);
            conn.setAutoCommit(false);
            addEmployeeStmt = conn.prepareStatement(addEmployeeInsert);
            addSalaryStmt = conn.prepareStatement(addSalaryInsert);

            addEmployeeStmt.setInt(1, 1000000);
            addEmployeeStmt.setString(2,"1988-06-22");
            addEmployeeStmt.setString(3, "Konrad");
            addEmployeeStmt.setString(4, "Jałowiecki");
            addEmployeeStmt.setString(5, "M");
            addEmployeeStmt.setString(6, "2018-12-15");

            addEmployeeStmt.executeUpdate();

            addSalaryStmt.setInt(1, 1000000);
            addSalaryStmt.setInt(2, 5000);
            addSalaryStmt.setString(3, "2018-12-15");
            addSalaryStmt.setString(4, "9999-01-01");

            addSalaryStmt.executeUpdate();

            conn.commit();

        } catch(SQLException e) {
            e.printStackTrace();
            if ( conn != null) {
                try {
                    conn.rollback();
                } catch(SQLException e2) { }
            }
        } finally {
            if (addSalaryStmt != null) {
                addSalaryStmt.close();
            }

            if (addEmployeeStmt != null) {
                addEmployeeStmt.close();
            }

            if( conn != null) {
                conn.close();
            }
        }
    }
}
