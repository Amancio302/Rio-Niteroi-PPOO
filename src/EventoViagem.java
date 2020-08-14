/**
 * Classe EventoViagem
 * Representa um tipo variante de Evento
 * @author Amancio, Jean, Leonardo e Vitor.
 */

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

    /**
     * Instancia um EventoViagem que é variante de Evento.
     * @param balsa
     * @param origem
     * @param destino 
     */
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

    /**
     * Atribui uma instancia para balsa.
     * @param balsa 
     */
    public void setBalsa(Balsa balsa) {
        this.balsa = balsa;
    }

    /**
     * @return balsa
     */
    public Balsa getBalsa() {
        return balsa;
    }
    
    /**
     * Atribui uma instancia para origem.
     * @param origem 
     */
    public void setOrigem(Porto origem) {
        this.origem = origem;
    }
    
    /**
     * @return origem
     */
    public Porto getOrigem() {
        return origem;
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
     * Atribui uma instancia para cargaAtual.
     * @param cargaAtual 
     */
    public void setCargaAtual(int cargaAtual) {
        this.cargaAtual = cargaAtual;
    }
    
    /**
     * @return cargaAtual
     */
    public int getCargaAtual() {
        return cargaAtual;
    }
    
    /**
     * Atribui uma instancia para embarque.
     * @param embarque 
     */
    public void setEmbarque(Evento embarque) {
        this.embarque = embarque;
    }
    
    /**
     * @return embarque
     */
    public Evento getEmbarque() {
        return embarque;
    }

    /**
     * Atribui uma instancia para desembarque.
     * @param desembarque 
     */
    public void setDesembarque(Evento desembarque) {
        this.desembarque = desembarque;
    }
    
    /**=
     * @return desembarque
     */
    public Evento getDesembarque() {
        return desembarque;
    }
    
    /**
     * Adiciona um passageiro.
     */
    public void addPassageiro() {
        this.cargaAtual++;
        this.maxPassageiro++;
    }
    
    /**
     * Remove um passageiro.
     */
    public void removePassageiro() {
        this.cargaAtual--;
    }
    
    /**
     * @return maxPassageiro
     */
    public int getMaxPassageiro() {
        return maxPassageiro;
    }

    /**
     * @return String de atributos
     */
    @Override
    public String toString() {
        return "-----VIAGEM-----\nBalsa: " + balsa + "\nCargaAtual: " + cargaAtual + "\nEmbarque: " + embarque + "\nDesembarque: " + desembarque + "\nInicio Viagem: " + getInicio() + "\nFim Viagem:" + getFim();
    }
    
}