import java.util.ArrayList;

public class Simulador {

	Porto portoRj;
	Porto portoNt;
	ArrayList<Balsa> balsas;
    ArrayList<Passageiro> passageiros;
    
    Simulador (Porto portoRJ, Porto PortoNt) {

    }
	
	public Porto getPortoRj() {
		return portoRj;
    }
    
	public void setPortoRj(Porto portoRj) {
		this.portoRj = portoRj;
    }
    
	public Porto getPortoNt() {
		return portoNt;
    }
    
	public void setPortoNt(Porto portoNt) {
		this.portoNt = portoNt;
    }
    
	public ArrayList<Balsa> getBalsas() {
		return balsas;
    }
    
	public void setBalsas(Balsa balsa) {
		this.balsas.add(balsa);
    }
    
	public ArrayList<Passageiro> getPassageiros() {
		return passageiros;
    }
    
	public void setPassageiros(Passageiro passageiro) {
		this.passageiros.add(passageiro);
	}
	
	
}
