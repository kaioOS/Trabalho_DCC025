/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.Random;

/**
 *
 * @author filipe
 */
public class Administrador extends Usuario{
    private int idAdm;
    
    // Construtor da classe
    public Administrador(String nome,int CPF,String telefone,String login,String senha, int tipoUsuario, int idAdmin){
        super(nome,CPF,telefone,login,senha,tipoUsuario);
        this.idAdm = idAdmin;
    }
    public Disciplina cadastraDisciplina(String codigoDisciplina, String nomeDisciplina){
        Disciplina disc = new Disciplina(codigoDisciplina, nomeDisciplina);
        return disc;
    }
    
    // Métodos da classe
    public Professor cadastroProfessorPorAdm(String nome,int CPF,String telefone,String login,String senha, int tipoUsuario){
        Random random = new Random();
        int siape = random.nextInt(7);
        Professor professor = new Professor(nome,CPF,telefone,login,senha,tipoUsuario,siape);
        return professor;
    }

    public Aluno cadastroAlunoPorAdm(String nome,int CPF,String telefone,String login,String senha, int tipoUsuario){
        System.out.println("Digite o nome");
        String matricula="2023"+nome;
        Aluno aluno = new Aluno(nome,CPF,telefone,login,senha,tipoUsuario,matricula);
        return aluno;
    }

    public void atribuiMateriaAluno(){
        
    }

    public void atribuiMateriaProfessor() {
        
    }
}
