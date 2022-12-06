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
public class Aposta {
    int id, id_usuario, id_time, id_partida, finished;
    double valor;
    String nomeUsuario;
    String nomeTimeApostado;
    String nomesTimesPartida;
    Date dt_partida;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public Date getDt_partida() {
        return dt_partida;
    }

    public void setDt_partida(Date dt_partida) {
        this.dt_partida = dt_partida;
    }

    public String getNomeTimeApostado() {
        return nomeTimeApostado;
    }

    public void setNomeTimeApostado(String nomeTimeApostado) {
        this.nomeTimeApostado = nomeTimeApostado;
    }

    public String getNomesTimesPartida() {
        return nomesTimesPartida;
    }

    public void setNomesTimesPartida(String nomesTimesPartida) {
        this.nomesTimesPartida = nomesTimesPartida;
    }

    // Usado para listagem, onde define todos os dados
    public Aposta(int id, int id_usuario, int id_time, int id_partida, Date dt_partida, int finished, double valor, String nomeTimeApostado, String nomesTimesPartida) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_time = id_time;
        this.id_partida = id_partida;
        this.dt_partida = dt_partida;
        this.finished = finished;
        this.valor = valor;
        this.nomeTimeApostado = nomeTimeApostado;
        this.nomesTimesPartida = nomesTimesPartida;
    }
    
    // Usado para criacao de uma aposta
    public Aposta(int id_usuario, int id_time, int id_partida, double valor) {
        this.id_usuario = id_usuario;
        this.id_time = id_time;
        this.id_partida = id_partida;
        this.valor = valor;
    }
    
    // Usado na listagem de apostas de uma partida
    public Aposta(int id_usuario, String nomeUsuario, double valor) {
        this.id_usuario = id_usuario;
        this.nomeUsuario = nomeUsuario;
        this.valor = valor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    public int getId_partida() {
        return id_partida;
    }

    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
