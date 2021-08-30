package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import logica.lightsOut;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class App {

	private JFrame frmLightsOut;
	private lightsOut juego;
	private ImageIcon luzPrendidaIcono=  new ImageIcon(App.class.getResource("/imagenes/luzPrendidaModif.png"));
	private ImageIcon luzPrendidaIconoHover=  new ImageIcon(App.class.getResource("/imagenes/luzPrendidaModifHover.png"));
	private ImageIcon luzApagadaIcono= new ImageIcon(App.class.getResource("/imagenes/luzApagadaModif.png"));
	private ImageIcon luzApagadaIconoHover= new ImageIcon(App.class.getResource("/imagenes/luzApagadaModifHover.png"));
	
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
		
		escalarImagenes(ancho , alto , i);
		
		ArrayList<JButton> botones = new ArrayList<JButton>();
		
		for (int j = 0; j < i*i; j++) {
			JButton temp = new JButton("");
			temp.setContentAreaFilled(false);
			temp.setFocusPainted(false);
			temp.setOpaque(false);
			temp.setBorderPainted(false);
			agregarActionListener(temp, j , ancho , alto , i);
			agregarHoverBotones(temp , j);
			botones.add(temp);
			frmLightsOut.getContentPane().add(temp);
		}
		
		verLuces(frmLightsOut);
		
	}
	
	private void agregarActionListener(JButton boton, int i , int ancho , int alto , int cantidad) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.cambiarLuces(i);
				verLuces(frmLightsOut );
				if(juego.isGanador()) {
					frmLightsOut.dispose();
				}
			}
		});
	}
	
	private void agregarHoverBotones(JButton boton, int i ) {
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
	
	private void escalarImagenes(int ancho , int alto , int cantidad) {
				//uso las imageicon como image para poder reescalarlas
				Image luzprendidaimage = luzPrendidaIcono.getImage();
				Image luzprendidaimageHover = luzPrendidaIconoHover.getImage();
				
				Image luzapagadaImage = luzApagadaIcono.getImage();
				Image luzapagadaImageHover = luzApagadaIconoHover.getImage();
				
				//consigo el ancho y el alto
				ancho = ancho / cantidad -15;
				alto = alto / cantidad -15;
				
				//reescalo las imagenes basado en el ancho y alto de la pantalla
				Image luzprendidaCambiada = luzprendidaimage.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
				Image luzprendidaCambiadaHover = luzprendidaimageHover.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
				Image luzapagadaCambiada = luzapagadaImage.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
				Image luzapagadaCambiadaHover = luzapagadaImageHover.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
				
				//cambio las variables globales a las escaladas
				luzPrendidaIcono = new ImageIcon(luzprendidaCambiada);
				luzPrendidaIconoHover = new ImageIcon(luzprendidaCambiadaHover);
				luzApagadaIcono = new ImageIcon(luzapagadaCambiada);
				luzApagadaIconoHover = new ImageIcon(luzapagadaCambiadaHover);
	}
	
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
