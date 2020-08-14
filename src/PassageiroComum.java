/**
 * Classe PassageiroComum
 * Representa um tipo variante da classe Passageiro
 * @author Amancio, Jean, Leonardo e Vitor.
 */
package src;
public class PassageiroComum extends Passageiro{

    // Versão da Classe PassageiroComum
    private static final long serialVersionUID = 1L;
    
    /**
     * Instancia um objeto do tipo PassageiroComum que é variante da classe Passageiro.
     * @param cpf
     * @param nome
     * @param idade
     * @param sexo 
     */
    PassageiroComum(String cpf, String nome, int idade, String sexo) {
        super(cpf, nome, idade, sexo, 2);
    }
    
}
