import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * Classe Simulador
 * Reponsável por simular toda a operação do porto
 */
public class Simulador implements Serializable{

    // Versão da Classe Simulador
    private static final Long serialVersionUID = 1L;

    private Porto porto1;
    private Porto porto2;
    private Evento simulacao;
    private ArrayList<Evento> eventosConcluidos;
    private ArrayList<Passageiro> listaDeComuns;
    private ArrayList<Long> listaDeAtendimentoComuns;
    private ArrayList<Passageiro> listaDePreferenciais;
    private ArrayList<Long> listaDeAtendimentoPreferenciais;
    private ArrayList<Passageiro> listaDeVIPs;
    private ArrayList<Long> listaDeAtendimentoVIPs;
    
    Simulador () {
        this.porto1 = null;
        this.porto2 = null;
        this.simulacao = new Evento();
        eventosConcluidos = new ArrayList<Evento>();
        listaDeComuns = new ArrayList<Passageiro>();
        listaDeAtendimentoComuns = new ArrayList<Long>();
        listaDePreferenciais = new ArrayList<Passageiro>();
        listaDeAtendimentoPreferenciais = new ArrayList<Long>();
        listaDeVIPs = new ArrayList<Passageiro>();
        listaDeAtendimentoVIPs = new ArrayList<Long>();
        
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

    public void encerrarSimulacao(Long fim) {
        this.simulacao.setFim(fim);
    }

    public void setEventosConcluidos(ArrayList<Evento> eventosConcluidos) {
        this.eventosConcluidos = eventosConcluidos;
    }

    public ArrayList<Evento> getEventosConcluidos() {
        return eventosConcluidos;
    }
    
    public ArrayList<Passageiro> getListaDeComuns() {
		return listaDeComuns;
	}

	public void setListaDeComuns(ArrayList<Passageiro> listaDeComuns) {
		this.listaDeComuns = listaDeComuns;
	}

	public ArrayList<Long> getListaDeAtendimentoComuns() {
		return listaDeAtendimentoComuns;
	}

	public void setListaDeAtendimentoComuns(ArrayList<Long> listaDeAtendimentoComuns) {
		this.listaDeAtendimentoComuns = listaDeAtendimentoComuns;
	}

	public ArrayList<Passageiro> getListaDePreferenciais() {
		return listaDePreferenciais;
	}

	public void setListaDePreferenciais(ArrayList<Passageiro> listaDePreferenciais) {
		this.listaDePreferenciais = listaDePreferenciais;
	}

	public ArrayList<Long> getListaDeAtendimentoPreferenciais() {
		return listaDeAtendimentoPreferenciais;
	}

	public void setListaDeAtendimentoPreferenciais(ArrayList<Long> listaDeAtendimentoPreferenciais) {
		this.listaDeAtendimentoPreferenciais = listaDeAtendimentoPreferenciais;
	}

	public ArrayList<Passageiro> getListaDeVIPs() {
		return listaDeVIPs;
	}

	public void setListaDeVIPs(ArrayList<Passageiro> listaDeVIPs) {
		this.listaDeVIPs = listaDeVIPs;
	}

	public ArrayList<Long> getListaDeAtendimentoVIPs() {
		return listaDeAtendimentoVIPs;
	}

	public void setListaDeAtendimentoVIPs(ArrayList<Long> listaDeAtendimentoVIPs) {
		this.listaDeAtendimentoVIPs = listaDeAtendimentoVIPs;
	}

	public void gerarRelatorioEmArquivo(){
    	String nomeArquivo = "Relatorio.txt";
    	Collections.sort(eventosConcluidos);
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
        try(FileWriter arq = new FileWriter(nomeArquivo)){
        	// Passageiros
        	for (Evento evento : eventosConcluidos) {
        		if (evento instanceof EventoTravessia) {
        			EventoTravessia temp = (EventoTravessia) evento;
		        	if (temp.getPassageiro() instanceof PassageiroComum) {
		        		arq.write("Nome Passageiro Comum: " + temp.getPassageiro().getNome() + " Tempo atendimento: " + (temp.getTempoDesembarque() - temp.getTempoEmbarque()));
		        		arq.write("\n" );
		        		listaDeComuns.add(temp.getPassageiro());
		        		listaDeAtendimentoComuns.add(temp.getTempoDesembarque() - temp.getTempoEmbarque());
		        	} else if (temp.getPassageiro() instanceof PassageiroPreferencial) {
		        		arq.write("Nome Passageiro Pref: " + temp.getPassageiro().getNome() + " Tempo atendimento: " + (temp.getTempoDesembarque() - temp.getTempoEmbarque()));
		    			arq.write("\n" );
		    			listaDePreferenciais.add(temp.getPassageiro());
		    			listaDeAtendimentoPreferenciais.add(temp.getTempoDesembarque() - temp.getTempoEmbarque());
		        	} else {
		        		arq.write("Nome Passageiro Pref: " + temp.getPassageiro().getNome() + " Tempo atendimento: " + (temp.getTempoDesembarque() - temp.getTempoEmbarque()));
		    			arq.write("\n" );
		    			listaDeVIPs.add(temp.getPassageiro());
		    			listaDeAtendimentoVIPs.add(temp.getTempoDesembarque() - temp.getTempoEmbarque());
		        	}
	        	}
        	}
            // Tempo total simulado
        	arq.write("Tempo total simulado: " + eventosConcluidos.get(eventosConcluidos.size() - 1).getFim());
            arq.write("\n" );
            arq.write("\n" );
            // Numero de eventos tratados
            arq.write("Numero de eventos tratados: " + eventosConcluidos.size());
            arq.write("\n" );
            arq.write("Total de travessias de passageiros: " + totalTravessia);
            arq.write("\n" );
            arq.write("Total de viagens das balsas: " + totalViagem);
            arq.write("\n" );
            arq.write("\n" );
            // Tempo medio de espera na fila
            arq.write("Tempo médio de espera na fila: " + tempoNaFila/totalTravessia);
            arq.write("\n" );
            // Tamanho medio da fila
            arq.write("Tamanho medio da fila: " + tamanhoFila/totalViagem);
            arq.write("\n" );
            // Tamanho maximo da fila
            arq.write("Tamanho máximo da fila: " + tamanhoMaxFila);
            arq.write("\n" );
            // Tempo medio de atendimento para cada tipo de cliente
            arq.write("Quantidade de Passageiros Comuns: " + qtdPassageiroComum);
            arq.write("\n" );
            arq.write("Tempo médio de atendimento: " + (qtdPassageiroComum > 0 ? tempoAtendimentoPassageiroComum/qtdPassageiroComum : "NaN"));
            arq.write("\n" );
            arq.write("Quantidade de Passageiros Preferenciais: " + qtdPassageiroPreferencial);
            arq.write("\n" );
            arq.write("Tempo médio de atendimento: " + (qtdPassageiroPreferencial > 0 ? tempoAtendimentoPassageiroPreferencial/qtdPassageiroPreferencial : "NaN"));
            arq.write("\n" );
            arq.write("Quantidade de Passageiros VIP: " + qtdPassageiroVIP);
            arq.write("\n" );
            arq.write("Tempo médio de atendimento: " + (qtdPassageiroVIP > 0 ? tempoAtendimentoPassageiroVIP/qtdPassageiroVIP : "NaN"));
            arq.write("\n" );
            arq.write("Quantidade de Viagens de Balsas Comuns: " + qtdBalsaComum);
            arq.write("\n" );
            arq.write("Tempo médio de atendimento: " + (qtdBalsaComum > 0 ? tempoAtendimentoBalsaComum/qtdBalsaComum: "NaN"));
            arq.write("\n" );
            arq.write("Quantidade de Viagens de Balsas Express: " + qtdBalsaExpress);
            arq.write("\n" );
            arq.write("Tempo médio de atendimento: " + (qtdBalsaExpress > 0 ? tempoAtendimentoBalsaExpress/qtdBalsaExpress : "NaN"));
            arq.write("\n" );
        }
        catch(IOException e){
          System.err.println(e.getMessage());
        }    
    }

    public void run(){
        ArrayList<Porto> portos = new ArrayList<Porto>();
        porto1.abrirPorto();
        porto2.abrirPorto();
        portos.add(porto1);
        portos.add(porto2);
        Long tempoAtual = this.simulacao.getInicio();
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
        System.out.println("Eventos Concluidos");
    	simulacao.setFim(System.currentTimeMillis());
        gerarRelatorioEmArquivo();
    }
}