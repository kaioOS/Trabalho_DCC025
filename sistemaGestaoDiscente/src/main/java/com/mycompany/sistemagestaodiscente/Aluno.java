/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author filipe
 */
/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC) 
 */

public class Aluno extends Usuario {
    private String matricula;
    private HashMap<Disciplina, Turma> turmasPorDisciplinaAluno;
    
     
    public Aluno(String nome,String CPF,String telefone, String email, String senha, int tipoUsuario, String matricula) throws UsuarioException{
        super(nome,CPF,telefone,email, senha,tipoUsuario);
        validarMatricula(matricula);
        this.matricula=matricula;
        this.turmasPorDisciplinaAluno = new HashMap<>();
    }
    
    public void consultaNotas(Turma turma) {        
        float nota = turma.getNotaAlunos(this.matricula);
        
        if (nota == -1) {
            System.out.println("Nota não encontrada.");
        } else {
            System.out.println("A nota do aluno com matrícula " + this.matricula + " na turma " + turma.getCodigoTurma() + " da disciplina "+ turma.getCodigoDisciplinaCorresp()+ " é: " + nota);
        }
    }
    
    public void consultaFrequencia(Turma turma){
        int frequencia = turma.getFrequenciaAluno(this.matricula);
        
        if (frequencia == -1) {
            System.out.println("Frequencia não encontrada.");
        } else {
            System.out.println("A frequencia do aluno com matrícula " + this.matricula + " na turma " + turma.getCodigoTurma() + " da disciplina "+ turma.getCodigoDisciplinaCorresp()+ " é: " + frequencia);
        }
        
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws UsuarioException {
        validarMatricula(matricula);
        this.matricula = matricula;
    }
    public void validarMatricula(String matricula) throws UsuarioException {
        if (matricula.length() < 15) {
            throw new UsuarioException("Matricula invalida!");
        }
        for (int i = 0; i < 15; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                throw new UsuarioException("Matricula invalida!");
            }
        }
        if (matricula.length() > 15) {
            for (int i = 15; i < matricula.length(); i++) {
                if (!Character.isLetter(matricula.charAt(i))) {
                    throw new UsuarioException("Matricula invalida!");
                }
            }
        }
        int anoMatricula = Integer.parseInt(matricula.substring(0, 3));
        Date data = new Date();
        int anoAtual = Integer.parseInt(data.toString().substring(24, 28));
        if (anoMatricula > anoAtual) {
            throw new UsuarioException("Matricula invalida!");
        }
    }
    
    public void imprimeAluno(){
        imprimeUsuario();
        System.out.println("Matricula: "+this.matricula);
        
    }
    public void adicionarTurma(Turma turma) {
        if (turma != null) {
            turmasPorDisciplinaAluno.put(turma.getDisciplina(), turma);
        }
    }
}
