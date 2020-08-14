/**
 * Classe PassageiroVIP
 * Representa um tipo variante da classe Passageiro
 * @author Amancio, Jean, Leonardo e Vitor.
 */
package src;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Plot extends Application {

	ArrayList<ArrayList<Passageiro>> passageiros;
    ArrayList<ArrayList<Long>> temposDeAtendimento;
    
    public Plot(){
    	passageiros = new ArrayList<ArrayList<Passageiro>>();
    	temposDeAtendimento = new ArrayList<ArrayList<Long>>();
    }
    
	@Override public void start(Stage stage) {
		stage.setTitle("Porto");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Tempo de Atendimento (ms)");
		final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
		lineChart.setTitle("Rio - Niteroi");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Passageiros Comuns");
        series1.getData().add(new XYChart.Data("Passageiro1", 15300));
        series1.getData().add(new XYChart.Data("Passageiro2", 15900));
        series1.getData().add(new XYChart.Data("Passageiro3", 16100));
        /*
        for(int i = 0; i < passageiros.get(0).size(); i++) {
        		series1.getData().add(new XYChart.Data(passageiros.get(0).get(i).getNome(), temposDeAtendimento.get(0).get(i)));
        }
        */
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Passageiros Preferenciais");
        series2.getData().add(new XYChart.Data("Passageiro1", 15100));
        series2.getData().add(new XYChart.Data("Passageiro2", 15300));
        series2.getData().add(new XYChart.Data("Passageiro3", 15500));
        /*
        for(int i = 0; i < passageiros.get(1).size(); i++) {
    			series2.getData().add(new XYChart.Data(passageiros.get(1).get(i).getNome(), temposDeAtendimento.get(1).get(i)));
        }
        */
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Passageiros VIPs");
        series3.getData().add(new XYChart.Data("Passageiro1", 8100));
        series3.getData().add(new XYChart.Data("Passageiro2", 8300));
        series3.getData().add(new XYChart.Data("Passageiro3", 8500));
        /*
        for(int i = 0; i < passageiros.get(2).size(); i++) {
    			series3.getData().add(new XYChart.Data(passageiros.get(2).get(i).getNome(), temposDeAtendimento.get(2).get(i)));
        }
        */
        
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series1, series2, series3);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public void runPlot(Simulador simulador) {
    	passageiros.add(simulador.getListaDeComuns());
    	temposDeAtendimento.add(simulador.getListaDeAtendimentoComuns());
    	passageiros.add(simulador.getListaDePreferenciais());
    	temposDeAtendimento.add(simulador.getListaDeAtendimentoPreferenciais());
    	passageiros.add(simulador.getListaDeVIPs());
    	temposDeAtendimento.add(simulador.getListaDeAtendimentoVIPs());
        System.out.println("\nPassageiros: " + passageiros);
        System.out.println("\nTempos de atendimento: " + temposDeAtendimento);
        System.out.println("\nTam: " + passageiros.get(0).size());
        System.out.println("\nTempo: " + temposDeAtendimento.get(0).get(0));
    	launch();
    }
}