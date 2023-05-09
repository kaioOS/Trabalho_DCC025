/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.HashMap;

/**
 *
 * @author filipe
 */
public class Turma extends Disciplina {
    private int siapeProfessor;    
    private HashMap <String,Integer> frequenciaAlunos = new HashMap<>();
    private HashMap <String,Float> notaAlunos = new HashMap<>();
    

    public Turma(String codigoDisciplina, String nomeDisciplina, int siapeProfessor, HashMap notaAlunos) {
        super(codigoDisciplina, nomeDisciplina);
        this.siapeProfessor = siapeProfessor;
      
    }
    

    public int getSiapeProfessor() {
        return siapeProfessor;
    }

    
    public int getFrequenciaAluno(String matricula){
        if(this.frequenciaAlunos.isEmpty())
            return -1;
        return this.frequenciaAlunos.get(matricula);
    }
    
    
    //atualiza frequencia do aluno
    public void setFrequenciaAluno(String matricula, boolean presenca){
        if(this.frequenciaAlunos.containsKey(matricula)){
            if(presenca)
                this.frequenciaAlunos.put(matricula, this.frequenciaAlunos.get(matricula)+1);
                
        }else{
            if(presenca)
                this.frequenciaAlunos.put(matricula, 1);
            else
                this.frequenciaAlunos.put(matricula, 0);
        }
    }

    public float getNotaAlunos(String matricula) {
        if(this.notaAlunos.isEmpty())
            return -1;
        
        return this.notaAlunos.get(matricula);
    }

    //atualiza nota do aluno
    public void setNotaAlunos(String matricula, float notaAluno) {
        if(this.notaAlunos.containsKey(matricula)){
            this.notaAlunos.put(matricula, this.notaAlunos.get(matricula)+notaAluno);
        }else{
            this.notaAlunos.put(matricula, notaAluno);
        }
        
    }

}
