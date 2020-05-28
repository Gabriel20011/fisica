package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class PanelPlano extends JPanel {
	
	
	private int alto;
	private int ancho;
	private boolean esPositivo;
	private Point velocidad = null;
	private Point campo = null;

	

	public PanelPlano(int ancho, int alto) {
		this.alto = alto;
		this.ancho = ancho;

		setLayout(null);
		setBackground(Color.black);

	}
	
	public PanelPlano(int ancho, int alto, boolean esPositivo, Point velocidad, Point campo) {
		this.alto = alto;
		this.ancho = ancho;
		this.esPositivo = esPositivo;
		this.velocidad = velocidad;
		this.campo = campo;

		setLayout(null);
		setBackground(Color.black);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		dibujar((Graphics2D) g);
		if (velocidad != null) {
			dibujarVectores(esPositivo, velocidad, campo);
		}
	}


	public void dibujar(Graphics2D g){

		if (alto > ancho) {
			for(int i = 0; i < alto ; i++){
				Line2D  linea = new Line2D.Double(i,0,i,alto);
				if(i % 10 == 0){
					g.setColor(new Color(204,204,204));
					g.draw(linea);
				}
			}

			for(int i = 0; i < ancho+ (alto - ancho) ; i++){
				Line2D  linea = new Line2D.Double(0,i,ancho,i);
				if(i % 10 == 0){
					g.setColor(new Color(204,204,204));
					g.draw(linea);
				}
			}
		}
		else {
			for(int i = 0; i < alto+ (ancho - alto); i++){
				Line2D  linea = new Line2D.Double(i,0,i,alto);
				if(i % 10 == 0){
					g.setColor(new Color(204,204,204));
					g.draw(linea);
				}
			}

			for(int i = 0; i < ancho  ; i++){
				Line2D  linea = new Line2D.Double(0,i,ancho,i);
				if(i % 10 == 0){
					g.setColor(new Color(204,204,204));
					g.draw(linea);
				}
			}
		}

		
		g.setColor(Color.BLACK);
		Line2D linea_y = new Line2D.Double(ancho/2,0,ancho/2,alto);
		Line2D BordeSuperior = new Line2D.Double(0, 0, ancho, 0);
		Line2D BordeInferior = new Line2D.Double(new Point(0, alto), new Point(ancho, alto));
		Line2D BordeLateralD = new Line2D.Double(ancho, alto, ancho , 0);
		Line2D BordeLateralI = new Line2D.Double(0, 0, 0 , alto);
		Line2D  linea_x = new Line2D.Double(0,alto/2,ancho,alto/2);

		g.draw(linea_x);
		g.draw(linea_y);
		g.draw(BordeSuperior);
		g.draw(BordeInferior);
		g.draw(BordeLateralI);
		g.draw(BordeLateralD);
	}

	public void dibujarVectores(boolean esPositivo, Point velocidad, Point campo) {
		
	}
}
