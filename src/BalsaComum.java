/**
 * Classe BalsaComum
 * Representa um tipo variante da classe Balsa
 * @author Amancio, Jean, Leonardo e Vitor.
 */

public class BalsaComum extends Balsa{
    
    // Versão da Classe Balsa Comum
    private static final long serialVersionUID = 1L;

    /**
     * Instancia um objeto do tipo BalsaComum que é variante da classe Balsa.
     * @param cargaMaxima 
     * @param preco 
     * @param tempoVigem
    */
    BalsaComum() {
        super(150, 20, 15000);
    }
}
