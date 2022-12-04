/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.User;
import CopaBolao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author bruno
 */
public class UserDAO {

    public static User auth(User user) {
        try {
            String sql = "SELECT * FROM tb_user where email like ? and senha like ?";

            Connection conexao = ConnectionFactory.obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getSenha());

            boolean result = false;
            
            try (ResultSet rs = ps.executeQuery()) {
                result = rs.next();
                if (result) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    double saldo = rs.getDouble("saldo");
                    int nivelAcesso = rs.getInt("id_nivelAcesso");

                    user.setId(id);
                    user.setId_nivelAcesso(nivelAcesso);
                    user.setSaldo(saldo);
                    user.setNome(nome);
                    user.setAuthenticated(true);
                }
            }

            ps.close();
            conexao.close();
            
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
