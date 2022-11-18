/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Time;
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
public class TimeDAO {

    public static int create(Time time) {
        try {
            String sql = "INSERT INTO TB_TIME(nome, id_grupo) VALUES (?, ?)";

            Connection conexao = (new ConnectionFactory()).obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, time.getNome());

            if (time.getGroup() != null) {
                ps.setInt(2, time.getGroup().getId());
            } else {
                ps.setNull(2, 0);
            }

            // 5 Executar o comando
            int result = ps.executeUpdate();

            // 6 Fechar a conexao
            ps.close();
            conexao.close();
            System.out.println(result);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static ArrayList<Time> list() {

        ArrayList<Time> lista = new ArrayList<>();
        String sql = "SELECT t.*, g.descricao FROM TB_TIME t JOIN TB_GRUPO g ON t.id_grupo = g.id";

        try {
            Connection conn = ConnectionFactory.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                int id = rs.getInt("id");
                int id_grupo = rs.getInt("id_grupo");
                String nome = rs.getString("nome");
                String grupoDescricao = rs.getString("descricao");
                Time time = new Time(id, id_grupo, nome, grupoDescricao);
                lista.add(time);
            }
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static boolean delete(Time time)
    {
        try {
            String sql = "DELETE FROM TB_TIME WHERE id = ?";

            Connection conexao = (new ConnectionFactory()).obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, time.getId());

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
