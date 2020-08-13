public class EventoTravessia extends Evento{

    // Versão da Classe EventoTravessia
    private static final long serialVersionUID = 1L;

    // Passageiro relacionado a travessia
    private Passageiro passageiro;
    // Viagem relacionada a travessia
    private EventoViagem viagem;
    // Tempo de embarque, em milissegundos
    private long tempoEmbarque;
    // Tempo de desembarque, em milissegundos
    private long tempoDesembarque;

    EventoTravessia(Passageiro passageiro) {
        super();
        this.passageiro = passageiro;
        this.viagem = null;
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
        return "-----Travessia-----\nPassageiro: " + passageiro + "\nViagem: " + viagem  + "\nEmbarque: " + tempoEmbarque + "\nDesembarque: " + tempoDesembarque + "\nInicio: " + getInicio() + "\nFim:" + getFim();
    }

}