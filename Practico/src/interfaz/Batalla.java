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
	private ControladorBatallas cb;
	private JTextField txtEnergia2;
	private JTextField txtEnergia1;
	private JLabel lblVida2;
	private JLabel lblVida1;
	private JLabel lblEnergia1;
	private JLabel lblEnergia2;
	
	

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
				atacar();
			}
		});
		btnAtacar2.setBounds(0, 65, 94, 23);
		panel.add(btnAtacar2);
		
		btnAtacar1 = new JButton("Atacar");
		btnAtacar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atacar();
			}
		});
		btnAtacar1.setBounds(115, 65, 94, 23);
		panel.add(btnAtacar1);
		
		btnDefender2 = new JButton("Defender");
		btnDefender2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defender();
			}
		});
		btnDefender2.setBounds(10, 278, 77, 23);
		panel.add(btnDefender2);
		
		btnDefender1 = new JButton("Defender");
		btnDefender1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defender();
			}
		});
		btnDefender1.setBounds(118, 278, 77, 23);
		panel.add(btnDefender1);
		
		lblVida2 = new JLabel("Vida2:");
		lblVida2.setBounds(10, 173, 84, 14);
		panel.add(lblVida2);
		
		lblVida1 = new JLabel("Vida 1:");
		lblVida1.setBounds(128, 173, 81, 14);
		panel.add(lblVida1);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setBounds(0, 232, 75, 23);
		panel.add(txtEnergia2);
		txtEnergia2.setColumns(10);
		
		lblEnergia2 = new JLabel("Energia2");
		lblEnergia2.setBounds(10, 207, 84, 14);
		panel.add(lblEnergia2);
		
		txtEnergia1 = new JTextField();
		txtEnergia1.setBounds(130, 233, 75, 22);
		panel.add(txtEnergia1);
		txtEnergia1.setColumns(10);
		
		lblEnergia1 = new JLabel("Energia1");
		lblEnergia1.setBounds(115, 207, 94, 14);
		panel.add(lblEnergia1);
	}
	private void batalla(){
		cb = new ControladorBatallas();
		if (!panelJug1.isSeleccionado() || !panelJug2.isSeleccionado()){
			informarError("Ambos jugadores deben seleccionar un personaje");
			return;
		}
		personaje1=panelJug1.getSeleccionado();
		personaje2=panelJug2.getSeleccionado();
		setTurno();
		
	}
	
	private void informarError(String mensaje){
		JOptionPane.showMessageDialog(frame, mensaje, "Batallas", JOptionPane.ERROR_MESSAGE);
	}

	private void setTurno(){
		cb = new ControladorBatallas();
		if(cb.cambioTurno()==1){
			btnAtacar2.setEnabled(false);
			btnDefender2.setEnabled(false);}
		else{
			btnAtacar1.setEnabled(false);
			btnDefender1.setEnabled(false);}
		}
	
	//Despues de cada ataque/defensa hay que actualizar el estado de cada 
	//personaje en la interfaz
	private void atacar(){
		cb = new ControladorBatallas();
		try{
			if(cb.getTurnoActual()==1){
				cb.ataque(Integer.valueOf(txtEnergia1.getText()));
			}
			else {
				cb.ataque(Integer.valueOf(txtEnergia2.getText()));
			}
		}
		catch(Exception ex){
			
		}
	}
	
	private void defender(){
		cb.defensa();
	}
	
	public void actualizarEstados(){
		cb = new ControladorBatallas();
		Personaje p = new Personaje();
		p=cb.getPersonaje1();
		lblVida1.setText("Vida: " + p.getVidaBatalla());
		lblEnergia1.setText("Energia: " + p.getEnergiaBatalla());
		//ACTUALIZAR ENERGIA
		p=cb.getPersonaje2();
		lblVida2.setText("Vida: " + p.getVidaBatalla());
		lblEnergia2.setText("Energia: " + p.getEnergiaBatalla());
	}
}  

