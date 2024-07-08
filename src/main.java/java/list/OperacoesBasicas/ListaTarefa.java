package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefParaRemover = new ArrayList<>();
        for (Tarefa t: tarefaList) {
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                tarefParaRemover.add(t);
            }
        }
        tarefaList.removeAll(tarefParaRemover);
    }

    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        System.out.println("Número de elementos: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adicionarTarefa("tarefa 1");
        listaTarefa.adicionarTarefa("tarefa 1");
        listaTarefa.adicionarTarefa("tarefa 2");
        listaTarefa.obterDescricoesTarefas();

        System.out.println("Número de elementos: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("tarefa 2");
        listaTarefa.obterDescricoesTarefas();

        System.out.println("Número de elementos: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.obterDescricoesTarefas();
    }
}
