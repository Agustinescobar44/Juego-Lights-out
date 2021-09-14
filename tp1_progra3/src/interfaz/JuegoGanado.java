package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoGanado {

	private JFrame frame;
	Ventana vent=new Ventana();

	/**
	 * Create the application.
	 */
	public JuegoGanado() {
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
		int ancho  = 450;
		int alto = 300;
		centrarVentana(ancho, alto, frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(30, 144, 255));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/imagenes/icono_lights_out.png")));
		frame.setTitle("Lights Out!");
		
		JLabel lblGanaste = new JLabel("Ganaste!");
		lblGanaste.setBounds(182, 34, 70, 15);
		lblGanaste.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		frame.getContentPane().add(lblGanaste);
		
		
		int TurnosUtilizados=Principal.devolverTurnos();
		
		JLabel lblTurnosUtilizados = new JLabel("Turnos utilizados: " + TurnosUtilizados);
		lblTurnosUtilizados.setBounds(122, 74, 179, 16);
		lblTurnosUtilizados.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		frame.getContentPane().add(lblTurnosUtilizados);
		
		int RecordActual=Principal.devolverRecord();
		
		JLabel textRecord = new JLabel("Record: " + RecordActual +" turnos.");
		textRecord.setBounds(122, 102, 207, 15);
		textRecord.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		//el record solo se muestra si fue modificado
		if(RecordActual!=10000) {
			frame.getContentPane().add(textRecord);
		}
		
		
		JButton btnVolverAlMenu = new JButton("Volver al menu");
		btnVolverAlMenu.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vent.mostrarse();
				frame.dispose();
				
			}
		});
		btnVolverAlMenu.setBounds(144, 155, 145, 25);
		frame.getContentPane().add(btnVolverAlMenu);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				System.exit(0);
			}
		});
		btnSalir.setBounds(144, 207, 145, 25);
		frame.getContentPane().add(btnSalir);
		
	}
	public void centrarVentana(int ancho , int alto , JFrame frame) {
		Dimension tamanioventana = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((tamanioventana.width/2)-(ancho/2), (tamanioventana.height/2)-(alto/2), ancho, alto);
	}
}
