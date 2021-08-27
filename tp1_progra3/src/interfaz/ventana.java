package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ventana {

	private JFrame menu;
	App juego= new App();
	dificultad dif = new dificultad();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana window = new ventana();
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

	public int mostrarse() {
		menu.setVisible(true);
		return 0;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menu = new JFrame();
		menu.setBounds(100, 100, 450, 300);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("nuevo juego");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.mostrarse();
				menu.dispose();
			}
		});
		btnNewButton.setBounds(143, 66, 127, 23);
		menu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("salir");
		btnNewButton_1.setBounds(163, 176, 89, 23);
		menu.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ranking");
		btnNewButton_2.setBounds(163, 142, 89, 23);
		menu.getContentPane().add(btnNewButton_2);
		
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
