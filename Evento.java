import java.io.Serializable;

public class Evento implements Serializable{
    
    // Versão da Classe Evento
    private static final long serialVersionUID = 1L;

    // Tempo de início do evento, em milissegundos
    private long inicio;
    // Tempo de término do evento, em milissegundos
    private long fim;

    Evento () {
        this.inicio = -1;
        this.fim = -1;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getInicio() {
        return inicio;
    }

    public void setFim(long fim) {
        this.fim = fim;
    }

    public long getFim() {
        return fim;
    }

    @Override
    public String toString() {
        return "\nInicio: " + inicio + "\nFim: " + fim;
    }

}
