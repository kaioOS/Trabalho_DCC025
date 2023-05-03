/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

/**
 *
 * @author filipe
 */
public class Disciplina{
    private String codigoTurma;
    private int siapeProfessor;
    private float notaAlunos[];
    
    
    
    public float listaNotaAluno(){
        return 0;
    }


    public String getCodigoTurma() {
        return codigoTurma;
    }


    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }


    public int getSiapeProfessor() {
        return siapeProfessor;
    }

  
    public void setSiapeProfessor(int siapeProfessor) {
        this.siapeProfessor = siapeProfessor;
    }

 
    public float[] getNotaAlunos() {
        return notaAlunos;
    }


    public void setNotaAlunos(float[] notaAlunos) {
        this.notaAlunos = notaAlunos;
    }
}
