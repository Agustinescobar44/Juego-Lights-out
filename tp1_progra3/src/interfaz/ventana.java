package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		ArrayList<JButton> interfazdificultad = new ArrayList<>();
		menu = new JFrame();
		menu.setIconImage(Toolkit.getDefaultToolkit().getImage(ventana.class.getResource("/imagenes/icono_lights_out.png")));
		
		//acomodado de la ventana
		Dimension tamanioventana = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho=450;
		int alto = 300;
		menu.setBounds((tamanioventana.width/2)-(ancho/2), (tamanioventana.height/2)-(alto/2), ancho, alto);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setLayout(null);
		
		// botones de menu-----------------------------------
		
		JButton nuevoJuego = new JButton("nuevo juego");
		nuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*dif.mostrarse();
				menu.dispose();*/
				ocultarBotones(interfazMenu);
				mostrarBotones(interfazdificultad);
			}
		});
		nuevoJuego.setBounds(142, 83, 127, 23);
		menu.getContentPane().add(nuevoJuego);

		
		JButton ranking = new JButton("ranking");
		ranking.setBounds(162, 159, 89, 23);
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
		salir.setBounds(128, 227, 159, 23);
		menu.getContentPane().add(salir);
		
		//botones de dificultad-------------------------------
		
		JButton volver = new JButton("volver");
		volver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*ventana.mostrarse();
				frame.dispose();*/
				ocultarBotones(interfazdificultad);
				mostrarBotones(interfazMenu);
			}
		});
		volver.setBounds(128, 227, 159, 23);
		menu.getContentPane().add(volver);
		
		JButton facil = new JButton("Facil");
		facil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(3);
			}
		});
		facil.setBounds(160, 73, 89, 23);
		menu.getContentPane().add(facil);
		
		JButton normal = new JButton("Normal");
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(4);
			}
		});
		normal.setBounds(160, 121, 89, 23);
		menu.getContentPane().add(normal);
		
		JButton dificil = new JButton("Dificil");
		dificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(5);
			}
		});
		dificil.setBounds(160, 171, 89, 23);
		menu.getContentPane().add(dificil);
		
		//agrego los botones a una lista para poder mostrarlos y ocultarlos 
		
		interfazMenu.add(nuevoJuego);
		interfazMenu.add(ranking);
		interfazMenu.add(salir);
		
		interfazdificultad.add(dificil);
		interfazdificultad.add(facil);
		interfazdificultad.add(normal);
		interfazdificultad.add(volver);
		
		//se empieza con el menu mostrado
		ocultarBotones(interfazdificultad);
		
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
	
	private void iniciarJuego(int i) {
		juego = new App(i);
		juego.mostrarse();
		menu.dispose();
	}
	
}
