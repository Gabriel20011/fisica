package modelo;

import java.util.ArrayList;

public class Potencial {
	private double potencial;
	private final static double k = 9E9;

	public Potencial() {
	}
	public void calcularPotencial(ArrayList<Carga> cargas, Carga pivote) {
		double total = 0;
		for (int i = 0; i < cargas.size(); i++) {
			double sumaI = cargas.get(i).getX()-pivote.getX();
			double sumaJ = cargas.get(i).getY()-pivote.getY();
			cargas.get(i).setR(Math.pow(sumaI, 2) + Math.pow(sumaJ, 2));
			total += cargas.get(i).getCarga()/cargas.get(i).getR();
		}
		potencial = k*total;
	}
	
	public double getPotencial() {
		return potencial;
	}
	public void setPotencial(double potencial) {
		this.potencial = potencial;
	}
}