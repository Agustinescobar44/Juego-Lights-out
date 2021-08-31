package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoGanado {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGanaste = new JLabel("Ganaste!");
		lblGanaste.setBounds(182, 34, 70, 15);
		frame.getContentPane().add(lblGanaste);
		
		JLabel lblTurnosUtilizados = new JLabel("Turnos utilizados: " + main.devolverTurnos());
		lblTurnosUtilizados.setBounds(122, 74, 179, 16);
		frame.getContentPane().add(lblTurnosUtilizados);
		
		System.out.println("turnos: " + main.devolverTurnos());
		System.out.println("record: " + main.devolverRecord());
		
		JLabel textRecord = new JLabel("Record: " + main.devolverRecord() +" turnos.");
		textRecord.setBounds(122, 102, 207, 15);
		frame.getContentPane().add(textRecord);
		
		JButton btnVolverAlMenu = new JButton("Volver al menu");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.mostrarse();
				frame.dispose();
				
			}
		});
		btnVolverAlMenu.setBounds(144, 155, 145, 25);
		frame.getContentPane().add(btnVolverAlMenu);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnSalir.setBounds(144, 207, 145, 25);
		frame.getContentPane().add(btnSalir);
	}
}
