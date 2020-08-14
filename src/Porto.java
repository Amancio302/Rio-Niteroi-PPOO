/**
 * Classe Porto
 * Representa um Porto
 * @author Amancio, Jean, Leonardo e Vitor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Porto implements Serializable{

    // Versão da Classe Porto
    private static final long serialVersionUID = 1L;

    private HashMap<String, ArrayList<Balsa>> balsasDisponiveis;
    private HashMap<String, ArrayList<Passageiro>> filas;
    private ArrayList<EventoViagem> viagens;
    private ArrayList<EventoTravessia> travessias;
    private long tempoAtual;
    private Porto destino;

    /**
     * Intancia um Porto.
     */
    Porto() {
        this.balsasDisponiveis = new HashMap<String, ArrayList<Balsa>>();
        this.filas = new HashMap<String, ArrayList<Passageiro>>();
        this.viagens = new ArrayList<EventoViagem>();
        this.travessias = new ArrayList<EventoTravessia>();
        this.tempoAtual = 0;
        destino = null;
    }

    /**
     * Adiciona uma instancia no HashMap balsasDisponiveis.
     * @param nome
     * @param balsa 
     */
    public void addBalsa(String nome, Balsa balsa) {
        if (this.balsasDisponiveis.get(nome) == null) {
            this.balsasDisponiveis.put(nome, new ArrayList<Balsa>());
        }
        this.balsasDisponiveis.get(nome).add(balsa);
    }
    
    /**
     * @param nome
     * @param index
     * @return balsasDisponiveis
     */
    public Balsa getBalsa(String nome, int index) {
        return this.balsasDisponiveis.get(nome).get(index);
    }

    /**
     * Retorna tipo de Balsa.
     * @param balsa
     * @return String nome
     */
    public String getTipoBalsa(Balsa balsa) {
        for(String nome : balsasDisponiveis.keySet()) {
            for(Balsa aux : balsasDisponiveis.get(nome)) {
                if (aux.equals(balsa)) {
                    return nome;
                }
                if (aux == balsa) {
                    return nome;
                }
            }
        }
        return null;
    }
    
    /**
     * @param nome
     * @param index
     * @return Balsa
     */
    public Balsa removeBalsa(String nome, int index) {
        return this.balsasDisponiveis.get(nome).remove(index);
    }
    
    /**
     * Adiciona passageiro no HashMap filas.
     * @param nome
     * @param passageiro 
     */
    public void addPassageiro(String nome, Passageiro passageiro) {
        if (this.filas.get(nome) == null) {
            this.filas.put(nome, new ArrayList<Passageiro>());
        }
        this.filas.get(nome).add(passageiro);
    }

    /**
     * @param nome
     * @param index
     * @return Passageiro
     */
    public Passageiro getPassageiro(String nome, int index) {
        return this.filas.get(nome).get(index);
    }

    /**
     * @param passageiro
     * @return String tipo Passageiro
     */
    public String getTipoPassageiro(Passageiro passageiro) {
        for(String nome : filas.keySet()) {
            for(Passageiro aux : filas.get(nome)) {
                if (aux.equals(passageiro)) {
                    return nome;
                }
            }
        }
        return null;
    }
    
    /**
     * Remove passageiro da filas.
     * @param nome
     * @param index
     * @return 
     */
    public Passageiro removePassageiro(String nome, int index) {
        return this.filas.get(nome).remove(index);
    }

    /**
     * Adiciona uma viagem no ArrayList viagens.
     * @param viagem 
     */
    public void addViagem(EventoViagem viagem) {
        this.viagens.add(viagem);
    }
    
    /**
     * @param index
     * @return EventoViagem
     */
    public EventoViagem getViagem(int index) {
        return this.viagens.get(index);
    }

    /**
     * Remove uma viagem do ArrayList viagens.
     * @param index
     * @return EventoViagem
     */
    public EventoViagem removeViagem(int index) {
        return this.viagens.remove(index);
    }

    /**
     * Remove uma viagem do ArrayList viagens.
     * @param viagem 
     */
    public void removeViagem(EventoViagem viagem) {
        this.viagens.remove(viagem);
    }
    
    /**
     * Adiciona uma travessia no ArrayList travessias.
     * @param travessia 
     */
    public void addTravessia(EventoTravessia travessia) {
        this.travessias.add(travessia);
    }
    
    /**
     * @param index
     * @return EventoTravessia
     */
    public EventoTravessia getTravessia(int index) {
        return this.travessias.get(index);
    }

    /**
     * Remove uma travessia do ArrayList travessias.
     * @param index
     * @return 
     */
    public EventoTravessia removeTravessia(int index) {
        return this.travessias.remove(index);
    }

    /**
     * Remove uma travessia do ArrayList travessias.
     * @param travessia 
     */
    public void removeTravessia(EventoTravessia travessia) {
        this.travessias.remove(travessia);
    }
    
    /**
     * Abri um Porto.
     */
    public void abrirPorto() {
        setViagens(tempoAtual);
        setTravessias();
    }

    /**
     * @return tempoAtual
     */
    public long getTempoAtual() {
        return tempoAtual;
    }
    
    /**
     * Atribui uma instancia para destino.
     * @param destino 
     */
    public void setDestino(Porto destino) {
        this.destino = destino;
    }
    
    /**
     * @return destino
     */
    public Porto getDestino() {
        return destino;
    }

    /**
     * Verifica se o HashMap filas está vazio.
     * @return boolean
     */
    public boolean filasVazias() {
        if (!travessias.isEmpty()) {
            return false;
        }
        if (!viagens.isEmpty()) {
            return false;
        }
        for (ArrayList<Passageiro> fila : filas.values()) {
            if (!fila.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Verifica se tem viagem disponível.
     * @param passageiro
     * @return EventoViagem
     */
    public EventoViagem viagemDisponivel(Passageiro passageiro) {
        String tipo = getTipoPassageiro(passageiro);
        if (tipo != null) {
            for (EventoViagem viagem : viagens) {
                if (getTipoBalsa(viagem.getBalsa()).equals(tipo)) {
                    if (viagem.getBalsa().getCargaMaxima() > viagem.getCargaAtual()) {
                        return viagem;
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * Atribui uma instancia para tempoAtual.
     * @param tempoAtual 
     */
    public void setViagens(long tempoAtual) {
        this.tempoAtual = tempoAtual;
        // Irá rodar uma única vez por porto, define a primeira viagem de suas balsas
        balsasDisponiveis.forEach((nomeTipo, balsaList) -> {
            balsaList.forEach((balsa) -> {
                setBalsaViagem(balsa);
            });
        });
    }
    
    /**
     * Adciona uma viagem no ArrayList viagens.
     * @param balsa 
     */
    public void setBalsaViagem(Balsa balsa) {
        // Cria uma nova viagem do porto atual até o porto de destino, com a balsa selecionada
        EventoViagem viagem = new EventoViagem(balsa, this, destino);
        // Define o tempo de início da viagem
        viagem.setInicio(this.tempoAtual); // O tempo nesse caso será: o tempo atual da simulação
        // Define o tempo de início do embarque
        viagem.getEmbarque().setInicio(this.tempoAtual + 100); // O tempo nesse caso será: o mesmo valor anterior somado ao tempo de abrir as portas da balsa (considerado como 100)
        // A viagem criada será colocada na lista de viagens
        viagens.add(viagem);
        // E a balsa removida da lista de balsas disponíveis
    }
    
    /**
     * Atribui uma instancia no ArrayList travessias.
     */
    public void setTravessias() {
        // Irá rodar uma única vez por porto, criando eventos de travessia para cada passageiro nas filas
        filas.forEach((nomeFila, fila) -> {
            fila.forEach((passageiro) -> {
                EventoTravessia travessia = new EventoTravessia(passageiro);
                // Define o início da travessia
                travessia.setInicio(tempoAtual); // Nesse caso o tempo será: o tempo atual
                this.tempoAtual += 100;
                travessias.add(travessia);
            });
        });
    }
    
    /**
     * Cria um Evento.
     * @param tempoAtual
     * @return eventosConcluidos
     */
    public ArrayList<Evento> run(long tempoAtual) {
        System.out.println("INICIO");
        System.out.println(this);
        // Guardará todos os eventos concluídos no porto
        ArrayList<Evento> eventosConcluidos = new ArrayList<Evento>();
        // Irá iterar em cada uma das viagens iniciadas e tentará finalizá-las
        ArrayList<EventoViagem> removeViagem = new ArrayList<EventoViagem>();
        viagens.forEach((viagem) -> {
            Balsa balsa = viagem.getBalsa();
            String tipo = getTipoBalsa(balsa);
            if (tipo != null) {
                // Testa se a balsa pode sair, estando cheia ou não havendo fila para a mesma
                if (filas.get(tipo) != null) {
                    if (balsa.getCargaMaxima() <= viagem.getCargaAtual() || filas.get(tipo).isEmpty()) {
                        // Define o tempo de fim do embarque
                        viagem.getEmbarque().setFim(viagem.getEmbarque().getInicio() + (viagem.getCargaAtual() * 100)); // Nessa caso o tempo será: o tempo de início do embarque somado ao tempo para cada passageiro entrar na balsa (considerado como 100)
                        // Define o tempo de início do desembarque
                        viagem.getDesembarque().setInicio(balsa.getTempoViagem() + viagem.getEmbarque().getFim()); // Nesse caso o tempo será: o tempo de fim do embarque somado ao tempo de viagem da balsa
                        // Define o tempo de fim do desembarque
                        viagem.getDesembarque().setFim((viagem.getCargaAtual() * 100) + viagem.getDesembarque().getInicio() + 100); // Nesse caso o tempo será: o tempo de início do desembarque somado ao tempo para cada passageiro sair da balsa (considerado como 100)
                        // Define o tempo de fim da viagem
                        viagem.setFim(viagem.getDesembarque().getFim() + 100); // Nesse caso o tempo será: o tempo de fim do desembarque mais o tempo para fechar as portas da balsa (considerado como 100)
                        // A balsa é adicionada a lista de balsas disponíveis no porto de destino
                        viagem.getDestino().addBalsa(tipo, balsa);
                        viagem.getDestino().setBalsaViagem(balsa);
                        balsasDisponiveis.get(tipo).remove(balsa);
                        // O evento é adicionado a lista de eventos concluídos
                        eventosConcluidos.add(viagem);
                        removeViagem.add(viagem);
                    }
                }
            }
        });
        for (EventoViagem eventoViagem : removeViagem) {
            viagens.remove(eventoViagem);
        }
        ArrayList<EventoTravessia> removeTravessia = new ArrayList<EventoTravessia>();
        // Irá iterar em cada uma das travessias criadas e tentar finalizá-las
        travessias.forEach((travessia) -> {
            Passageiro passageiro = travessia.getPassageiro();
            // Testa se a travessia já possui alguma viagem relacionada
            if (travessia.getViagem() == null) {
                EventoViagem viagem = viagemDisponivel(passageiro);
                // Caso haja alguma viagem disponível para o passageiro, ele será alocado a ela
                if (viagem != null) {
                    travessia.setViagem(viagem);
                    viagem.addPassageiro();
                    // Define o tempo de embarque
                    travessia.setTempoEmbarque(viagem.getEmbarque().getInicio() + (viagem.getCargaAtual() * 100)); // Nesse caso o tempo será: o tempo de início do embarque na balsa somado ao tempo gasto por todos os passageiros que ingressaram antes do passageiro na balsa (considerado como 100)
                    filas.get(getTipoPassageiro(passageiro)).remove(passageiro);
                }
            }
            // Caso a viagem já esteja alocada
            if (travessia.getViagem() != null) {
                EventoViagem viagem = travessia.getViagem();
                // Testa se o desembarque da viagem já começou
                if (travessia.getViagem().getDesembarque().getInicio() != -1) {
                    long tempo = viagem.getDesembarque().getInicio() + viagem.getCargaAtual() * 100;
                    // Define o tempo de inpicio do desembarque
                    travessia.setTempoDesembarque(tempo); // O tempo nesse caso será: o tempo de início do desembarque somado ao tempo para cada passageiro sair (considerado como 100)
                    // Define o tempo de fim da travessia
                    travessia.setFim(tempo + 100); // O tempo nesse caso será: o tempo anterior somado ao tempo para fechar a balsa (considerado como 100)
                    // Adiciona a tarvessia a lista de eventos concluiídos
                    eventosConcluidos.add(travessia);
                    removeTravessia.add(travessia);
                    viagem.removePassageiro();
                }
            }
        });
        for (EventoTravessia eventoTravessia : removeTravessia) {
        	System.out.println(eventoTravessia);
        	System.out.println("\nEvento travessia deletado \n\n");
            travessias.remove(eventoTravessia);
        }
        System.out.println("FIM");
        System.out.println(this);
        return eventosConcluidos;
    }

    /**
     * @return String de atributos
     */
    @Override
    public String toString() {
        return ("-----EXIBINDO DADOS DO PORTO-----\n")
        +("\nBalsas Disponíveis\n")
        +("\n-----\n")
        +(balsasDisponiveis.values())
        +("\n-----\n")
        +("\nFilas\n")
        +("\n-----\n")
        +(filas.values())
        +("\n-----\n")
        +("\nViagens\n")
        +("\n-----\n")
        +(viagens)
        +("\n-----\n")
        +("\nTravessias\n")
        +("\n-----\n")
        +(travessias)
        +("\n-----\n");
    }
}
