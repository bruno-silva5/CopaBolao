/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author bruno
 */
public class Time {
    int id, id_grupo;
    String nome;
    Group group;
    String grupoDescricao;

    public Time(int id, int id_grupo, String nome, String grupoDescricao) {
        this.id = id;
        this.id_grupo = id_grupo;
        this.nome = nome;
        this.grupoDescricao = grupoDescricao;
    }
    
    public Time(String nome, Group group) {
        this.nome = nome;
        this.group = group;
    }
    
    public String getGrupoDescricao() {
        return grupoDescricao;
    }

    public void setGrupoDescricao(String grupoDescricao) {
        this.grupoDescricao = grupoDescricao;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
