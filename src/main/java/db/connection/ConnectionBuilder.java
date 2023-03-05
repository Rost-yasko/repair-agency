package db.connection;

import java.sql.Connection;

public interface ConnectionBuilder {
    Connection getConnection();
}
