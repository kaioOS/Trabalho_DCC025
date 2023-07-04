/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author filipe
 */
/**
 * Kaio de Oliveira e Sousa(202165080AC) Filipe de Lima Namorato(202165035AB)
 * Gustavo Silva Ribeiro (202165057AC)
 */
public class Turma {

    private String codigoTurma;
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> alunos;
    private HashMap<String, Integer> frequenciaAlunos;
    private int formaAvaliacao;
    private Avaliacao notaProvas;

    public Turma() {

    }

    public Turma(String codigoTurma, Disciplina disciplina, int formaAvaliacao) throws ExceptionFormaAvaliacao, ExceptionTurmaCadastrada {
        validaFormaAvalicao(formaAvaliacao);
        verificaTurma(codigoTurma, disciplina);
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.formaAvaliacao = formaAvaliacao;
        this.alunos = new ArrayList<>();
        this.frequenciaAlunos = new HashMap<>();

        if (this.formaAvaliacao == 1) {
            notaProvas = new NotaMediaAritmetica();
        }
        if (this.formaAvaliacao == 2) {
            notaProvas = new NotaMediaPonderada();
        }
        if (this.formaAvaliacao == 3) {
            notaProvas = new NotaMediaComDescarte();
        }
        if (this.formaAvaliacao == 4) {
            notaProvas = new NotaSomatorio();
        }

    }

    public void setFrequencia(HashMap<String, Integer> frequenciaAlunos) {
        this.frequenciaAlunos = frequenciaAlunos;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getFormaAvaliacao() {
        return formaAvaliacao;
    }

    public void setFormaAvaliacao(int formaAvaliacao) throws ExceptionFormaAvaliacao {
        validaFormaAvalicao(formaAvaliacao);
        this.formaAvaliacao = formaAvaliacao;
    }

    public void validaFormaAvalicao(int formaAvaliacao) throws ExceptionFormaAvaliacao {
        if (formaAvaliacao != 1 && formaAvaliacao != 2 && formaAvaliacao != 3) {
            throw new ExceptionFormaAvaliacao();
        }
    }

    public String getCodigoDisciplinaCorresp() {
        return this.disciplina.getCodigoDisciplina();
    }

    public String getSiapeProfessor() {
        return professor.getSiape();
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void adicionarAluno(Aluno aluno) throws ExceptionTurma {
        if (this.disciplina.getCodigoDisciplina() != null) {
            alunos.add(aluno);
        } else {
            throw new ExceptionTurma();
        }
    }

    public int getFrequenciaAluno(String matricula) {
        if (this.frequenciaAlunos.isEmpty()) {
            return -1;
        }
        return this.frequenciaAlunos.get(matricula);
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    //atualiza frequencia do aluno
    public void setFrequenciaAluno(String matricula, boolean presenca) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                if (this.frequenciaAlunos.containsKey(matricula)) {
                    if (presenca) {
                        this.frequenciaAlunos.put(matricula, this.frequenciaAlunos.get(matricula) + 1);
                    }
                } else {
                    if (presenca) {
                        this.frequenciaAlunos.put(matricula, 1);
                    } else {
                        this.frequenciaAlunos.put(matricula, 0);
                    }
                }
                System.out.println("Frequencia lançada para o aluno " + aluno.getNome() + " na disciplina " + this.getCodigoDisciplinaCorresp());
            } else {
                System.out.println("Matricula nao encontrada!");
            }
        }
    }

    public List<Float> getNotaAlunos(String matricula) {
        return this.notaProvas.getNotaAlunos().get(matricula);
    }

    public float getNotaFinalAluno(String matricula) throws ExceptionNota {
        return this.notaProvas.calcularMediaFinal(matricula);
    }

    //atualiza nota do aluno
    public void setNotaAlunos(String matricula, float notaAluno) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                notaProvas.adicionarNota(aluno, notaAluno);
                System.out.println("Nota lançada para o aluno " + aluno.getNome() + " na disciplina " + this.getCodigoDisciplinaCorresp());
            } else {
                System.out.println("Matricula nao encontrada!");
            }
        }
    }

    public void imprimeTurma() {
        System.out.println("Codigo turma: " + this.codigoTurma);
        System.out.println("Codigo disciplina: " + this.disciplina.getCodigoDisciplina());
        if (this.professor != null) {
            System.out.println("SIAPE professor: " + this.professor.getSiape());
        } else {
            System.out.println("Professor nao cadastrado!");
        }
    }

    public void imprimirListaAlunos() {
        System.out.println("Lista de Alunos da Disciplina " + this.disciplina.getCodigoDisciplina() + " Turma " + this.codigoTurma);

        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matrícula: " + aluno.getMatricula());
        }
    }

    public void imprimirProf() {
        System.out.println("Professor da Disciplina " + this.disciplina.getCodigoDisciplina() + " Turma " + this.codigoTurma);
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Matrícula: " + professor.getSiape());
    }

    public static void verificaTurma(String codigoTurma, Disciplina disciplina) throws ExceptionTurmaCadastrada {
        PersistenciaTurma persistenciaTurma = new PersistenciaTurma();
        List<Turma> turmas = persistenciaTurma.carregarDados();
        for (Turma turma : turmas) {
            if (turma.getCodigoTurma().equals(codigoTurma) && turma.getCodigoDisciplinaCorresp().equals(disciplina.getCodigoDisciplina())) {
                throw new ExceptionTurmaCadastrada();
            }
        }

    }

    void defineFormaAvaliacao(int formaAvaliacao) {
        if (formaAvaliacao == 1) {
            notaProvas = new NotaMediaAritmetica();
        }
        if (formaAvaliacao == 2) {
            notaProvas = new NotaMediaPonderada();
        }
        if (formaAvaliacao == 3) {
            notaProvas = new NotaMediaComDescarte();
        }
        if (formaAvaliacao == 4) {
            notaProvas = new NotaSomatorio();
        }
    }

}
