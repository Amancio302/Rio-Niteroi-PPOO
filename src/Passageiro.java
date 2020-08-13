/**
 * Classe Passageiro
 * Instancia um objeto do tipo Passageiro
 * @author Amancio, Jean, Leonardo e Vitor.
 */

import java.io.Serializable;

public class Passageiro implements Comparable<Passageiro>, Serializable{

    // Versão da Classe Passageiro
    private static final long serialVersionUID = 1L;

    private String cpf;
    private String nome;
    private int idade;
    private String sexo;
    private int prioridade;
    
    /**
     * Instancia um objeto do tipo Passageiro.
     * @param cpf
     * @param nome
     * @param idade
     * @param sexo
     * @param prioridade 
     */
    Passageiro (String cpf, String nome, int idade, String sexo, int prioridade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.prioridade = prioridade;
    }

    /**
     * Atribui uma instancia para cpf.
     * @param cpf 
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    /**
     * @return cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Atribui uma instancia para nome.
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Atribui uma instancia para idade.
     * @param idade 
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Atribui uma instancia para sexo.
     * @param sexo 
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    /**
     * @return sexo
     */
    public String getSexo() {
        return sexo;
    }
    
    /**
     * Atribui uma instancia para prioridade.
     * @param prioridade 
     */
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    
    /**
     * @return prioridade
     */
    public int getPrioridade() {
        return prioridade;
    }

    /**
     * @return atributos
     */
    @Override
    public String toString() {
        return "Passageiro: " + this.nome + "\nCPF: " + this.cpf + "\nSexo: " + this.sexo + "\nIdade: " + this.idade; 
    }
    
    /**
     * Compara prioridade de passageiros.
     * @param passageiro
     * @return int
     */
    @Override
    public int compareTo(Passageiro passageiro) {
        if (this.prioridade > passageiro.getPrioridade())
            return 1;
        else if (this.prioridade == passageiro.getPrioridade())
            return 0;
        return -1;
    }

}