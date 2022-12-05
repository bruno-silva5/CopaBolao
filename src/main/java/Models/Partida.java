/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author bruno
 */
public class Partida {

    private int id, id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, id_fase;
    private Date dt_partida;
    String nomeTime1;
    String nomeTime2;


    public Partida(int id, int id_time1, int id_time2, int qtd_gols_time1, int qtd_gols_time2, int id_fase, Date dt_partida, String nomeTime1, String nomeTime2) {
        this.id = id;
        this.id_time1 = id_time1;
        this.id_time2 = id_time2;
        this.qtd_gols_time1 = qtd_gols_time1;
        this.qtd_gols_time2 = qtd_gols_time2;
        this.id_fase = id_fase;
        this.dt_partida = dt_partida;
        this.nomeTime1 = nomeTime1;
        this.nomeTime2 = nomeTime2;
    }

    public String getNomeTime1() {
        return nomeTime1;
    }

    public void setNomeTime1(String nomeTime1) {
        this.nomeTime1 = nomeTime1;
    }

    public String getNomeTime2() {
        return nomeTime2;
    }

    public void setNomeTime2(String nomeTime2) {
        this.nomeTime2 = nomeTime2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_time1() {
        return id_time1;
    }

    public void setId_time1(int id_time1) {
        this.id_time1 = id_time1;
    }

    public int getId_time2() {
        return id_time2;
    }

    public void setId_time2(int id_time2) {
        this.id_time2 = id_time2;
    }

    public int getQtd_gols_time1() {
        return qtd_gols_time1;
    }

    public void setQtd_gols_time1(int qtd_gols_time1) {
        this.qtd_gols_time1 = qtd_gols_time1;
    }

    public int getQtd_gols_time2() {
        return qtd_gols_time2;
    }

    public void setQtd_gols_time2(int qtd_gols_time2) {
        this.qtd_gols_time2 = qtd_gols_time2;
    }

    public int getId_fase() {
        return id_fase;
    }

    public void setId_fase(int id_fase) {
        this.id_fase = id_fase;
    }

    public Date getDt_partida() {
        return dt_partida;
    }

    public void setDt_partida(Date dt_partida) {
        this.dt_partida = dt_partida;
    }

}
