package employees.basic;

import employees.common.ConnectionFactory;
import employees.common.DataSourceFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayDepartments {

    public static void main(String[] args) throws SQLException {
        try(Connection conn = DataSourceFactory.getDataSource().getConnection();
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM departments");
            rs.next();
            System.out.println("Liczba departamentów: " + rs.getInt(1));
            rs.close();
        }
    }
}
