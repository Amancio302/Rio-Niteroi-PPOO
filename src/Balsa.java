/**
 * Classe Balsa
 * Instancia um objeto do tipo Balsa
 * 
 * @author Amancio, Jean, Leonardo e Vitor.
 */

import java.io.Serializable;

public class Balsa implements Serializable{
    
    // Versão da Classe Balsa
    private static final long serialVersionUID = 1L;
    // Carga máxima de passageiros
    private int cargaMaxima;
    // Preço da passagem
    private float preco;
    // Tempo da viagem em milissegundos
    private long tempoViagem;

    /**
     * Instancia um objeto do tipo Balsa.
     * @param cargaMaxima 
     * @param preco 
     * @param tempoVigem
    */
    Balsa (int cargaMaxima, float preco, long tempoViagem) {
        this.cargaMaxima = cargaMaxima;
        this.preco = preco;
        this.tempoViagem = tempoViagem;
    }
    
    /**
     * Atribui uma instancia para cargaMaxima.
     * @param cargaMaxima
    */
    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    /**
     * @return cargaMaxima 
     */
    public int getCargaMaxima() {
        return cargaMaxima;
    }

    /**
     * Atribui uma instancia para preco.
     * @param preco
    */
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    /**
     * @return preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Atribui uma instancia para tempoViagem.
     * @param tempoViagem
    */
    public void setTempoViagem(long tempoViagem) {
        this.tempoViagem = tempoViagem;
    }
    
    /**
     * @return tempoViagem
     */
    public Long getTempoViagem() {
        return tempoViagem;
    }
    
    /**
     * @return String de atributos
     */
    @Override
    public String toString() {
        return cargaMaxima + " " + preco + " " + tempoViagem;
    }

}