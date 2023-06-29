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
        Administrador adm = new Administrador("Filipe","123","(32) 99999-9999","teste@teste.com", "12345678",0,1);
               
        int opcao;
        String nome,telefone, email, senha;
        String CPF;
        String codigoDisciplina, nomeDisciplina, codigoTurma, codigoDisciplinaCorresp;
        int siapeProfessor;
        
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
            }else if(opcao == 7){
                System.out.println("--------Cadastrando Turma--------");
                sc.nextLine();
                System.out.println("Digite o código da Turma: ");
                codigoTurma = sc.nextLine();
                System.out.println("Digite o código da Disciplina: ");
                codigoDisciplinaCorresp = sc.nextLine();
                System.out.println("Digite o SIAPE do Professor: ");
                siapeProfessor = Integer.parseInt(sc.nextLine());
                vetTurma[contTurma]= new Turma(codigoTurma, codigoDisciplinaCorresp, siapeProfessor);
                contTurma++;
            }else if(opcao == 8){
                 System.out.println("--------Listando turmas--------");
                for (int i = 0; i < contTurma; i++) {
                    if(vetTurma[i]==null)
                        break;
                    System.out.println("Turma "+i+": ");
                    vetTurma[i].imprimeTurma();
                    System.out.println("------------------------");
                }
            }
        
        }while(opcao!=0);
                
    }
}
