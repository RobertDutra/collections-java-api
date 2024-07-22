package map.Pequisa;

import exception.ListEmptyException;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> palavrasMap;

    public ContagemPalavras() {
        this.palavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        palavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if (!palavrasMap.isEmpty()){
            if (palavrasMap.containsKey(palavra)){
                palavrasMap.remove(palavra);
            }
            else{
                System.out.println("Palavra não encontrada!");
            }
        }else{
            System.out.println("Cojunto map vázio!");
        }
    }

    public int exibirContagemPalavras(){
        int contagemTotal = 0;
        for (int c : palavrasMap.values()) {
            contagemTotal += c;
        }
        return contagemTotal;
    }

    public void exibirPalavras(){
        System.out.println(palavrasMap);
    }

    public String encontrarPalavraMaisFrequente() throws ListEmptyException {
        String palavraMaisFrenquente = null;
        int maisFrenquente = Integer.MIN_VALUE;
        if (!palavrasMap.isEmpty()){
            for (Map.Entry<String, Integer> p: palavrasMap.entrySet()) {
                if (p.getValue() > maisFrenquente){
                    maisFrenquente = p.getValue();
                    palavraMaisFrenquente = p.getKey();
                }
            }
            return palavraMaisFrenquente;
        }else{
            throw new ListEmptyException("Cojunto map vázio!");
        }
    }

    public static void main(String[] args) throws ListEmptyException {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("Casa", 2);
        contagemPalavras.adicionarPalavra("Carro", 4);
        contagemPalavras.adicionarPalavra("Bicicleta", 45);
        contagemPalavras.adicionarPalavra("Cigarro", 6);
        contagemPalavras.adicionarPalavra("Chinelo", 65);

        contagemPalavras.exibirPalavras();
        System.out.println("Contagem total: " + contagemPalavras.exibirContagemPalavras());
        contagemPalavras.removerPalavra("Cigarro");
        contagemPalavras.exibirPalavras();

        System.out.println("Palavra de maior contagem: " + contagemPalavras.encontrarPalavraMaisFrequente());
    }
}
