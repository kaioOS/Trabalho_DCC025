/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;
/**
 *
 * @author filipe
 */
public class Usuario {
    private int id;
    private String nome;
    private int CPF;
    private String telefone;
    private String rua;
    private String bairro;
    private String numero;
    private String login;
    private String senha;
    private int tipoUsuario;

    //ID
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
    //------------------------
    
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
    
    //Endereço
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
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
    
    public void validarMatricula(){
        
    }
    
    public void validarEmail(){
        
    }
    
    public void validarTelefone(){
        
    }
    //------------------------
}
