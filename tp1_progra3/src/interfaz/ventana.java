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
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class ventana {

	private static JFrame menu;
	App juego;
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
		final ArrayList<JButton> interfazMenu = new ArrayList<JButton>();
		final ArrayList<JButton> interfazdificultad = new ArrayList<JButton>();
		menu = new JFrame();
		menu.setResizable(false);
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
		nuevoJuego.setFocusable(false);
		nuevoJuego.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nuevoJuego.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		nuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ocultarBotones(interfazMenu);
				mostrarBotones(interfazdificultad);
			}
		});
		nuevoJuego.setBounds(142, 83, 127, 23);
		menu.getContentPane().add(nuevoJuego);

		
		JButton ranking = new JButton("ranking");
		ranking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ranking.setFocusable(false);
		ranking.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		ranking.setBounds(162, 159, 89, 23);
		menu.getContentPane().add(ranking);
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane muestraRanking = new JOptionPane();
				ArrayList<Integer> rankingActual=Principal.devolverRanking();
				Integer primerPuesto=(rankingActual.size()>=1)?rankingActual.get(0):0;
				Integer segundoPuesto=(rankingActual.size()>=2)?rankingActual.get(1):0;
				Integer tercerPuesto=(rankingActual.size()>=3)?rankingActual.get(2):0;
				Integer cuartoPuesto=(rankingActual.size()>=4)?rankingActual.get(3):0;
				muestraRanking.showMessageDialog(menu, "Ranking: \nPrimer Puesto: " + primerPuesto +" Turnos"
						+ "\nSegundo Puesto: " + segundoPuesto + " Turnos"
						+ "\nTercer Puesto: " + tercerPuesto + " Turnos"
						+ "\nCuarto Puesto: " + cuartoPuesto + " Turnos");
			}
		});
		
		JButton salir = new JButton("salir");
		salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salir.setFocusable(false);
		salir.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
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
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setFocusable(false);
		volver.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		volver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ocultarBotones(interfazdificultad);
				mostrarBotones(interfazMenu);
			}
		});
		volver.setBounds(128, 227, 159, 23);
		menu.getContentPane().add(volver);
		
		JButton facil = new JButton("Facil");
		facil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		facil.setFocusable(false);
		facil.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		facil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(3);
			}
		});
		facil.setBounds(160, 73, 89, 23);
		menu.getContentPane().add(facil);
		
		JButton normal = new JButton("Normal");
		normal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		normal.setFocusable(false);
		normal.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(4);
			}
		});
		normal.setBounds(160, 121, 89, 23);
		menu.getContentPane().add(normal);
		
		JButton dificil = new JButton("Dificil");
		dificil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dificil.setFocusable(false);
		dificil.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
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
		
		//se empieza con el menu mostrado y la dificultad ocultada
		ocultarBotones(interfazdificultad);
		
		JLabel titulo = new JLabel("Lights Out!");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
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
