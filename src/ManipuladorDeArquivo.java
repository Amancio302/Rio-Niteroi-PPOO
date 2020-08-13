/**
 * Classe ManipuladorDeArquivo
 * Manipula o Arquivo
 * @author Amancio, Jean, Leonardo e Vitor.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Classe com objetivo central de manipular arquivos
 * Todas as operações de I/O em arquivos são realizadas nesse arquivo
 */
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

    /**
     * Função para carregar uma simulação de arquivo binário
     * @param nome Nome do arquivo
     * @return Instância da simulação carregada
     */
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