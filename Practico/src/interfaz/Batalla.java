package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;


public class Batalla {

	private JFrame frame;
	private PanelSeleccion panelJug1 = new PanelSeleccion();
	private PanelSeleccion panelJug2 = new PanelSeleccion();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Batalla window = new Batalla();
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
	public Batalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		addPanels();
	}
	
	private void addPanels(){
		panelJug1.setTitle("Jugador 1");
		panelJug2.setTitle("Jugador 2");
		frame.getContentPane().add(panelJug1, BorderLayout.EAST);
		frame.getContentPane().add(panelJug2, BorderLayout.WEST);
	}

}
