/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private Map<Disciplina, Turma> turmasProfessor;
    Random random = new Random();

    public Professor(String nome,String CPF,String telefone, String email, String senha, int tipoUsuario) throws UsuarioException{
        super(nome,CPF,telefone, email, senha,tipoUsuario);

        this.siape = Integer.toString(random.nextInt(9000000) + 1000000); // Gera um número de 7 dígitos e passa para String
        validarSiape(this.siape);
        this.turmasProfessor = new HashMap<>();
    }

   
    public String getSiape() {
        return siape;
    }
    
    private void setSiape(String siape)throws UsuarioException {
        validarSiape(siape);
        this.siape = siape;
    }

    public void lancarNotaAluno(Turma turma, Aluno aluno, float nota) {
        
        if (turma!=null) {
            turma.setNotaAlunos(aluno.getMatricula(), nota);
        }
    }
    public void lancarFrequencia(Turma turma, Aluno aluno, boolean presenca){
        if (turma!=null) {
            turma.setFrequenciaAluno(aluno.getMatricula(), presenca);
        }
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
    
    public void adicionarTurma(Turma turma) {
        if (turma != null) {
        this.turmasProfessor.put(turma.getDisciplina(), turma);
        turma.setProfessor(this);
        }
    }
    
    public void imprimeTurmas() {
        for (Disciplina d : turmasProfessor.keySet()) {
            Turma turma = turmasProfessor.get(d);
            System.out.println("Disciplina: " + turma.getCodigoDisciplinaCorresp());
            System.out.println("Turma: " + turma.getCodigoTurma());
        }
    }

    
    public void consultaTurma(Disciplina disciplina) {
        List<Turma> turmasEncontradas = new ArrayList<>();

        for (Map.Entry<Disciplina, Turma> entry : turmasProfessor.entrySet()) {
            Disciplina disciplinaTurma = entry.getKey();
            Turma turma = entry.getValue();

            if (disciplinaTurma.getNomeDisciplina().equals(disciplina.getNomeDisciplina())) {
                turmasEncontradas.add(turma);
            }
        }

        if (!turmasEncontradas.isEmpty()) {
            System.out.println("Turmas encontradas para a disciplina " + disciplina.getNomeDisciplina() + ":");
            for (Turma turma : turmasEncontradas) {
                System.out.println(turma.getCodigoTurma());
            }
        } else {
            System.out.println("Nenhuma turma encontrada para a disciplina: " + disciplina.getNomeDisciplina());
        }
    }

    
}
