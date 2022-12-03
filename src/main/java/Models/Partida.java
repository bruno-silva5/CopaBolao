/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author gusta
 */
public class Partida {
    int id_time1, id_time2, qtd_gols_time1, qtd_gols_time2;
    String dt_partida;

    public Partida(int id_time1,int  id_time2,int  qtd_gols_time1,int  qtd_gols_time2,String dt_partida, String Nome_time1, String Nome_time2) {
        this.id_time1 = id_time1;
        this.id_time2 = id_time2;
        this.dt_partida = dt_partida;
        this.qtd_gols_time1 = qtd_gols_time1;
        this.qtd_gols_time2 = qtd_gols_time2;
    }
     public String getdt_partida() {
        return dt_partida;
    }

    public void setdt_partida(String dt_partida) {
        this.dt_partida =dt_partida;
    }

 
    public int getId_time1() {
        return id_time1;
    }

    public void setId_time1(int  id_time1) {
        this.id_time1 = id_time1;
    }
    public int getId_time2() {
        return id_time2;
    }

    public void setId_time2(int id_time2) {
        this.id_time2 = id_time2;
    }
     public int getqtd_gols_time1() {
        return qtd_gols_time1;
    }

    public void setqtd_gols_time1(int qtd_gols_time1) {
        this.qtd_gols_time1 = qtd_gols_time1;
    }
    public int getqtd_gols_time2() {
        return qtd_gols_time2;
    }

    public void setqtd_gols_time2(int qtd_gols_time2) {
        this.qtd_gols_time2 = qtd_gols_time2;
    }
    
}
