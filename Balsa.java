import java.util.ArrayList;

public class Balsa {
    
    private Double cargaMaxima;
    private Double preco;
    private long tempoViagem;
    int qtdEspacos;
    ArrayList<Passageiro> passageiros;

    Balsa (Double cargaMaxima, Double preco, long tempoViagem, int qtdEspacos) {
        this.cargaMaxima = cargaMaxima;
        this.preco = preco;
        this.tempoViagem = tempoViagem;
        this.qtdEspacos = qtdEspacos;
        this.passageiros = new ArrayList<Passageiro>();
    }

    public void setCargaMaxima(Double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setTempoViagem(long tempoViagem) {
        this.tempoViagem = tempoViagem;
    }

    public void setQtdEspacos(int qtdEspacos) {
        this.qtdEspacos = qtdEspacos;
    }

    public Double getCargaMaxima() {
        return cargaMaxima;
    }

    public Double getPreco() {
        return preco;
    }

    public int getQtdEspacos() {
        return qtdEspacos;
    }

    public long getTempoViagem() {
        return tempoViagem;
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    void embarque(Passageiro passageiro) {
        this.passageiros.add(passageiro);
    }

    void desembarque(Passageiro passageiro) {
        this.passageiros.remove(passageiro);
    }

    void desembarque() {
        this.passageiros.clear();
    }

}
