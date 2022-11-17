package CopaBolao;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {

    public static final Connection obterConexao() {
        try {

            Dotenv dotenv = Dotenv.configure().load();

            String usuario = dotenv.get("db_user");
            String senha = dotenv.get("db_password");
            String host = dotenv.get("db_host");
            String porta = dotenv.get("db_port");
            String db = dotenv.get("db_name");

            String stringConexao = String.format("jdbc:mysql://%s:%s/%s", host, porta, db);
            Connection conn = DriverManager.getConnection(stringConexao, usuario, senha);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
