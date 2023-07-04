/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

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
public class NotaSomatorio extends Avaliacao {
    public NotaSomatorio() {
        super();
    }

    @Override
    public float calcularMediaFinal(String matricula) throws ExceptionNota {
        Map<String, List<Float>> notaAlunos = getNotaAlunos();
        
        if (!notaAlunos.containsKey(matricula)) {
            throw new ExceptionNota("Não há notas para a matrícula especificada.");
        }
    
        List<Float> notas = notaAlunos.get(matricula);
        
        if (notas.isEmpty()) {
            throw new ExceptionNota("Não há notas para a matrícula especificada.");
        }
    
        float somaNotas = 0;
        for (Float nota : notas) {
            somaNotas += nota;
        }
    
        return somaNotas;
    }
}
