package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial window = new Inicial();
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
	public Inicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 447, 224);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAbmPersonajes = new JButton("ABM Personajes");
		btnAbmPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickAbm();
			}
		});
		frame.getContentPane().add(btnAbmPersonajes, BorderLayout.WEST);
		
		JButton btnBatalla = new JButton("Batalla");
		btnBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickBatalla();
			}
		});
		frame.getContentPane().add(btnBatalla, BorderLayout.EAST);
	}

	private void clickAbm(){
		Personajes p = new Personajes();
		p.open();
	}
	
	private void clickBatalla(){
		Batalla b = new Batalla();
		b.open();
	}
}
