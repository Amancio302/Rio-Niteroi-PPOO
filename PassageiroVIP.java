public class PassageiroVIP extends Passageiro{

    // Versão da Classe PassageiroVIP
    private static final long serialVersionUID = 1L;

    // Comprovante de passe VIP
    private String comprovanteVIP;

    PassageiroVIP(String cpf, String nome, int idade, String sexo, String comprovanteVIP) {
        super(cpf, nome, idade, sexo, 0);
        this.comprovanteVIP = comprovanteVIP;
    }

    public void setComprovanteVIP(String comprovanteVIP) {
        this.comprovanteVIP = comprovanteVIP;
    }

    public String getComprovanteVIP() {
        return comprovanteVIP;
    }

    @Override
    public String toString() {
        return super.toString() + "\n(VIP, " + this.comprovanteVIP + ")";
    }
    
    
}