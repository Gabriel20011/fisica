package vista;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import controlador.Controlador;
import modelo.Carga;

public class VPrincipal extends JFrame implements MouseMotionListener, MouseListener, ActionListener {

	private final int ORIGENX, ORIGENY;
	private PanelPlano pPlano;
	private VMagnitud vMagnitud;
	private VPosicion vPosicion;
	private int contP = 0, contN = 0;
	private ArrayList<JButton> btnPositivos;
	private ArrayList<JButton> btnNegativos;
	private JButton btnPivote;
	private JMenuBar menu;
	private JMenuItem limpiar, positivo, negativo, punto, calcularPositivo, calcularNegativo, calcularPunto,
	fuezaPositivo, fuerzaNegativo, calcularpotencial;
	private vVector vVector;
	private JLabel lblPiboteX, lblPiboteY, lblPositivoX, lblPositivoY, lblNegativoX, lblNegativoY;
	private boolean eventoCalcularP , eventoCalcularN, eventoFuerzaP, eventoFuerzaN ;
	private ImageIcon imgPositivos = new ImageIcon("Imagenes/carga positiva.png");
	private ImageIcon imgNegativos = new ImageIcon("Imagenes/carga negativa.png");
	private ImageIcon imgPunto = new ImageIcon("Imagenes/punto.png");
	private Controlador c;



	public VPrincipal (Controlador c, int anchura, int altura) {
		super("Fisica");
		this.c = c;
		ORIGENX = (anchura/2) - 15;
		ORIGENY = (altura/2) - 25;
		setSize(anchura + 300, altura + 50);

		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);

		vMagnitud = new VMagnitud(this);
		vPosicion = new VPosicion(this);

		pPlano = new PanelPlano(anchura, altura);
		pPlano.setBounds(10, 0, anchura + 10, altura + 10);
		pPlano.setVisible(true);
		add(pPlano);

		iniciarArrays();

		btnPositivos.add(new JButton(imgPositivos));
		btnPositivos.get(0).setActionCommand("Positivo");
		btnPositivos.get(0).setBorderPainted(false);
		btnPositivos.get(0).setBounds((ORIGENX * 2) + 80, 50, 50, 50);
		btnPositivos.get(0).addActionListener(this);
		btnPositivos.get(0).addMouseMotionListener(this);
		btnPositivos.get(0).addMouseListener(this);
		add(btnPositivos.get(0));

		btnNegativos.add(new JButton(imgNegativos));
		btnNegativos.get(0).setActionCommand("Negativo");
		btnNegativos.get(0).setBorderPainted(false);
		btnNegativos.get(0).setBounds((ORIGENX * 2) + 80, 150, 50, 50);
		btnNegativos.get(0).addActionListener(this);
		btnNegativos.get(0).addMouseMotionListener(this);
		btnNegativos.get(0).addMouseListener(this);
		add(btnNegativos.get(0));


		lblNegativoX = new JLabel("x : 0 , 0 cm");
		lblNegativoX.setBounds((ORIGENX * 2) + 140, 150, 100, 20);
		add(lblNegativoX);

		lblNegativoY = new JLabel("y : 0 , 0 cm");
		lblNegativoY.setBounds((ORIGENX * 2) + 140, 170, 100, 20);
		add(lblNegativoY);

		lblPositivoX = new JLabel("x : 0 , 0 cm");
		lblPositivoX.setBounds((ORIGENX * 2) + 140, 50, 100, 20);
		add(lblPositivoX);

		lblPositivoY= new JLabel("y : 0 , 0 cm");
		lblPositivoY.setBounds((ORIGENX * 2) + 140, 70, 100, 20);
		add(lblPositivoY);

		lblPiboteX = new JLabel("x : 0 , 0 cm");
		lblPiboteX.setBounds((ORIGENX * 2) + 140, 250, 100, 20);
		add(lblPiboteX);

		lblPiboteY = new JLabel("y : 0 , 0 cm");
		lblPiboteY.setBounds((ORIGENX * 2) + 140, 270, 100, 20);
		add(lblPiboteY);


		btnPivote = new JButton(imgPunto);
		btnPivote.setBounds((ORIGENX * 2) + 80, 250, 50, 50);
		btnPivote.setBorderPainted(false);
		btnPivote.addMouseMotionListener(this);
		btnPivote.addMouseListener(this);
		add(btnPivote);


		iniciarMenu();


	}

	public void iniciarMenu() {
		menu = new JMenuBar();
		JMenu campoTools = new JMenu("Campo");
		JMenu opciones = new JMenu("Opciones");
		JMenu fuerzaTools = new JMenu("Fuerza");
		JMenu potencial = new JMenu("Potencial");
		limpiar = new JMenuItem("Limpiar");
		limpiar.addActionListener(this);
		positivo = new JMenuItem("Ingresar carga positiva");
		positivo.addActionListener(this);
		negativo = new JMenuItem("Ingresar carga negativa");
		negativo.addActionListener(this);
		punto = new JMenuItem("Ingresar un punto");
		punto.addActionListener(this);
		fuezaPositivo = new JMenuItem("Calcular la fuerza a una carga Positiva");
		fuezaPositivo.addActionListener(this);
		fuerzaNegativo = new JMenuItem("Calcular la fuerza a una carga Negativa");
		fuerzaNegativo.addActionListener(this);
		calcularPositivo = new JMenuItem("Calcular campo a una carga Positiva");
		calcularPositivo.addActionListener(this);
		calcularNegativo = new JMenuItem("Calcular campo a una carga Negativa");
		calcularNegativo.addActionListener(this);
		calcularPunto = new JMenuItem("Calcular campo al Punto");
		calcularPunto.addActionListener(this);
		calcularpotencial = new JMenuItem("calcular potencial de una carga puntual");
		calcularpotencial.addActionListener(this);
		opciones.add(limpiar);
		opciones.add(positivo);
		opciones.add(negativo);
		opciones.add(punto);
		campoTools.add(calcularPositivo);
		campoTools.add(calcularNegativo);
		campoTools.add(calcularPunto);
		fuerzaTools.add(fuezaPositivo);
		fuerzaTools.add(fuerzaNegativo);
		potencial.add(calcularpotencial);
		menu.add(opciones);
		menu.add(campoTools);
		menu.add(fuerzaTools);
		menu.add(potencial);
		setJMenuBar(menu);
	}


	public void iniciarArrays() {
		btnNegativos = new ArrayList<JButton>();
		btnPositivos = new ArrayList<JButton>();

	}

	public void dibujarVector(Point vector) {
		vVector = new vVector(vector);
		vVector.setSize(400, 335);
		vVector.setVisible(true);
	}

	public void limpiar() {
		for (int j = btnPositivos.size() - 1; j > -1; j--) {
			btnPositivos.get(j).setVisible(false);
			btnPositivos.get(j).repaint();
			btnPositivos.remove(j);
		}
		for (int i = btnNegativos.size() - 1; i > -1; i--) {
			btnNegativos.get(i).setVisible(false);
			btnNegativos.get(i).repaint();
			btnNegativos.remove(i);
		}

		lblNegativoX.setText("x : 0 , 0 cm");
		lblNegativoY.setText("y : 0 , 0 cm");
		lblPiboteX.setText("x : 0 , 0 cm");
		lblPiboteY.setText("y : 0 , 0 cm");
		lblPositivoX.setText("x : 0 , 0 cm");
		lblPositivoY.setText("y : 0 , 0 cm");

		btnPivote.setLocation((ORIGENX * 2) + 80, 250);

		btnNegativos = new ArrayList<JButton>();
		btnPositivos = new ArrayList<JButton>();

		btnPositivos.add(new JButton(imgPositivos));
		btnPositivos.get(0).setActionCommand("Positivo");
		btnPositivos.get(0).addMouseListener(this);
		btnPositivos.get(0).setBorderPainted(false);
		btnPositivos.get(0).addActionListener(this);
		btnPositivos.get(0).addMouseMotionListener(this);
		btnPositivos.get(0).setBounds((ORIGENX * 2) + 80, 50, 50, 50);

		btnNegativos.add(new JButton(imgNegativos));
		btnNegativos.get(0).setActionCommand("Negativo");
		btnNegativos.get(0).addMouseListener(this);
		btnNegativos.get(0).setBorderPainted(false);
		btnNegativos.get(0).addActionListener(this);
		btnNegativos.get(0).setBounds((ORIGENX * 2) + 80, 150, 50, 50);
		btnNegativos.get(0).addMouseMotionListener(this);

		add(btnNegativos.get(0));
		add(btnPositivos.get(0));
		contN =0;
		contP = 0;
		c.vaciar();
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {

		if (arg0.getSource().equals(btnNegativos.get(contN))) {
			btnNegativos.get(contN).setLocation(btnNegativos.get(contN).getLocation().x + arg0.getPoint().x - 25,
					btnNegativos.get(contN).getLocation().y + arg0.getPoint().y - 25);
			btnNegativos.get(contN).repaint();
			double posX = btnNegativos.get(contN).getLocation().x - ORIGENX ;
			double posY =  ORIGENY - btnNegativos.get(contN).getLocation().y;
			lblNegativoX.setText("x: " + posX+" cm");
			lblNegativoY.setText("y: " + posY+" cm");
			pPlano.repaint();
			repaint();
		}

		if (arg0.getSource().equals(btnPositivos.get(contP))) {
			btnPositivos.get(contP).setLocation(btnPositivos.get(contP).getLocation().x + arg0.getPoint().x - 25,
					btnPositivos.get(contP).getLocation().y + arg0.getPoint().y - 25);
			double posX = btnPositivos.get(contP).getLocation().x - ORIGENX ;
			double posY =  ORIGENY - btnPositivos.get(contP).getLocation().y;
			lblPositivoX.setText("x: " + posX+" cm");
			lblPositivoY.setText("y: " + posY+" cm");
			btnPositivos.get(contP).repaint();
			pPlano.repaint();
			repaint();
		}

		if (arg0.getSource().equals(btnPivote)) {
			btnPivote.setLocation(btnPivote.getLocation().x + arg0.getPoint().x - 25,
					btnPivote.getLocation().y + arg0.getPoint().y - 25);
			double posX = btnPivote.getLocation().x - ORIGENX ;
			double posY =  ORIGENY - btnPivote.getLocation().y;
			lblPiboteX.setText("x: " + posX+" cm");
			lblPiboteY.setText("y: " + posY+" cm");
			btnPivote.repaint();
			pPlano.repaint();
			repaint();
		}
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public boolean verificarArea(JButton but) {
		boolean hola = false;
		if (but.getLocation().x <= ORIGENX*2 && but.getLocation().y <= ORIGENY*2
				&& but.getLocation().x >= 10 && but.getLocation().y >= 0) {
			hola =true;
		}
		return hola;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {



	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (arg0.getSource().equals(btnNegativos.get(contN))) {
			if (!verificarArea(btnNegativos.get(contN))) {
				btnNegativos.get(contN).setLocation((ORIGENX * 2) + 80, 150);
				lblNegativoX.setText("x : 0 , 0 cm");
				lblNegativoY.setText("x : 0 , 0 cm");
				btnNegativos.get(contN).repaint();
				pPlano.repaint();
				repaint();

			}
			else {
				contN ++;
				btnNegativos.add(new JButton(imgNegativos));
				btnNegativos.get(contN).addActionListener(this);
				btnNegativos.get(contN).setBorderPainted(false);
				btnNegativos.get(contN).addMouseListener(this);
				btnNegativos.get(contN).addMouseMotionListener(this);
				btnNegativos.get(contN).setBounds((ORIGENX * 2) + 80, 150, 50, 50);
				add(btnNegativos.get(contN));
				repaint();
				vMagnitud.getBtnAceptar().setActionCommand("AceptarMagnitudNegativo");
				vMagnitud.setVisible(true);
			}
		}
		if (arg0.getSource().equals(btnPositivos.get(contP))) {
			if (!verificarArea(btnPositivos.get(contP))) {
				btnPositivos.get(contP).setLocation((ORIGENX * 2) + 80, 50);
				lblPositivoX.setText("x : 0 , 0 cm");
				lblPositivoY.setText("x : 0 , 0 cm");
				btnPositivos.get(contP).repaint();
				pPlano.repaint();
				repaint();
			}
			else {
				contP ++;
				btnPositivos.add(new JButton(imgPositivos));
				btnPositivos.get(contP).addActionListener(this);
				btnPositivos.get(contP).setBorderPainted(false);
				btnPositivos.get(contP).addMouseListener(this);
				btnPositivos.get(contP).addMouseMotionListener(this);
				btnPositivos.get(contP).setBounds((ORIGENX * 2) + 80, 50, 50, 50);
				add(btnPositivos.get(contP));
				repaint();
				vMagnitud.getBtnAceptar().setActionCommand("AceptarMagnitudPositivo");
				vMagnitud.setVisible(true);
			}

		}
		if (arg0.getSource().equals(btnPivote)) {
			if (!verificarArea(btnPivote)) {
				btnPivote.setLocation((ORIGENX * 2) + 80, 250);
				lblPiboteX.setText("x : 0 , 0 cm");
				lblPiboteY.setText("x : 0 , 0 cm");
				btnPivote.repaint();
				pPlano.repaint();
				repaint();
			}
			else {
				c.setPivote(new Carga());
				c.getPivote().setX(ORIGENX - btnPivote.getLocation().getX());
				c.getPivote().setY(ORIGENY - btnPivote.getLocation().getY());
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Limpiar")){
			limpiar();
		}
		else if (arg0.getActionCommand() == "AceptarMagnitudPositivo") {

			double carga = vMagnitud.enviarMagnitud();
			if (carga != Math.PI) {
				int x = (int) btnPositivos.get(contP - 1).getLocation().getX() - ORIGENX;
				int y = ORIGENY - (int) btnPositivos.get(contP - 1).getLocation().getY();
				c.agregar(new Carga(carga, x, y));

				JOptionPane.showMessageDialog(null, "La carga fue ingresada con exito");
				vMagnitud.setVisible(false);
				vMagnitud.reiniciar();
			}
			else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese bien los datos");
			}
		}
		else if (arg0.getActionCommand() == "AceptarMagnitudNegativo") {
			double carga = vMagnitud.enviarMagnitud();
			if (carga != 5000) {
				int x = (int) btnNegativos.get(contN - 1).getLocation().getX() - ORIGENX;
				int y =  ORIGENY - (int) btnNegativos.get(contN - 1).getLocation().getY();
				c.agregar(new Carga(carga*-1, x, y));

				JOptionPane.showMessageDialog(null, "La carga fue ingresada con exito");
				vMagnitud.setVisible(false);
				vMagnitud.reiniciar();
			}
			else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese bien los datos");
			}
		}
		else if (arg0.getActionCommand() == "Ingresar carga positiva") {
			vPosicion.getBtnAceptar().setActionCommand("AceptarPosicionPositivo");
			vPosicion.setVisible(true);

		}
		else if (arg0.getActionCommand() == "Ingresar carga negativa") {
			vPosicion.getBtnAceptar().setActionCommand("AceptarPosicionNegativo");
			vPosicion.setVisible(true);

		}
		else if (arg0.getActionCommand() == "Ingresar un punto") {
			vPosicion.getBtnAceptar().setActionCommand("AceptarPosicionPuntual");
			vPosicion.setVisible(true);

		}
		else if (arg0.getActionCommand() == "AceptarPosicionPositivo") {
			vPosicion.setVisible(false);
			vMagnitud.getBtnAceptar().setActionCommand("AceptarMagnitudPositivo");
			contP ++;
			btnPositivos.add(new JButton(imgPositivos));
			btnPositivos.get(contP).addActionListener(this);
			btnPositivos.get(contP).setBorderPainted(false);
			btnPositivos.get(contP).addMouseListener(this);
			btnPositivos.get(contP).addMouseMotionListener(this);
			int x = (int)vPosicion.getSpinnerX().getValue() + ORIGENX;
			int y = ORIGENY - (int)vPosicion.getSpinnerY().getValue();
			btnPositivos.get(contP).setBounds(500, 50, 50, 50);
			btnPositivos.get(contP - 1).setLocation(x, y);
			add(btnPositivos.get(contP));
			repaint();
			vMagnitud.getBtnAceptar().setActionCommand("AceptarMagnitudPositivo");
			vMagnitud.setVisible(true);

		}
		else if (arg0.getActionCommand() == "AceptarPosicionNegativo") {

			vPosicion.setVisible(false);
			vMagnitud.getBtnAceptar().setActionCommand("AceptarMagnitudNegativo");
			contN ++;
			btnNegativos.add(new JButton(imgNegativos));
			btnNegativos.get(contN).addActionListener(this);
			btnNegativos.get(contN).setBorderPainted(false);
			btnNegativos.get(contN).addMouseListener(this);
			btnNegativos.get(contN).addMouseMotionListener(this);
			int x = (int)vPosicion.getSpinnerX().getValue() + ORIGENX;
			int y = ORIGENY - (int)vPosicion.getSpinnerY().getValue();
			btnNegativos.get(contN).setBounds(500, 150, 50, 50);
			btnNegativos.get(contN - 1).setLocation(x, y);
			add(btnNegativos.get(contN));
			repaint();
			vMagnitud.getBtnAceptar().setActionCommand("AceptarMagnitudNegativo");
			vMagnitud.setVisible(true);

		}
		else if (arg0.getActionCommand() == "AceptarPosicionPuntual") {
			vPosicion.setVisible(false);
			int x = (int)vPosicion.getSpinnerX().getValue() + ORIGENX;
			int y = ORIGENY - (int)vPosicion.getSpinnerY().getValue();
			btnPivote.setLocation(x, y);
			repaint();

		}
		else if (arg0.getActionCommand() == "Calcular campo a una carga Positiva") {
			eventoCalcularP = true;
			if (btnPositivos.size() > 1) {
				JOptionPane.showMessageDialog(null, "Seleccione la carga positiva a la cual desea ver el campo ejercido hacia el");
				for (int i = 0 ; i < btnNegativos.size() ; i++) {
					btnNegativos.get(i).setEnabled(false);
				}
				btnPositivos.get(btnPositivos.size() - 1).setEnabled(false);
				btnPivote.setEnabled(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay cargas positivas sobre el plano");
			}

		}
		else if(arg0.getActionCommand()== "calcular potencial de una carga puntual") {

			if(c.getCargas().size() > 0) {
				if (verificarArea(btnPivote)) {	
					Carga pivote = new Carga(1, btnPivote.getLocation().getX() - ORIGENX,
							ORIGENY - btnPivote.getLocation().getY());
					c.setPivote(pivote);
					c.calcularPotencial();

					double potencial = c.getPot().getPotencial();
					JOptionPane.showMessageDialog(null, "El resultado es: " + potencial+" V");

				}
				else {
					JOptionPane.showMessageDialog(null, "Ingrese un punto sobre el plano ");

				}
			}else {
				JOptionPane.showMessageDialog(null, "No hay cargas suficieintes sobre el plano");
			}
		}
		else if (arg0.getActionCommand() == "Calcular campo a una carga Negativa") {

			eventoCalcularN = true;
			if (btnNegativos.size() > 1) {
				JOptionPane.showMessageDialog(null, "Seleccione la carga negativa a la cual desea ver el campo ejercido hacia el");
				for (int i = 0 ; i < btnPositivos.size() ; i++) {
					btnPositivos.get(i).setEnabled(false);
				}
				btnNegativos.get(btnNegativos.size() - 1).setEnabled(false);
				btnPivote.setEnabled(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay cargas negativas sobre el plano");
			}

		}
		else if (arg0.getActionCommand() == "Calcular campo al Punto") {
			if (verificarArea(btnPivote)) {
				boolean hayCargas = false;
				for (int i = 0 ; i < btnNegativos.size() ; i++) {
					if (verificarArea(btnNegativos.get(i))) {
						hayCargas = true;
					}
				}
				for (int i = 0 ; i < btnPositivos.size() ; i++) {
					if (verificarArea(btnPositivos.get(i))) {
						hayCargas = true;
					}
				}
				if (hayCargas) {


					c.setPivote(new Carga(1, btnPivote.getLocation().getX()- ORIGENX,
							ORIGENY - btnPivote.getLocation().getY()));
					c.calcularCampo();

					double resultadoI = c.getCe().getCampoI();
					double resultadoJ = c.getCe().getCampoJ();

					if (resultadoJ >= 0 ) {

						JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N/C i +" + resultadoJ + " N/C j");
					}
					else {

						JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N/C i " + resultadoJ+ " N/C j");
					}
					if (Math.abs(resultadoJ) < 100 && Math.abs(resultadoJ) < 100) {
						while(Math.abs(resultadoJ) < 100 && Math.abs(resultadoI) < 100){
							resultadoJ *= 10;
							resultadoI *= 10;
						}
					}
					else if (Math.abs(resultadoJ) > 1000 || Math.abs(resultadoJ) > 1000) {
						while(Math.abs(resultadoJ) > 1000 && Math.abs(resultadoJ) > 1000) {
							resultadoJ /= 10;
							resultadoI /= 10;
						}
					}
					dibujarVector(new Point((int)resultadoI, (int) resultadoJ));

				}
				else {
					JOptionPane.showMessageDialog(null, "No hay cargas sobre el Plano asi que el campo ejercido"
							+ " al Punto es 0i + 0j");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Diriga el pivote en el plano");
			}

		}
		else if (arg0.getActionCommand() == "Calcular la fuerza a una carga Positiva") {
			eventoFuerzaP = true;
			if (btnPositivos.size() > 1) {
				JOptionPane.showMessageDialog(null, "Seleccione la carga positiva a la cual desea ver la fuerza ejercido hacia el");
				for (int i = 0 ; i < btnNegativos.size() ; i++) {
					btnNegativos.get(i).setEnabled(false);
				}
				btnPositivos.get(btnPositivos.size() - 1).setEnabled(false);
				btnPivote.setEnabled(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay cargas positivas sobre el plano");
			}

		}
		else if (arg0.getActionCommand() == "Calcular la fuerza a una carga Negativa") {
			eventoFuerzaN = true;
			if (btnNegativos.size() > 1) {
				JOptionPane.showMessageDialog(null, "Seleccione la carga negativa a la cual desea ver la fuerza ejercido hacia el");
				for (int i = 0 ; i < btnPositivos.size() ; i++) {
					btnPositivos.get(i).setEnabled(false);
				}
				btnNegativos.get(btnNegativos.size() - 1).setEnabled(false);
				btnPivote.setEnabled(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay cargas negativas sobre el plano");
			}

		}
		else if (eventoCalcularN == true) {

			int index;
			for (index = 0 ; index < btnNegativos.size() - 1 ; index++) {
				if (btnNegativos.get(index).equals(arg0.getSource())) {
					break;
				}
			}

			Carga pivote = c.buscarCarga(btnNegativos.get(index).getLocation().getX() - ORIGENX,
					ORIGENY - btnNegativos.get(index).getLocation().getY());
			c.setPivote(pivote);
			c.calcularCampo();

			double resultadoI = c.getCe().getCampoI();
			double resultadoJ = c.getCe().getCampoJ();


			if (resultadoJ >= 0 ) {
				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N/C i +" + resultadoJ + " N/C j");
			}
			else {

				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N/C i " + resultadoJ+ " N/C j");
			}

			for (int i = 0; i < btnPositivos.size(); i++) {
				btnPositivos.get(i).setEnabled(true);

			}
			for (int i = 0 ; i < btnNegativos.size() ; i++) {
				btnNegativos.get(i).setEnabled(true);
			}
			btnPivote.setEnabled(true);
			if (Math.abs(resultadoJ) < 100 || Math.abs(resultadoJ) < 100) {
				while(Math.abs(resultadoJ) < 100 && Math.abs(resultadoI) < 100){
					resultadoJ *= 10;
					resultadoI *= 10;
				}
			}
			else if (Math.abs(resultadoJ) > 1000 || Math.abs(resultadoJ) > 1000) {
				while(Math.abs(resultadoJ) > 1000 && Math.abs(resultadoJ) > 1000) {
					resultadoJ /= 10;
					resultadoI /= 10;
				}
			}
			dibujarVector(new Point((int)resultadoI, (int) resultadoJ));
			index = 0;
			eventoCalcularN = false;

		}
		else if (eventoCalcularP == true) {
			int index = 0;
			for (index = 0 ; index < btnPositivos.size() - 1; index++) {
				if (btnPositivos.get(index).equals(arg0.getSource())) {
					break;
				}
			}

			Carga pivote = c.buscarCarga(btnPositivos.get(index).getLocation().getX() - ORIGENX,
					ORIGENY - btnPositivos.get(index).getLocation().getY());
			c.setPivote(pivote);
			c.calcularCampo();

			double resultadoI = c.getCe().getCampoI();
			double resultadoJ = c.getCe().getCampoJ();
			if (resultadoJ >= 0 ) {
				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N/C i +" + resultadoJ + " N/C j");
			}
			else {

				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N/C i " + resultadoJ+ " N/C j");
			}
			for (int i = 0; i < btnPositivos.size(); i++) {
				btnPositivos.get(i).setEnabled(true);

			}
			for (int i = 0 ; i < btnNegativos.size() ; i++) {
				btnNegativos.get(i).setEnabled(true);
			}

			btnPivote.setEnabled(true);
			if (Math.abs(resultadoJ) < 100 || Math.abs(resultadoJ) < 100) {
				while(Math.abs(resultadoJ) < 100 && Math.abs(resultadoI) < 100){
					resultadoJ *= 10;
					resultadoI *= 10;
				}
			}
			else if (Math.abs(resultadoJ) > 1000 || Math.abs(resultadoJ) > 1000) {
				while(Math.abs(resultadoJ) > 1000 && Math.abs(resultadoJ) > 1000) {
					resultadoJ /= 10;
					resultadoI /= 10;
				}
			}
			dibujarVector(new Point((int)resultadoI, (int) resultadoJ));
			index = 0;
			eventoCalcularP = false;
		}
		else if (eventoFuerzaN == true) {
			eventoFuerzaN = false;
			int index;
			for (index = 0 ; index < btnNegativos.size() - 1 ; index++) {
				if (btnNegativos.get(index).equals(arg0.getSource())) {
					break;
				}
			}

			Carga pivote = c.buscarCarga(btnNegativos.get(index).getLocation().getX() - ORIGENX,
					ORIGENY- btnNegativos.get(index).getLocation().getY());
			c.setPivote(pivote);
			c.calcularFuerza();

			double resultadoI = c.getLc().getFuerzaI();
			double resultadoJ = c.getLc().getFuerzaJ();
			if (resultadoJ >= 0 ) {
				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N i +" + resultadoJ + " N j");
			}
			else {

				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N i " + resultadoJ+ " N j");
			}

			for (int i = 0; i < btnPositivos.size(); i++) {
				btnPositivos.get(i).setEnabled(true);

			}
			for (int i = 0 ; i < btnNegativos.size() ; i++) {
				btnNegativos.get(i).setEnabled(true);
			}
			btnPivote.setEnabled(true);
			if (Math.abs(resultadoJ) < 100 || Math.abs(resultadoJ) < 100) {
				while(Math.abs(resultadoJ) < 100 && Math.abs(resultadoI) < 100){
					resultadoJ *= 10;
					resultadoI *= 10;
				}
			}
			else if (Math.abs(resultadoJ) > 1000 || Math.abs(resultadoJ) > 1000) {
				while(Math.abs(resultadoJ) > 1000 && Math.abs(resultadoJ) > 1000) {
					resultadoJ /= 10;
					resultadoI /= 10;
				}
			}
			dibujarVector(new Point((int)resultadoI, (int) resultadoJ));
		}
		else if (eventoFuerzaP == true) {
			eventoFuerzaP = false;
			int index;
			for (index = 0 ; index < btnPositivos.size() - 1 ; index++) {
				if (btnPositivos.get(index).equals(arg0.getSource())) {
					break;
				}
			}
			Carga pivote = c.buscarCarga(btnPositivos.get(index).getLocation().getX() - ORIGENX,
					ORIGENY - btnPositivos.get(index).getLocation().getY());
			c.setPivote(pivote);
			c.calcularFuerza();

			double resultadoI = c.getLc().getFuerzaI();
			double resultadoJ = c.getLc().getFuerzaJ();
			if (resultadoJ >= 0 ) {
				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N i +" + resultadoJ + " N j");
			}
			else {

				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadoI + " N i " + resultadoJ+ " N j");
			}

			for (int i = 0; i < btnPositivos.size(); i++) {
				btnPositivos.get(i).setEnabled(true);

			}
			for (int i = 0 ; i < btnNegativos.size() ; i++) {
				btnNegativos.get(i).setEnabled(true);
			}
			btnPivote.setEnabled(true);
			
			if (Math.abs(resultadoJ) < 100 && Math.abs(resultadoJ) < 100) {
				while(Math.abs(resultadoJ) < 100 && Math.abs(resultadoI) < 100){
					resultadoJ *= 10;
					resultadoI *= 10;
				}
			}
			else if (Math.abs(resultadoJ) > 1000 || Math.abs(resultadoJ) > 1000) {
				while(Math.abs(resultadoJ) > 1000 && Math.abs(resultadoJ) > 1000) {
					resultadoJ /= 10;
					resultadoI /= 10;
				}
			}
			dibujarVector(new Point((int)resultadoI, (int) resultadoJ));

			index = 0;
		}

	}
}
// Sofi <3
