/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.Random;

/**
 *
 * @author filipe
 */

/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC) 
 */
public class Professor extends Usuario{
    private int siape;
    Random random = new Random();

    public Professor(String nome,String CPF,String telefone, String email, String senha, int tipoUsuario, int siape) throws UsuarioException{
        super(nome,CPF,telefone, email, senha,tipoUsuario);
        this.siape = random.nextInt(9999999);
    }
   
    public int getSiape() {
        return siape;
    }
    
    private void setSiape(int siape) {
        this.siape = siape;
    }

    public void lancarNotaAluno(String matricula){
        
    }
    public void lancarFrequencia(String codigoTurma){
        
    }
    public void consultaTurmas(){
        
    }
    public void validaSiape(){
        
    }
    public void imprimeProfessor(){
        imprimeUsuario();
        System.out.println("SIAPE:"+this.siape);
    }
    
}
