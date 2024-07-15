package set.Pesquisa;

import exception.ListEmptyException;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao, false));
    }
    public void removerTarefa(String descricao) throws ListEmptyException {
        if (!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaSet.remove(t);
                    break;
                }
            }
        }else{
            throw new ListEmptyException("Conjunto de tarefas vázio!");
        }
    }
    public void exibirTarefas(){
        if (!tarefaSet.isEmpty()){
            System.out.println(tarefaSet);
        }else{
            System.out.println("Conjunto de tarefas vázio!");
        }
    }
    public int contarTarefas() throws ListEmptyException {
        if (!tarefaSet.isEmpty()){
            return tarefaSet.size();
        }else{
            throw new ListEmptyException("Conjunto de tarefas vázio!");
        }

    }
    public Set<Tarefa> obterTarefasConcluidas() throws ListEmptyException {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if (t.isTarefaConcluida()){
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        }else{
            throw new ListEmptyException("Conjunto de tarefas vázio!");
        }
    }

    public Set<Tarefa> obterTarefasPendentes() throws ListEmptyException {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if (!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if (!t.isTarefaConcluida()){
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        }else{
            throw new ListEmptyException("Conjunto de tarefas vázio!");
        }
    }

    public void marcarTarefaConcluida(String descricao){
        if (!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setTarefaConcluida(true);
                    break;
                }
            }
        }else{
            System.out.println("Conjunto de tarefas vázio!");
        }
    }

    public void marcarTarefaPendente(String descricao){
        if (!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setTarefaConcluida(false);
                    break;
                }
            }
        }else{
            System.out.println("Conjunto de tarefas vázio!");
        }
    }

    public void limparListaTarefas(){
        Set<Tarefa> removeTarefa = tarefaSet;
        if (!tarefaSet.isEmpty()){
            tarefaSet.removeAll(removeTarefa);
        }else{
            System.out.println("Conjunto de tarefas vázio!");
        }
    }

    public static void main(String[] args) throws ListEmptyException {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Dormir");
        listaTarefas.adicionarTarefa("Jogar bola");
        listaTarefas.adicionarTarefa("Correr");
        listaTarefas.adicionarTarefa("Dançar");
        listaTarefas.exibirTarefas();
        System.out.println("Total de tarefas: " + listaTarefas.contarTarefas());
        System.out.println(listaTarefas.obterTarefasPendentes());
        System.out.println(listaTarefas.obterTarefasConcluidas());
        listaTarefas.marcarTarefaConcluida("dormir");
        listaTarefas.marcarTarefaConcluida("correr");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        listaTarefas.removerTarefa("jogar bola");
        listaTarefas.exibirTarefas();
        System.out.println(listaTarefas.obterTarefasPendentes());
//        listaTarefas.limparListaTarefas();
//        listaTarefas.exibirTarefas();
    }
}
