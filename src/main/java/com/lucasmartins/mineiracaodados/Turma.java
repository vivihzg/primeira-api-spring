package com.lucasmartins.mineiracaodados;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    private int id;

    private String descricao;

    private String horasAula;

    private String curso;

    private String professor;

    public int getId(){
        return id;
    }
    public String getDescricao(){
        return descricao;
    }
    public String getHorasAula(){
        return horasAula;
    }
    public String getCurso(){
        return curso;
    }
    public String getProfessor(){
        return professor;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void getHorasAula(String horasAula){
        this.horasAula = horasAula;
    }
    public void getCurso(String curso){
        this.curso = curso;
    }
    public void getProfessor(String professor){
        this.professor = professor;
    }

}
