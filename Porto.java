import java.util.*;

public class Porto{
	
	private ArrayList<Balsa> balsasDisponiveis;
	private ArrayList<Passageiro> filaComum;
	private ArrayList<Passageiro> filaExpress;
	
	
	public Porto(ArrayList<Balsa> balsas, ArrayList<Passageiro> filaCm, ArrayList<Passageiro> filaEx){
		balsasDisponiveis = balsas;
		filaComum = filaCm;
		filaExpress = filaEx;
	}
	
	public void setBalsasDisponiveis(ArrayList<Balsa> balsas) {
        this.balsasDisponiveis = balsas;
    }
    
    public void setFilaComum(ArrayList<Passageiro> filaCm){
        this.filaComum = filaCm;
    }
    
    public void setFilaExpress(ArrayList<Passageiro> filaEx){
        this.filaExpress = filaEx;
    }
    
    public ArrayList<Balsa> getBalsasDisponiveis(){
		return balsasDisponiveis;
	}
	
    public ArrayList<Passageiro> getFilaComum(){
		return filaComum;
	}
	
    public ArrayList<Passageiro> getFilaExpress(){
		return filaExpress;
	}
	
	public void entrarNaFila(Passageiro p, String fila){}
	public void sairDaFila(Passageiro p){}
	public void embarcarBalsa(Balsa b){}
	public void desembarcarBalsa(Balsa b){}
}

