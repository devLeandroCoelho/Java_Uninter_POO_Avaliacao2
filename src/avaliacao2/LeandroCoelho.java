package avaliacao2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    String cpf;
    String nome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Aluno extends Pessoa {
    String matricula;
    String disciplinas;

    String nota;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}

public class LeandroCoelho {
    Scanner sc = null;
    ArrayList<Aluno> alunos;



    public LeandroCoelho() {
        sc = new Scanner(System.in);
        alunos = new ArrayList<Aluno>();
// deve chamar o método para ler dados de arquivo
    }

    public static void main(String[] args) {
        avaliacao2.LeandroCoelho leandro = new avaliacao2.LeandroCoelho();
        leandro.metodo01();
        leandro.metodo02();
        leandro.metodo03();
    }

    public void metodo01() {
        /* Deve questionar a entrada de dados de CPF(Pessoa), nome(Pessoa),
         * matricula (Aluno) , disciplinas(Aluno), nota (Aluno)
         *
         */
// deve chamar o método para salvar em um arquivo
    }

    public void metodo02() {
        /* Deve listar os dados lista
         * Deve imprimir quem está aprovado
         */
    }

    public void metodo03() {
        /* Deve listar os dados lista
         * Deve imprimir quem está reprovado
         */
    }

    public void save(String fileName) throws FileNotFoundException {
        FileOutputStream fout = new FileOutputStream(fileName);
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(fout);
            oos.writeObject(alunos);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(fin);
            alunos = (ArrayList<Aluno>) ois.readObject();
            fin.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}