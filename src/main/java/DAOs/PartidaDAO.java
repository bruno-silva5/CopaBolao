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

    public int create(Partida partida) {
        try {
            Connection conexao = ConnectionFactory.obterConexao();

            String sql = "INSERT INTO TB_PARTIDA(id_time1,id_time2,qtd_gols_time1,qtd_gols_time2,dt_partida,id_fase) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, partida.getId_Time1());
            ps.setInt(2, partida.getId_Time2());
            ps.setInt(3, partida.getQtdGolsTimes1());
            ps.setInt(4, partida.getQtdGolsTimes2());
            ps.setDate(5, partida.getDataDaPartida());

            int result = ps.executeUpdate();

            ps.close();
            conexao.close();
            System.out.println(result);
            return result;

        } catch (Exception e) {
            error = "Desculpe, houve um erro interno ao cadastrar a partida.";
            e.printStackTrace();
            return 0;
        }
    }

    public static ArrayList<Partida> list() {
        
        //LISTATUDO
        ArrayList<Partida> lista = new ArrayList<>();
        String sql = "SELECT \n" +
                        "TB_PARTIDA.id,\n" +
                        "TB_PARTIDA.id_time1,\n" +
                        "tm_1.nome,\n" +
                        "TB_PARTIDA.id_time2,\n" +
                        "tm_2.nome,\n" +
                        "TB_PARTIDA.qtd_gols_time1,\n" +
                        "TB_PARTIDA.qtd_gols_time2,\n" +
                        "TB_PARTIDA.dt_partida,\n" +
                        "TB_PARTIDA.id_fase,\n" +
                        "fs.descricao\n" +
                     "FROM TB_PARTIDA\n" +
                    "INNER JOIN TB_TIME as tm_1 ON tm_1.id = TB_PARTIDA.id_time1\n" +
                    "INNER JOIN TB_TIME as tm_2 ON tm_2.id = TB_PARTIDA.id_time2\n" +
                    "INNER JOIN TB_FASE as fs ON fs.id = TB_PARTIDA.id_fase\n" +
                    "where dt_partida>=CURDATE();";

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
                String faseDescricao = rs.getString("descricao");
                
                Partida partida = new Partida(id, id_time1, id_time2,  dt_partida, id_fase, faseDescricao,qtd_gols_time1, qtd_gols_time2);
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
            String sql = "DELETE FROM TB_PARTIDA WHERE id = ?";

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
