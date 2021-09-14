package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import logica.lightsOut;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class Tablero {

	private JFrame frameJuego;
	private lightsOut juego; 
	
	
	
	//imagenes
	private ImageIcon luzPrendidaIcono=  new ImageIcon(Tablero.class.getResource("/imagenes/luzPrendidaModif.png"));
	private ImageIcon luzPrendidaIconoHover=  new ImageIcon(Tablero.class.getResource("/imagenes/luzPrendidaModifHover.png"));
	private ImageIcon luzApagadaIcono= new ImageIcon(Tablero.class.getResource("/imagenes/luzApagadaModif.png"));
	private ImageIcon luzApagadaIconoHover= new ImageIcon(Tablero.class.getResource("/imagenes/luzApagadaModifHover.png"));

	/**
	 * Create the application.
	 */
	public Tablero(int i) {
		juego= new lightsOut(i);
		initialize(i);
	}

    public Tablero(int i,int j) {
    	Principal.tableroArmado(true);
		juego=new lightsOut(i,j);
		initialize(i);

	}

	public void mostrarse() {
		frameJuego.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int i ) {
		frameJuego = new JFrame();
		frameJuego.setIconImage(Toolkit.getDefaultToolkit().getImage(Tablero.class.getResource("/imagenes/icono_lights_out.png")));
		frameJuego.setTitle("Lights Out!");
		
		//obtengo las dimensiones de la pantalla para posicionar la ventana
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 800;
		int alto = 600;
		int x = (pantalla.width/2) - (ancho/2);
		int y = (pantalla.height/2) - (alto/2);
		frameJuego.setBounds(x, y, ancho, alto);
		frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuego.getContentPane().setLayout(new GridLayout(0, i, 2, 2));
		frameJuego.getContentPane().setBackground(new Color(30, 144, 255));
		
		//escalarImagenes(ancho , alto , i);
		luzPrendidaIcono = escalarImagen(ancho, alto, i, luzPrendidaIcono);
		luzApagadaIcono = escalarImagen(ancho, alto, i, luzApagadaIcono);
		luzApagadaIconoHover =escalarImagen(ancho, alto, i, luzApagadaIconoHover);
		luzPrendidaIconoHover = escalarImagen(ancho, alto, i, luzPrendidaIconoHover);
		
		ArrayList<JButton> botones = new ArrayList<JButton>();
		
		Principal.modificarTurnos(0);
		
		for (int j = 0; j < i*i; j++) {
			JButton temp = new JButton("");
			temp.setContentAreaFilled(false);
			temp.setFocusPainted(false);
			temp.setOpaque(false);
			temp.setBorderPainted(false);
			agregarActionListener(temp, j);
			agregarHoverBotones(temp , j);
			botones.add(temp);
			frameJuego.getContentPane().add(temp);
		}
		
		verLuces(frameJuego);
		
	}
	

	private void agregarActionListener(JButton boton, final int i) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.cambiarLuces(i);
				verLuces(frameJuego );
				Principal.modificarTurnos(Principal.devolverTurnos()+1);
				if(juego.isGanador()) {
					final int TurnosUtilizados=Principal.devolverTurnos();
					if(!Principal.esTableroArmado()) {
						Principal.modificarRecord(Principal.devolverTurnos());
					}
					Principal.tableroArmado(false);
					JuegoGanado juegoGanado=new JuegoGanado();
					juegoGanado.mostrarse();
					frameJuego.dispose();
					
				}
			}
		});
	}
	
	private void agregarHoverBotones(final JButton boton, final int i ) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(juego.estaPrendida(i)) {
					boton.setIcon(luzPrendidaIconoHover);
				}else {
					boton.setIcon(luzApagadaIconoHover);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(juego.estaPrendida(i)) {
					boton.setIcon(luzPrendidaIcono);
				}else {
					boton.setIcon(luzApagadaIcono);
				}
			}
		});
	}
	
	private ImageIcon escalarImagen(int ancho , int alto , int cantidad, ImageIcon img) {
		//consigo el ancho y el alto del escalado
		ancho = (ancho/cantidad) - 15;
		alto = (alto/cantidad) - 15;
		
		//transgformo la imagenicon a image para escalar
		Image tempImage = img.getImage();
		
		//la escalo
		Image tempCambiada = tempImage.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		
		//retorno la image como imageicon
		return (new ImageIcon(tempCambiada));
	}
	
	//agregar las imagenes a los botones
	private void verLuces(JFrame frame) {
		
		Component[] componentes= frame.getContentPane().getComponents();
		
		for (int i = 0; i < componentes.length; i++) {
			if(componentes[i] instanceof JButton) {
				if(juego.estaPrendida(i)) {
					((AbstractButton) componentes[i]).setIcon(luzPrendidaIcono);
				}else {
					
					((AbstractButton) componentes[i]).setIcon(luzApagadaIcono);
				}
					
			}
		}
	}
}
