/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Group;
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
public class GroupDAO {

    public static int create(Group group) {
        try {
            String sql = "INSERT INTO TB_GRUPO(descricao) VALUES (?)";

            Connection conexao = ConnectionFactory.obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, group.getDescription());

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

    public static ArrayList<Group> list() {

        ArrayList<Group> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_GRUPO";

        try {
            Connection conn = ConnectionFactory.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("descricao");
                Group group = new Group(id, description);
                lista.add(group);
            }

            return lista;
        } catch (Exception ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static boolean delete(Group group)
    {
        try {
            String sql = "DELETE FROM TB_GRUPO WHERE id = ?";

            Connection conexao = (new ConnectionFactory()).obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, group.getId());

            // 5 Executar o comando
            int result = ps.executeUpdate();

            // 6 Fechar a conexao
            ps.close();
            conexao.close();

            return result == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
