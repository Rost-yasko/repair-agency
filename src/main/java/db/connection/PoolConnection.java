package db.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnection implements ConnectionBuilder {
    private final BasicDataSource ds = new BasicDataSource();

    public PoolConnection() {
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/repair_agency");
        ds.setUsername("postgres");
        ds.setPassword("admin");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    @Override
    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to the DB",e);
        }
    }


}
