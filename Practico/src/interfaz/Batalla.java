package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import entidades.Personaje;
import logica.ControladorBatallas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;


public class Batalla {

	private JFrame frame;
	private PanelSeleccion panelJug1 = new PanelSeleccion();
	private PanelSeleccion panelJug2 = new PanelSeleccion();
	private Personaje personaje1 = new Personaje();
	private Personaje personaje2 = new Personaje();
	private JButton btnAtacar2;
	private JButton btnDefender1;
	private JButton btnAtacar1;
	private JButton btnDefender2;
	private ControladorBatallas cb = new ControladorBatallas();
	
	

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
		frame.setBounds(100, 100, 717, 487);
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
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnAtacar2 = new JButton("Atacar");
		btnAtacar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtacar2.setBounds(10, 65, 65, 23);
		panel.add(btnAtacar2);
		
		btnAtacar1 = new JButton("Atacar");
		btnAtacar1.setBounds(130, 65, 65, 23);
		panel.add(btnAtacar1);
		
		btnDefender2 = new JButton("Defender");
		btnDefender2.setBounds(10, 278, 77, 23);
		panel.add(btnDefender2);
		
		btnDefender1 = new JButton("Defender");
		btnDefender1.setBounds(118, 278, 77, 23);
		panel.add(btnDefender1);
		
		JLabel lblVida2 = new JLabel("Vida2:");
		lblVida2.setBounds(10, 173, 46, 14);
		panel.add(lblVida2);
		
		JLabel lblVida_1 = new JLabel("Vida 1:");
		lblVida_1.setBounds(149, 173, 46, 14);
		panel.add(lblVida_1);
	}
	private void batalla(){
		if (!panelJug1.isSeleccionado() || !panelJug2.isSeleccionado()){
			informarError("Ambos jugadores deben seleccionar un personaje");
			return;
		}
		personaje1=panelJug1.getSeleccionado();
		personaje2=panelJug2.getSeleccionado();
		setturno(cb.ge)
	}
	
	private void informarError(String mensaje){
		JOptionPane.showMessageDialog(frame, mensaje, "Batallas", JOptionPane.ERROR_MESSAGE);
	}

	private void setturno(int turno){
		if(turno==1){
			btnAtacar2.setEnabled(false);
			btnDefender2.setEnabled(false);}
		else{
			btnAtacar1.setEnabled(false);
			btnDefender1.setEnabled(false);}
		}
		
	


}  
