/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

/**
 *
 * @author gustavo 
 */
public class ExceptionTurmaCadastrada extends Exception{
    public ExceptionTurmaCadastrada() {
        super("Turma já cadastrada.");
     }
    
}