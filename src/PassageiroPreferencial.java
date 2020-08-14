/**
 * Classe PassageiroPreferencial
 * Representa um tipo variante da classe Passageiro
 * @author Amancio, Jean, Leonardo e Vitor.
 */
package src;
public class PassageiroPreferencial extends Passageiro{

    // Versão da Classe PassageiroPreferencial
    private static final long serialVersionUID = 1L;
    // Tipo de Preferência, não utilizado no momento
    private String tipoPreferencia;
    
    /**
     * Instancia um objeto do tipo PassageiroPreferencial que é variante da classe Passageiro.
     * @param cpf
     * @param nome
     * @param idade
     * @param sexo
     * @param tipoPreferencia 
     */
    PassageiroPreferencial (String cpf, String nome, int idade, String sexo, String tipoPreferencia) {
        super(cpf, nome, idade, sexo, 1);
        this.tipoPreferencia = tipoPreferencia;
    }

    /**
     * Atribui uma instancia para tipoPreferencia.
     * @param tipoPreferencia 
     */
    public void setTipoPreferencia(String tipoPreferencia) {
        this.tipoPreferencia = tipoPreferencia;
    }

    /** 
     * @return tipoPreferencia
     */
    public String getTipoPreferencia() {
        return tipoPreferencia;
    }

    /**
     * @return String de atributos
     */
    @Override
    public String toString() {
        return super.toString() + "\n(Preferencial, " + this.tipoPreferencia + ")";
    }
    
}
