package controlador;
import java.util.ArrayList;

import modelo.CampoElectrico;
import modelo.CampoMagnetico;
import modelo.Carga;
import modelo.LeyCoulomb;
import modelo.Potencial;
import vista.MainMenu;
import vista.PanelPlano;
import vista.VPrincipal;

public class Controlador {

	private LeyCoulomb lc;
	private CampoElectrico ce;
	private Carga pivote;
	private Potencial pot;
	private ArrayList<Carga> cargas;
	private CampoMagnetico magnetico;

	public Controlador() {
		iniciar();
	}

	public void iniciar() {

		cargas = new ArrayList<Carga>();
		lc = new LeyCoulomb();
		ce = new CampoElectrico();
		pot = new Potencial();
		MainMenu vista = new MainMenu(this);
		vista.setVisible(true);
		pivote = new Carga();
		magnetico = new CampoMagnetico();
	}
	public void iniciarPlano(int anchura, int altura, VPrincipal h) {

		cargas = new ArrayList<Carga>();
		lc = new LeyCoulomb();
		ce = new CampoElectrico();
		pot = new Potencial();
		pivote = new Carga();
		magnetico = new CampoMagnetico();
		h.setVisible(false);
		h = null;
		VPrincipal p = new VPrincipal(this, anchura, altura);
		p.setVisible(true);
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
	public void calcularPotencial() {
		seleccionarPivote();
		pot.calcularPotencial(seleccionarPivote(), pivote);
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
	public CampoMagnetico getMagnetico() {
		return magnetico;
	}
	public void setMagnetico(CampoMagnetico magnetico) {
		this.magnetico = magnetico;
	}

}