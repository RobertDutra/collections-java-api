package Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalagoLivros {

    List<Livro> livros;

    public CatalagoLivros() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        Livro livro = new Livro(titulo, autor, anoPublicacao);
        livros.add(livro);
    }

    public void pesquisarPorAutor(String autor){
        List<Livro> autorList = new ArrayList<>();
        
        if (!livros.isEmpty()){
            for (Livro l : livros) {
                if (l.getAutor().equalsIgnoreCase(autor)){
                    autorList.add(l);
                }
            }
            System.out.println("Lista do autor(a) "+ autor + " " + autorList);
        }else {
            System.out.println("Lista vazia!");
        }
    }

    public void exibirLivros(){
        System.out.println(livros);
    }

    public void pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){

        List<Livro> livrosAnos = new ArrayList<>();

        if (!livros.isEmpty()){
            for (Livro l: livros) {
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal ) {
                    livrosAnos.add(l);
                }
            }
            if (livrosAnos.isEmpty()){
                System.out.println("Não foi encontrado livros no intervalo de tempo entre " + anoInicial + " e " + anoFinal + ".");
            }else {
                System.out.println("Lista por intervalo de anos entre " + anoInicial + " e " + anoFinal + " : " + livrosAnos);
            }
        }else {
            System.out.println("Lista vazia!");
        }
    }

    public void pesquisarPorTitulo(String titulo){
        Livro livro = new Livro();
        boolean test = false;

        if (!livros.isEmpty()){
            for (Livro l : livros) {
                if (l.getTitulo().equalsIgnoreCase(titulo)){
                    livro = l;
                    test = true;
                    break;
                }
            }
            if (test){
                System.out.println("Livros com o título '"+ titulo + "' = " +livro);
            }else {
                System.out.println("Não á título com esse nome: " + titulo);
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public static void main(String[] args) {
        CatalagoLivros catalagoLivros = new CatalagoLivros();

        catalagoLivros.adicionarLivro("Fogo e gelo", "Robert", 2019);
        catalagoLivros.adicionarLivro("Fogo", "Robert", 2024);
        catalagoLivros.adicionarLivro("Gelo", "Kiara", 2020);

        catalagoLivros.exibirLivros();

        catalagoLivros.pesquisarPorAutor("kiara");

        catalagoLivros.pesquisarPorIntervaloAnos(2018, 2025);

        catalagoLivros.pesquisarPorTitulo("gelo");

    }
}
