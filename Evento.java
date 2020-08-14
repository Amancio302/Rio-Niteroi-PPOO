import java.io.Serializable;

public class Evento implements Comparable<Evento>, Serializable{
    
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
        return "-----Evento-----\nInicio Evento: " + inicio + "\nFim Evento: " + fim;
    }

    @Override
    public int compareTo(Evento e) {
        if (this.fim > e.fim) {
            return 1;
        } else if (this.fim == e.fim) {
            return 0;
        }
        return -1;
    }

}
