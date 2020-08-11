import java.util.ArrayList;

public class Simulador {
	Porto portoRj;
	Porto portoNt;
	ArrayList<Balsa> balsas;
	ArrayList<Veiculo> veiculos;
	
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
	public void setBalsas(ArrayList<Balsa> balsas) {
		this.balsas = balsas;
	}
	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	
}
