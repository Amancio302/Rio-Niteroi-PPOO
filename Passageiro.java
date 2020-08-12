import java.io.Serializable;

public class Passageiro implements Comparable<Passageiro>, Serializable{

    // Versão da Classe Passageiro
    private static final long serialVersionUID = 1L;

    private String cpf;
    private String nome;
    private int idade;
    private String sexo;
    private int prioridade;

    Passageiro (String cpf, String nome, int idade, String sexo, int prioridade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.prioridade = prioridade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return "Passageiro: " + this.nome + "\nCPF: " + this.cpf + "\nSexo: " + this.sexo + "\nIdade: " + this.idade; 
    }

    @Override
    public int compareTo(Passageiro v) {
        if (this.prioridade > v.getPrioridade())
            return 1;
        else if (this.prioridade == v.getPrioridade())
            return 0;
        return -1;
    }

}
