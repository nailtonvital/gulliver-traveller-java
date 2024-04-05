package dao;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    private Connection connection;
    private String url;
    private String hostname;
    private String username;
    private String password;
    private String database;
    private int port;

    public DataSource() {
        try {
            DriverManager.registerDriver(
                    new OracleDriver());
            hostname = "oracle.fiap.com.br";
            port = 3000;
            username = "**seu usuario**";
            password = "**sua senha**";
            database = "**nome do seu SID**";
            url = STR."jdbc:oracle:thin:@\{hostname}:\{port}:\{database}";
            connection =
                    DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Conectado com sucesso");
            } else {
                System.out.println("Falhou na conexão");
            }
        } catch (Exception ex) {
            System.out.println(STR."Datasource ERRO: \{ex.getMessage()}");
        }
    }

    public Connection getConnection() {
        return connection;
    }


}