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
    private String siape;
    Random random = new Random();

    public Professor(String nome,String CPF,String telefone, String email, String senha, int tipoUsuario) throws UsuarioException{
        super(nome,CPF,telefone, email, senha,tipoUsuario);

        this.siape = Integer.toString(random.nextInt(9000000) + 1000000); // Gera um número de 7 dígitos e passa para String
        validarSiape(this.siape);
    }
   
    public String getSiape() {
        return siape;
    }
    
    private void setSiape(String siape)throws UsuarioException {
        validarSiape(siape);
        this.siape = siape;
    }

    public void lancarNotaAluno(String matricula){
        
    }
    public void lancarFrequencia(String codigoTurma){
        
    }
    public void consultaTurmas(){
        
    }
    public void validarSiape(String siape) throws UsuarioException{
        if (siape.length() != 7) {
            throw new UsuarioException("SIAPE invalido!");
        }

        char primeiroDigito = siape.charAt(0);
        if (primeiroDigito == '0') {
            throw new UsuarioException("SIAPE invalido!");
        }

        try {
            Integer.parseInt(siape);
        } catch (NumberFormatException e) {
            throw new UsuarioException("SIAPE invalido!");
        }
        
    }
    public void imprimeProfessor(){
        imprimeUsuario();
        System.out.println("SIAPE: "+this.siape);
    }
    
}
