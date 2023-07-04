/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filipe
 */

/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC) 
 */

public class Disciplina{
    private String codigoDisciplina;
    private String nomeDisciplina;
    private List <String>turmasCadastradas = new ArrayList<>();
    
    public Disciplina(String codigoDisciplina, String nomeDisciplina) throws ExceptionDisciplinaCadastrada{
        verificaDisciplina(codigoDisciplina, nomeDisciplina);
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
    }

    
    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }
    public List<String> getDisciplinas()
    {
        return this.turmasCadastradas;
    }
    public void setNovaTurma(String codTurma)
    {
        this.turmasCadastradas.add(codTurma);
        
    }
    
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void imprimeDisciplina() {
        System.out.println("Codigo disciplina: "+this.codigoDisciplina);
        System.out.println("Nome disciplina: "+this.nomeDisciplina);
    }
    
    public static void verificaDisciplina(String codigoDisciplina, String nomeDisciplina) throws ExceptionDisciplinaCadastrada{
        PersistenciaDisciplina persistenciaDisciplina = new PersistenciaDisciplina();
        List<Disciplina> disciplinas = persistenciaDisciplina.carregarDados();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigoDisciplina().equals(codigoDisciplina) && disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
                    throw new ExceptionDisciplinaCadastrada();
            }
        }
    }
}
