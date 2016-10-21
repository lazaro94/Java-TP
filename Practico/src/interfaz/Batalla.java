package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import entidades.Personaje;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Batalla {

	private JFrame frame;
	private PanelSeleccion panelJug1 = new PanelSeleccion();
	private PanelSeleccion panelJug2 = new PanelSeleccion();
	private Personaje personaje1 = new Personaje();
	private Personaje personaje2 = new Personaje();
	

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
		frame.setBounds(100, 100, 717, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frame.setPreferredSize(new Dimension(700, 600));
		
		JPanel panelSouth = new JPanel();
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnIniciarBatalla = new JButton("Iniciar Batalla");
		btnIniciarBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				batalla();
			}
		});
		panelSouth.add(btnIniciarBatalla);
		frame.setPreferredSize(new Dimension(600, 400));
		addPanels();
	}
	
	private void addPanels(){
		panelJug1.setTitle("Jugador 1");
		panelJug2.setTitle("Jugador 2");
		frame.getContentPane().add(panelJug1, BorderLayout.EAST);
		frame.getContentPane().add(panelJug2, BorderLayout.WEST);
	}
	private void batalla(){
		if (!panelJug1.isSeleccionado() || !panelJug2.isSeleccionado()){
			informarError("Ambos jugadores deben seleccionar un personaje");
			return;
		}
		personaje1=panelJug1.getSeleccionado();
		personaje2=panelJug2.getSeleccionado();
	}
	
	private void informarError(String mensaje){
		JOptionPane.showMessageDialog(frame, mensaje, "Batallas", JOptionPane.ERROR_MESSAGE);
	}

}
