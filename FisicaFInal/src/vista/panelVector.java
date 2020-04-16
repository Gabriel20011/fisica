package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class panelVector extends JPanel {
	
	private Point dir;
	
	public panelVector(Point dir) {
		setLayout(null);
		this.dir = dir;
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		dibujar((Graphics2D) g);
		graficarVector((Graphics2D) g);
	}
	
	public void graficarVector(Graphics2D g) {
		Line2D linea = new Line2D.Float(new Point((int)(400/2), (int) (320/2)), dir);
		g.draw(linea);
		
	}
	public void dibujar(Graphics2D g){

		int alto = 400;
		int ancho = 320;
		
		for(int i = 0; i < alto ; i+=10){
			Line2D  linea = new Line2D.Double(i,0,i,alto);
			if(i % 10 == 0){
				g.setColor(new Color(204,204,204));
				g.draw(linea);
			}
		}

		for(int i = 0; i < ancho +(alto - ancho); i+=10){
			Line2D  linea = new Line2D.Double(0,i,alto,i);
			if(i % 10 == 0){
				g.setColor(new Color(204,204,204));
				g.draw(linea);
			}
		}
		g.setColor(Color.BLACK);
		Line2D linea_y = new Line2D.Double(alto/2,0,alto/2,alto);
		Line2D  linea_x = new Line2D.Double(0,ancho/2,alto,ancho/2);

		g.draw(linea_x);
		g.draw(linea_y);

	}
}
