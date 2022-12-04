/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author bruno
 */
public class Aposta {
    int id, id_usuario, id_time, id_partida;
    double valor;
    String nomeTimeApostado;
    String nomesTimesPartida;

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
    public Aposta(int id, int id_usuario, int id_time, int id_partida, double valor, String nomeTimeApostado, String nomesTimesPartida) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_time = id_time;
        this.id_partida = id_partida;
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
