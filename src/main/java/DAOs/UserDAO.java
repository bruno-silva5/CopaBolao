/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.User;
import com.mycompany.copabolao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author bruno
 */
public class UserDAO {

    public static boolean auth(User user) {
        try {
            String sql = "SELECT * FROM TB_USER where email like ? and senha like ?";

            Connection conexao = ConnectionFactory.obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getSenha());

            boolean result = false;
            try (ResultSet rs = ps.executeQuery()) {
                result = rs.next();
            }
            
            ps.close();
            conexao.close();
            
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
