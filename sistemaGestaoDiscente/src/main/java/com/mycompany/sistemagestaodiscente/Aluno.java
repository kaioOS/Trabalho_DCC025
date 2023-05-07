/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

/**
 *
 * @author filipe
 */
public class Aluno extends Usuario {
    private String matricula;
    
     
    public Aluno(String nome,int CPF,String telefone,String login,String senha, int tipoUsuario, String matricula){
        super(nome,CPF,telefone,login,senha,tipoUsuario);
        this.matricula=matricula;
    }
    public void consultaNotas(){
        
    }
    public void consultaFrequencia(){
        
    }
    public void validaMatricula(){
        
    }

    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void imprimeAluno(){
        imprimeUsuario();
        System.out.println("Matricula:"+matricula);
        
    }
}
