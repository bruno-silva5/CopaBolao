/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.copabolao;

import Views.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author bruno
 */
public class CopaBolao {

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
    
    void insertUserTest  () {
        try {
            //1. Especificar o comando SQL
            String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";

            //2. Abrir uma conexão com o MySQL
            ConnectionFactory conexaoFactory = new ConnectionFactory();
            Connection conexao  = conexaoFactory.obterConexao();

            //3. Pré compilar o comando
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, "Usuario");
            ps.setString(2, "12345");
            ps.setString(3, "userr@live.com");

            // 5 Executar o comando
            ps.execute();

            // 6 Fechar a conexao
            ps.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
