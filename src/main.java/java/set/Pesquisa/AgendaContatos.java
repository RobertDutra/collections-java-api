package set.Pesquisa;

import exception.ListEmptyException;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        if (!contatoSet.isEmpty()){
            System.out.println(contatoSet);
        }else{
            System.out.println("Conjunto de contatos vázio!");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome) throws ListEmptyException {
        Set<Contato> contatosPorNome = new HashSet<>();
        if (!contatoSet.isEmpty()) {
            for (Contato c: contatoSet) {
                if (c.getNome().startsWith(nome)){
                    contatosPorNome.add(c);
                }
            }
            return contatosPorNome;
        }else{
            throw new ListEmptyException("Conjunto de contatos vázio!");
        }
    }

    public void atualizarNumeroContato(String nome, int novoNumero){
        if(!contatoSet.isEmpty()) {
            for (Contato c: contatoSet) {
                if (c.getNome().equalsIgnoreCase(nome)){
                    c.setNumeroTelefone(novoNumero);
                    break;
                }
            }
        }
        else {
            System.out.println("Conjunto de contatos vázio!");
        }
    }

    public static void main(String[] args) throws ListEmptyException {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Tulio", 124);
        agendaContatos.adicionarContato("Froid", 12224);
        agendaContatos.adicionarContato("Froid alencar", 12224);
        agendaContatos.adicionarContato("Cred", 1245);
        agendaContatos.exibirContatos();
        agendaContatos.atualizarNumeroContato("Tulio", 2444);
        agendaContatos.exibirContatos();
        System.out.println(agendaContatos.pesquisarPorNome("Froid"));
    }
}
