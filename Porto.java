import java.util.*;

public class Porto{
	
	private ArrayList<Balsa> balsasDisponiveis;
	private ArrayList<Veiculo> filaComum;
	private ArrayList<Veiculo> filaExpress;
	
	
	public Porto(ArrayList<Balsa> balsas, ArrayList<Veiculo> filaCm, ArrayList<Veiculo> filaEx){
		balsasDisponiveis = balsas;
		filaComum = filaCm;
		filaExpress = filaEx;
	}
	
	public void setBalsasDisponiveis(ArrayList<Balsa> balsas) {
        this.balsasDisponiveis = balsas;
    }
    
    public void setFilaComum(ArrayList<Veiculo> filaCm){
        this.filaComum = filaCm;
    }
    
    public void setFilaExpress(ArrayList<Veiculo> filaEx){
        this.filaExpress = filaEx;
    }
    
    public ArrayList<Balsa> getBalsasDisponiveis(){
		return balsasDisponiveis;
	}
	
    public ArrayList<Veiculo> getFilaComum(){
		return filaComum;
	}
	
    public ArrayList<Veiculo> getFilaExpress(){
		return filaExpress;
	}
	
	public void entrarNaFila(Veiculo v, String fila){}
	public void sairDaFila(Veiculo v){}
	public void embarcarBalsa(Balsa b){}
	public void desembarcarBalsa(Balsa b){}
}

