/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

/**
 *
 * @author gusta
 */
public class PartidaDAO {
    String sql = "SELECT p.*, t.nome FROM TB_PARTIDA p JOIN TB_TIME t ON p.id_time1 = t.id";
}
