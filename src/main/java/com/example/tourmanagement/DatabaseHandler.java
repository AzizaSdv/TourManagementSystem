import java.sql.*;

public class DatabaseHandler {
    private static DatabaseHandler instance;
    private Connection connection;

    private DatabaseHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tour_management", "username", "password");
            System.out.println("Database connection established.");
            setupDatabase();
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public static DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                System.out.println("Reconnecting to database...");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tour_management", "username", "password");
            }
        } catch (SQLException e) {
            System.out.println("Failed to reconnect: " + e.getMessage());
        }
        return connection;
    }

    private void setupDatabase() {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS tours (id SERIAL PRIMARY KEY, name TEXT, location TEXT, price REAL, dates TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS guides (id SERIAL PRIMARY KEY, name TEXT, language TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS tour_guides (tour_id INTEGER REFERENCES tours(id), guide_id INTEGER REFERENCES guides(id), PRIMARY KEY (tour_id, guide_id))");
            System.out.println("Database setup completed.");
        } catch (SQLException e) {
            System.out.println("Failed to setup database: " + e.getMessage());
        }
    }
}
