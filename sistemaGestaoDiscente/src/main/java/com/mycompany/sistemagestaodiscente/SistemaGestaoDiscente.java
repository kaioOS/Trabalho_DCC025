/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemagestaodiscente;

import java.util.Scanner;

/**
 *
 * @author filipe
 */

/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC) 
 */
public class SistemaGestaoDiscente {

    public static void main(String[] args) throws UsuarioException, TurmaException {
        Scanner sc = new Scanner(System.in);
        //Aluno aluno1 = new Aluno("Filipe",123,"123","filipe","123",2,"202165035AB");
        Aluno vetAlunos[] = new Aluno[100];
        int contAlunos = 0;
        
        Professor vetProfessores[] = new Professor[10];
        int contProfessor = 0;
        
        Disciplina vetDisciplina[] = new Disciplina[5];
        int contDisciplina = 0;
        
        Turma vetTurma[] = new Turma[4];
        int contTurma = 0;
        
        //aluno1.imprimeAluno();
        Administrador adm = new Administrador("Filipe","384.628.477-70","(32) 99999-9999","teste@teste.com", "12345678",0,1);
        
// TESTES        
//        Aluno a1 = adm.cadastroAlunoPorAdm("Gustavo","384.628.477-70","(32) 99999-9999","teste@teste.com", "12345678",2);
//        Aluno a2 = adm.cadastroAlunoPorAdm("Fulano","489.325.417-01","(32) 99999-9999","teste@teste.com", "12345678",2);
//        Professor p1 = adm.cadastroProfessorPorAdm("Kaio","384.628.477-70","(32) 99999-9999","teste@teste.com", "12345678",1);
//        Disciplina d = new Disciplina("MAT123", "MAT");
//        Turma t = new Turma("A", d);
//        Disciplina d2 = new Disciplina("DCC123", "DCC");
//        Turma t2 = new Turma("B", d2);
//        Disciplina d3 = new Disciplina("DCC123", "DCC");
//        Turma t3 = new Turma("A", d3);
//
//        adm.atribuiTurmaProfessor(t, p1);
//        adm.atribuiTurmaProfessor(t2, p1);
//        adm.atribuiTurmaProfessor(t3, p1);
//        adm.atribuiTurmaAluno(t, a1);
//        adm.atribuiTurmaAluno(t2, a2);
//        p1.imprimeTurmas();
//        p1.consultaTurma(d3);
//        t.imprimeTurma();
//        t.imprimirListaAlunos();
//        p1.lancarNotaAluno(t, a1, 100);
//        p1.lancarNotaAluno(t, a2, 100);
//        p1.lancarFrequencia(t, a1, true);
//        p1.lancarFrequencia(t, a1, false);
//        p1.lancarFrequencia(t, a2, true);
        
        int opcao;
        String nome,telefone, email, senha;
        String CPF;
        String codigoDisciplina, nomeDisciplina;
        
        do{
            System.out.println("Bem vindo ao Sistema de Gestão Discente");
            System.out.println("Digite: ");
            System.out.println("0 para sair");
            
            System.out.println("1 para cadastrar professor");
            System.out.println("2 para listar os professores");
            
            System.out.println("3 para cadastrar aluno");
            System.out.println("4 para listar os alunos");
            
            
            System.out.println("5 para cadastrar Disciplina");
            System.out.println("6 para listar Disciplinas");
            
            System.out.println("7 para cadastrar Turma");
            System.out.println("8 para listar Turmas");
            
            opcao = sc.nextInt();
            
            if(opcao==1){
                System.out.println("--------Cadastro de professor--------");

                sc.nextLine();
                System.out.println("Digite o nome:");
                nome = sc.nextLine();
                
                System.out.println("Digite o CPF:");
                CPF = sc.nextLine();
                
                System.out.println("Digite o telefone:");
                telefone = sc.nextLine();
                
                System.out.println("Digite o email:");
                email = sc.nextLine();
                
                System.out.println("Digite a senha:");
                senha = sc.nextLine();
                
                vetProfessores[contProfessor] = adm.cadastroProfessorPorAdm(nome, CPF, telefone,email, senha, 2);
                contProfessor++;
                
            }else if(opcao==2){
                
                System.out.println("--------Listando professores--------");
                for (int i = 0; i < contProfessor; i++) {
                    if(vetProfessores[i]==null)
                        break;
                    System.out.println("Professor "+i+": ");
                    vetProfessores[i].imprimeProfessor();
                    System.out.println("------------------------");
                }
                
            }else if(opcao==3){
                System.out.println("--------Cadastro de aluno--------");
                
                sc.nextLine();

                System.out.println("Digite o nome:");
                nome = sc.nextLine();
                
                System.out.println("Digite o CPF:");
                CPF = sc.nextLine();

                System.out.println("Digite o telefone:");
                telefone = sc.nextLine();
                
                System.out.println("Digite o email:");
                email = sc.nextLine();
                
                System.out.println("Digite a senha:");
                senha = sc.nextLine();
                
                vetAlunos[contAlunos] = adm.cadastroAlunoPorAdm(nome, CPF, telefone, email, senha, 2);
                contAlunos++;

                
            }else if(opcao==4){
                
                System.out.println("--------Listando alunos--------");
                for (int i = 0; i < contAlunos; i++){
                    if(vetAlunos[i]==null)
                        break;
                    System.out.println("Aluno"+i+": ");
                    vetAlunos[i].imprimeAluno();
                    System.out.println("------------------------");
                }
                
            }else if(opcao == 5){
                
                System.out.println("--------Cadastrando disciplina--------");
                sc.nextLine();
                System.out.println("Digite o código da disciplina: ");
                codigoDisciplina = sc.nextLine();
                System.out.println("Digite o nome da disciplina: ");
                nomeDisciplina = sc.nextLine();
                vetDisciplina[contDisciplina]=adm.cadastraDisciplina(codigoDisciplina,nomeDisciplina);
                contDisciplina++;
                
            }else if(opcao == 6){
                 System.out.println("--------Listando disciplinas--------");
                for (int i = 0; i < contDisciplina; i++) {
                    if(vetDisciplina[i]==null)
                        break;
                    System.out.println("Disciplina "+i+": ");
                    vetDisciplina[i].imprimeDisciplina();
                    System.out.println("------------------------");
                }
            }
        
        }while(opcao!=0);
                
    }
}
