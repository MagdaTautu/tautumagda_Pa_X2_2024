package homework;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Clasa Database se ocupă de gestionarea conexiunii la baza de date.
 */
public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static HikariDataSource dataSource;

    /**
     * Constructor pentru clasa Database.
     */
    public Database() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        dataSource = new HikariDataSource(config);
    }

    /**
     * Returnează o conexiune la baza de date.
     *
     * @return Conexiunea la baza de date.
     * @throws SQLException Dacă apare o excepție legată de baza de date.
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
