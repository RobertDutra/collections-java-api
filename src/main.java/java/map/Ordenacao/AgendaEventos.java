package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        agendaEventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        if (!agendaEventosMap.isEmpty()){
            Map<LocalDate, Evento> agendaPorData = new TreeMap<>(agendaEventosMap);
            System.out.println(agendaPorData);
        }else{
            System.out.println("Agenda vázia!");
        }
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> agendaPorData = new TreeMap<>(agendaEventosMap);
        for (Map.Entry<LocalDate, Evento> entry: agendaPorData.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("O próximo enveto: " + entry.getValue() + " acontecerá na data " + entry.getKey());
                break;
            }
        }

    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.DECEMBER, 23), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 23), "Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 2), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2020, Month.DECEMBER, 14), "Evento 3", "Atração 3");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
    }
}
