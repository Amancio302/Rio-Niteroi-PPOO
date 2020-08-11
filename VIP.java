public class VIP extends Passageiro{
    
    private String documentoOficial;

    VIP (String cpf, String nome, String sexo, int idade, String documentoOficial) {
        super(cpf, nome, sexo, idade, 0);
        this.documentoOficial = documentoOficial;
    }

    public void setDocumentoOficial(String documentoOficial) {
        this.documentoOficial = documentoOficial;
    }

    public String getDocumentoOficial() {
        return documentoOficial;
    }

}