package modelo;
import java.util.ArrayList;
public class CampoMagnetico {
	private double carga;
	private ArrayList<Double> velocidad;
	private ArrayList<Double> campo;
	private double x;
	private double y;
	private double z;
	private String fuerza;


	public CampoMagnetico() {
	}
	public void fuerzaElectromagnetica(double carga, ArrayList<Double> velocidad,ArrayList<Double> campo){
		ArrayList<Double> productoCruz = new ArrayList<Double>();
		productoCruz.add((velocidad.get(1)*campo.get(2)) - (velocidad.get(2)*campo.get(1)));
		productoCruz.add(-1*(velocidad.get(0)*campo.get(2)) - (velocidad.get(2)*campo.get(0)));
		productoCruz.add((velocidad.get(0)*campo.get(1)) - (velocidad.get(1)*campo.get(0)));
		for (int i = 0; i < productoCruz.size(); i++) {
			productoCruz.set(i,productoCruz.get(i)*carga);
		}
		x = productoCruz.get(0);
		y = productoCruz.get(1);
		z = productoCruz.get(2);
		if(x>=0) {
			fuerza = String.valueOf(x)+" x ";
		}if(y==0) {
			fuerza += "+ "+String.valueOf(-1*y)+" y ";
		}if(y>0) {
			fuerza += "+ "+String.valueOf(y)+" y ";
		}if(y<0) {
			fuerza += String.valueOf(y)+" y ";
		}if(z>=0) {
			fuerza += "+ "+String.valueOf(z)+" z ";
		}else {
			fuerza += String.valueOf(z)+" z ";
		}
	}
	public double getCarga() {
		return carga;
	}
	public void setCarga(double carga) {
		this.carga = carga;
	}
	public ArrayList<Double> getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(ArrayList<Double> velocidad) {
		this.velocidad = velocidad;
	}
	public ArrayList<Double> getCampo() {
		return campo;
	}
	public void setCampo(ArrayList<Double> campo) {
		this.campo = campo;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public String getFuerza() {
		return fuerza;
	}
	public void setFuerza(String fuerza) {
		this.fuerza = fuerza;
	}

}