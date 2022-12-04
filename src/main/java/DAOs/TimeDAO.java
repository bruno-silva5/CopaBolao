/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Time;
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

    private String error;

    public int create(Time time) {
        try {
            Connection conexao = ConnectionFactory.obterConexao();

            if (isTeamsLimitAchieved(conexao) >= 32) {
                error = "Limite máximo de times cadastrado!";
                return 0;
            }

            String sql = "INSERT INTO tb_time(nome, id_grupo) VALUES (?, ?)";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, time.getNome());

            // Verifica se o time pertence a um grupo ou nao
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
            error = "Desculpe, houve um erro interno ao cadastrar o time.";
            e.printStackTrace();
            return 0;
        }
    }

    public static int createOfficialTeams() {
        try {
            Connection conexao = ConnectionFactory.obterConexao();
            
            // Deleta todos os times cadastrados
            String sql = "DELETE FROM tb_time;";
            PreparedStatement ps = conexao.prepareStatement(sql);
            int result = ps.executeUpdate();
            
            // Zera as chaves estrangeiras
            sql = "ALTER TABLE tb_time AUTO_INCREMENT = 1;";
            ps = conexao.prepareStatement(sql);
            result = ps.executeUpdate();
            
            sql = "INSERT INTO tb_time (nome, id_grupo) VALUES \n"
                    + "('QATAR', 1),\n"
                    + "('EQUADOR', 1),\n"
                    + "('SENEGAL', 1),\n"
                    + "('HOLANDA', 1),\n"
                    + "-- GRUPO A\n"
                    + "('INGLATERRA', 2),\n"
                    + "('IRAN', 2),\n"
                    + "('ESTADOS UNIDOS', 2),\n"
                    + "('PAÍS DE GALES', 2),\n"
                    + "-- GRUPO B\n"
                    + "('ARGENTINA', 3),\n"
                    + "('ARABIA SAUDITA', 3),\n"
                    + "('MEXICO', 3),\n"
                    + "('POLÔNIA', 3),\n"
                    + "-- GRUPO C\n"
                    + "('FRANÇA', 4),\n"
                    + "('AUSTRALIA', 4),\n"
                    + "('DINAMARCA', 4),\n"
                    + "('TUNISIA', 4),\n"
                    + "-- GRUPO D\n"
                    + "('ESPANHA', 5),\n"
                    + "('COSTA RICA', 5),\n"
                    + "('ALEMANHA', 5),\n"
                    + "('JAPÃO', 5),\n"
                    + "-- GRUPO E\n"
                    + "('BELGICA', 6),\n"
                    + "('CANADA', 6),\n"
                    + "('MARROCOS', 6),\n"
                    + "('CROACIA', 6),\n"
                    + "-- GRUPO F\n"
                    + "('BRASIL', 7),\n"
                    + "('SERVIA', 7),\n"
                    + "('SUIÇA', 7),\n"
                    + "('CAMARÕES', 7),\n"
                    + "-- GRUPO G\n"
                    + "('PORTUGAL', 8),\n"
                    + "('GANA', 8),\n"
                    + "('URUGUAI', 8),\n"
                    + "('COREIA DO SUL', 8);\n"
                    + "-- GRUPO H";

            ps = conexao.prepareStatement(sql);
            result = ps.executeUpdate();

            ps.close();
            conexao.close();

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int isTeamsLimitAchieved(Connection conexao) {
        try {
            String sql = "SELECT COUNT(id) count_times FROM tb_time";
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            rs.next();
            int result = rs.getInt("count_times");

            ps.close();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static ArrayList<Time> list() {

        ArrayList<Time> lista = new ArrayList<>();
        String sql = "SELECT t.*, g.descricao FROM tb_time t JOIN tb_grupo g ON t.id_grupo = g.id";

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

    public static boolean delete(Time time) {
        try {
            String sql = "DELETE FROM tb_time WHERE id = ?";

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
