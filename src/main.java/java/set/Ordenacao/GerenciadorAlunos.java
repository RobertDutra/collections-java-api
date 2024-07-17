package set.Ordenacao;

import exception.ListEmptyException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    private void adicionarAluno(String nome, Long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    private void removerAluno(Long matricula){
        boolean presente = false;
        if(!alunoSet.isEmpty()){
            alunoSet.removeIf(a -> a.getMatricula().equals(matricula));
//            for (Aluno a : alunoSet) {
//                if (a.getMatricula().equals(matricula)){
//                    alunoSet.remove(a);
//                    break;
//
//                }
////                else {
////                    System.out.println("Não á aluno presente com a matrícula: " + matricula);
////                    break;
////                }
//            }

        }else {
            System.out.println("Conjunto de alunos vázio!");
        }


    }

    private Set<Aluno> exibirAlunosPorNome() throws ListEmptyException {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        if (!alunoSet.isEmpty()){
            return alunosPorNome;
        }else{
            throw new ListEmptyException("Conjunto de alunos vázio!");
        }
    }

    private Set<Aluno> exibirAlunosPorNota() throws ListEmptyException {
        Set<Aluno> alunosPorNota = new TreeSet<>(new AlunosPorNota());
        if (!alunoSet.isEmpty()){
            alunosPorNota.addAll(alunoSet);
            return alunosPorNota;
        }else{
            throw new ListEmptyException("Conjunto de alunos vázio!");
        }
    }

    private void exibirAlunos(){
        if (!alunoSet.isEmpty()){
            System.out.println(alunoSet);
        }else{
            System.out.println("Conjunto de alunos vázio!");
        }
    }

    public static void main(String[] args) throws ListEmptyException {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Ricardo", 12124L, 6);
        gerenciadorAlunos.adicionarAluno("Alex", 62786L, 6);
        gerenciadorAlunos.adicionarAluno("Olivia", 26666L, 8);
        gerenciadorAlunos.adicionarAluno("Lucas", 53252L, 9);
        gerenciadorAlunos.adicionarAluno("Aber", 552522L, 10);
        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.removerAluno(26666L);

        gerenciadorAlunos.exibirAlunos();

        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());

    }
}
