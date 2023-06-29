/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author filipe
 */

/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC) 
 */

public class Turma {
    final String codigoTurma;  
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> alunos;
    private HashMap <String,Integer> frequenciaAlunos;
    private HashMap <String,Float> notaAlunos;
    

    public Turma(String codigoTurma, Disciplina disciplina) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
        this.frequenciaAlunos = new HashMap<>();
        this.notaAlunos = new HashMap<>();
      
    }
    
    
    public String getCodigoTurma() {
        return codigoTurma;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public String getCodigoDisciplinaCorresp() {
        return this.disciplina.getCodigoDisciplina();
    }
    
    
    public String getSiapeProfessor() {
        return professor.getSiape();
    }
    
    public void setProfessor(Professor professor) {
       this.professor = professor;
    }
     
    
    public void adicionarAluno(Aluno aluno) throws TurmaException {
        if (this.disciplina.getCodigoDisciplina() != null) {
            alunos.add(aluno);
        } else {
            throw new TurmaException("A turma não está vinculada a uma disciplina.");
        }
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
    
    public void imprimeTurma() {
        System.out.println("Codigo turma: "+this.codigoTurma);
        System.out.println("Codigo disciplina: "+this.disciplina.getCodigoDisciplina());
        if(this.professor!=null){
            System.out.println("SIAPE professor: "+this.professor.getSiape());
        }
        else
        {
            System.out.println("Professor nao cadastrado!");
        }
    }
    public void imprimirListaAlunos() {
        System.out.println("Lista de Alunos da Disciplina "+ this.disciplina.getCodigoDisciplina() +" Turma " + this.codigoTurma);

        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matrícula: " + aluno.getMatricula());
        }
    }
    
    public void imprimirProf() {
        System.out.println("Professor da Disciplina "+ this.disciplina.getCodigoDisciplina() +" Turma " + this.codigoTurma);
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Matrícula: " + professor.getSiape());
    }
}
