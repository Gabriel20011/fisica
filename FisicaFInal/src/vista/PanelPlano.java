package vista;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class PanelPlano extends JPanel {
	
	
	private int alto;
	private int ancho;

	

	public PanelPlano() {
		setLayout(null);
		setBackground(Color.black);

	}
	@Override
	public void paintComponent(Graphics g)
	{
		dibujar((Graphics2D) g);


	}
	public void graficarPuntos(Point inicio, Point fin) {
		int inicioX = inicio.x;
		int inicioY = inicio.y;
		int finX = fin.x;
		int finY = fin.y;
		((Graphics2D)this.getGraphics()).setColor(Color.BLUE);
		((Graphics2D)this.getGraphics()).drawLine(inicioX, inicioY, finX, finY);
		paint(this.getGraphics());
		
	}
	public void graficarUnitario(Point inicio, Point fin) {
		((Graphics2D)this.getGraphics()).setColor(Color.BLUE);
		((Graphics2D)this.getGraphics()).setStroke(new BasicStroke(10));
		this.getGraphics().drawLine(inicio.x, inicio.y, fin.x, fin.y);
		paint(this.getGraphics());
		
	}

	public void dibujar(Graphics2D g){


		for(int i = 0; i < alto ; i++){
			Line2D  linea = new Line2D.Double(i,0,i,alto);
			if(i % 10 == 0){
				g.setColor(new Color(204,204,204));
				g.draw(linea);
			}
		}

		for(int i = 0; i < ancho +(alto - ancho); i++){
			Line2D  linea = new Line2D.Double(0,i,alto,i);
			if(i % 10 == 0){
				g.setColor(new Color(204,204,204));
				g.draw(linea);
			}
		}
		g.setColor(Color.BLACK);
		Line2D linea_y = new Line2D.Double(alto/2,0,alto/2,alto);
		Line2D BordeSuperior = new Line2D.Double(0, 0, alto, 0);
		Line2D BordeInferior = new Line2D.Double(0, alto, alto , alto);
		Line2D BordeLateralI = new Line2D.Double(0, 0, 0 , alto);
		Line2D BordeLateralD = new Line2D.Double(alto, 0, alto , alto);
		Line2D  linea_x = new Line2D.Double(0,alto/2,alto,alto/2);

		g.draw(linea_x);
		g.draw(linea_y);
		g.draw(BordeSuperior);
		g.draw(BordeInferior);
		g.draw(BordeLateralI);
		g.draw(BordeLateralD);
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

}
