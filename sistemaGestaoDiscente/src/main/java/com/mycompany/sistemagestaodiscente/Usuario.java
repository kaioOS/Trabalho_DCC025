/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private String email;
    private String senha;
    private int tipoUsuario;

    
    public Usuario(String nome,String CPF,String telefone, String email, String senha, int tipoUsuario) throws UsuarioException{
        validarTelefone(telefone);
        validarEmail(email);
        validarSenha(senha);
        validarCPF(CPF);
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
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
    
    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
    
    //------------------------
    
    //Login

    private String getSenha() {
        return senha;
    }

    private void setSenha(String senha) throws UsuarioException {
        validarSenha(String.valueOf(senha));
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
    public static void validarSenha(String senha) throws UsuarioException{
       if (senha == null || senha.length() < 8) {
            throw new UsuarioException("Senha inválida!");
        }
    }
    
    public static void validarEmail(String email) throws UsuarioException {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            throw new UsuarioException("Email inválido!");
        }

    }
    
    public static void validarCPF(String cpf) throws UsuarioException {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            throw new UsuarioException("CPF inválido!");
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            throw new UsuarioException("CPF inválido!");
        }
        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        
        int primeiroDigitoVerificador;
        if (resto < 2) {
            primeiroDigitoVerificador = 0;
        } else {
           primeiroDigitoVerificador = 11-resto;
        }  

        if (primeiroDigitoVerificador != Character.getNumericValue(cpf.charAt(9))) {
            throw new UsuarioException("CPF inválido!");
        }
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int segundoDigitoVerificador;
        if (resto < 2) {
            segundoDigitoVerificador = 0;
        } else {
           segundoDigitoVerificador = 11-resto;
        } 
        if (segundoDigitoVerificador != Character.getNumericValue(cpf.charAt(10))) {
            throw new UsuarioException("CPF inválido!");
        }
    }
    

    
    public static void validarTelefone(String telefone) throws UsuarioException{
        Pattern pattern = Pattern.compile("^\\(\\d{2}\\)\\s?\\d{5}-\\d{4}$");
        Matcher matcher = pattern.matcher(telefone);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            throw new UsuarioException("Telefone inválido");
        }
        
    }
    //------------------------
    
    public void imprimeUsuario(){
        System.out.println("Nome: "+this.nome);
        System.out.println("CPF: "+this.CPF);
        System.out.println("Telefone: "+this.telefone);
        System.out.println("Email: "+this.email);
        System.out.println("Senha: "+this.senha);
        System.out.println("TipoUsuario: "+this.tipoUsuario);

    }
}
