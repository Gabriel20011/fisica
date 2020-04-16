package controlador;
import java.util.ArrayList;

import modelo.CampoElectrico;
import modelo.Carga;
import modelo.LeyCoulomb;
import modelo.Potencial;
import vista.VPrincipal;
public class Controlador {

	private VPrincipal vPrincipal;
	private LeyCoulomb lc;
	private CampoElectrico ce;
	private Carga pivote;
	private Potencial pot;
	private ArrayList<Carga> cargas;
	

	public Controlador() {

		cargas = new ArrayList<Carga>();
		lc = new LeyCoulomb();
		ce = new CampoElectrico();
		pot = new Potencial();
		vPrincipal = new VPrincipal(this, 0 ,0);
		vPrincipal.setVisible(true);
		pivote = new Carga();
	}
	public Potencial getPot() {
		return pot;
	}
	public void setPot(Potencial pot) {
		this.pot = pot;
	}

	public Carga buscarCarga(double x, double y) {
		Carga found = null;
		for (Carga i : cargas) {
			if (i.getX() == x && i.getY() == y) {
				found = i;
			}
		}
		return found;
	}
	public ArrayList<Carga> seleccionarPivote() {
		ArrayList<Carga> cargaSinPivote = new ArrayList<Carga>();
		for (Carga i : cargas) {
			if (i.getX() != pivote.getX() || i.getY() != pivote.getY()) {
				cargaSinPivote.add(i);
			}
		}
		return cargaSinPivote;
	}
	public void calcularCampo() {
		seleccionarPivote();
		ce.vectorCampo(seleccionarPivote(), pivote);
	}
	
	public void calcularFuerza() {
		seleccionarPivote();
		lc.vectorFuerza(seleccionarPivote(), pivote);
	}
	public void vaciar() {
		cargas = new ArrayList<Carga>();
		setPivote(null);
		ce.setCampoI(0);
		ce.setCampoJ(0);
	}
	


	public void agregar(Carga carga) {
		cargas.add(carga);
	}

	public LeyCoulomb getLc() {
		return lc;
	}

	public void setLc(LeyCoulomb lc) {
		this.lc = lc;
	}

	public CampoElectrico getCe() {
		return ce;
	}

	public void setCe(CampoElectrico ce) {
		this.ce = ce;
	}

	public ArrayList<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(ArrayList<Carga> cargas) {
		this.cargas = cargas;
	}

	public void setPivote(Carga pivote) {
		this.pivote = pivote;
	}

	public Carga getPivote() {
		return pivote;
	}
}