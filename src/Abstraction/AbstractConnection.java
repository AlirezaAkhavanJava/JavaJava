package Abstraction;

import javax.sql.DataSource;

public abstract class AbstractConnection implements ConnectToDatabase {
    @Override
    public void check() {

    }

    @Override
    public DataSource data() {
        return null;
    }
}
