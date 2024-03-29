/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.List;
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

public abstract class Usuario {
    private String nome;
    private String CPF;
    private String telefone;
    private String email;
    private String senha;
    private int tipoUsuario;

    public Usuario(){
        
    }
    public Usuario(String nome,String CPF,String telefone, String email, String senha, int tipoUsuario) throws ExceptionNome, ExceptionTelefone, ExceptionEmail, ExceptionSenha, ExceptionCPF{
        validarNome(nome);
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

    public void setNome(String nome) throws ExceptionNome {
        validarNome(nome);
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) throws ExceptionCPF {
        validarCPF(CPF);
        this.CPF = CPF;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws ExceptionTelefone {
        validarTelefone(telefone);
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ExceptionEmail {
        validarEmail(email);
        this.email = email;
    }
    
    //------------------------
    
    //Login

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws ExceptionSenha {
        validarSenha(String.valueOf(senha));
        this.senha = senha;
    }

    private int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }    
    //------------------------

    //Validações
    public static void validarSenha(String senha) throws ExceptionSenha{
       if (senha == null || senha.length() < 8) {
            throw new ExceptionSenha();
        }
    }
    
    public static void validarEmail(String email) throws ExceptionEmail {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            throw new ExceptionEmail();
        }

    }
    
    public static void validarCPF(String cpf) throws ExceptionCPF {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            throw new ExceptionCPF();
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            throw new ExceptionCPF();
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
            throw new ExceptionCPF();
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
            throw new ExceptionCPF();
        }
    }
    
    public static void verificaCpfExiste(String cpf) throws ExceptionCPF{
        PersistenciaAluno persistenciaAluno = new PersistenciaAluno();
        PersistenciaProfessor persistenciaProfessor = new PersistenciaProfessor();
        PersistenciaAdministrador persistenciaAdministrador = new PersistenciaAdministrador();
        
        List<Aluno> alunos = persistenciaAluno.carregarDados();
        List<Professor> professores = persistenciaProfessor.carregarDados();
        List<Administrador> administradores = persistenciaAdministrador.carregarDados();
        
        for (Aluno aluno : alunos) {
            if (aluno.getCPF().equals(cpf)) {
                throw new ExceptionCPF();
            }
        }

        for (Professor professor : professores) {
            if (professor.getCPF().equals(cpf)) {
                throw new ExceptionCPF();
            }
        }
        for (Administrador administrador : administradores) {
            if (administrador.getCPF().equals(cpf)) {
                throw new ExceptionCPF();
            }
        }
    }
    
    public static boolean verificaLoginUsuario(String cpf, String senha, int tipoUsuario){
        if(tipoUsuario == 0){
            PersistenciaAdministrador persistenciaAdministrador = new PersistenciaAdministrador();
            List<Administrador> administradores = persistenciaAdministrador.carregarDados();
            for (Administrador administrador : administradores) {
                if (administrador.getCPF().equals(cpf) && administrador.getSenha().equals(senha)) {
                    return true;
                }
           }
           return false;
        }else if(tipoUsuario == 1){
            PersistenciaProfessor persistenciaProfessor = new PersistenciaProfessor();
            List<Professor> professores = persistenciaProfessor.carregarDados();
            for (Professor professor : professores) {
                if (professor.getCPF().equals(cpf) && professor.getSenha().equals(senha)) {
                    return true;
                }
            }
            return false;
        }else if(tipoUsuario == 2){
            PersistenciaAluno persistenciaAluno = new PersistenciaAluno();
            List<Aluno> alunos = persistenciaAluno.carregarDados();
            for (Aluno aluno : alunos) {
                if (aluno.getCPF().equals(cpf) && aluno.getSenha().equals(senha)) {
                    return true;
                }
            }
            System.out.println("Aluno");
            return false;
        }
        System.out.println("Ultimo");
        return false;
    }
    
    public static void validarTelefone(String telefone) throws ExceptionTelefone{
        String telefoneNumeros = telefone.replaceAll("\\D", "");
        if (!telefoneNumeros.matches("\\d{10,11}")) {
            throw new ExceptionTelefone();
        }        
    }
    public static void validarNome(String nome) throws ExceptionNome
    {
        if (nome == null || nome.length() == 0) {
            throw new ExceptionNome();
        }

        Pattern pattern = Pattern.compile(
                "^(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*(?: (?:(?:e|y|de(?:(?: la| las| lo| los))?|do|dos|da|das|del|van|von|bin|le) )?(?:(?:(?:d'|D'|O'|Mc|Mac|al\\-))?(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+|(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*))+(?: (?:Jr\\.|II|III|IV))?$");
        Matcher matcher = pattern.matcher(nome);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            throw new ExceptionNome();
        }
    }
    //------------------------
}
