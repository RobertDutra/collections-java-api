package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {

    private List<Pessoa> pessoaList;

    public OrdenacaoPessoas() {
        this.pessoaList = new ArrayList<>();
    }

    private void adicionarPessoa(String nome, int idade, double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    private void ordenarPorIdade(){
        Collections.sort(pessoaList);
    }

    private void ordenarPorAltura(){
        pessoaList.sort(new PessoaPorAlturaComparator());
    }

    private void exibirPessoas(){
        for (Pessoa p :
                pessoaList) {
            System.out.println("Nome: " + p.getNome() + ", Idade: " + p.getIdade() + ", Altura: " + p.getAltura() + ".");
        };
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Lucas", 19, 1.65d);
        ordenacaoPessoas.adicionarPessoa("Roberta", 34, 1.55d);
        ordenacaoPessoas.adicionarPessoa("Cris", 15, 1.76d);
        ordenacaoPessoas.adicionarPessoa("Kiara", 32, 1.92d);
        System.out.println("Lista não ordenada");
        ordenacaoPessoas.exibirPessoas();
        System.out.println();
        System.out.println("Lista ordenada por idade");
        ordenacaoPessoas.ordenarPorIdade();
        ordenacaoPessoas.exibirPessoas();
        System.out.println();
        System.out.println("Lista ordenada por altura");
        ordenacaoPessoas.ordenarPorAltura();
        ordenacaoPessoas.exibirPessoas();

    }
}
