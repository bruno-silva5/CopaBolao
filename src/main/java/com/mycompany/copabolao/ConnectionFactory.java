
package com.mycompany.copabolao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {    
    private String usuario = "root";
    private String senha = "vintage";
    private String host = "localhost";
    private String porta = "3306";
    private String db = "usjt";    
    
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
