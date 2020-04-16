package modelo;

import java.util.ArrayList;

public class Potencial {
	private double potencial;
	private final static double k = 9E9;

	public Potencial() {
	}
	public void calcularPotencial(ArrayList<Carga> cargas, Carga pivote) {
		double total = 0;
		double pivoteX = pivote.getX()/100;
		double pivoteY = pivote.getY()/100;
		potencial=0;
		for (int i = 0; i < cargas.size(); i++) {
			double sumaI = (cargas.get(i).getX()/100)-pivoteX;
			double sumaJ = (cargas.get(i).getY()/100)-pivoteY;
			if(sumaI<0) {
				sumaI = sumaI*-1;
			}
			if(sumaJ<0) {
				sumaJ = sumaJ*-1;
			}
			double r = Math.pow(sumaI, 2) + Math.pow(sumaJ, 2);
			cargas.get(i).setR(Math.pow(r, 0.5));
			total += cargas.get(i).getCarga()/cargas.get(i).getR();
		}
		potencial = k*pivote.getCarga()*total;
	}
	
	public double getPotencial() {
		return potencial;
	}
	public void setPotencial(double potencial) {
		this.potencial = potencial;
	}
}