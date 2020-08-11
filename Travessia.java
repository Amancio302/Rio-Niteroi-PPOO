public class Travessia extends Evento{
    
    private Passageiro passageiro;
    private Viagem viagem;
    private long tempoAtendimento;
    private long tempoEmbarque;
    private long tempoDesembarque;

    Travessia (Passageiro passageiro, Viagem viagem) {
        super();
        this.passageiro = passageiro;
        this.viagem = viagem;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public void setTempoAtendimento(long tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
    }

    public void setTempoEmbarque(long tempoEmbarque) {
        this.tempoEmbarque = tempoEmbarque;
    }

    public void setTempoDesembarque(long tempoDesembarque) {
        this.tempoDesembarque = tempoDesembarque;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public long getTempoAtendimento() {
        return tempoAtendimento;
    }

    public long getTempoEmbarque() {
        return tempoEmbarque;
    }

    public long getTempoDesembarque() {
        return tempoDesembarque;
    }

}
