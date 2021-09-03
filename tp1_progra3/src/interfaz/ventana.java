package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.SwingConstants;

import logica.DatosJuego;

public class ventana {

	private static JFrame menu;
	App juego;
	dificultad dif = new dificultad();
//	 private static DatosJuego data=new DatosJuego();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final ventana window = new ventana();
					window.menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventana() {
		initialize();
	}

	public static int mostrarse() {
		menu.setVisible(true);
		return 0;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<JButton> interfazMenu = new ArrayList<>();
		menu = new JFrame();
		
		//acomodado de la ventana
		Dimension tamanioventana = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho=450;
		int alto = 300;
		menu.setBounds((tamanioventana.width/2)-(ancho/2), (tamanioventana.height/2)-(alto/2), ancho, alto);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setLayout(null);
		
		// botones
		
		JButton nuevoJuego = new JButton("nuevo juego");
		nuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*dif.mostrarse();
				menu.dispose();*/
				ocultarBotones(interfazMenu);
			}
		});
		nuevoJuego.setBounds(143, 66, 127, 23);
		menu.getContentPane().add(nuevoJuego);

		
		JButton ranking = new JButton("ranking");
		ranking.setBounds(163, 142, 89, 23);
		menu.getContentPane().add(ranking);
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane muestraRanking = new JOptionPane();
				ArrayList<Integer> rankingActual=Principal.devolverRanking();
				//falta agregar ranking a la ventana de dialogo
				muestraRanking.showMessageDialog(menu, "Ranking: \nPrimer Puesto: " + Principal.devolverRecord() + "\n Segundo Puesto: ");
			}
		});
		
		JButton salir = new JButton("salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.dispose();
				System.exit(0);
			}
		});
		salir.setBounds(163, 176, 89, 23);
		menu.getContentPane().add(salir);
		
		interfazMenu.add(nuevoJuego);
		interfazMenu.add(ranking);
		interfazMenu.add(salir);
		
		JLabel titulo = new JLabel("Lights Out!");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo.setBounds(106, 11, 204, 44);
		menu.getContentPane().add(titulo);

	}
	
	private void ocultarBotones (ArrayList<JButton> botones) {
		for (JButton boton : botones) {
			boton.setVisible(false);
		}
	}
	private void mostrarBotones (ArrayList<JButton> botones) {
		for (JButton boton : botones) {
			boton.setVisible(true);
		}
	}
	
}
