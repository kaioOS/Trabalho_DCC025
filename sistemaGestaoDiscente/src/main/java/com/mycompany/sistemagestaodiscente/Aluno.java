/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.ArrayList;
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
    private HashMap<String, String> turmasAluno;//<codigoDisciplina,codigoTurma>
    
    public Aluno() {
        super();
    }
     
    public Aluno(String nome,String CPF,String telefone, String email, String senha, String matricula) throws ExceptionNome, ExceptionTelefone, ExceptionEmail, ExceptionSenha, ExceptionCPF, ExceptionMatricula{
        super(nome,CPF,telefone,email, senha, 2);
        validarMatricula(matricula);
        this.matricula=matricula;
        this.turmasAluno = new HashMap<>();
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
        return this.matricula;
    }

    public void setMatricula(String matricula) throws ExceptionMatricula {
        validarMatricula(matricula);
        this.matricula = matricula;
    }
    
    public void setTurmaAluno(HashMap<String, String> turmasAluno) {
        this.turmasAluno = turmasAluno;
    }
    
    
    public void validarMatricula(String matricula) throws ExceptionMatricula {
        if (matricula.length() < 15) {
            throw new ExceptionMatricula();
        }
        for (int i = 0; i < 15; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                throw new ExceptionMatricula();
            }
        }
        if (matricula.length() > 15) {
            for (int i = 15; i < matricula.length(); i++) {
                if (!Character.isLetter(matricula.charAt(i))) {
                    throw new ExceptionMatricula();
                }
            }
        }
        int anoMatricula = Integer.parseInt(matricula.substring(0, 3));
        Date data = new Date();
        int anoAtual = Integer.parseInt(data.toString().substring(24, 28));
        if (anoMatricula > anoAtual) {
            throw new ExceptionMatricula();
        }
    }
    public static void verficaMatriculaExiste(String matricula) throws ExceptionMatricula
    {
        PersistenciaAluno persistenciaAluno = new PersistenciaAluno();
        List<Aluno> alunos = persistenciaAluno.carregarDados();
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                throw new ExceptionMatricula();
            }
        }
    }
    public void adicionarTurma(String codTurma) throws ExceptionTurma {
        PersistenciaTurma Pturma = new PersistenciaTurma();
        List<Turma> turmas = new ArrayList<>();
        turmas = Pturma.carregarDados();
        for(Turma i : turmas)
        {
            if(i.getCodigoTurma().equals(codTurma))
            {
                i.adicionarAluno(this);
                Pturma.armazenarDados(turmas);
                return;
            }
        }
        
    }
}
