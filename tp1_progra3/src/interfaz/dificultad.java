package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dificultad { 

	private JFrame frame;
	private App juego;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dificultad window = new dificultad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dificultad() {
		initialize();
	}
	public void mostrarse() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 450;
		int alto = 300;
		int x = (pantalla.width/2) - (ancho/2);
		int y = (pantalla.height/2) - (alto/2);
		frame.setBounds(x, y, ancho, alto);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("volver");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.mostrarse();
				frame.dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(125, 190, 159, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton facil = new JButton("Facil");
		facil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(3);
			}
		});
		facil.setBounds(157, 36, 89, 23);
		frame.getContentPane().add(facil);
		
		JButton normal = new JButton("Normal");
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(4);
			}
		});
		normal.setBounds(157, 84, 89, 23);
		frame.getContentPane().add(normal);
		
		JButton dificil = new JButton("Dificil");
		dificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(5);
			}
		});
		dificil.setBounds(157, 134, 89, 23);
		frame.getContentPane().add(dificil);
	}
	
	private void iniciarJuego(int i) {
		juego = new App(i);
		juego.mostrarse();
		frame.dispose();
	}
}
