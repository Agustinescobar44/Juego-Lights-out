package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import logica.lightsOut;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.naming.directory.AttributeModificationException;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class App {

	private String luzPrendida= "/imagenes/luzPrendidaModif.png";
	private String luzApagada= "/imagenes/luzApagadaModif.png";
	private JFrame frmLightsOut;
	private lightsOut juego;
	ImageIcon luzPrendidaIcono=  new ImageIcon(App.class.getResource(luzPrendida));
	ImageIcon luzApagadaIcono= new ImageIcon(App.class.getResource(luzApagada));
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App(7);
					window.frmLightsOut.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App(int i) {
		juego= new lightsOut(i);
		initialize(i);
	}

	public void mostrarse() {
		frmLightsOut.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int i ) {
		frmLightsOut = new JFrame();
		frmLightsOut.setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/imagenes/icono_lights_out.png")));
		frmLightsOut.setTitle("Lights Out!");
		
		//obtengo las dimensiones de la pantalla para posicionar la ventana
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 800;
		int alto = 600;
		int x = (pantalla.width/2) - (ancho/2);
		int y = (pantalla.height/2) - (alto/2);
		frmLightsOut.setBounds(x, y, ancho, alto);
		frmLightsOut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLightsOut.getContentPane().setLayout(new GridLayout(0, i, 2, 2));
		
		ArrayList<JButton> botones = new ArrayList<JButton>();
		
		for (int j = 0; j < i*i; j++) {
			JButton temp = new JButton("");
			temp.setContentAreaFilled(false);
			temp.setFocusPainted(false);
			temp.setOpaque(false);
			agregarActionListener(temp, j , ancho , alto , i);
			botones.add(temp);
			frmLightsOut.getContentPane().add(temp);
		}
		
		verLuces(frmLightsOut , ancho , alto , i);
		
	}
	
	private void agregarActionListener(JButton boton, int i , int ancho , int alto , int cantidad) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.cambiarLuces(i);
				verLuces(frmLightsOut , ancho , alto , cantidad);
				if(juego.isGanador()) {
					frmLightsOut.dispose();
				}
			}
		});
	}
	
	private void verLuces(JFrame frame , int ancho , int alto, int cantidad) {
		
		Component[] componentes= frame.getContentPane().getComponents();
		
		//uso las imageicon como image para poder reescalarlas
		Image luzprendidaimage = luzPrendidaIcono.getImage();
		Image luzapagadaImage = luzApagadaIcono.getImage();
		
		ancho = ancho / cantidad -15;
		alto = alto / cantidad -15;
		
		//reescalo las imagenes basado en el ancho y alto de la pantalla
		Image luzprendidaCambiada = luzprendidaimage.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		Image luzapagadaCambiada = luzapagadaImage.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		
		for (int i = 0; i < componentes.length; i++) {
			if(componentes[i] instanceof JButton) {
				if(juego.estaPrendida(i)) {
					
					((AbstractButton) componentes[i]).setIcon(new ImageIcon(luzprendidaCambiada));
				}else {
					
					((AbstractButton) componentes[i]).setIcon(new ImageIcon(luzapagadaCambiada));
				}
					
			}
		}
	}
}
