package employees.common;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {

    static final String url = "jdbc:mysql://localhost/employees";
    static final String user = "sda";
    static final String password = "JavaKat_9";

    public static DataSource getDataSource() {
        MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setUrl(url);
        return ds;
    }
}
