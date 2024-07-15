package set.Pesquisa;

import java.util.Objects;

public class Contato {

    private String nome;
    private int numeroTelefone;

    public Contato(String nome, int numeroTelefone) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }

    public Contato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return getNumeroTelefone() == contato.getNumeroTelefone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroTelefone());
    }

    @Override
    public String toString() {
        return "Contato { " +
                "nome = '" + nome + '\'' +
                ", numeroTelefone = '" + numeroTelefone +
                '}';
    }
}
