package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros{

    private List<Integer> integerList;

    public OrdenacaoNumeros() {
        this.integerList = new ArrayList<>();
    }



    private void adicionarNumero(int numero){
        integerList.add(numero);
    }

    private void adicionarNumeros(List<Integer> list){
        integerList.addAll(list);
    }

    private void ordenarAscendente(){
        Collections.sort(integerList);
    }

    private void ordenarDescendente(){
        Collections.reverse(integerList);
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumeros(new ArrayList<>(List.of(24, 52, 2, 5, 21,65)));

        ordenacaoNumeros.adicionarNumero(22);
        ordenacaoNumeros.adicionarNumero(5);
        ordenacaoNumeros.adicionarNumero(7);
        ordenacaoNumeros.adicionarNumero(34);
        ordenacaoNumeros.adicionarNumero(1);

        System.out.println(ordenacaoNumeros.integerList);
        ordenacaoNumeros.ordenarAscendente();
        System.out.println();
        System.out.println(ordenacaoNumeros.integerList);
        System.out.println();
        ordenacaoNumeros.ordenarDescendente();
        System.out.println(ordenacaoNumeros.integerList);

    }

}
