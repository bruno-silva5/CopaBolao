package DAOs;

import Models.Partida;
import Models.Fase;
import CopaBolao.ConnectionFactory;
import Models.Time;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author caiol
 */
public class PartidaDAO {

    private String error;

    public static ArrayList<Partida> list() {

        //LISTATUDO
        ArrayList<Partida> lista = new ArrayList<>();
        String sql = "SELECT tb_partida.id,\n"
                + "       tb_partida.id_time1,\n"
                + "       tm_1.nome nome_time1,\n"
                + "       tb_partida.id_time2,\n"
                + "       tm_2.nome nome_time2,\n"
                + "       tb_partida.qtd_gols_time1,\n"
                + "       tb_partida.qtd_gols_time2,\n"
                + "       tb_partida.dt_partida,\n"
                + "       tb_partida.id_fase\n"
                + "FROM tb_partida\n"
                + "INNER JOIN tb_time AS tm_1 ON tm_1.id = tb_partida.id_time1\n"
                + "INNER JOIN tb_time AS tm_2 ON tm_2.id = tb_partida.id_time2;";

        try {
            Connection conn = ConnectionFactory.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            rs.beforeFirst();
            int contador = 0;

            //se for para passar os dados do join está incompleto
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_time1 = rs.getInt("id_time1");
                int id_time2 = rs.getInt("id_time2");
                int qtd_gols_time1 = rs.getInt("qtd_gols_time1");
                int qtd_gols_time2 = rs.getInt("qtd_gols_time2");
                Date dt_partida = rs.getDate("dt_partida");
                int id_fase = rs.getInt("id_fase");
                String nomeTime1 = rs.getString("nome_time1");
                String nomeTime2 = rs.getString("nome_time2");

                Partida partida = new Partida(id, id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, id_fase, dt_partida, nomeTime1, nomeTime2);
                lista.add(partida);
            }
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static boolean delete(Partida partida) {
        try {
            String sql = "DELETE FROM tb_partida WHERE id = ?";

            Connection conexao = (new ConnectionFactory()).obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, partida.getId());

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
