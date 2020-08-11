public class Travessia extends Evento{
    
    private Veiculo veiculo;
    private Viagem viagem;
    private long tempoAtendimento;
    private long tempoEmbarque;
    private long tempoDesembarque;

    Travessia (Veiculo veiculo, Viagem viagem) {
        super();
        this.veiculo = veiculo;
        this.viagem = viagem;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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

    public Veiculo getVeiculo() {
        return veiculo;
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
