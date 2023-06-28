/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

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
    
     
    public Aluno(String nome,String CPF,String telefone, String email, String senha, int tipoUsuario, String matricula) throws UsuarioException{
        super(nome,CPF,telefone,email, senha,tipoUsuario);
        this.matricula=matricula;
    }
    public void consultaNotas(String matricula, String codigoTurma){
        
    }
    public void consultaFrequencia(String matricula, String codigoTurma){
        
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
        System.out.println("Matricula: "+this.matricula);
        
    }
}
