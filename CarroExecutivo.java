public class CarroExecutivo extends Veiculo{
    
    private String documentoOficial;

    CarroExecutivo (String placa, String marca, String modelo, Double peso, int qtdOcupantes, String documentoOficial) {
        super(placa, marca, modelo, peso, 4, qtdOcupantes, 0);
        this.documentoOficial = documentoOficial;
    }

    public void setDocumentoOficial(String documentoOficial) {
        this.documentoOficial = documentoOficial;
    }

    public String getDocumentoOficial() {
        return documentoOficial;
    }

}
