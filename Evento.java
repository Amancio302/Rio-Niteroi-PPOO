public class Evento {
    
    private long tempoInicio;
    private long tempoFim;

    Evento () {
        this.tempoInicio = System.currentTimeMillis();
    }

    public long getTempoInicio() {
        return tempoInicio;
    }

    public long getTempoFim() {
        return tempoFim;
    }

    public void encerrarEvento() {
        this.tempoFim = System.currentTimeMillis();
    }

}
