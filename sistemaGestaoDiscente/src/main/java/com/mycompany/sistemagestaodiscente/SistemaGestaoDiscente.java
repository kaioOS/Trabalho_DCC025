/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemagestaodiscente;

import java.util.Scanner;

/**
 *
 * @author filipe
 */
public class SistemaGestaoDiscente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Aluno aluno1 = new Aluno("Filipe",123,"123","filipe","123",2,"202165035AB");
        Aluno vetAlunos[] = new Aluno[100];
        int contAlunos = 0;
        Professor vetProfessores[] = new Professor[10];
        int contProfessor = 0;
        
        //aluno1.imprimeAluno();
        Administrador adm = new Administrador("Filipe",123,"123","filipe","123",0,1);
               
        int opcao;
        String nome,telefone, rua, bairro, numero, login, senha;
        int CPF, CEP, tipoUsuario=2;
        
        do{
            System.out.println("Bem vindo ao Sistema de Gestão Discente");
            System.out.println("Digite: ");
            System.out.println("0 para sair");
            System.out.println("1 para cadastrar professor");
            System.out.println("2 para cadastrar aluno");
            System.out.println("3 para listar os alunos");
            System.out.println("4 para listar os professores");
            opcao = sc.nextInt();
            
            if(opcao==1){
                
                sc.nextLine();
                System.out.println("Digite o nome:");
                nome = sc.nextLine();
                
                System.out.println("Digite o CPF:");
                CPF = sc.nextInt();
                
                System.out.println("Digite o telefone:");
                telefone = sc.nextLine();
                
                sc.nextLine();
                System.out.println("Digite o login:");
                login = sc.nextLine();
                
                System.out.println("Digite a senha:");
                senha = sc.nextLine();
                
                vetProfessores[contProfessor] = adm.cadastroProfessorPorAdm(nome, CPF, telefone, login, senha, 2);
                contProfessor++;
                
            }else if(opcao==2){
                
                System.out.println("Digite o nome:");
                nome = sc.nextLine();
                
                System.out.println("Digite o CPF:");
                CPF = sc.nextInt();

                System.out.println("Digite o telefone:");
                telefone = sc.nextLine();
                
                System.out.println("Digite o login:");
                login = sc.nextLine();

                System.out.println("Digite a senha:");
                senha = sc.nextLine();
                
                vetAlunos[contAlunos] = adm.cadastroAlunoPorAdm(nome, CPF, telefone, login, senha, 2);
                contAlunos++;
                
            }else if(opcao==3){
                for (int i = 0; i < contAlunos; i++) {
                    if(vetAlunos[i]==null)
                        break;
                    System.out.println("--------Listando professores--------");
                    System.out.println("Professor "+i+": ");
                    vetAlunos[i].imprimeAluno();
                    System.out.println("------------------------");
                }

                
            }else if(opcao==4){
                for (int i = 0; i < contProfessor; i++) {
                    if(vetProfessores[i]==null)
                        break;
                    System.out.println("--------Listando professores--------");
                    System.out.println("Professor "+i+": ");
                    vetProfessores[i].imprimeProfessor();
                    System.out.println("------------------------");
                }
                
            }
        
        }while(opcao!=0);
        
        
                
    }
}
