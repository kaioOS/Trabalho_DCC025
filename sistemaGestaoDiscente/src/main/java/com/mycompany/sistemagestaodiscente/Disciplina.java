/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

/**
 *
 * @author filipe
 */
public class Disciplina{
    private String codigoDisciplina;
    private String nomeDisciplina;
    
    public Disciplina(String codigoDisciplina, String nomeDisciplina){
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
    }


    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }


    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void imprimeDisciplina() {
        System.out.println("Codigo disciplina: "+codigoDisciplina);
        System.out.println("Nome disciplina: "+nomeDisciplina);
    }
    
   
}
