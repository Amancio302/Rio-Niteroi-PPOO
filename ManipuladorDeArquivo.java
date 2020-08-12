import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManipuladorDeArquivo {
    
    /**
     * Função para salvar simulação em arquivo binário
     * @param simulacao Simulação a ser salvo
     * @param nome Nome do arquivo
     */
    public static void salvarSimulacaoEmArquivo(Simulador simulacao, String nome){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nome))){
            oos.writeObject(simulacao);
        } catch (Exception e) {
            System.out.println("Algo deu errado, " + e.getMessage());
        }
    }

    public static Simulador lerSimulacaoDeArquivo(String nome){
        Simulador simulacao = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nome))) {
            simulacao = (Simulador)ois.readObject();
        } catch(Exception e){
            System.out.println("Algo deu errado, " + e.getMessage());
        }
        return simulacao;
    }


}