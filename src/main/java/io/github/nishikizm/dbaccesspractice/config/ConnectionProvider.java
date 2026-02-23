package io.github.nishikizm.dbaccesspractice.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionProvider {
    private static final Dotenv DOTENV = Dotenv.load();
    private static final String host = DOTENV.get("DB_HOST");
    private static final String port = DOTENV.get("DB_PORT");
    private static final String name = DOTENV.get("DB_NAME");
    private static final String user = DOTENV.get("DB_USER");
    private static final String password = DOTENV.get("DB_PASSWORD");
    private static final String url = "jdbc:postgresql://" + host + ":" + port + "/" + name; 

    public static Connection connectionGet() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
