/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author caiol
 */

public class Partida {
    int id, id_time1,id_time2,id_fase,qtd_gols_time1 ,qtd_gols_time2;
    Date dataDaPartida;
    Fase fase;
    Time time1;
    Time time2;
    String faseDescricao;

    public Partida(int id,int id_time1,int id_time2, Date dataDaPartida,int id_fase, String faseDescricao,int qtd_gols_time1,int qtd_gols_time2) {
        this.id = id;
        this.id_time1 = id_time1;
        this.id_time2 = id_time2;
        this.dataDaPartida = dataDaPartida;
        this.id_fase = id_fase;
        this.faseDescricao = faseDescricao;
        this.qtd_gols_time1 = qtd_gols_time1;
        this.qtd_gols_time2 = qtd_gols_time2;
    }
    
    public Partida(int id, Date dataDaPartida, Time time1,Time time2,int qtd_gols_time1,int qtd_gols_time2,int id_fase) {
        
        this.id = id;
        this.dataDaPartida = dataDaPartida;
        this.time1 = time1;
        this.time2 = time2;
        this.qtd_gols_time1 = qtd_gols_time1;
        this.qtd_gols_time2 = qtd_gols_time2;
        this.id_fase = id_fase;
    }
    
    public String getFaseDescricao() {
        return faseDescricao;
    }

    public void setfaseDescricao(String faseDescricao) {
        this.faseDescricao = faseDescricao;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }
    
    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }
    
    
    public int getQtdGolsTimes1() {
        return qtd_gols_time1;
    }

    public void setQtdGolsTimes1(int qtd_gols_time1) {
        this.qtd_gols_time1 = qtd_gols_time1;
    }
    
    public int getQtdGolsTimes2() {
        return qtd_gols_time2;
    }

    public void setQtdGolsTimes2(int qtd_gols_time2) {
        this.qtd_gols_time2 = qtd_gols_time2;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Time1() {
        return id_time1;
    }

    public void setId_Time1(int id_time1) {
        this.id_time1 = id_time1;
    }

    public int getId_Time2() {
        return id_time2;
    }

    public void setId_Time2(int id_time2) {
        this.id_time2 = id_time2;
    }
    
    public int getId_Fase() {
        return id_fase;
    }

    public void setId_Fase(int id_fase) {
        this.id_fase = id_fase;
    }
    
    public Date getDataDaPartida() {
        return dataDaPartida;
    }

    public void setDataDaPartida(Date dataDaPartida) {
        this.dataDaPartida = dataDaPartida;
    }
}
