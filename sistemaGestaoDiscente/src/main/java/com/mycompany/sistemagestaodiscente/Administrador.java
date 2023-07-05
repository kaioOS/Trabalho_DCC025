/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.Date;
import java.util.*;
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
public class Administrador extends Usuario{
    private int idAdm;
    
    // Construtor da classe
    public Administrador(String nome,String CPF,String telefone,String email, String senha, int idAdmin) throws ExceptionNome, ExceptionTelefone, ExceptionEmail, ExceptionSenha, ExceptionCPF{
        super(nome,CPF,telefone,email, senha, 0);
        this.idAdm = idAdmin;
    }
    public static void cadastroDisciplinaPorAdm(String codigoDisciplina, String nomeDisciplina) throws ExceptionDisciplinaCadastrada{
        PersistenciaDisciplina persistenciaDisciplina = new PersistenciaDisciplina();
        
        Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina);
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas = persistenciaDisciplina.carregarDados();
        disciplinas.add(disciplina);
        persistenciaDisciplina.armazenarDados(disciplinas);
        
       
    }
    
    // Métodos da classe
    public static void cadastroProfessorPorAdm(String nome,String CPF,String telefone,String email, String senha) throws ExceptionNome, ExceptionTelefone, ExceptionEmail, ExceptionSenha, ExceptionCPF, ExceptionSIAPE {
        PersistenciaProfessor persistenciaProfessor = new PersistenciaProfessor();
        CPF = CPF.replaceAll("[^0-9]", "");
        Professor professor = new Professor(nome,CPF,telefone, email, senha);
        List <Professor> professores = new ArrayList<>();
        professores = persistenciaProfessor.carregarDados();
        professores.add(professor);
        persistenciaProfessor.armazenarDados(professores);
        
    }

    public static void cadastroAlunoPorAdm(String nome,String CPF,String telefone, String email, String senha) throws ExceptionNome, ExceptionTelefone, ExceptionEmail, ExceptionSenha, ExceptionCPF, ExceptionMatricula{
        PersistenciaAluno persistenciaAluno = new PersistenciaAluno();
        Date data = new Date();
        CPF = CPF.replaceAll("[^0-9]", "");
        String matricula= data.toString().substring(24, 28) +CPF;
        Aluno aluno = new Aluno(nome,CPF,telefone, email, senha, matricula);
        List <Aluno> alunos = new ArrayList<>();
        alunos = persistenciaAluno.carregarDados();
        alunos.add(aluno);
        persistenciaAluno.armazenarDados(alunos);
        
    }
    
    
    public static void cadastroTurmaPorAdm(String codigoTurma, String codigoDisciplinaCorres, int tipoAvaliacao) throws ExceptionFormaAvaliacao, ExceptionTurmaCadastrada{
        PersistenciaTurma persistenciaTurma = new PersistenciaTurma();
        PersistenciaDisciplina persistenciaDisciplina = new PersistenciaDisciplina();
        List <Disciplina> disciplinas =  new ArrayList<>();
        disciplinas = persistenciaDisciplina.carregarDados();
        for (Disciplina disciplina : disciplinas) {
            if(disciplina.getCodigoDisciplina().equals(codigoDisciplinaCorres))
            {
                //disciplina.setNovaTurma(codigoTurma);
                Disciplina disciplinaCorres = disciplina;
                Turma turma = new Turma(codigoTurma, disciplinaCorres, tipoAvaliacao);
                List<Turma> turmas = new ArrayList<>();
                turmas = persistenciaTurma.carregarDados();
                turmas.add(turma);
                persistenciaTurma.armazenarDados(turmas);
                disciplina.setNovaTurma(codigoTurma);
                persistenciaDisciplina.armazenarDados(disciplinas);
                return;
            }
        }
        
    }    
                
    
    public static void atribuirTurmaProfessor( String turma, String siape) throws ExceptionTurma {
        PersistenciaProfessor Pprofessores = new PersistenciaProfessor();
        List <Professor> professores = new ArrayList<>();
        professores = Pprofessores.carregarDados();
        for(Professor i : professores)
        {
            if(i.getSiape().equals(siape))
            {
                i.adicionarTurma(turma);
                System.out.println("Entrou");
            }
        }
        Pprofessores.armazenarDados(professores);
    }
    public static void atribuirAlunoTurma( String cTurma, String matricula) throws ExceptionTurma {
        PersistenciaAluno Palunos = new PersistenciaAluno();
        List <Aluno> alunos = new ArrayList<>();
        alunos = Palunos.carregarDados();
        for(Aluno i : alunos)
        {
            if(i.getMatricula().equals(matricula))
            {
                i.adicionarTurma(cTurma);
                Palunos.armazenarDados(alunos); 
                return;
            }
        }
              
    }
}
