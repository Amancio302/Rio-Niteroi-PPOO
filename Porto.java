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

    Porto() {
        this.balsasDisponiveis = new HashMap<String, ArrayList<Balsa>>();
        this.filas = new HashMap<String, ArrayList<Passageiro>>();
        this.viagens = new ArrayList<EventoViagem>();
        this.travessias = new ArrayList<EventoTravessia>();
        this.tempoAtual = 0;
        destino = null;
    }

    public void addBalsa(String nome, Balsa balsa) {
        if (this.balsasDisponiveis.get(nome) == null) {
            this.balsasDisponiveis.put(nome, new ArrayList<Balsa>());
        }
        this.balsasDisponiveis.get(nome).add(balsa);
    }

    public Balsa getBalsa(String nome, int index) {
        return this.balsasDisponiveis.get(nome).get(index);
    }

    public String getTipoBalsa(Balsa balsa) {
        System.out.println(1);
        for(String nome : balsasDisponiveis.keySet()) {
            System.out.println("------------Hash: " + nome);
            System.out.println("------------Value: " + balsasDisponiveis.get(nome));
            for(Balsa aux : balsasDisponiveis.get(nome)) {
                System.out.println(3);
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

    public Balsa removeBalsa(String nome, int index) {
        return this.balsasDisponiveis.get(nome).remove(index);
    }

    public void addPassageiro(String nome, Passageiro passageiro) {
        if (this.filas.get(nome) == null) {
            this.filas.put(nome, new ArrayList<Passageiro>());
        }
        this.filas.get(nome).add(passageiro);
    }

    public Passageiro getPassageiro(String nome, int index) {
        return this.filas.get(nome).get(index);
    }

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

    public Passageiro removePassageiro(String nome, int index) {
        return this.filas.get(nome).remove(index);
    }

    public void addViagem(EventoViagem viagem) {
        this.viagens.add(viagem);
    }

    public EventoViagem getViagem(int index) {
        return this.viagens.get(index);
    }

    public EventoViagem removeViagem(int index) {
        return this.viagens.remove(index);
    }

    public void removeViagem(EventoViagem viagem) {
        this.viagens.remove(viagem);
    }

    public void addTravessia(EventoTravessia travessia) {
        this.travessias.add(travessia);
    }

    public EventoTravessia getTravessia(int index) {
        return this.travessias.get(index);
    }

    public EventoTravessia removeTravessia(int index) {
        return this.travessias.remove(index);
    }

    public void removeTravessia(EventoTravessia travessia) {
        this.travessias.remove(travessia);
    }

    public void abrirPorto() {
        this.tempoAtual = System.currentTimeMillis();
        setViagens(tempoAtual);
        setTravessias();
    }

    public long getTempoAtual() {
        return tempoAtual;
    }

    public void setDestino(Porto destino) {
        this.destino = destino;
    }

    public Porto getDestino() {
        return destino;
    }

    public boolean filasVazias() {
        if (!travessias.isEmpty()) {
            return false;
        }
        if (!viagens.isEmpty()) {
            return false;
        }
        return true;
    }

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

    public void setViagens(long tempoAtual) {
        this.tempoAtual = tempoAtual;
        // Irá rodar uma única vez por porto, define a primeira viagem de suas balsas
        System.out.println("Setando Viagens");
        balsasDisponiveis.forEach((nomeTipo, balsaList) -> {
            System.out.println("BalsaList: " + balsaList);
            balsaList.forEach((balsa) -> {
                System.out.println("Balsa: " + balsa);
                System.out.println("BalsaList: " + balsaList);
                // Cria uma nova viagem do porto atual até o porto de destino, com a balsa selecionada
                EventoViagem viagem = new EventoViagem(balsa, this, destino);
                // Define o tempo de início da viagem
                viagem.setInicio(this.tempoAtual); // O tempo nesse caso será: o tempo atual da simulação
                // Define o tempo de início do embarque
                viagem.getEmbarque().setInicio(this.tempoAtual + 100); // O tempo nesse caso será: o mesmo valor anterior somado ao tempo de abrir as portas da balsa (considerado como 100)
                // A viagem criada será colocada na lista de viagens
                viagens.add(viagem);
                // E a balsa removida da lista de balsas disponíveis
                System.out.println("/Balsa: " + balsa);
                System.out.println("/BalsaList: " + balsaList);
            });
        });
        System.out.println("/Setando Viagens");
    }

    public void setTravessias() {
        // Irá rodar uma única vez por porto, criando eventos de travessia para cada passageiro nas filas
        System.out.println("Setando Travessias");
        filas.forEach((nomeFila, fila) -> {
            System.out.println("FILA RUN: " + fila);
            fila.forEach((passageiro) -> {
                System.out.println("PASSAGEIRO RUN: " + passageiro);
                EventoTravessia travessia = new EventoTravessia(passageiro);
                // Define o início da travessia
                travessia.setInicio(tempoAtual); // Nesse caso o tempo será: o tempo atual
                // Define o tempo de atendimento
                this.tempoAtual += 100;
                travessia.setTempoAtendimento(tempoAtual); // Nesse caso  o tempo será: o tempo atual somado ao tempo de atendimento (Considerado como 100)
                System.out.println("Travessia: " + travessia);
                travessias.add(travessia);
            });
        });
        System.out.println("/Setando Travessias");
        System.out.println();
        System.out.println();
        System.out.println("Travessias Criadas: " + travessias);
        System.out.println();
        System.out.println();
    }

    public ArrayList<Evento> run(long tempoAtual) {
        // Guardará todos os eventos concluídos no porto
        ArrayList<Evento> eventosConcluidos = new ArrayList<Evento>();
        // Irá iterar em cada uma das viagens iniciadas e tentará finalizá-las
        ArrayList<EventoViagem> removeViagem = new ArrayList<EventoViagem>();
        System.out.println("Iterando viagens");
        viagens.forEach((viagem) -> {
            System.out.println("Viagem: " + viagem);
            Balsa balsa = viagem.getBalsa();
            System.out.println("Balsa: " + balsa);
            String tipo = getTipoBalsa(balsa);
            System.out.println("Tipo: " + tipo);
            if (tipo != null) {
                // Testa se a balsa pode sair, estando cheia ou não havendo fila para a mesma
                System.out.println("Filas na tipo: " + filas.get(tipo));
                if (balsa.getCargaMaxima() >= viagem.getCargaAtual() || filas.get(tipo).isEmpty()) {
                    // Define o tempo de fim do embarque
                    viagem.getEmbarque().setFim(viagem.getEmbarque().getInicio() + (viagem.getCargaAtual() * 100)); // Nessa caso o tempo será: o tempo de início do embarque somado ao tempo para cada passageiro entrar na balsa (considerado como 100)
                    // Define o tempo de início do desembarque
                    viagem.getDesembarque().setInicio(balsa.getTempoViagem() + viagem.getEmbarque().getFim()); // Nesse caso o tempo será: o tempo de fim do embarque somado ao tempo de viagem da balsa
                    // Define o tempo de fim do desembarque
                    viagem.getDesembarque().setFim(balsa.getTempoViagem() + (viagem.getCargaAtual() * 100) + tempoAtual); // Nesse caso o tempo será: o tempo de início do desembarque somado ao tempo para cada passageiro sair da balsa (considerado como 100)
                    // Define o tempo de fim da viagem
                    viagem.setFim(balsa.getTempoViagem() + viagem.getDesembarque().getFim() + 100); // Nesse caso o tempo será: o tempo de fim do desembarque mais o tempo para fechar as portas da balsa (considerado como 100)
                    // A balsa é adicionada a lista de balsas disponíveis no porto de destino
                    viagem.getDestino().addBalsa(tipo, balsa);
                    // O evento é adicionado a lista de eventos concluídos
                    eventosConcluidos.add(viagem);
                    removeViagem.add(viagem);
                }
            }
            System.out.println("/Viagem: " + viagem);
        });
        System.out.println("/Iterando Viagens");
        for (EventoViagem eventoViagem : removeViagem) {
            viagens.remove(eventoViagem);
        }
        ArrayList<EventoTravessia> removeTravessia = new ArrayList<EventoTravessia>();
        // Irá iterar em cada uma das travessias criadas e tentar finalizá-las
        System.out.println("Iterando travessias");
        travessias.forEach((travessia) -> {
            Passageiro passageiro = travessia.getPassageiro();
            // Testa se a travessia já possui alguma viagem relacionada
            System.out.println("passageio: " + passageiro);
            if (travessia.getViagem() == null) {
                System.out.println("Nao tem viagem");
                EventoViagem viagem = viagemDisponivel(passageiro);
                System.out.println("Viagem virou: " + viagem);
                // Caso haja alguma viagem disponível para o passageiro, ele será alocado a ela
                if (viagem != null) {
                    travessia.setViagem(viagem);
                    viagem.addPassageiro();
                    // Define o tempo de embarque
                    travessia.setTempoEmbarque(viagem.getEmbarque().getInicio() + (viagem.getCargaAtual() * 100)); // Nesse caso o tempo será: o tempo de início do embarque na balsa somado ao tempo gasto por todos os passageiros que ingressaram antes do passageiro na balsa (considerado como 100)
                }
            }
            // Caso a viagem já esteja alocada
            if (travessia.getViagem() != null) {
                System.out.println("Tem viagem");
                EventoViagem viagem = travessia.getViagem();
                // Testa se o desembarque da viagem já começou
                if (travessia.getViagem().getDesembarque().getInicio() != -1) {
                    long tempo = viagem.getDesembarque().getInicio() + viagem.getCargaAtual() * 100;
                    // Define o tempo de inpicio do desembarque
                    travessia.setTempoDesembarque(tempo); // O tempo nesse caso será: o tempo de início do desembarque somado ao tempo para cada passageiro sair (considerado como 100)
                    // Define o tempo de fim da travessia
                    travessia.setFim(viagem.getDesembarque().getInicio() + viagem.getCargaAtual() * 100 + 100); // O tempo nesse caso será: o tempo anterior somado ao tempo para fechar a balsa (considerado como 100)
                    // Adiciona a tarvessia a lista de eventos concluiídos
                    eventosConcluidos.add(travessia);
                    removeTravessia.add(travessia);
                }
            }
        });
        System.out.println("/Iterando travesias");
        for (EventoTravessia eventoTravessia : removeTravessia) {
            travessias.remove(eventoTravessia);
        }
        System.out.println("Concluidos: " + eventosConcluidos);
        return eventosConcluidos;
    }
}

