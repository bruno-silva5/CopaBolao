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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static double consultaSaldo(User usuario)
    {
        ArrayList<User> lista = new ArrayList<>();
        String sql = "SELECT u.saldo FROM tb_user u where u.id = ?";

        
        try {
            Connection conn = ConnectionFactory.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ResultSet rs = ps.executeQuery();

            rs.beforeFirst();
            rs.next();
    
            return rs.getDouble("saldo");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public static int atualizarSaldo(User usuario, double novoSaldo) 
    {
        try {
            String sql = "UPDATE tb_user SET saldo = ? WHERE tb_user.id = ?";

            Connection conexao = (new ConnectionFactory()).obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDouble(1, novoSaldo);
            ps.setInt(2, usuario.getId());

            // 5 Executar o comando
            int result = ps.executeUpdate();

            // 6 Fechar a conexao
            ps.close();
            conexao.close();

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static int aumentarSaldo(int id_usuario, double novoSaldo) 
    {
        try {
            String sql = "UPDATE tb_user SET saldo = saldo + ? WHERE tb_user.id = ?";

            Connection conexao = (new ConnectionFactory()).obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDouble(1, novoSaldo);
            ps.setInt(2, id_usuario);

            // 5 Executar o comando
            int result = ps.executeUpdate();

            // 6 Fechar a conexao
            ps.close();
            conexao.close();

            return result;

        } catch (Exception e) {
            System.out.println("Erro ao aumentar o saldo");
            e.printStackTrace();
            return 0;
        }
    }
 
    public static int countTotalUsers() {
        ArrayList<User> lista = new ArrayList<>();
        String sql = "SELECT \n"
                + "	COUNT(tb_user.id) count_users \n"
                + "FROM tb_user\n";

        try {
            Connection conn = ConnectionFactory.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            rs.beforeFirst();
            rs.next();
            return rs.getInt("count_users");

        } catch (Exception ex) {
            Logger.getLogger(ApostaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
