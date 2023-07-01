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
    private Map<String, List<Float>> notaAlunos;

    public Avaliacao() {
        this.notaAlunos = new HashMap<>();
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
        return notaAlunos;
    }
  
    

}
