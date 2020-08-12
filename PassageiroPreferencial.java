public class PassageiroPreferencial extends Passageiro{

    // Versão da Classe PassageiroPreferencial
    private static final long serialVersionUID = 1L;

    // Tipo de Preferência, não utilizado no momento
    private String tipoPreferencia;

    PassageiroPreferencial (String cpf, String nome, int idade, String sexo, String tipoPreferencia) {
        super(cpf, nome, idade, sexo, 1);
        this.tipoPreferencia = tipoPreferencia;
    }

    public void setTipoPreferencia(String tipoPreferencia) {
        this.tipoPreferencia = tipoPreferencia;
    }

    public String getTipoPreferencia() {
        return tipoPreferencia;
    }

    @Override
    public String toString() {
        return super.toString() + "\n(Preferencial, " + this.tipoPreferencia + ")";
    }
    
}