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

            if (time.getId_grupo() > 0) {
                ps.setInt(2, time.getId_grupo());
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
        String sql = "SELECT * FROM TB_TIME";

        try {
            Connection conn = ConnectionFactory.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                int id_grupo = rs.getInt("id_grupo");
                String nome = rs.getString("nome");
                Time time = new Time(id_grupo, nome);
                lista.add(time);
            }
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
