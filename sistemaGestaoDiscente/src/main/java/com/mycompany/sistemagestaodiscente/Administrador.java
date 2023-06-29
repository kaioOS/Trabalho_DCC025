/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.Date;
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
    public Administrador(String nome,String CPF,String telefone,String email, String senha, int tipoUsuario, int idAdmin) throws NomeException, TelefoneException, EmailException, SenhaException, CPFException{
        super(nome,CPF,telefone,email, senha,tipoUsuario);
        this.idAdm = idAdmin;
    }
    public Disciplina cadastraDisciplina(String codigoDisciplina, String nomeDisciplina){
        Disciplina disc = new Disciplina(codigoDisciplina, nomeDisciplina);
        return disc;
    }
    
    // Métodos da classe
    public Professor cadastroProfessorPorAdm(String nome,String CPF,String telefone,String email, String senha, int tipoUsuario) throws NomeException, TelefoneException, EmailException, SenhaException, CPFException, SIAPEException {
        Professor professor = new Professor(nome,CPF,telefone, email, senha,tipoUsuario);
        return professor;
    }

    public Aluno cadastroAlunoPorAdm(String nome,String CPF,String telefone, String email, String senha, int tipoUsuario) throws NomeException, TelefoneException, EmailException, SenhaException, CPFException, MatriculaException{
        Date data = new Date();
        CPF = CPF.replaceAll("[^0-9]", "");
        String matricula= data.toString().substring(24, 28) +CPF;
        Aluno aluno = new Aluno(nome,CPF,telefone, email, senha,tipoUsuario,matricula);
        return aluno;
    }
    
    
    public void atribuiTurmaAluno(Turma turma, Aluno aluno) throws TurmaException {
        aluno.adicionarTurma(turma);
    }

    public void atribuiTurmaProfessor( Turma turma, Professor professor) throws TurmaException {
        professor.adicionarTurma(turma);
        
    }
}
