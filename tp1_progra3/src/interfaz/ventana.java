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
		menu = new JFrame();
		Dimension tamanioventana = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho=450;
		int alto = 300;
		menu.setBounds((tamanioventana.width/2)-(ancho/2), (tamanioventana.height/2)-(alto/2), ancho, alto);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("nuevo juego");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dif.mostrarse();
				menu.dispose();
			}
		});
		
		btnNewButton.setBounds(143, 66, 127, 23);
		menu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.dispose();
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(163, 176, 89, 23);
		menu.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ranking");
		btnNewButton_2.setBounds(163, 142, 89, 23);
		menu.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane muestraRanking = new JOptionPane();
				ArrayList<Integer> rankingActual=Principal.devolverRanking();
				//falta agregar ranking a la ventana de dialogo
				muestraRanking.showMessageDialog(menu, "Ranking: \nPrimer Puesto: " + Principal.devolverRecord() + "\n Segundo Puesto: ");
			}
		});
		
		JLabel lblNewLabel = new JLabel("Lights Out!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(106, 11, 204, 44);
		menu.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("dificultad");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dif.mostrarse();
				menu.dispose();
			}
		});
		btnNewButton_3.setBounds(163, 110, 89, 23);
		menu.getContentPane().add(btnNewButton_3);
	}
}
