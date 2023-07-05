/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gustavo
 */
/**
    Kaio de Oliveira e Sousa(202165080AC)
    Filipe de Lima Namorato(202165035AB)
    Gustavo Silva Ribeiro (202165057AC) 
 */
public abstract class Avaliacao {

    private int idAvaliacao;
    private Map<String, List<Float>> notaAlunos;

    public Avaliacao() {
    }

    public abstract float calcularMediaFinal(String matricula) throws ExceptionNota;

    public void adicionarNota(Aluno aluno, float nota) {

        String matricula = aluno.getMatricula();
        if (!notaAlunos.containsKey(matricula)) {
            notaAlunos.put(matricula, new ArrayList<>());
        }

        List<Float> notas = notaAlunos.get(matricula);
        notas.add(nota);
    }

    public Map<String, List<Float>> getNotaAlunos() {
        return this.notaAlunos;
    }

    public int getIdAvaliacao() {
        return this.idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public void setNotaAlunos(Map<String, List<Float>> notaAlunos) {
        this.notaAlunos = notaAlunos;
    }

}
