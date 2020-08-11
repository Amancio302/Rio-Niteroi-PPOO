import java.util.ArrayList;

public class Balsa {
    
    private Double cargaMaxima;
    private Double preco;
    private long tempoViagem;
    int qtdEspacos;
    ArrayList<Veiculo> veiculos;

    Balsa (Double cargaMaxima, Double preco, long tempoViagem, int qtdEspacos) {
        this.cargaMaxima = cargaMaxima;
        this.preco = preco;
        this.tempoViagem = tempoViagem;
        this.qtdEspacos = qtdEspacos;
        this.veiculos = new ArrayList<Veiculo>();
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

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    void embarque(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    void desembarque(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
    }

    void desembarque() {
        this.veiculos.clear();
    }

}
