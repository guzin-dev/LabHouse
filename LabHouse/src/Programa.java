import Entidades.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Programa {
    static Scanner leitor = new Scanner(System.in);
    static int id = 0;
    static ArrayList<Aluno> listaDeAlunos = new ArrayList<Aluno>();
    static ArrayList<Professor> listaDeProfessores = new ArrayList<Professor>();
    static ArrayList<Pedagogo> listaDePedagogos = new ArrayList<Pedagogo>();

    public static void main(String[] args) {
        System.out.println("Olá! Bem-vindo ao LabSchool =D\n");
        menuPrincipal();
    }
    public static void menuPrincipal(){
        System.out.println("\n-------OPÇÕES-------");
        System.out.println("1- Gerenciar alunos\n" +
                "2- Gerenciar professores\n" +
                "3- Gerenciar pedagogos\n" +
                "4- Visualiar como Lab School\n" +
                "5- Sair do programa\n" +
                "--------------------");
        int opcao = -1;
        do {
            System.out.printf("Opção -> ");
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    menuAlunos();
                    break;
                case 2:
                    menuProfessores();
                    break;
                case 3:
                    menuPedagogos();
                    break;
                case 4:
                    menuLabSchool();
                    break;
                case 5:
                    System.out.println("\nAdeus, até breve =D");
                    break;
                default:
                    System.out.println("Opção não existe");
                    break;
            }
        }while(opcao < 1 || opcao > 5);
    }
    public static void menuAlunos(){
        System.out.println("\n-------ALUNO-------");
        System.out.println("1- Criar aluno\n" +
                "2- Visualizar todos os alunos\n" +
                "3- Visualizar um aluno\n" +
                "4- Ver total de atendimentos pedagógicos realizados de um aluno\n" +
                "5- Alterar estado de um aluno\n" +
                "6- Voltar\n" +
                "-------------------");
        int opcao = -1;
        do {
            System.out.printf("Opção -> ");
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    criarAluno();
                    break;
                case 2:
                    mostrarListaDeAlunos();
                    break;
                case 3:
                    verUmAluno();
                    break;
                case 4:
                    verQuantidadeDeAtendimentosAluno();
                    break;
                case 5:
                    alterarEstadoDoUsuario();
                    break;
                case 6:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("\nERRO! INSIRA UMA OPÇÃO VÁLIDA\n");
                    menuAlunos();
                    break;
            }
        }while(opcao < 1 || opcao > 6);
    }
    public static void menuProfessores(){
        System.out.println("\n-------PROFESSOR-------");
        System.out.println("1- Criar professor\n" +
                "2- Visualizar todos os professores\n" +
                "3- Visualizar um professor\n" +
                "4- Alterar o estado de um professor\n" +
                "5- Voltar\n" +
                "-----------------------");
        int opcao = -1;
        do{
            System.out.printf("Opção -> ");
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    criarProfessor();
                    break;
                case 2:
                    mostrarListaDeProfessores();
                    break;
                case 3:
                    verUmProfessor();
                    break;
                case 4:
                    alterarEstadoDoProfessor();
                    break;
                case 5:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção não existe!");
                    break;
            }
        }while(opcao < 1 || opcao > 5);
    }
    public static void menuPedagogos(){
        System.out.println("\n-------PEDAGOGO-------");
        System.out.println("1- Criar pedagogo\n" +
                "2- Visualizar todos os pedagogos\n" +
                "3- Realizar um atendimento pedagogo\n" +
                "4- Ver total de atendimentos pedagógicos realizados de um pedagogo\n" +
                "5- Voltar\n" +
                "----------------------");
        System.out.printf("Opção -> ");
        int opcao = leitor.nextInt();
        switch (opcao) {
            case 1:
                criarPedagogo();
                break;
            case 2:
                mostrarListaDePedagogos();
                break;
            case 3:
                realizarAtendimentoPedagogico();
                break;
            case 4:
                verQuantidadeDeAtendimentosPedagogo();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                System.out.println("\nERRO! INSIRA UMA OPÇÃO VÁLIDA\n");
                menuPedagogos();
                break;
        }
    }
    public static void menuLabSchool(){
        System.out.println("\n-------LAB SCHOOL-------");
        System.out.println("1- Lista de pessoas\n" +
                "2- Relatório de alunos\n" +
                "3- Relatório dos professores\n" +
                "4- Alunos com mais atendimentos pedagógicos\n" +
                "5- Pedagogos com mais atendimentos pedagógicos\n" +
                "6- Voltar\n" +
                "----------------------");
        System.out.printf("Opção -> ");
        int opcao = leitor.nextInt();
        switch (opcao) {
            case 1:
                listaDePessoas();
                break;
            case 2:
                relatorioDeAlunos();
                break;
            case 3:
                relatorioDeProfessores();
                break;
            case 4:
                maisAtendimentosPedagogicosAluno();
                //Lista de alunos com mais atendimentos pedagógicos
                break;
            case 5:
                maisAtendimentosPedagogicosPedagogo();
                //Lista de pedagogos com mais atendimentos pedagógicos
                break;
            case 6:
                menuPrincipal();
                break;
            default:
                System.out.println("\nERRO! INSIRA UMA OPÇÃO VÁLIDA\n");
                menuLabSchool();
                break;
        }
    }






    //-----------------------------ALUNO-----------------------------
    public static void criarAluno(){
        id++;
        Aluno aluno = new Aluno();
        System.out.printf("\nInsira o nome do aluno: ");
        String nome = leitor.next();
        aluno.setNome(nome);
        System.out.printf("Insira a data de nascimento do aluno: ");
        String dataDeNascimento = leitor.next();
        aluno.setDataDeNascimento(dataDeNascimento);
        System.out.printf("Insira o número de telefone do aluno: ");
        String numeroDeTelefone = leitor.next();
        aluno.setTelefone(numeroDeTelefone);
        System.out.printf("Insira o CPF do aluno: ");
        String CPF = leitor.next();
        aluno.setCPF(CPF);
        float notaDoProcesso = -1;
        while(notaDoProcesso < 0 || notaDoProcesso > 10) {
            System.out.printf("Insira a nota do processo do aluno (A nota vai de 0 a 10): ");
            notaDoProcesso = leitor.nextFloat();
        }
        aluno.setNotaDoProcesso(notaDoProcesso);
        aluno.setId(id);
        aluno.setStatus("Ativo");
        listaDeAlunos.add(aluno);
        System.out.println("Aluno criado com sucesso!");
        menuAlunos();
    }
    public static void mostrarListaDeAlunos(){
        if(listaDeAlunos.isEmpty()) {
            System.out.println("A lista está vazia! Por favor, crie um aluno antes de utilizar essa opção");
        }else{
            System.out.println("\n-------LISTA DE ALUNOS-------");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                System.out.println(listaDeAlunos.get(i).getNome());
            }
            System.out.println("-----------------------------");
        }
        menuAlunos();
    }
    public static void verUmAluno(){
        System.out.printf("\nInsira o nome do aluno que você deseja visualizar: ");
        String nomeDoAluno = leitor.next();
        boolean achou = false;
        for(int i = 0; i < listaDeAlunos.size(); i++){
            if(nomeDoAluno.equals(listaDeAlunos.get(i).getNome())) {
                System.out.println("\n-------DADOS DO ALUNO-------");
                System.out.println("Nome do aluno: " + listaDeAlunos.get(i).getNome());
                System.out.println("Número de telefone do aluno: " + listaDeAlunos.get(i).getTelefone());
                System.out.println("Data de nascimento do aluno: " + listaDeAlunos.get(i).getDataDeNascimento());
                System.out.println("CPF do aluno: " + listaDeAlunos.get(i).getCPF());
                System.out.println("Nota de processo do aluno: " + listaDeAlunos.get(i).getNotaDoProcesso());
                System.out.println("Estado atual deste usuário: " + listaDeAlunos.get(i).getStatus());
                System.out.println("-----------------------------");
                achou = true;
            }
        }
        if(achou == false){
            System.out.println("Aluno não encontrado!");
        }
        menuAlunos();
    }
    public static void verQuantidadeDeAtendimentosAluno(){
        System.out.printf("\nInsira o nome do aluno que você deseja visualizar a quantidade de atendimentos: ");
        String nomeDoAluno = leitor.next();
        boolean achou = false;
        for(int i = 0; i < listaDeAlunos.size(); i++){
            if(nomeDoAluno.equals(listaDeAlunos.get(i).getNome())){
                System.out.println("Quantidade de atendimentos deste usuário: " + listaDeAlunos.get(i).getTotalDeAtendimentos());
                achou = true;
            }
        }
        if(achou == false){
            System.out.println("Aluno não encontrado!");
        }
        menuAlunos();
    }
    public static void alterarEstadoDoUsuario(){
        System.out.printf("\nInsira o nome do aluno que você deseja alterar o estado: ");
        String nomeDoAluno = leitor.next();
        boolean achou = false;
        for(int i = 0; i < listaDeAlunos.size(); i++){
            if(nomeDoAluno.equals(listaDeAlunos.get(i).getNome())){
                System.out.println("Estado atual do usário é: " + listaDeAlunos.get(i).getStatus());
                System.out.printf("Selecione o novo estado para este usuário\n" +
                        "1- Ativo\n" +
                        "2- Irregular\n" +
                        "3- Atendimento pedagógico\n" +
                        "4- Inativo\n");
                int opcao = -1;
                do {
                    System.out.printf("Opção -> ");
                    opcao = leitor.nextInt();
                    switch(opcao) {
                        case 1:
                            listaDeAlunos.get(i).setStatus("Ativo");
                            break;
                        case 2:
                            listaDeAlunos.get(i).setStatus("Irregular");
                            break;
                        case 3:
                            listaDeAlunos.get(i).setStatus("Atendimento pedagógico");
                            break;
                        case 4:
                            listaDeAlunos.get(i).setStatus("Inativo");
                            break;
                        default:
                            System.out.println("Opção não existe!");
                            break;
                    }
                }while(opcao < 1 || opcao > 4);
                achou = true;
            }
        }
        if(achou == false){
            System.out.println("Aluno não encontrado!");
        }
        menuAlunos();
    }






    //-----------------------------PROFESSOR-----------------------------
    public static void criarProfessor(){
        id++;
        Professor professor = new Professor();
        System.out.printf("\nInsira o nome do professor: ");
        String nome = leitor.next();
        professor.setNome(nome);
        System.out.printf("Insira a data de nascimento do professor: ");
        String dataDeNascimento = leitor.next();
        professor.setDataDeNascimento(dataDeNascimento);
        System.out.printf("Insira o número de telefone do professor: ");
        String numeroDeTelefone = leitor.next();
        professor.setTelefone(numeroDeTelefone);
        System.out.printf("Insira o CPF do professor: ");
        String CPF = leitor.next();
        professor.setCPF(CPF);
        System.out.printf("Selecione a formação acadêmica do professor\n" +
                "1- Graduação incompleta\n" +
                "2- Graduação completa\n" +
                "3- Mestrado\n" +
                "4- Doutorado\n");
        int opcao = -1;
        do{
            System.out.printf("Opção -> ");
            opcao = leitor.nextInt();
            switch(opcao) {
                case 1:
                    professor.setFormacaoAcademica("Graduação incompleta");
                    break;
                case 2:
                    professor.setFormacaoAcademica("Graduação completa");
                    break;
                case 3:
                    professor.setFormacaoAcademica("Mestrado");
                    break;
                case 4:
                    professor.setFormacaoAcademica("Doutorado");
                    break;
                default:
                    System.out.println("Opção não existe!");
                    break;
            }
        }while(opcao < 1 || opcao > 4);
        System.out.printf("Selecione a experiência em desenvolvimento do professor\n" +
                "1- Front-End\n" +
                "2- Back-End\n" +
                "3- Full-Stack\n");
        int opcao2 = -1;
        do{
            System.out.printf("Opção -> ");
            opcao2 = leitor.nextInt();
            switch(opcao) {
                case 1:
                    professor.setExperiencia("Front-End");
                    break;
                case 2:
                    professor.setExperiencia("Back-End");
                    break;
                case 3:
                    professor.setExperiencia("Full-Stack");
                    break;
                default:
                    System.out.println("Opção não existe!");
                    break;
            }
        }while(opcao2 < 1 || opcao2 > 3);
        professor.setId(id);
        professor.setStatus("Ativo");
        listaDeProfessores.add(professor);
        System.out.println("Professor criado com sucesso!");
        menuProfessores();
    }
    public static void mostrarListaDeProfessores(){
        if(listaDeProfessores.isEmpty()) {
            System.out.println("A lista está vazia! Por favor, crie um professor antes de utilizar essa opção");
        }else{
            System.out.println("\n-------LISTA DE PROFESSORES-------");
            for (int i = 0; i < listaDeProfessores.size(); i++) {
                System.out.println(listaDeProfessores.get(i).getNome());
            }
            System.out.println("----------------------------------");
        }
        menuProfessores();
    }
    public static void verUmProfessor(){
        System.out.printf("\nInsira o nome do professor que você deseja visualizar: ");
        String nomeDoProfessor = leitor.next();
        boolean achou = false;
        for(int i = 0; i < listaDeProfessores.size(); i++){
            if(nomeDoProfessor.equals(listaDeProfessores.get(i).getNome())) {
                System.out.println("\n-------DADOS DO PROFESSOR-------");
                System.out.println("Nome do professor: " + listaDeProfessores.get(i).getNome());
                System.out.println("Número de telefone do professor: " + listaDeProfessores.get(i).getTelefone());
                System.out.println("Data de nascimento do professor: " + listaDeProfessores.get(i).getDataDeNascimento());
                System.out.println("CPF do professor: " + listaDeProfessores.get(i).getCPF());
                System.out.println("Formação acadêmica do professor: " + listaDeProfessores.get(i).getFormacaoAcademica());
                System.out.println("Experiência em desenvolvimento do professor: " + listaDeProfessores.get(i).getExperiencia());
                System.out.println("Estado atual deste professor: " + listaDeProfessores.get(i).getStatus());
                System.out.println("-----------------------------");
                achou = true;
            }
        }
        if(achou == false){
            System.out.println("Professor não encontrado!");
        }
        menuProfessores();
    }
    public static void alterarEstadoDoProfessor(){
        System.out.printf("\nInsira o nome do professor que você deseja alterar o estado: ");
        String nomeDoProfessor = leitor.next();
        boolean achou = false;
        for(int i = 0; i < listaDeProfessores.size(); i++){
            if(nomeDoProfessor.equals(listaDeProfessores.get(i).getNome())){
                System.out.println("Estado atual do professor é: " + listaDeProfessores.get(i).getStatus());
                System.out.println("Selecione o novo estado para este professor\n" +
                        "1- Ativo\n" +
                        "2- Irregular");
                int opcao = -1;
                do {
                    System.out.printf("Opção -> ");
                    opcao = leitor.nextInt();
                    switch(opcao) {
                        case 1:
                            listaDeProfessores.get(i).setStatus("Ativo");
                            break;
                        case 2:
                            listaDeProfessores.get(i).setStatus("Irregular");
                            break;
                        default:
                            System.out.println("Opção não existe!");
                            break;
                    }
                }while(opcao < 1 || opcao > 2);
                achou = true;
            }
        }
        if(achou == false){
            System.out.println("Professor não encontrado!");
        }
        menuProfessores();
    }




    //-----------------------------PEDAGOGOS-----------------------------
    public static void criarPedagogo(){
        id++;
        Pedagogo pedagogo = new Pedagogo();
        System.out.printf("\nInsira o nome do pedagogo: ");
        String nome = leitor.next();
        pedagogo.setNome(nome);
        System.out.printf("Insira a data de nascimento do pedagogo: ");
        String dataDeNascimento = leitor.next();
        pedagogo.setDataDeNascimento(dataDeNascimento);
        System.out.printf("Insira o número de telefone do pedagogo: ");
        String numeroDeTelefone = leitor.next();
        pedagogo.setTelefone(numeroDeTelefone);
        System.out.printf("Insira o CPF do pedagogo: ");
        String CPF = leitor.next();
        pedagogo.setCPF(CPF);
        pedagogo.setId(id);
        listaDePedagogos.add(pedagogo);
        System.out.println("Pedagogo criado com sucesso!");
        menuPedagogos();
    }
    public static void mostrarListaDePedagogos(){
        if(listaDePedagogos.isEmpty()) {
            System.out.println("A lista está vazia! Por favor, crie um pedagogo antes de utilizar essa opção");
        }else{
            System.out.println("\n-------LISTA DE PEDAGOGOS-------");
            for (int i = 0; i < listaDePedagogos.size(); i++) {
                System.out.println(listaDePedagogos.get(i).getNome());
            }
            System.out.println("-----------------------------");
        }
        menuPedagogos();
    }
    public static void realizarAtendimentoPedagogico(){
        System.out.printf("\nInsira o nome do pedagogo que irá realizar o atendimento: ");
        String nomeDoPedagogo = leitor.next();
        boolean achouPedagogo = false;
        for(int i = 0; i < listaDePedagogos.size(); i++){
            if(nomeDoPedagogo.equals(listaDePedagogos.get(i).getNome())) {
                achouPedagogo = true;
            }
        }
        System.out.printf("Insira o nome do aluno que receberá o atendimento pedagógico: ");
        String nomeDoAluno = leitor.next();
        boolean achouAluno = false;
        for(int i = 0; i < listaDeAlunos.size(); i++){
            if(nomeDoAluno.equals(listaDeAlunos.get(i).getNome())) {
                achouAluno = true;
            }
        }
        if(achouAluno == true && achouPedagogo == true){
            for(int i = 0; i < listaDeAlunos.size(); i++){
                if(nomeDoAluno.equals(listaDeAlunos.get(i).getNome())) {
                    listaDeAlunos.get(i).setTotalDeAtendimentos(listaDeAlunos.get(i).getTotalDeAtendimentos()+1);
                }
            }
            for(int i = 0; i < listaDePedagogos.size(); i++){
                if(nomeDoPedagogo.equals(listaDePedagogos.get(i).getNome())) {
                    listaDePedagogos.get(i).setTotalDeAtendimentos(listaDePedagogos.get(i).getTotalDeAtendimentos()+1);
                }
            }
            System.out.println("Atendimento pedagógico realizado com sucesso!");
        }else if(achouAluno == false && achouPedagogo == false){
            System.out.println("Aluno e pedagogo não encontrado!");
        }
        else if(achouAluno == false){
            System.out.println("Aluno não encontrado!");
        }else if(achouPedagogo == false) {
            System.out.println("Pedagogo não encontrado!");
        }
        menuPedagogos();
    }
    public static void verQuantidadeDeAtendimentosPedagogo(){
        System.out.printf("\nInsira o nome do pedagogo que você deseja visualizar a quantidade de atendimentos: ");
        String nomeDoPedagogo = leitor.next();
        boolean achou = false;
        for(int i = 0; i < listaDePedagogos.size(); i++){
            if(nomeDoPedagogo.equals(listaDePedagogos.get(i).getNome())){
                System.out.println("Quantidade de atendimentos deste pedagogo: " + listaDePedagogos.get(i).getTotalDeAtendimentos());
                achou = true;
            }
        }
        if(achou == false){
            System.out.println("Pedagogo não encontrado!");
        }
        menuPedagogos();
    }


    //-----------------------------FUNCIONARIOS-----------------------------
    public static void mostrarListaDeFuncionarios(){
        boolean temPedagogo = false;
        if(!listaDePedagogos.isEmpty()) {
            temPedagogo = true;
        }
        boolean temProfessor = false;
        if(!listaDeProfessores.isEmpty()) {
            temProfessor = true;
        }
        if(!temPedagogo && !temProfessor){
            System.out.println("Não existem funcionários!");
        }else{
            System.out.println("\n-------LISTA DE FUNCIONARIOS-------");
            for (int i = 0; i < listaDePedagogos.size(); i++) {
                System.out.println(listaDePedagogos.get(i).getNome() + " (Pedagogo), código identificador: " + listaDePedagogos.get(i).getId() + ", CPF: " + listaDePedagogos.get(i).getCPF());
            }
            for (int i = 0; i < listaDeProfessores.size(); i++) {
                System.out.println(listaDeProfessores.get(i).getNome() + " (Professor) , código identificador: " + listaDeProfessores.get(i).getId() + ", CPF: " + listaDeProfessores.get(i).getCPF());
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }

    //-----------------------------LAB SCHOOL-----------------------------
    public static void mostrarListaDeAlunosLabSchool(){
        if(listaDeAlunos.isEmpty()) {
            System.out.println("A lista está vazia! Por favor, crie um aluno antes de utilizar essa opção");
        }else{
            System.out.println("\n-------LISTA DE ALUNOS-------");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                System.out.println(listaDeAlunos.get(i).getNome() + ", código identificador: " + listaDeAlunos.get(i).getId() + ", CPF: " + listaDeAlunos.get(i).getCPF());
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
    public static void mostrarListaDeProfessoresLabSchool(){
        if(listaDeProfessores.isEmpty()) {
            System.out.println("A lista está vazia! Por favor, crie um professor antes de utilizar essa opção");
        }else{
            System.out.println("\n-------LISTA DE PROFESSORES-------");
            for (int i = 0; i < listaDeProfessores.size(); i++) {
                System.out.println(listaDeProfessores.get(i).getNome() + ", código identificador: " + listaDeProfessores.get(i).getId() + ", CPF: " + listaDeProfessores.get(i).getCPF());
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
    public static void mostrarListaGeral(){
        boolean temAluno = false;
        if(!listaDeAlunos.isEmpty()){
            temAluno = true;
        }
        boolean temPedagogo = false;
        if(!listaDePedagogos.isEmpty()) {
            temPedagogo = true;
        }
        boolean temProfessor = false;
        if(!listaDeProfessores.isEmpty()) {
            temProfessor = true;
        }
        if(!temPedagogo && !temProfessor && !temAluno){
            System.out.println("Não existem usuários!");
        }else{
            System.out.println("\n-------LISTA DE PESSOAS-------");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                System.out.println(listaDeAlunos.get(i).getNome() + " (Aluno), código identificador: " + listaDeAlunos.get(i).getId() + ", CPF: " + listaDeAlunos.get(i).getCPF());
            }
            for (int i = 0; i < listaDePedagogos.size(); i++) {
                System.out.println(listaDePedagogos.get(i).getNome() + " (Pedagogo), código identificador: " + listaDePedagogos.get(i).getId() + ", CPF: " + listaDePedagogos.get(i).getCPF());
            }
            for (int i = 0; i < listaDeProfessores.size(); i++) {
                System.out.println(listaDeProfessores.get(i).getNome() + " (Professor), código identificador: " + listaDeProfessores.get(i).getId() + ", CPF: " + listaDeProfessores.get(i).getCPF());
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
    public static void listaDePessoas(){
        System.out.println("\nEscolha o tipo de usuário\n" +
                "1- Aluno\n" +
                "2- Professores\n" +
                "3- Funcionarios\n" +
                "4- Todos");
        int opcao = -1;
        do {
            System.out.printf("Opção -> ");
            opcao = leitor.nextInt();
            switch(opcao) {
                case 1:
                    mostrarListaDeAlunosLabSchool();
                    break;
                case 2:
                    mostrarListaDeProfessoresLabSchool();
                    break;
                case 3:
                    mostrarListaDeFuncionarios();
                    break;
                case 4:
                    mostrarListaGeral();
                    break;
                default:
                    System.out.println("Opção não existe!");
                    break;
            }
        }while(opcao < 1 || opcao > 4);
    }
    public static void mostrarListaDeAlunosAtivos(){
        boolean temAluno = false;
        if(!listaDeAlunos.isEmpty()){
            temAluno = true;
        }
        if(!temAluno){
            System.out.println("Não existem alunos ativos!");
        }else{
            System.out.println("\n-------LISTA DE ALUNOS ATIVOS-------");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                if(listaDeAlunos.get(i).getStatus().equals("Ativo")){
                    System.out.println("Aluno: " + listaDeAlunos.get(i).getNome() + ", código identificador: " + listaDeAlunos.get(i).getId() + ", nota: " + listaDeAlunos.get(i).getNotaDoProcesso() + ", total de atendimentos pedagógicos: " + listaDeAlunos.get(i).getTotalDeAtendimentos());
                }
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
    public static void mostrarListaDeAlunosIrregulares(){
        boolean temAluno = false;
        if(!listaDeAlunos.isEmpty()){
            temAluno = true;
        }
        if(!temAluno){
            System.out.println("Não existem alunos irregulares!");
        }else{
            System.out.println("\n-------LISTA DE ALUNOS IRREGULARES-------");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                if(listaDeAlunos.get(i).getStatus().equals("Irregular")){
                    System.out.println("Aluno: " + listaDeAlunos.get(i).getNome() + ", código identificador: " + listaDeAlunos.get(i).getId() + ", nota: " + listaDeAlunos.get(i).getNotaDoProcesso() + ", total de atendimentos pedagógicos: " + listaDeAlunos.get(i).getTotalDeAtendimentos());
                }
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
    public static void mostrarListaDeAlunosAtendimentoPedagogico(){
        boolean temAluno = false;
        if(!listaDeAlunos.isEmpty()){
            temAluno = true;
        }
        if(!temAluno){
            System.out.println("Não existem alunos em atendimento pedagógico!");
        }else{
            System.out.println("\n-------LISTA DE ALUNOS ATIVOS-------");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                if(listaDeAlunos.get(i).getStatus().equals("Atendimento pedagógico")){
                    System.out.println("Aluno: " + listaDeAlunos.get(i).getNome() + ", código identificador: " + listaDeAlunos.get(i).getId() + ", nota: " + listaDeAlunos.get(i).getNotaDoProcesso() + ", total de atendimentos pedagógicos: " + listaDeAlunos.get(i).getTotalDeAtendimentos());
                }
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
    public static void mostrarListaDeAlunosInativos(){
        boolean temAluno = false;
        if(!listaDeAlunos.isEmpty()){
            temAluno = true;
        }
        if(!temAluno){
            System.out.println("Não existem alunos inativos!");
        }else{
            System.out.println("\n-------LISTA DE ALUNOS INATIVOS-------");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                if(listaDeAlunos.get(i).getStatus().equals("Inativo")){
                    System.out.println("Aluno: " + listaDeAlunos.get(i).getNome() + ", código identificador: " + listaDeAlunos.get(i).getId() + ", nota: " + listaDeAlunos.get(i).getNotaDoProcesso() + ", total de atendimentos pedagógicos: " + listaDeAlunos.get(i).getTotalDeAtendimentos());
                }
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
    public static void mostrarListaDeTodosOsAlunos() {
        boolean temAluno = false;
        if (!listaDeAlunos.isEmpty()) {
            temAluno = true;
        }
        if (!temAluno) {
            System.out.println("Não existem alunos!");
        } else {
            System.out.println("\n-------LISTA DE TODOS ALUNOS-------");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                System.out.println("Aluno: " + listaDeAlunos.get(i).getNome() + ", código identificador: " + listaDeAlunos.get(i).getId() + ", nota: " + listaDeAlunos.get(i).getNotaDoProcesso() + ", total de atendimentos pedagógicos: " + listaDeAlunos.get(i).getTotalDeAtendimentos());
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
    public static void relatorioDeAlunos(){
        System.out.println("\nEscolha o tipo de aluno\n" +
                "1- Ativo\n" +
                "2- Irregular\n" +
                "3- Atendimento pedagógico\n" +
                "4- Inativo\n" +
                "5- Todos");
        int opcao = -1;
        do {
            System.out.printf("Opção -> ");
            opcao = leitor.nextInt();
            switch(opcao) {
                case 1:
                    mostrarListaDeAlunosAtivos();
                    break;
                case 2:
                    mostrarListaDeAlunosIrregulares();
                    break;
                case 3:
                    mostrarListaDeAlunosAtendimentoPedagogico();
                    break;
                case 4:
                    mostrarListaDeAlunosInativos();
                    break;
                case 5:
                    mostrarListaDeTodosOsAlunos();
                    break;
                default:
                    System.out.println("Opção não existe!");
                    break;
            }
        }while(opcao < 1 || opcao > 5);
    }
    public static void mostrarListaDeProfessoresFrontEnd(){
        boolean temProfessor = false;
        boolean temProfessorFrontEnd = false;
        if(!listaDeProfessores.isEmpty()){
            temProfessor = true;
        }
        if(!temProfessor){
            System.out.println("Não existem professores!");
        }
        for (int i = 0; i < listaDeProfessores.size(); i++) {
            if(listaDeProfessores.get(i).getExperiencia().equals("Front-End")){
                System.out.println(listaDeProfessores.get(i).getNome());
                temProfessorFrontEnd = true;
            }
        }
        if(!temProfessorFrontEnd){
            System.out.println("Não existem professores com formação em front-end!");
        }else{
            System.out.println("\n-------LISTA DE PROFESSORES COM FORMAÇÃO EM FRONT-END-------");
            for (int i = 0; i < listaDeProfessores.size(); i++) {
                if(listaDeProfessores.get(i).getExperiencia().equals("Front-End")){
                    System.out.println(listaDeProfessores.get(i).getNome());
                }
            }
            System.out.println("------------------------------------------------------------");
        }
        menuLabSchool();
    }

    public static void mostrarListaDeProfessoresBackEnd(){
        boolean temProfessor = false;
        boolean temProfessorBackEnd = false;
        if(!listaDeProfessores.isEmpty()){
            temProfessor = true;
        }
        if(!temProfessor){
            System.out.println("Não existem professores!");
        }
        for (int i = 0; i < listaDeProfessores.size(); i++) {
            if(listaDeProfessores.get(i).getExperiencia().equals("Back-End")){
                System.out.println(listaDeProfessores.get(i).getNome());
                temProfessorBackEnd = true;
            }
        }
        if(!temProfessorBackEnd){
            System.out.println("Não existem professores com formação em back-end!");
        }else{
            System.out.println("\n-------LISTA DE PROFESSORES COM FORMAÇÃO EM BACK-END-------");
            for (int i = 0; i < listaDeProfessores.size(); i++) {
                if(listaDeProfessores.get(i).getExperiencia().equals("Back-End")){
                    System.out.println(listaDeProfessores.get(i).getNome());
                }
            }
            System.out.println("------------------------------------------------------------");
        }
        menuLabSchool();
    }
    public static void mostrarListaDeProfessoresFullStack(){
        boolean temProfessor = false;
        boolean temProfessorFullStack = false;
        if(!listaDeProfessores.isEmpty()){
            temProfessor = true;
        }
        if(!temProfessor){
            System.out.println("Não existem professores!");
        }
        for (int i = 0; i < listaDeProfessores.size(); i++) {
            if(listaDeProfessores.get(i).getExperiencia().equals("Full-Stack")){
                System.out.println(listaDeProfessores.get(i).getNome());
                temProfessorFullStack = true;
            }
        }
        if(!temProfessorFullStack){
            System.out.println("Não existem professores com formação full-stack!");
        }else{
            System.out.println("\n-------LISTA DE PROFESSORES COM FORMAÇÃO FULL-STACK-------");
            for (int i = 0; i < listaDeProfessores.size(); i++) {
                if(listaDeProfessores.get(i).getExperiencia().equals("Full-Stack")){
                    System.out.println(listaDeProfessores.get(i).getNome());
                }
            }
            System.out.println("------------------------------------------------------------");
        }
        menuLabSchool();
    }
    public static void mostrarListaDeTodosOsProfessores() {
        boolean temProfessor = false;
        if (!listaDeProfessores.isEmpty()) {
            temProfessor = true;
        }
        if (!temProfessor) {
            System.out.println("Não existem professores!");
        } else {
            System.out.println("\n-------LISTA DE TODOS PROFESSORES-------");
            for (int i = 0; i < listaDeProfessores.size(); i++) {
                System.out.println(listaDeProfessores.get(i).getNome());
            }
            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
    public static void relatorioDeProfessores(){
        System.out.println("\nEscolha o tipo de formação do professor\n" +
                "1- Front-End\n" +
                "2- Back-End\n" +
                "3- Full-Stack\n" +
                "4- Todos");
        int opcao = -1;
        do {
            System.out.printf("Opção -> ");
            opcao = leitor.nextInt();
            switch(opcao) {
                case 1:
                    mostrarListaDeProfessoresFrontEnd();
                    break;
                case 2:
                    mostrarListaDeProfessoresBackEnd();
                    break;
                case 3:
                    mostrarListaDeProfessoresFullStack();
                    break;
                case 4:
                    mostrarListaDeTodosOsProfessores();
                    break;
                default:
                    System.out.println("Opção não existe!");
                    break;
            }
        }while(opcao < 1 || opcao > 4);
    }
    public static void maisAtendimentosPedagogicosAluno(){
        boolean temAluno = false;
        if (!listaDeAlunos.isEmpty()) {
            temAluno = true;
        }
        if (!temAluno) {
            System.out.println("Não existem alunos!");
        } else {
            System.out.println("\n-------LISTA DE ALUNOS COM MAIS ATENDIMENTOS PEDAGOGICOS-------");

            Collections.sort(listaDeAlunos, new Comparator<Aluno>() {
                public int compare(Aluno a1, Aluno a2) {
                    return Integer.valueOf(a2.getTotalDeAtendimentos()).compareTo(a1.getTotalDeAtendimentos());
                }
            });

            for(int i = 0; i < listaDeAlunos.size(); i++){
                System.out.println("Aluno: " + listaDeAlunos.get(i).getNome() + ", quantidade de atendimentos: " + listaDeAlunos.get(i).getTotalDeAtendimentos());
            }

            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }

    public static void maisAtendimentosPedagogicosPedagogo(){
        boolean temPedagogo = false;
        if (!listaDePedagogos.isEmpty()) {
            temPedagogo = true;
        }
        if (!temPedagogo) {
            System.out.println("Não existem pedagogos!");
        } else {
            System.out.println("\n-------LISTA DE PEDAGOGOS COM MAIS ATENDIMENTOS PEDAGOGICOS-------");

            Collections.sort(listaDePedagogos, new Comparator<Pedagogo>() {
                public int compare(Pedagogo p1, Pedagogo p2) {
                    return Integer.valueOf(p2.getTotalDeAtendimentos()).compareTo(p1.getTotalDeAtendimentos());
                }
            });

            for(int i = 0; i < listaDePedagogos.size(); i++){
                System.out.println("Pedagogo: " + listaDePedagogos.get(i).getNome() + ", quantidade de atendimentos: " + listaDePedagogos.get(i).getTotalDeAtendimentos());
            }

            System.out.println("-----------------------------");
        }
        menuLabSchool();
    }
}