package modelo;
import java.util.ArrayList;
public class CampoElectrico {
	private final static double k = 9E9;
	private double campoI;
	private double campoJ;
	
	public CampoElectrico() {
	}
	private double campoPunto(int i, ArrayList<Carga> cargas, Carga pivote) {
		double a =0;
		if(cargas.get(i).getCarga()<0) {
			cargas.get(i).setCarga(cargas.get(i).getCarga()*-1);
		}
			a = (k*pivote.getCarga()*cargas.get(i).getCarga())/(Math.pow(cargas.get(i).getR(), 2));
		return a;
	}
	public void vectorCampo(ArrayList<Carga> cargas, Carga pivote) {
		campoI=0;
		campoJ=0;
		for (int i = 0; i < cargas.size(); i++) {
			if(cargas.get(i).getCarga()>0 && pivote.getCarga()<0 ||
			cargas.get(i).getCarga()<0 && pivote.getCarga()>0) {
				unitarioAtracion(cargas, pivote);
			}else{
				unitarioRepulsion(cargas, pivote);
			}
			System.out.println(cargas.get(i).getUnitarioI());
			campoI += campoPunto(i,cargas, pivote)*cargas.get(i).getUnitarioI();
			campoJ += campoPunto(i,cargas, pivote)*cargas.get(i).getUnitarioJ();
		}
	}	
	public void unitarioAtracion(ArrayList<Carga> cargas, Carga pivote) {
		
		double pivoteX = pivote.getX()/100;
		double pivoteY = pivote.getY()/100;
		for (int i = 0; i < cargas.size(); i++) {
			double sumaI = (cargas.get(i).getX()/100)-pivoteX;
			double sumaJ = (cargas.get(i).getY()/100)-pivoteY;
			double r = Math.pow(sumaI, 2) + Math.pow(sumaJ, 2);
			cargas.get(i).setR(Math.pow(r, 0.5));
			cargas.get(i).setUnitarioI(sumaI/Math.pow(r, 0.5));
			cargas.get(i).setUnitarioJ(sumaJ/Math.pow(r, 0.5));
		}
	}
	public void unitarioRepulsion(ArrayList<Carga> cargas, Carga pivote) {

		double pivoteX = pivote.getX()/100;
		double pivoteY = pivote.getY()/100;
		for (int i = 0; i < cargas.size(); i++) {
			double sumaI = (cargas.get(i).getX()/100)-pivoteX;
			double sumaJ = (cargas.get(i).getY()/100)-pivoteY;
			double r = Math.pow(sumaI, 2) + Math.pow(sumaJ, 2);
			cargas.get(i).setR(Math.pow(r, 0.5));
			cargas.get(i).setUnitarioI(sumaI/Math.pow(r, 0.5)*-1);
			cargas.get(i).setUnitarioJ(sumaJ/Math.pow(r, 0.5)*-1);
			
		}
	}

	public double getCampoI() {
		return campoI;
	}
	
	public void setCampoI(double fuerzaI) {
		this.campoI = fuerzaI;
	}
	
	public double getCampoJ() {
		return campoJ;
	}
	
	public void setCampoJ(double fuerzaJ) {
		this.campoJ = fuerzaJ;
	}
}