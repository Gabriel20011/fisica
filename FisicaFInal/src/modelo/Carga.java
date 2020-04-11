package modelo;

public class Carga {
	private double carga;
	private double x,y;
	private double unitarioI;
	private double unitarioJ;
	private double r;
	private double uniI;
	private double uniJ;

	
	public double getUniI() {
		return uniI;
	}
	public void setUniI(double uniI) {
		this.uniI = uniI;
	}
	public double getUniJ() {
		return uniJ;
	}
	public void setUniJ(double uniJ) {
		this.uniJ = uniJ;
	}
	public Carga(double carga, double x, double y) {
		super();
		this.carga = carga;
		this.x = x;
		this.y = y;
	}
	public Carga() {
		
	}
	public double getCarga() {
		return carga;
	}
	public void setCarga(double carga) {
		this.carga = carga;
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
	public double getUnitarioI() {
		return unitarioI;
	}
	public void setUnitarioI(double unitarioI) {
		this.unitarioI = unitarioI;
	}
	public double getUnitarioJ() {
		return unitarioJ;
	}
	public void setUnitarioJ(double unitarioJ) {
		this.unitarioJ = unitarioJ;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
}