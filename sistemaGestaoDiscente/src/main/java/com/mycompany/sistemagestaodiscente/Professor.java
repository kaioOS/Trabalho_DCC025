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
    private Map<String, String> turmasProfessor;
    
    public Professor(){
        super();
    }
    public Professor(String nome,String CPF,String telefone, String email, String senha) throws ExceptionNome, ExceptionTelefone, ExceptionEmail, ExceptionSenha, ExceptionCPF, ExceptionSIAPE{
        super(nome,CPF,telefone, email, senha, 1);
        Random random = new Random();
        this.siape = Integer.toString(random.nextInt(9000000) + 1000000); // Gera um número de 7 dígitos e passa para String
        validarSiape(this.siape);
        this.turmasProfessor = new HashMap<>();
    }

   
    public String getSiape() {
        return siape;
    }
    
    public void setSiape(String siape)throws ExceptionSIAPE {
        validarSiape(siape);
        this.siape = siape;
    }
    
    public Map<String, String> getTurmasProfessor() {
        return turmasProfessor;
    }


    public void setTurmasProfessor(Map<String, String> turmasProfessor) {
        this.turmasProfessor = turmasProfessor;
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
    
    
    public void calculaMediaFinalAluno(Turma turma, Aluno aluno) throws ExceptionNota {
        
        if (turma!=null) {
            turma.getNotaFinalAluno(aluno.getMatricula());
        }
    }
    
    public void validarSiape(String siape) throws ExceptionSIAPE{
        if (siape.length() != 7) {
            throw new ExceptionSIAPE();
        }

        try {
            Integer.parseInt(siape);
        } catch (NumberFormatException e) {
            throw new ExceptionSIAPE();
        }
        
    }

    public void adicionarTurma(String codTurma) {
        PersistenciaTurma Pturma = new PersistenciaTurma();
        List<Turma> turmas = new ArrayList<>();
        turmas = Pturma.carregarDados();
        for(Turma i : turmas)
        {
            if(i.getCodigoTurma().equals(codTurma))
            {
                i.setSiapeProfessor(this.getSiape());
                Pturma.armazenarDados(turmas);
                return;
            }
        }
        
    }
    
    public void consultaTurma(Disciplina disciplina) {
        List<Turma> turmasEncontradas = new ArrayList<>();

        /*for (Map.Entry<Disciplina, Turma> entry : turmasProfessor.entrySet()) {
            Disciplina disciplinaTurma = entry.getKey();
            Turma turma = entry.getValue();

            if (disciplinaTurma.getNomeDisciplina().equals(disciplina.getNomeDisciplina())) {
                turmasEncontradas.add(turma);
            }
        }*/

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
