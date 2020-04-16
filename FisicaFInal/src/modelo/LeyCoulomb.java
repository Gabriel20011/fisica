package modelo;

import java.util.ArrayList;

public class LeyCoulomb {
	private static double k = 9E9;
	private double fuerzaI;
	private double fuerzaJ;

	public LeyCoulomb() {
	}
	public void vectorFuerza(ArrayList<Carga> cargas, Carga pivote) {
		double sumai =0;
		double sumaj =0;
		fuerzaI =0;
		fuerzaJ = 0;
		for (int i = 0; i < cargas.size(); i++) {
			if(cargas.get(i).getCarga()>0 && pivote.getCarga()<0 ||
			cargas.get(i).getCarga()<0 && pivote.getCarga()>0) {
				unitarioAtracion(cargas, pivote);
			}else {
				unitarioRepulsion(cargas, pivote);
			}
			fuerzaI += fuerza(i,cargas, pivote)*cargas.get(i).getUnitarioI();
			fuerzaJ += fuerza(i,cargas, pivote)*cargas.get(i).getUnitarioJ();
			sumai += cargas.get(i).getUnitarioI();
			sumaj += cargas.get(i).getUnitarioI();
		}
		pivote.setUniI(sumai);
		pivote.setUniJ(sumaj);
	}
	public double fuerza(int i,ArrayList<Carga> cargas, Carga pivote) {
		double a = 0;
		a = k*pivote.getCarga()*cargas.get(i).getCarga()/Math.pow(cargas.get(i).getR(), 2);
		return a;
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
			cargas.get(i).setR(Math.pow(sumaI, 2) + Math.pow(sumaJ, 2));
			cargas.get(i).setUnitarioI(sumaI/Math.pow(r, 0.5)*-1);
			cargas.get(i).setUnitarioJ(sumaJ/Math.pow(r, 0.5)*-1);
		}
	}
	public double getFuerzaI() {
		return fuerzaI;
	}
	public void setFuerzaI(double fuerzaI) {
		this.fuerzaI = fuerzaI;
	}
	public double getFuerzaJ() {
		return fuerzaJ;
	}
	public void setFuerzaJ(double fuerzaJ) {
		this.fuerzaJ = fuerzaJ;
	}
}