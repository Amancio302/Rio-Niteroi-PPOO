public class Passageiro implements Comparable<Passageiro>{

    private String cpf;
    private String nome;
    private String sexo;
    private int idade;
    private int prioridade;

    Passageiro (String cpf, String nome, String sexo, int idade, int prioridade) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.prioridade = prioridade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
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
