package map.OperacoesBasicas;

import exception.ListEmptyException;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> palavras;

    public Dicionario() {
        this.palavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        palavras.put(palavra.toUpperCase(), definicao.toUpperCase());
    }

    public void removerPalavra(String palavra) throws ListEmptyException {
        if (palavras.containsKey(palavra.toUpperCase())){
            palavras.remove(palavra.toUpperCase());
        }else {
        throw new ListEmptyException("Palavra não encontrada!");
        }
    }

    public void exibirPalavras(){
        System.out.println(palavras);
    }

    public String pesquisarPorPalavra(String palavra) throws ListEmptyException {
        if (palavras.containsKey(palavra.toUpperCase())){
            return palavras.get(palavra.toUpperCase());
        }else{
            throw new ListEmptyException("Palavra não encontrada!");
        }
    }

    public static void main(String[] args) throws ListEmptyException {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Java", "Linguagem back-end");
        dicionario.adicionarPalavra("JavaScript", "Linguagem front-end");
        dicionario.adicionarPalavra("Html", "Linguagem de hyper text");
        dicionario.exibirPalavras();
        System.out.println(dicionario.pesquisarPorPalavra("html"));
        dicionario.removerPalavra("javascript");
        dicionario.exibirPalavras();
    }
}
