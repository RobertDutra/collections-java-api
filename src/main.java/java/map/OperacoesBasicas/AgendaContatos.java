package map.OperacoesBasicas;

import exception.ListEmptyException;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    private Map<String, Integer> contatoMap;

    public AgendaContatos() {
        this.contatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        contatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if (!contatoMap.isEmpty()){
            contatoMap.remove(nome);
        }else {
            System.out.println("Conjuntos de contatos vázio!");
        }
    }

    public void exibirContatos(){
        if (!contatoMap.isEmpty()){
            System.out.println(contatoMap);
        }else{
            System.out.println("Conjuntos de contatos vázio!");
        }
    }

    public Integer pesquisarPorNome(String nome) throws ListEmptyException {
        if (contatoMap.containsKey(nome)){
            return contatoMap.get(nome);
        }else {
            throw new ListEmptyException("Nome não encontrado!");
        }
    }

    public static void main(String[] args) throws ListEmptyException {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Kiara", 98219752);
        agendaContatos.adicionarContato("Lucas", 985259752);
        agendaContatos.adicionarContato("Ricardo", 6337373);
        agendaContatos.exibirContatos();
        agendaContatos.removerContato("Ricardo");
        agendaContatos.exibirContatos();
        System.out.println(agendaContatos.pesquisarPorNome("Kiaraa"));
    }

}
