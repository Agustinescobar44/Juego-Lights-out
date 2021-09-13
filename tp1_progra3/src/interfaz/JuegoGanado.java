package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoGanado {

	private JFrame frame;
	ventana vent=new ventana();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoGanado window = new JuegoGanado();
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
		
		JLabel lblGanaste = new JLabel("Ganaste!");
		lblGanaste.setBounds(182, 34, 70, 15);
		frame.getContentPane().add(lblGanaste);
		
		
		int TurnosUtilizados=Principal.devolverTurnos();
		
		JLabel lblTurnosUtilizados = new JLabel("Turnos utilizados: " + TurnosUtilizados);
		lblTurnosUtilizados.setBounds(122, 74, 179, 16);
		frame.getContentPane().add(lblTurnosUtilizados);
		
		int RecordActual=Principal.devolverRecord();
		
		JLabel textRecord = new JLabel("Record: " + RecordActual +" turnos.");
		textRecord.setBounds(122, 102, 207, 15);
		//el record solo se muestra si fue modificado
		if(RecordActual!=10000) {
			frame.getContentPane().add(textRecord);
		}
		
		
		JButton btnVolverAlMenu = new JButton("Volver al menu");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vent.mostrarse();
				frame.dispose();
				
			}
		});
		btnVolverAlMenu.setBounds(144, 155, 145, 25);
		frame.getContentPane().add(btnVolverAlMenu);
		
		JButton btnSalir = new JButton("Salir");
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
