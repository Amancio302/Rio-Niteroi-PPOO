import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Classe Simulador
 * Reponsável por simular toda a operação do porto
 */
public class Simulador implements Serializable{

    // Versão da Classe Simulador
    private static final long serialVersionUID = 1L;

    private Porto porto1;
    private Porto porto2;
    private Evento simulacao;
    private ArrayList<Evento> eventosConcluidos;
    
    Simulador () {
        this.porto1 = null;
        this.porto2 = null;
        this.simulacao = new Evento();
        eventosConcluidos = new ArrayList<Evento>();
    }

    public void setPorto1(Porto porto1) {
        this.porto1 = porto1;
    }

    public Porto getPorto1() {
        return porto1;
    }

    public void setPorto2(Porto porto2) {
        this.porto2 = porto2;
    }

    public Porto getPorto2() {
        return porto2;
    }

    public void iniciarSimulacao() {
        this.simulacao.setInicio(System.currentTimeMillis());
        run();
    }

    public void encerrarSimulacao(long fim) {
        this.simulacao.setFim(fim);
    }

    public void setEventosConcluidos(ArrayList<Evento> eventosConcluidos) {
        this.eventosConcluidos = eventosConcluidos;
    }

    public ArrayList<Evento> getEventosConcluidos() {
        return eventosConcluidos;
    }

    public void run(){
        ArrayList<Porto> portos = new ArrayList<Porto>();
        porto1.abrirPorto();
        porto2.abrirPorto();
        portos.add(porto1);
        portos.add(porto2);
        long tempoAtual = this.simulacao.getInicio();
        ArrayList<Porto> removeList = new ArrayList<Porto>();
        while (!portos.isEmpty()) {
            
            for (Porto porto : portos) {
                System.out.println(porto.equals(porto1) ? "P1" : "P2");
                ArrayList<Evento> eventosConcluidos = porto.run(tempoAtual);
                for(Evento evento : eventosConcluidos) {
                    this.eventosConcluidos.add(evento);
                }
                if (porto.filasVazias()) {
                    removeList.add(porto);
                }
            }
            for (Porto porto : removeList) {
                portos.remove(porto);
            }
        }
        Collections.sort(eventosConcluidos);
        System.out.println("Eventos Concluidos");
        int totalTravessia = 0;
        int totalViagem = 0;
        long tempoNaFila = 0;
        int tamanhoFila = 0;
        int tamanhoMaxFila = -1;
        long tempoAtendimentoPassageiroComum = 0;
        int qtdPassageiroComum = 0;
        long tempoAtendimentoPassageiroPreferencial = 0;
        int qtdPassageiroPreferencial = 0;
        long tempoAtendimentoPassageiroVIP = 0;
        int qtdPassageiroVIP = 0;
        long tempoAtendimentoBalsaComum = 0;
        int qtdBalsaComum = 0;
        long tempoAtendimentoBalsaExpress = 0;
        int qtdBalsaExpress = 0;
        for (Evento evento : eventosConcluidos) {
            if (evento instanceof EventoTravessia) {
                EventoTravessia ev = (EventoTravessia) evento;
                totalTravessia++;
                tempoNaFila += ev.getTempoEmbarque();
                if (ev.getPassageiro() instanceof PassageiroComum) {
                    tempoAtendimentoPassageiroComum += ev.getTempoDesembarque() - ev.getTempoEmbarque();
                    qtdPassageiroComum++;
                } else if (ev.getPassageiro() instanceof PassageiroPreferencial) {
                    tempoAtendimentoPassageiroPreferencial += ev.getTempoDesembarque() - ev.getTempoEmbarque();
                    qtdPassageiroPreferencial++;
                } else {
                    tempoAtendimentoPassageiroVIP += ev.getTempoDesembarque() - ev.getTempoEmbarque();
                    qtdPassageiroVIP++;
                }
            } else {
                totalViagem++;
                EventoViagem ev = (EventoViagem) evento;
                tamanhoFila += ev.getMaxPassageiro();
                if (ev.getMaxPassageiro() > tamanhoMaxFila) {
                    tamanhoMaxFila = ev.getMaxPassageiro();
                }
                if (ev.getBalsa() instanceof BalsaComum){
                    tempoAtendimentoBalsaComum += ev.getDesembarque().getFim() -  ev.getEmbarque().getInicio();
                    qtdBalsaComum++;
                } else {
                    tempoAtendimentoBalsaExpress += ev.getDesembarque().getFim() -  ev.getEmbarque().getInicio();
                    qtdBalsaExpress++;
                }
            }
        }
        // Tempo total simulado
        System.out.println("Tempo total simulado: " + eventosConcluidos.get(eventosConcluidos.size() - 1).getFim());
        // Numero de eventos tratados
        System.out.println("Numero de eventos tratados: " + eventosConcluidos.size());
        System.out.println("Total de travessias de passageiros: " + totalTravessia);
        System.out.println("Total de viagens das balsas: " + totalViagem);
        // Tempo medio de espera na fila
        System.out.println("Tempo médio de espera na fila: " + tempoNaFila/totalTravessia);
        // Tamanho medio da fila
        System.out.println("Tamanho medio da fila: " + tamanhoFila/totalViagem);
        // Tamanho maximo da fila
        System.out.println("Tamanho máximo da fila: " + tamanhoMaxFila);
        // Tempo medio de atendimento para cada tipo de cliente
        System.out.println("Quantidade de Passageiros Comuns: " + qtdPassageiroComum);
        System.out.println("Tempo médio de atendimento: " + tempoAtendimentoPassageiroComum/qtdPassageiroComum);
        System.out.println("Quantidade de Passageiros Preferenciais: " + qtdPassageiroPreferencial);
        System.out.println("Tempo médio de atendimento: " + tempoAtendimentoPassageiroPreferencial/qtdPassageiroPreferencial);
        System.out.println("Quantidade de Passageiros VIP: " + qtdPassageiroVIP);
        System.out.println("Tempo médio de atendimento: " + tempoAtendimentoPassageiroVIP/qtdPassageiroVIP);
        System.out.println("Quantidade de Viagens de Balsas Comuns: " + qtdBalsaComum);
        System.out.println("Tempo médio de atendimento: " + tempoAtendimentoBalsaComum/qtdBalsaComum);
        System.out.println("Quantidade de Viagens de Balsas Express: " + qtdBalsaExpress);
        System.out.println("Tempo médio de atendimento: " + (qtdBalsaExpress > 0 ? tempoAtendimentoBalsaExpress/qtdBalsaExpress : "NaN"));
    }

}