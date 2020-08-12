import java.io.Serializable;

public class Balsa implements Serializable{
    
    // Versão da Classe Balsa
    private static final long serialVersionUID = 1L;

    // Carga máxima de passageiros
    private int cargaMaxima;
    // Preço da passagem
    private float preco;
    // Tempo da viagem em milissegundos
    private long tempoViagem;

    Balsa (int cargaMaxima, float preco, long tempoViagem) {
        this.cargaMaxima = cargaMaxima;
        this.preco = preco;
        this.tempoViagem = tempoViagem;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setTempoViagem(long tempoViagem) {
        this.tempoViagem = tempoViagem;
    }

    public Long getTempoViagem() {
        return tempoViagem;
    }

    @Override
    public String toString() {
        return cargaMaxima + " " + preco + " " + tempoViagem;
    }

}