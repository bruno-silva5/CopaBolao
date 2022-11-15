/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author bruno
 */
public class User {
    private String id, nome, senha, email;
    private double saldo;
    private int id_nivelAcesso;

    public User(String nome, String senha, String email, int id_nivelAcesso) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.id_nivelAcesso = id_nivelAcesso;
    }

    public User(String email, String senha) {
        this.senha = senha;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getId_nivelAcesso() {
        return id_nivelAcesso;
    }

    public void setId_nivelAcesso(int id_nivelAcesso) {
        this.id_nivelAcesso = id_nivelAcesso;
    }
}
