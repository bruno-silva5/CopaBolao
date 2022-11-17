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
    private int id;
    private String nome, senha, email;
    private double saldo;
    private int id_nivelAcesso;
    private boolean authenticated;

    public User(int id, String nome, String senha, String email, double saldo, int id_nivelAcesso) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.id_nivelAcesso = id_nivelAcesso;
        this.authenticated = false;
    }
    
    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public User(String email, String senha) {
        this.senha = senha;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
