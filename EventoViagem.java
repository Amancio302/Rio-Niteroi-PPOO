public class EventoViagem extends Evento{

    // Versão da Classe EventoViagem
    private static final long serialVersionUID = 1L;

    private Balsa balsa;
    private Porto origem;
    private Porto destino;
    private int cargaAtual;
    private Evento embarque;
    private Evento desembarque;
    private int maxPassageiro;

    EventoViagem(Balsa balsa, Porto origem, Porto destino){
        super();
        this.balsa = balsa;
        this.origem = origem;
        this.destino = destino;
        this.cargaAtual = 0;
        this.embarque = new Evento();
        this.desembarque = new Evento();
        this.maxPassageiro = 0;
    }

    public void setBalsa(Balsa balsa) {
        this.balsa = balsa;
    }

    public Balsa getBalsa() {
        return balsa;
    }

    public void setOrigem(Porto origem) {
        this.origem = origem;
    }

    public Porto getOrigem() {
        return origem;
    }

    public void setDestino(Porto destino) {
        this.destino = destino;
    }

    public Porto getDestino() {
        return destino;
    }

    public void setCargaAtual(int cargaAtual) {
        this.cargaAtual = cargaAtual;
    }

    public int getCargaAtual() {
        return cargaAtual;
    }

    public void setEmbarque(Evento embarque) {
        this.embarque = embarque;
    }

    public Evento getEmbarque() {
        return embarque;
    }

    public void setDesembarque(Evento desembarque) {
        this.desembarque = desembarque;
    }

    public Evento getDesembarque() {
        return desembarque;
    }

    public void addPassageiro() {
        this.cargaAtual++;
        this.maxPassageiro++;
    }

    public void removePassageiro() {
        this.cargaAtual--;
    }

    public int getMaxPassageiro() {
        return maxPassageiro;
    }

    @Override
    public String toString() {
        return "-----VIAGEM-----\nBalsa: " + balsa + "\nCargaAtual: " + cargaAtual + "\nEmbarque: " + embarque + "\nDesembarque: " + desembarque + "\nInicio: " + getInicio() + "\nFim:" + getFim();
    }
    
}