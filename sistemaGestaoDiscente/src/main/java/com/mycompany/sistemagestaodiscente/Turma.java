/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

/**
 *
 * @author filipe
 */
public class Turma extends Disciplina {
    private int siapeProfessor;
    private float notaAlunos[];

    public Turma(String codigoDisciplina, String nomeDisciplina, int siapeProfessor, float notaAlunos[]) {
        super(codigoDisciplina, nomeDisciplina);
        this.siapeProfessor = siapeProfessor;
        this.notaAlunos = notaAlunos;
    }

    /**
     * @return the siapeProfessor
     */
    public int getSiapeProfessor() {
        return siapeProfessor;
    }

    /**
     * @return the notaAlunos
     */
    public float[] getNotaAlunos() {
        return notaAlunos;
    }

    /**
     * @param notaAlunos the notaAlunos to set
     */
    public void setNotaAlunos(float[] notaAlunos) {
        this.notaAlunos = notaAlunos;
    }

}
