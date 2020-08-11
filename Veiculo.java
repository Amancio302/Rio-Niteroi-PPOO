public class Veiculo implements Comparable<Veiculo>{

    private String placa;
    private String marca;
    private String modelo;
    private Double peso;
    private int espaco;
    private int qtdOcupantes;
    private int prioridade;

    Veiculo (String placa, String marca, String modelo, Double peso, int espaco, int qtdOcupantes, int prioridade) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.espaco = espaco;
        this.qtdOcupantes = qtdOcupantes;
        this.prioridade = prioridade;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setEspaco(int espaco) {
        this.espaco = espaco;
    }

    public void setQtdOcupantes(int qtdOcupantes) {
        this.qtdOcupantes = qtdOcupantes;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPeso() {
        return peso;
    }

    public int getEspaco() {
        return espaco;
    }

    public int getQtdOcupantes() {
        return qtdOcupantes;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return this.marca + ' ' + this.modelo + "\nPlaca: " + this.placa + "\nTotal de Ocupantes: " + this.qtdOcupantes;
    }

    @Override
    public int compareTo( Veiculo v) {
        if (this.prioridade > v.getPrioridade())
            return 1;
        else if (this.prioridade == v.getPrioridade())
            return 0;
        return -1;
    }

}
