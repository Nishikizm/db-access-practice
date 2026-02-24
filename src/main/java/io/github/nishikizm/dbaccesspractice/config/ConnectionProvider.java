package io.github.nishikizm.dbaccesspractice.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionProvider {
    private static final Dotenv DOTENV = Dotenv.load();
    private static final String HOST = DOTENV.get("DB_HOST");
    private static final String PORT = DOTENV.get("DB_PORT");
    private static final String NAME = DOTENV.get("DB_NAME");
    private static final String USER = DOTENV.get("DB_USER");
    private static final String PASSWORD = DOTENV.get("DB_PASSWORD");
    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + NAME; 

    public static Connection connectionGet() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
