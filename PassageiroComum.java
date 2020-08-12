public class PassageiroComum extends Passageiro{

    // Versão da Classe PassageiroComum
    private static final long serialVersionUID = 1L;

    PassageiroComum(String cpf, String nome, int idade, String sexo) {
        super(cpf, nome, idade, sexo, 2);
    }
    
}