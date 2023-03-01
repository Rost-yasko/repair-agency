package db.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionBuilder {
    Connection getConnection() throws SQLException, ClassNotFoundException, IOException;
}
