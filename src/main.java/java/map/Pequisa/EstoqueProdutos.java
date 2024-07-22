package map.Pequisa;

import exception.ListEmptyException;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> produtoMap;

    public EstoqueProdutos() {
        produtoMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        produtoMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        System.out.println(produtoMap);
    }

    public double calcularValorTotalEstoque() throws ListEmptyException {
        double totalProdutos = 0d;
        if (!produtoMap.isEmpty()){
            for (Produto p: produtoMap.values()) {
                totalProdutos += p.getPreco() * p.getQuantidade();
            }
            return totalProdutos;
        }else {
            throw new ListEmptyException("Conjunto de produtos vázio!");
        }
    }

    public Produto obterProdutoMaisCaro() throws ListEmptyException {
        double maisCaro = Double.MIN_VALUE;
        Produto produtoMaisCaro = null;
        if (!produtoMap.isEmpty()){
            for (Produto p: produtoMap.values()) {
                if (p.getPreco() > maisCaro){
                    maisCaro = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
            return produtoMaisCaro;
        }else {
            throw new ListEmptyException("Conjunto de produtos vázio!");
        }

    }

    public Produto obterProdutoMaisBarato() throws ListEmptyException {
        double maisBarato = Double.MAX_VALUE;
        Produto produtoMaisBarato = null;
        if (!produtoMap.isEmpty()){
            for (Produto p: produtoMap.values()) {
                if (p.getPreco() < maisBarato){
                    maisBarato = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
            return produtoMaisBarato;
        }else {
            throw new ListEmptyException("Conjunto de produtos vázio!");
        }

    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() throws ListEmptyException {
        Produto produtoMaiorValor = null;
        double maiorValorTotalProdutoEstoque  = 0;
        if (!produtoMap.isEmpty()){
            for (Map.Entry<Long, Produto> p: produtoMap.entrySet()) {
                double produtoTotal = p.getValue().getPreco() * p.getValue().getQuantidade();
                if (produtoTotal > maiorValorTotalProdutoEstoque ){
                    maiorValorTotalProdutoEstoque  = produtoTotal;
                    produtoMaiorValor = p.getValue();
                }
            }
            return produtoMaiorValor;
        }else {
            throw new ListEmptyException("Conjunto de produtos vázio!");
        }
    }

    public static void main(String[] args) throws ListEmptyException {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Celular", 2, 1500d);
        estoqueProdutos.adicionarProduto(2L, "Tablet", 5, 1000d);
        estoqueProdutos.adicionarProduto(3L, "Notebook", 2, 6000d);
        estoqueProdutos.adicionarProduto(4L, "Computador", 2, 5000d);
        estoqueProdutos.adicionarProduto(4L, "Carro", 3, 15000d);
        estoqueProdutos.exibirProdutos();
        System.out.println("Valor total do estoque: " + estoqueProdutos.calcularValorTotalEstoque());
        System.out.println("Produto mais caro do estoque: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("Produto mais barato do estoque: " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("Produto maior quantidade e valor do estoque: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }

}
