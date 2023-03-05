package db.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class PoolConnection implements ConnectionBuilder {
    private final BasicDataSource ds = new BasicDataSource();

    public PoolConnection() {
        Properties property = new Properties();

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/application.properties");
            property.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Can't read properties file");
        }

        ds.setUrl(property.getProperty("db.url"));
        ds.setUsername(property.getProperty("db.login"));
        ds.setPassword(property.getProperty("db.password"));
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }
    @Override
    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to the DB");
        }
    }


}
