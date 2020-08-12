import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Classe Simulador
 * Reponsável por simular toda a operação do porto
 */
public class Simulador implements Serializable{

    // Versão da Classe Simulador
    private static final long serialVersionUID = 1L;

    private Porto porto1;
    private Porto porto2;
    private Evento simulacao;
    private ArrayList<Evento> eventosConcluidos;
    
    Simulador () {
        this.porto1 = null;
        this.porto2 = null;
        this.simulacao = new Evento();
        eventosConcluidos = new ArrayList<Evento>();
    }

    public void setPorto1(Porto porto1) {
        this.porto1 = porto1;
    }

    public Porto getPorto1() {
        return porto1;
    }

    public void setPorto2(Porto porto2) {
        this.porto2 = porto2;
    }

    public Porto getPorto2() {
        return porto2;
    }

    public void iniciarSimulacao() {
        this.simulacao.setInicio(System.currentTimeMillis());
        run();
    }

    public void encerrarSimulacao(long fim) {
        this.simulacao.setFim(fim);
    }

    public void setEventosConcluidos(ArrayList<Evento> eventosConcluidos) {
        this.eventosConcluidos = eventosConcluidos;
    }

    public ArrayList<Evento> getEventosConcluidos() {
        return eventosConcluidos;
    }

    public void run(){
        ArrayList<Porto> portos = new ArrayList<Porto>();
        porto1.abrirPorto();
        porto2.abrirPorto();
        portos.add(porto1);
        portos.add(porto2);
        long tempoAtual = this.simulacao.getInicio();
        ArrayList<Porto> removeList = new ArrayList<Porto>();
        while (!portos.isEmpty()) {
            
            for (Porto porto : portos) {
                ArrayList<Evento> eventosConcluidos = porto.run(tempoAtual);
                for(Evento evento : eventosConcluidos) {
                    this.eventosConcluidos.add(evento);
                }
                if (porto.filasVazias()) {
                    removeList.add(porto);
                }
            }
            for (Porto porto : removeList) {
                portos.remove(porto);
            }
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
        System.out.println("Eventos: " + eventosConcluidos);
        for (Evento evento : eventosConcluidos) {
            System.out.println(evento);
        }
        System.out.println("Cabou carai 2");
    }

}
