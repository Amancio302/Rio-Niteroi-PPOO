/**
 * Classe EventoTravessia
 * Representa um tipo variante de Evento
 * @author Amancio, Jean, Leonardo e Vitor.
 */
package src;
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

    /**
     * Instancia um EventoTravessia que é variante da classe Evento.
    */
    EventoTravessia(Passageiro passageiro) {
        super();
        this.passageiro = passageiro;
        this.viagem = null;
        this.tempoEmbarque = -1;
        this.tempoDesembarque = -1;
        
    }

    /**
     * Atribui uma instancia para passageiro.
     * @param passageiro
    */
    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
    
    /**
     * @return passageiro
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * Atribui uma instancia para viagem.
     * @param viagem
    */
    public void setViagem(EventoViagem viagem) {
        this.viagem = viagem;
    }

    /**
     * @return viagem
     */
    public EventoViagem getViagem() {
        return viagem;
    }

    /**
     * Atribui uma instancia para tempoEmbarque.
     * @param tempoEmbarque
    */
    public void setTempoEmbarque(long tempoEmbarque) {
        this.tempoEmbarque = tempoEmbarque;
    }
    
    /**
     * @return tempoEmbarque
     */
    public long getTempoEmbarque() {
        return tempoEmbarque;
    }

    /**
     * Atribui uma instancia para tempoDesembarque.
     * @param tempoDesembarque
    */
    public void setTempoDesembarque(long tempoDesembarque) {
        this.tempoDesembarque = tempoDesembarque;
    }
    
    /**
     * @return tempoDesembarque
     */
    public long getTempoDesembarque() {
        return tempoDesembarque;
    }
    
    /**
     * @return String de atributos
     */

    @Override
    public String toString() {
        return "-----Travessia-----\nPassageiro: " + passageiro + "\nViagem: " + viagem  + "\nEmbarque: " + tempoEmbarque + "\nDesembarque: " + tempoDesembarque + "\nInicio Travessia: " + getInicio() + "\nFim Travessia:" + getFim();
    }

}