package avaliacao2;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Boolean.*;

/**
 * @author Leandro Prazeres Coelho - RU 3867885
 * @version 1.0
 * OBS.: Foi extraido as classes "Pessoa" e "Aluno" para arquivos separados.
 */

public class LeandroCoelho {
    Scanner sc;
    ArrayList<Aluno> alunos;
    private String nomeArquivo;

    public LeandroCoelho() {
        sc = new Scanner(System.in);
        alunos = new ArrayList<>();
        String nomeArquivo = "classeDeAlunos.txt";

        inicializaArquivo(nomeArquivo);

        try {
            this.load(nomeArquivo);
        } catch (FileNotFoundException error) {
            System.out.println("Arquivo não encontrado. Erro: " + error);
        }
    }

    public static void main(String[] args) {
        LeandroCoelho leandro = new LeandroCoelho();
        leandro.metodo01();
        leandro.metodo02();
        leandro.metodo03();
    }

    /**
     * Metodo de leitura dos alunos
     */
    private void metodo01() {

        boolean opcao = TRUE;
        while (opcao) {
            Aluno aluno = new Aluno();

            System.out.println("CADASTRO DE NOVO ALUNO");

            System.out.println("NOME do aluno: ");
            aluno.setNome(sc.nextLine());

            System.out.println("CPF do aluno: ");
            aluno.setCpf(sc.nextLine());

            System.out.println("MATRICULA do aluno: ");
            aluno.setMatricula(sc.nextLine());

            System.out.println("DISCIPLINA do aluno: ");
            aluno.setDisciplina(sc.nextLine());

            System.out.println("NOTA do aluno: ");
            aluno.setNota(sc.nextFloat());
            //sem este nextLine estava pulando linha no Loop
            sc.nextLine();

            alunos.add(aluno);
            String op = "";
            // Verifica se o usuário digitou as opções corretas.
            while (!op.equalsIgnoreCase("s") && !op.equalsIgnoreCase("n")) {
                System.out.println("Deseja cadastrar mais um aluno? (S ou N)");
                op = sc.nextLine();

                opcao = op.equalsIgnoreCase("s") ? TRUE : FALSE;
            }
        }
        try {
            this.save("classeDeAlunos.txt");
        } catch (FileNotFoundException error) {
            System.out.println("Não foi possivel gravar o arquivo. Erro: \n" + error);
        }
    }

    /**
     * Metodo que Escreve os alunos APROVADOS
     */
    private void metodo02() {
        System.out.println("Alunos APROVADOS");
        for (Aluno a : alunos) {
            if (a.getNota() >= 7.0) {
                NumberFormat formatarFloat = new DecimalFormat("0.00");
                System.out.printf("CPF: %s \t|\t Nome: %s \t|\t Matricula: %s \t|\t Disciplina: %s \t|\t Nota: %s\n", a.getCpf(), a.getNome(), a.getMatricula(), a.getDisciplina(), formatarFloat.format(a.getNota()));
            }
        }

    }

    /**
     * Metodo que Escreve os alunos REPROVADOS
     */
    private void metodo03() {
        System.out.println("Alunos REPROVADOS");
        for (Aluno a : alunos) {
            if (a.getNota() < 7.0) {
                NumberFormat formatarFloat = new DecimalFormat("0.00");
                System.out.printf("CPF: %s \t|\t Nome: %s \t|\t Matricula: %s \t|\t Disciplina: %s \t|\t Nota: %s\n", a.getCpf(), a.getNome(), a.getMatricula(), a.getDisciplina(), formatarFloat.format(a.getNota()));
            }
        }

    }

    public void save(String fileName) throws FileNotFoundException {
        FileOutputStream fout = new FileOutputStream(fileName);
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(fout);
            oos.writeObject(alunos);
            fout.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void load(String fileName) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(fin);
            alunos = (ArrayList<Aluno>) ois.readObject();
            fin.close();

        } catch (IOException | ClassNotFoundException error) {
            error.printStackTrace();
        }
    }

    /**
     * Este metodo verifica se o arquivo inicialmente existe. Caso não exista ele cria o arquivo, caso exista ele não zera o mesmo.
     *
     * @param nomeArquivo (String) nome do arquivo que será salvo.       Exemplo: "alunos.txt"
     */
    private void inicializaArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        try {
            if (!new File(this.nomeArquivo).exists()) {
                save(this.nomeArquivo);
            }

        } catch (FileNotFoundException error) {
            System.out.println("Não foi possivel salvar o arquivo. Erro: " + error);
        }
    }
}