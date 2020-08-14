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
    	
    }
    
	@Override public void start(Stage stage) {
		stage.setTitle("Porto");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Tempo de Atendimento (ms)");
		final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
		lineChart.setTitle("Rio - Niteroi");
        
		System.out.println("teste0 " + passageiros);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Passageiros Comuns");
        for(int i = 0; i < passageiros.get(0).size(); i++) {
        		series1.getData().add(new XYChart.Data(passageiros.get(0).get(i).getNome(), temposDeAtendimento.get(0).get(i)));
        }
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Passageiros Preferenciais");
        System.out.println("teste1");
        for(int i = 0; i < passageiros.get(1).size(); i++) {
    			series2.getData().add(new XYChart.Data(passageiros.get(1).get(i).getNome(), temposDeAtendimento.get(1).get(i)));
        }
        System.out.println("teste2");
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Passageiros VIPs");
        for(int i = 0; i < passageiros.get(2).size(); i++) {
    			series3.getData().add(new XYChart.Data(passageiros.get(2).get(i).getNome(), temposDeAtendimento.get(2).get(i)));
        }
        
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series1, series2, series3);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public void runPlot(Simulador simulador) {
    	passageiros = new ArrayList<ArrayList<Passageiro>>();
    	temposDeAtendimento = new ArrayList<ArrayList<Long>>();
    	passageiros.add(simulador.getListaDeComuns());
    	temposDeAtendimento.add(simulador.getListaDeAtendimentoComuns());
    	passageiros.add(simulador.getListaDePreferenciais());
    	temposDeAtendimento.add(simulador.getListaDeAtendimentoPreferenciais());
    	passageiros.add(simulador.getListaDeVIPs());
    	temposDeAtendimento.add(simulador.getListaDeAtendimentoVIPs());
        System.out.println(passageiros);
        System.out.println(temposDeAtendimento);
    	launch();
    }
}