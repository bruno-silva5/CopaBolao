/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Time;
import CopaBolao.ConnectionFactory;
import Models.Aposta;
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
            System.out.println(result);
            return result;

        } catch (Exception e) {
            error = "Desculpe, houve um erro interno ao cadastrar o time.";
            e.printStackTrace();
            return 0;
        }
    }

    // Disponivel somente para o ADM, listar TODAS apostas
    public static ArrayList<Time> list() {

        ArrayList<Time> lista = new ArrayList<>();
        String sql = "SELECT t.*FROM tb_time";

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
                int id_time = rs.getInt("id_time");
                String nomeTimeApostado = rs.getString("nome_time_apostado");
                String time1 = rs.getString("time1");
                String time2 = rs.getString("time2");
                
                Aposta aposta = new Aposta(id, id_usuario, id_time, id_partida, valor, nomeTimeApostado, (time1 + " X " + time2));
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
