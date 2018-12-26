package employees.basic;

import employees.common.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Injection {

    static final String queryTemplate = "SELECT * FROM employees WHERE emp_no=";

    public static void main(String[] args) throws SQLException {
        queryEmp("10000");
        queryEmp("10000; DROP TABLE dept_manager;");
    }

    public static void queryEmp(String emp_no) throws SQLException {
        try(Connection conn = ConnectionFactory.getConnection()) {
            Statement stmt = conn.createStatement();
            System.out.println(queryTemplate + emp_no);
            stmt.execute(queryTemplate + emp_no);

        }
    }
}
