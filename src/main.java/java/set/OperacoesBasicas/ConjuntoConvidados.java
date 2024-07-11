package set.OperacoesBasicas;

import exception.ListEmptyException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConjuntoConvidados {

    Set<Convidado> convidados;

    public ConjuntoConvidados() {
        this.convidados = new HashSet<>();
    }

    private void adicionarConvidado(String nome, int codigoConvite){
        convidados.add(new Convidado(nome, codigoConvite));
    }

    private void removerConvidadoPorCodigoConvite(int codigoConvite) throws ListEmptyException {

        if (!convidados.isEmpty()) {
            convidados.removeIf(c -> c.getCodigoConvite() == codigoConvite);
        }
        else{
            throw new ListEmptyException("Lista vázia!");
        }
    }

    private int contarConvidados(){
        return convidados.size();
    }

    private void exibirConvidados(){
        System.out.println(convidados);;
    }

    public static void main(String[] args) throws ListEmptyException {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Robert", 23);
        conjuntoConvidados.adicionarConvidado("Lucas", 2);
        conjuntoConvidados.adicionarConvidado("Gabriela", 54);
        System.out.println("Total de convidados: " + conjuntoConvidados.contarConvidados());
        conjuntoConvidados.exibirConvidados();
        conjuntoConvidados.removerConvidadoPorCodigoConvite(54);
        System.out.println("Total de convidados: " + conjuntoConvidados.contarConvidados());
        conjuntoConvidados.exibirConvidados();
    }
}
