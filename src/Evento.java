/**
 * Classe Evento
 * Representa um Evento
 * @author Amancio, Jean, Leonardo e Vitor.
 */

import java.io.Serializable;

public class Evento implements Comparable<Evento>, Serializable{
    
    // Versão da Classe Evento
    private static final long serialVersionUID = 1L;

    // Tempo de início do evento, em milissegundos
    private long inicio;
    // Tempo de término do evento, em milissegundos
    private long fim;

    /**
     * Instancia um Evento.
    */
    Evento () {
        this.inicio = -1;
        this.fim = -1;
    }

    /**
     * Atribui uma instancia para inicio.
     * @param inicio
    */
    public void setInicio(long inicio) {
        this.inicio = inicio;
    }
    
    /**
     * @return inicio
     */
    public long getInicio() {
        return inicio;
    }

    /**
     * Atribui uma instancia para fim.
     * @param fim
    */
    public void setFim(long fim) {
        this.fim = fim;
    }
    
    /**
     * @return fim
     */
    public long getFim() {
        return fim;
    }

    /**
     * @return String de atributos
     */
    @Override
    public String toString() {
        return "-----Evento-----\nInicio Evento: " + inicio + "\nFim Evento: " + fim;
    }

    /**
     * Faz a comparação do fim do Evento.
     * @param evento
    */
    @Override
    public int compareTo(Evento evento) {
        if (this.fim > evento.fim) {
            return 1;
        } else if (this.fim == evento.fim) {
            return 0;
        }
        return -1;
    }

}