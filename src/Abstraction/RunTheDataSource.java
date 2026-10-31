package Abstraction;

public class RunTheDataSource {
    private final ConnectToDatabase connectToDatabase = new Sqlite();
    private final ConnectToDatabase connectToDatabasePostgresql = new PostgreSQL();
}
