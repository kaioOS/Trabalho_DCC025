/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;
/**
 *
 * @author filipe
 */
abstract class Usuario {
    private String nome;
    private int CPF;
    private String telefone;
    private String login;
    private String senha;
    private int tipoUsuario;

    
    public Usuario(String nome,int CPF,String telefone,String login,String senha, int tipoUsuario){
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.login = login;
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

    public int getCPF() {
        return CPF;
    }

    private void setCPF(int CPF) {
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
    private String getLogin() {
        return login;
    }

    private void setLogin(String login) {
        this.login = login;
    }

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
        System.out.println("Nome: "+nome);
        System.out.println("CPF: "+CPF);
        System.out.println("Telefone"+telefone);
        System.out.println("Login: "+login);
        System.out.println("Senha: "+senha);
        System.out.println("TipoUsuario: "+tipoUsuario);

    }
}
