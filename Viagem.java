public class Viagem extends Evento{

    private Porto porto;
    private Balsa balsa;
    private Evento embarque;
    private Evento desembarque;

    Viagem (Porto porto, Balsa balsa) {
        super();
        this.porto = porto;
        this.balsa = balsa;
    }

    public void setPorto(Porto porto) {
        this.porto = porto;
    }

    public void setBalsa(Balsa balsa) {
        this.balsa = balsa;
    }

    public void setEmbarque(Evento embarque) {
        this.embarque = embarque;
    }

    public void setDesembarque(Evento desembarque) {
        this.desembarque = desembarque;
    }

    public Porto getPorto() {
        return porto;
    }

    public Balsa getBalsa() {
        return balsa;
    }

    public Evento getEmbarque() {
        return embarque;
    }

    public Evento getDesembarque() {
        return desembarque;
    }

}