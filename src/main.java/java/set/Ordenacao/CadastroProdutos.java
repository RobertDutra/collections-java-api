package set.Ordenacao;

import exception.ListEmptyException;

import java.util.*;

public class CadastroProdutos {
    Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(nome, cod, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() throws ListEmptyException {
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        if (!produtoSet.isEmpty()){
            return produtosPorNome;
        }else {
            throw new ListEmptyException("Conjuntos de produtos vázio!");
        }
        
    }

    public Set<Produto>  exibirProdutosPorPreco() throws ListEmptyException {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ProdutoPoPreco());
        if (!produtoSet.isEmpty()){
            produtosPorPreco.addAll(produtoSet);
            return produtosPorPreco;
        }else {
            throw new ListEmptyException("Conjuntos de produtos vázio!");
        }

    }

    public void exibirProdutos(){
        if (!produtoSet.isEmpty()){
            System.out.println(produtoSet);
        }else{
            System.out.println("Conjuntos de produtos vázio!");
        }
    }

    public static void main(String[] args) throws ListEmptyException {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "calça", 243.99, 4);
        cadastroProdutos.adicionarProduto(2L, "camisa", 69.99, 4);
        cadastroProdutos.adicionarProduto(3L, "bermuda", 49.99, 4);
        cadastroProdutos.adicionarProduto(4L, "anel", 499.99, 2);
        cadastroProdutos.exibirProdutos();
        System.out.println(cadastroProdutos.exibirProdutosPorNome());
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());

    }
}
