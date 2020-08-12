public class EventoTravessia extends Evento{

    // Versão da Classe EventoTravessia
    private static final long serialVersionUID = 1L;

    // Passageiro relacionado a travessia
    private Passageiro passageiro;
    // Viagem relacionada a travessia
    private EventoViagem viagem;
    // Tempo de atendimento, em milissegundos
    private long tempoAtendimento;
    // Tempo de embarque, em milissegundos
    private long tempoEmbarque;
    // Tempo de desembarque, em milissegundos
    private long tempoDesembarque;

    EventoTravessia(Passageiro passageiro) {
        super();
        this.passageiro = passageiro;
        this.viagem = null;
        this.tempoAtendimento = -1;
        this.tempoEmbarque = -1;
        this.tempoDesembarque = -1;
        
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setViagem(EventoViagem viagem) {
        this.viagem = viagem;
    }

    public EventoViagem getViagem() {
        return viagem;
    }

    public void setTempoAtendimento(long tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
    }

    public long getTempoAtendimento() {
        return tempoAtendimento;
    }

    public void setTempoEmbarque(long tempoEmbarque) {
        this.tempoEmbarque = tempoEmbarque;
    }

    public long getTempoEmbarque() {
        return tempoEmbarque;
    }

    public void setTempoDesembarque(long tempoDesembarque) {
        this.tempoDesembarque = tempoDesembarque;
    }

    public long getTempoDesembarque() {
        return tempoDesembarque;
    }

    @Override
    public String toString() {
        return "\nPassageiro: " + passageiro + "\nViagem: " + viagem + "\nAtendimento: " + tempoAtendimento + "\nEmbarque: " + tempoEmbarque + "\nDesembarque: " + tempoDesembarque;
    }

}