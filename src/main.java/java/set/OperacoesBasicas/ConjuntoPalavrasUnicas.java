package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    Set<String> conjuntoPalavras;

    public ConjuntoPalavrasUnicas() {
        this.conjuntoPalavras = new HashSet<>();
    }

    private void adicionarPalavra(String palavra){
        conjuntoPalavras.add(palavra);
    }

    private void removerPalavra(String palavra){
        if (!conjuntoPalavras.isEmpty()) {
            if (conjuntoPalavras.contains(palavra)){
                conjuntoPalavras.remove(palavra);
            }else {
                System.out.println("Palavra '"+ palavra + "' não econtrada!");
            }
        }else{
            System.out.println("Lista de palavras vázia!");
        }

    }

    private boolean verificarPalavra(String palavra){
        return conjuntoPalavras.contains(palavra);
    }

    private void exibirPalavrasUnicas(){
        if (conjuntoPalavras.isEmpty()){
            System.out.println("Lista de palavras vázia!");
        }else{
            System.out.println(conjuntoPalavras);

        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Teste 01");
        conjuntoPalavrasUnicas.adicionarPalavra("Teste 02");
        conjuntoPalavrasUnicas.adicionarPalavra("Teste 03");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        System.out.println(conjuntoPalavrasUnicas.verificarPalavra("Teste 02"));

        conjuntoPalavrasUnicas.removerPalavra("Teste 03");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
    }
}
