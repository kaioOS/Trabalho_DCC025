/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.Date;
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

public class Aluno extends Usuario {
    private String matricula;
    private HashMap<Disciplina, Turma> turmasPorDisciplinaAluno;
    
     
    public Aluno(String nome,String CPF,String telefone, String email, String senha, int tipoUsuario, String matricula) throws NomeException, TelefoneException, EmailException, SenhaException, CPFException, MatriculaException{
        super(nome,CPF,telefone,email, senha,tipoUsuario);
        validarMatricula(matricula);
        this.matricula=matricula;
        this.turmasPorDisciplinaAluno = new HashMap<>();
    }
    
    public void consultaNotas(Turma turma) {        
        List<Float> notas = turma.getNotaAlunos(this.matricula);
        
        if (notas.isEmpty()) {
            System.out.println("Nota não encontrada.");
        } else {
            System.out.println("As notas do aluno com matrícula " + this.matricula + " na turma " + turma.getCodigoTurma() + " da disciplina "+ turma.getCodigoDisciplinaCorresp()+ " são: ");
            for (float nota : notas) {
                System.out.println(nota);
            }
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

    public void setMatricula(String matricula) throws MatriculaException {
        validarMatricula(matricula);
        this.matricula = matricula;
    }
    public void validarMatricula(String matricula) throws MatriculaException {
        if (matricula.length() < 15) {
            throw new MatriculaException();
        }
        for (int i = 0; i < 15; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                throw new MatriculaException();
            }
        }
        if (matricula.length() > 15) {
            for (int i = 15; i < matricula.length(); i++) {
                if (!Character.isLetter(matricula.charAt(i))) {
                    throw new MatriculaException();
                }
            }
        }
        int anoMatricula = Integer.parseInt(matricula.substring(0, 3));
        Date data = new Date();
        int anoAtual = Integer.parseInt(data.toString().substring(24, 28));
        if (anoMatricula > anoAtual) {
            throw new MatriculaException();
        }
    }
    
    public void imprimeAluno(){
        imprimeUsuario();
        System.out.println("Matricula: "+this.matricula);
        
    }
    public void adicionarTurma(Turma turma) throws TurmaException {
        if (turma != null) {
            turmasPorDisciplinaAluno.put(turma.getDisciplina(), turma);
            turma.adicionarAluno(this);
        }
    }
}
