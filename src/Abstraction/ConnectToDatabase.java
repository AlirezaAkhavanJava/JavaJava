package Abstraction;

import javax.sql.DataSource;

public interface ConnectToDatabase {
    String createTable();

    void check();

    void persist();

    DataSource data();
}
