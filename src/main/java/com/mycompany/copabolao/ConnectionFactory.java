
package com.mycompany.copabolao;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory { 
    Dotenv dotenv = Dotenv.configure().load();
    
    private String usuario = dotenv.get("db_user");
    private String senha = dotenv.get("db_password");
    private String host = dotenv.get("db_host");
    private String porta = dotenv.get("db_port");
    private String db = dotenv.get("db_name");
    
    public Connection obterConexao() {
        try{
            String stringConexao = String.format("jdbc:mysql://%s:%s/%s", host, porta, db );
            Connection conn = DriverManager.getConnection(stringConexao, usuario, senha);
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }    
}
