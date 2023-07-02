/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.Date;
import java.util.*;
import java.util.Random;

/**
 *
 * @author filipe
 */
/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC) 
 */
public class Administrador extends Usuario{
    private int idAdm;
    
    // Construtor da classe
    public Administrador(String nome,String CPF,String telefone,String email, String senha, int idAdmin) throws ExceptionNome, ExceptionTelefone, ExceptionEmail, ExceptionSenha, ExceptionCPF{
        super(nome,CPF,telefone,email, senha, 0);
        this.idAdm = idAdmin;
    }
    public Disciplina cadastraDisciplina(String codigoDisciplina, String nomeDisciplina){
        PersistenciaDisciplina persistenciaDisciplina = new PersistenciaDisciplina();
        
        Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina);
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas = persistenciaDisciplina.carregarDados();
        disciplinas.add(disciplina);
        persistenciaDisciplina.armazenarDados(disciplinas);
        
        return disciplina;
    }
    
    // Métodos da classe
    public static Professor cadastroProfessorPorAdm(String nome,String CPF,String telefone,String email, String senha) throws ExceptionNome, ExceptionTelefone, ExceptionEmail, ExceptionSenha, ExceptionCPF, ExceptionSIAPE {
        PersistenciaProfessor persistenciaProfessor = new PersistenciaProfessor();
        Professor professor = new Professor(nome,CPF,telefone, email, senha);
        List <Professor> professores = new ArrayList<>();
        professores = persistenciaProfessor.carregarDados();
        professores.add(professor);
        persistenciaProfessor.armazenarDados(professores);
        return professor;
    }

    public static Aluno cadastroAlunoPorAdm(String nome,String CPF,String telefone, String email, String senha) throws ExceptionNome, ExceptionTelefone, ExceptionEmail, ExceptionSenha, ExceptionCPF, ExceptionMatricula{
        PersistenciaAluno persistenciaAluno = new PersistenciaAluno();
        Date data = new Date();
        CPF = CPF.replaceAll("[^0-9]", "");
        String matricula= data.toString().substring(24, 28) +CPF;
        Aluno aluno = new Aluno(nome,CPF,telefone, email, senha, matricula);
        List <Aluno> alunos = new ArrayList<>();
        alunos = persistenciaAluno.carregarDados();
        alunos.add(aluno);
        persistenciaAluno.armazenarDados(alunos);
        return aluno;
    }
    
    
    public static void atribuiTurmaAluno(Turma turma, Aluno aluno) throws ExceptionTurma {
        aluno.adicionarTurma(turma);
    }

    public static void atribuiTurmaProfessor( Turma turma, Professor professor) throws ExceptionTurma {
        professor.adicionarTurma(turma);
        
    }
}
