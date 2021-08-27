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
					App window = new App();
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
	public App() {
		juego= new lightsOut(3);
		initialize();
	}

	public void mostrarse() {
		frmLightsOut.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLightsOut = new JFrame();
		frmLightsOut.setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/imagenes/icono_lights_out.png")));
		frmLightsOut.setTitle("Lights Out!");
		frmLightsOut.setBounds(100, 100, 800, 600);
		frmLightsOut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLightsOut.getContentPane().setLayout(new GridLayout(0, 3, 2, 2));
		
		ArrayList<JButton> botones = new ArrayList<JButton>();
		
		for (int i = 0; i < 9; i++) {
			JButton temp = new JButton("");
			agregarActionListener(temp, i);
			botones.add(temp);
			frmLightsOut.getContentPane().add(temp);
		}
		
		verLuces(frmLightsOut);
		
	}
	
	private void agregarActionListener(JButton boton, int i ) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.cambiarLuces(i);
				verLuces(frmLightsOut);
				if(juego.isGanador()) {
					frmLightsOut.dispose();
				}
			}
		});
	}
	
	private void verLuces(JFrame frame) {
		
		Component[] componentes= frame.getContentPane().getComponents();
		Image luzprendidaimage = luzPrendidaIcono.getImage();
		Image luzapagadaImage = luzApagadaIcono.getImage();
		
		for (int i = 0; i < componentes.length; i++) {
			if(componentes[i] instanceof JButton) {
				if(juego.estaPrendida(i)) {
					Image luzprendidaCambiada = luzprendidaimage.getScaledInstance(frame.getWidth()/4, frame.getHeight()/4, Image.SCALE_SMOOTH);
					((AbstractButton) componentes[i]).setIcon(new ImageIcon(luzprendidaCambiada));
				}else {
					Image luzapagadaCambiada = luzapagadaImage.getScaledInstance(frame.getWidth()/4, frame.getHeight()/4, Image.SCALE_SMOOTH);
					((AbstractButton) componentes[i]).setIcon(new ImageIcon(luzapagadaCambiada));
				}
					
			}
		}
	}
}
