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
		juego= new lightsOut(4);
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
		frmLightsOut.getContentPane().setLayout(new GridLayout(0, 4, 2, 2));
		
		
		
		
		
		JButton boton11 = new JButton("");
		
		boton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.cambiarLuces(0);
				verLuces(frmLightsOut);
			}
		});
		frmLightsOut.getContentPane().add(boton11);
		
		
		JButton boton12 = new JButton("New button");
		boton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.cambiarLuces(1);
				verLuces(frmLightsOut);
			}
		});
		frmLightsOut.getContentPane().add(boton12);
		
		JButton btnNewButton_7 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_2 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_8 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_10 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_4 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_9 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_11 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_12 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("New button");
		frmLightsOut.getContentPane().add(btnNewButton_14);
		
		JButton boton12_1 = new JButton("New button");
		frmLightsOut.getContentPane().add(boton12_1);
		
		verLuces(frmLightsOut);
		
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
