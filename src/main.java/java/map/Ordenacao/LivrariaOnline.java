package map.Ordenacao;

import exception.ListEmptyException;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livroMap.put(link, new Livro(titulo, autor, preco));
    }
    public void removerLivro(String titulo){
        Livro livro = null;
        if (!livroMap.isEmpty()){
            for (Map.Entry<String, Livro> entry : livroMap.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    livroMap.remove(entry.getKey(), entry.getValue());
                    System.out.println("Livro '" + entry.getValue().getTitulo() +  "' removido!");
                    livro = entry.getValue();
                    break;
                }
            }
            if (livro == null){
                System.out.println("Livro com título '" + titulo + "' não presente no conjunto!");
            }
        }
        else{
            System.out.println("Conjuntos de livros vázios!");
        }
    }

    public void exibirLivros(){
        if (!livroMap.isEmpty()){
            System.out.println(livroMap);
        }
        else {
            System.out.println("Conjuntos de livros vázios!");
        }
    }
    public void exibirLivrosOrdenadosPorPreco(){
        if (!livroMap.isEmpty()){
            List<Map.Entry<String, Livro>> livroPropreco = new ArrayList<>(livroMap.entrySet());
            livroPropreco.sort(Comparator.comparing(entry -> entry.getValue().getValor()));
            Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();
            for (Map.Entry<String, Livro> entry : livroPropreco) {
                livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
            }
            System.out.println(livrosOrdenadosPorPreco);
        }
        else {
            System.out.println("Conjuntos de livros vázios!");
        }
    }

    public List<Livro> pesquisarLivrosPorAutor(String autor) throws ListEmptyException {
        List<Livro> listaLivros = new ArrayList<>();
        if (!livroMap.isEmpty()){
            for (Livro l : livroMap.values()) {
                if (l.getAutor().equalsIgnoreCase(autor)){
                    listaLivros.add(l);
                }
            }
            return listaLivros;
        } else {
            throw new ListEmptyException("Conjuntos de livros vázios!");
        }
    }

    public Livro obterLivroMaisCaro() throws ListEmptyException {
        Livro livroMaisCaro = null;
        double maiorValor = 0;
        if (!livroMap.isEmpty()){
            for (Livro l : livroMap.values()) {
                if (l.getValor() > maiorValor){
                    maiorValor = l.getValor();
                    livroMaisCaro = l;
                }
            }
            return livroMaisCaro;
        }else {
            throw new ListEmptyException("Conjunto de livros vázios!");
        }
    }

    public Livro exibirLivroMaisBarato() throws ListEmptyException {
        Livro livroMaisBarato = null;
        double menorValor = Double.MAX_VALUE;
        if (!livroMap.isEmpty()){
            for (Livro l : livroMap.values()) {
                if (l.getValor() < menorValor){
                    menorValor = l.getValor();
                    livroMaisBarato = l;
                }
            }
            return livroMaisBarato;
        }else {
            throw new ListEmptyException("Conjuntos de livros vázios!");
        }
    }

    public static void main(String[] args) throws ListEmptyException {

        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("42425", "Gelo e fogo", "Geoger", 79d);
        livrariaOnline.adicionarLivro("54745", "Crises", "Lucas", 56d);
        livrariaOnline.adicionarLivro("96786", "Fogo", "Gregorio", 99d);
        livrariaOnline.adicionarLivro("89768", "Gelo", "Gregorio", 34d);
        livrariaOnline.adicionarLivro("645646", "AAAA", "Alex", 23d);

        livrariaOnline.exibirLivros();
        livrariaOnline.exibirLivrosOrdenadosPorPreco();
        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());
        System.out.println("Lista por autor: " + livrariaOnline.pesquisarLivrosPorAutor("gregorio"));
        livrariaOnline.removerLivro("Fogo");
        livrariaOnline.exibirLivros();
    }

}
