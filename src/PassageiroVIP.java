/**
 * Classe PassageiroVIP
 * Representa um tipo variante da classe Passageiro
 * @author Amancio, Jean, Leonardo e Vitor.
 */

public class PassageiroVIP extends Passageiro{

    // Versão da Classe PassageiroVIP
    private static final long serialVersionUID = 1L;

    // Comprovante de passe VIP
    private String comprovanteVIP;
    
    /**
     * Instancia um objeto do tipo PassageiroVIP que é variante da classe Passageiro.
     * @param cpf
     * @param nome
     * @param idade
     * @param sexo
     * @param comprovanteVIP 
     */
    PassageiroVIP(String cpf, String nome, int idade, String sexo, String comprovanteVIP) {
        super(cpf, nome, idade, sexo, 0);
        this.comprovanteVIP = comprovanteVIP;
    }
    
    /**
     * Atribui uma instancia para comprovanteVIP.
     * @param comprovanteVIP 
     */
    public void setComprovanteVIP(String comprovanteVIP) {
        this.comprovanteVIP = comprovanteVIP;
    }

    /**
     * @return comprovanteVIP
     */
    public String getComprovanteVIP() {
        return comprovanteVIP;
    }

    /**
     * @return String de atributos
     */
    @Override
    public String toString() {
        return super.toString() + "\n(VIP, " + this.comprovanteVIP + ")";
    }
      
}
