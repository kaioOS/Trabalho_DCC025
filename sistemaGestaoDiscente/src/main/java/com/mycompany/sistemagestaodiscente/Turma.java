/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author filipe
 */
public class Turma extends Disciplina {
    private int siapeProfessor;    
    private String matriculaAlunos[];
    private float notaAlunos[];

    public Turma(String codigoDisciplina, String nomeDisciplina, int siapeProfessor, float notaAlunos[]) {
        super(codigoDisciplina, nomeDisciplina);
        this.siapeProfessor = siapeProfessor;
        this.notaAlunos = notaAlunos;
    }


    public int getSiapeProfessor() {
        return siapeProfessor;
    }


    public float[] getNotaAlunos() {
        return notaAlunos;
    }


    public void setNotaAlunos(float[] notaAlunos) {
        this.notaAlunos = notaAlunos;
    }

}
