/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Time;
import CopaBolao.ConnectionFactory;
import Models.Aposta;
import Models.Partida;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class ApostaDAO {

    private String error;

    public int create(Aposta aposta) {
        try {
            Connection conexao = ConnectionFactory.obterConexao();

            String sql = "INSERT INTO tb_aposta(valor, id_usuario, id_partida, id_time) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDouble(1, aposta.getValor());
            ps.setInt(2, aposta.getId_usuario());
            ps.setInt(3, aposta.getId_partida());
            ps.setInt(4, aposta.getId_time());

            // 5 Executar o comando
            int result = ps.executeUpdate();

            // 6 Fechar a conexao
            ps.close();
            conexao.close();
            System.out.println("Aposta foi criada? " + result);
            return result;

        } catch (Exception e) {
            error = "Desculpe, houve um erro interno ao criar a aposta";
            e.printStackTrace();
            return 0;
        }
    }

    public static int countPendingBets() {
        ArrayList<Time> lista = new ArrayList<>();
        String sql = "SELECT \n"
                + "	COUNT(tb_aposta.id) count_apostas \n"
                + "FROM tb_aposta\n"
                + "	JOIN tb_partida ON\n"
                + "		tb_aposta.id_partida = tb_partida.id\n"
                + "WHERE tb_partida.finished = 0";

        try {
            Connection conn = ConnectionFactory.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            rs.beforeFirst();
            rs.next();
            return rs.getInt("count_apostas");

        } catch (Exception ex) {
            Logger.getLogger(ApostaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    // Disponivel somente para o ADM, listar TODAS apostas
    public static ArrayList<Aposta> listBetsByTeam(Partida partida, int id_time) {
        ArrayList<Aposta> lista = new ArrayList<>();

        String sql = "SELECT \n"
                + "	A.id_usuario, \n"
                + "	A.valor, \n"
                + "     U.nome nome_usuario \n"
                + "FROM tb_aposta A\n"
                + "	join tb_user U on\n"
                + "		U.id = A.id_usuario\n"
                + "WHERE A.id_partida = ?\n"
                + "AND A.id_time = ?; \n";

        try {
            Connection conn = ConnectionFactory.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, partida.getId());
            ps.setInt(2, id_time);
            ResultSet rs = ps.executeQuery();

            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                double valor = rs.getDouble("valor");
                int idUsuario = rs.getInt("id_usuario");
                String nomeUsuario = rs.getString("nome_usuario");

                Aposta aposta = new Aposta(idUsuario, nomeUsuario, valor);
                lista.add(aposta);
            }
    
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(ApostaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Exclusiva do usuario, para listar as apostas somente dele
    public static ArrayList<Aposta> list(int IdUser) {

        ArrayList<Aposta> lista = new ArrayList<>();
        String sql = "SELECT \n"
                + "	A.id, \n"
                + "	A.id_usuario, \n"
                + "	A.id_partida, \n"
                + "	A.id_time, \n"
                + "	A.valor, \n"
                + "    T.nome nome_time_apostado, \n"
                + "    P.id id_partida,\n"
                + "    P.dt_partida,\n"
                + "    P.finished,\n"
                + "    T1.nome time1,\n"
                + "    T2.nome time2\n"
                + "FROM tb_aposta A\n"
                + "	join tb_time T on\n"
                + "		A.id_time = T.id\n"
                + "	join tb_partida P on\n"
                + "		P.id = A.id_partida\n"
                + "	join tb_time T1 on\n"
                + "		T1.id = P.id_time1\n"
                + "	join tb_time T2 on\n"
                + "		T2.id = P.id_time2\n"
                + "WHERE A.id_usuario = ?;";

        try {
            Connection conn = ConnectionFactory.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, IdUser);

            ResultSet rs = ps.executeQuery();

            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                int id = rs.getInt("id");
                double valor = rs.getDouble("valor");
                int id_usuario = rs.getInt("id_usuario");
                int id_partida = rs.getInt("id_partida");
                Date dt_partida = rs.getDate("dt_partida");
                int finished = rs.getInt("finished");
                int id_time = rs.getInt("id_time");
                String nomeTimeApostado = rs.getString("nome_time_apostado");
                String time1 = rs.getString("time1");
                String time2 = rs.getString("time2");

                Aposta aposta = new Aposta(id, id_usuario, id_time, id_partida, dt_partida, finished, valor, nomeTimeApostado, (time1 + " X " + time2));
                lista.add(aposta);
            }
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(ApostaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static boolean delete(Aposta aposta) {
        try {
            String sql = "DELETE FROM tb_aposta WHERE id = ?";

            Connection conexao = (new ConnectionFactory()).obterConexao();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, aposta.getId());

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
