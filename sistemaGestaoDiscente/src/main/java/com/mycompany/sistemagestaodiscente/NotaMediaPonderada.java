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
public class NotaMediaPonderada extends Nota{

    public NotaMediaPonderada() {
        super();
    }
    
    public static List<Float> calcularPesos(Map<String, List<Float>> notaAlunos, String matricula) {
        List<Float> pesos = new ArrayList<>();
        List<Float> notas = notaAlunos.get(matricula);
        for (int i = 0; i < notas.size(); i++) {
            float peso = 1.0f + (0.5f * i); // Atribuindo pesos crescentes com base no número de notas
            pesos.add(peso);
        }
        return pesos;
    }

    @Override
    public float calcularMediaFinal(String matricula) throws ExceptionNota {
        Map<String, List<Float>> notaAlunos = getNotaAlunos();
        if (!notaAlunos.containsKey(matricula)) {
            throw new ExceptionNota("Não há notas para a matrícula especificada.");
        }

        List<Float> notas = notaAlunos.get(matricula);
        List<Float> pesos = calcularPesos(notaAlunos, matricula);
       

        if (notas.size() != pesos.size()) {
            throw new ExceptionNota("O número de notas e pesos não coincide.");
        }

        float somaNotasPonderadas = 0;
        float somaPesos = 0;
        for (int i = 0; i < notas.size(); i++) {
            float nota = notas.get(i);
            float peso = pesos.get(i);
            somaNotasPonderadas += nota * peso;
            somaPesos += peso;
        }
        
        return somaNotasPonderadas / somaPesos;
    }

}
