package Pesquisa;

import exception.ListEmptyException;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    List<Integer> integerList;

    public SomaNumeros() {
        this.integerList = new ArrayList<>();
    }

    private void adicionarNumero(int numero){
        integerList.add(numero);
    }

    private int calcularSoma(){
        int soma = 0;
        for (Integer i: integerList) {
            soma += i;
        }
        return soma;
    }

    private int encontrarMaiorNumero() throws ListEmptyException {
        int maiorValor = integerList.get(0);

       if (!integerList.isEmpty()) {
           for (Integer i: integerList) {
               if (i > maiorValor){
                   maiorValor = i ;
               }
           }
           return maiorValor;
       }else {
           throw new ListEmptyException("Lista de números vázia!");
       }
    }

    private int encontrarMenorNumero() throws ListEmptyException {
        int menorValor = integerList.get(0);

        if (!integerList.isEmpty()){
            for (Integer i: integerList) {
                if (i < menorValor){
                    menorValor = i ;
                }
            }
            return menorValor;
        }else{
            throw new ListEmptyException("Lista de números vázia!");
            }
        }

    private List<Integer> exibirNumeros() throws ListEmptyException {

        if (!integerList.isEmpty()){
            return integerList;
        }else {
            throw new ListEmptyException("Lista de números vázia!");
        }

    }

    public static void main(String[] args) throws ListEmptyException {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(4);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(78);
        somaNumeros.adicionarNumero(52);
        somaNumeros.adicionarNumero(927);
        somaNumeros.adicionarNumero(24);
        System.out.println(somaNumeros.exibirNumeros());
        System.out.println("A soma de todos os números da lista: " + somaNumeros.calcularSoma());
        System.out.println("O maior valor da lista: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("O menor valor da lista: " + somaNumeros.encontrarMenorNumero());
    }
}
