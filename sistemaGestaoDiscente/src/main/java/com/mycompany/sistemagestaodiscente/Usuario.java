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

abstract class Usuario {
    private String nome;
    private String CPF;
    private String telefone;
    private String senha;
    private int tipoUsuario;

    
    public Usuario(String nome,String CPF,String telefone,String senha, int tipoUsuario){
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }
    
    //Dados pessoais do usuário
    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    private void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    //------------------------
    
    //Login

    private String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    private int getTipoUsuario() {
        return tipoUsuario;
    }

    private void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }    
    //------------------------

    //Validações
    public void validarSenha(){
       
    }
    
    public void validarEmail(){
        
    }
    
    public void validarTelefone(){
        
    }
    //------------------------
    
    public void imprimeUsuario(){
        System.out.println("Nome: "+this.nome);
        System.out.println("CPF: "+this.CPF);
        System.out.println("Telefone: "+this.telefone);
        System.out.println("Senha: "+this.senha);
        System.out.println("TipoUsuario: "+this.tipoUsuario);

    }
}
