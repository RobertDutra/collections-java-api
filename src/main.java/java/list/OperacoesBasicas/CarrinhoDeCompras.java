package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        Item item = new Item(nome, preco, quantidade);
        itemList.add(item);
    }

    public void removerItem(String nome){
        List<Item> list = new ArrayList<>();

        if (!itemList.isEmpty()){
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)){
                    list.add(i);
                }
            }
            itemList.removeAll(list);
        }else {
            System.out.println("Lista vazia!");
        }
    }

    public void calcularValorTotal(){

        double total = 0d;

        if (!itemList.isEmpty()){
            for (Item item: itemList) {
                total += item.getPreco() * item.getQuantidade();
            }
            System.out.printf("Valor total: %.2f%n", total);
        }else {
            System.out.println("Lista vazia!");
        }

    }

    public void exibirItens(){
        if (!itemList.isEmpty()) {
            for (Item i :
                    itemList) {
                System.out.println("Produto: " +  i.getNome() + ", Precço: " + i.getPreco()
                        + ", Quantidade: " + i.getQuantidade());
            }
        }else {
            System.out.println("Lista vazia!");
        }

    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Celular", 5000d,2);
        carrinhoDeCompras.adicionarItem("Celular", 3000d,1);
        carrinhoDeCompras.adicionarItem("Capinha", 50d,5);
        carrinhoDeCompras.adicionarItem("Carregador", 150d,3);
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.removerItem("Celular");
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.calcularValorTotal();



    }
}
