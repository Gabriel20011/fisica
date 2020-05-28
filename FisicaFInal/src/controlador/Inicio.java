package controlador;

import java.util.ArrayList;

import modelo.CampoMagnetico;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Controlador c = new Controlador();
		CampoMagnetico c = new CampoMagnetico();
		ArrayList<Double> v = new ArrayList<Double>();
		ArrayList<Double> b = new ArrayList<Double>();
		v.add((double) 20);
		v.add(-19.79);
		v.add((double) 0);
		b.add((double) 0);
		b.add((double) 0);
		b.add(0.01);
		c.fuerzaElectromagnetica(5E-6, v, b);
		System.out.println(c.getX());
		System.out.println(c.getY());
		System.out.println(c.getZ());

		
	}
}