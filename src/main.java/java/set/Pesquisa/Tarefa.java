package set.Pesquisa;

public class Tarefa {

    private String descricao;
    private boolean tarefaConcluida;

    public Tarefa(String descricao, boolean tarefaConcluida) {
        this.descricao = descricao;
        this.tarefaConcluida = tarefaConcluida;
    }

    public Tarefa() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isTarefaConcluida() {
        return tarefaConcluida;
    }

    public void setTarefaConcluida(boolean tarefaConcluida) {
        this.tarefaConcluida = tarefaConcluida;
    }

    @Override
    public String toString() {
        return "{" + descricao + '\'' + tarefaConcluida +
                '}';
    }
}
