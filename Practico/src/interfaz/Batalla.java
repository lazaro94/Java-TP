package interfaz;

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
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Batalla {

	private JFrame frmBatalla;
	private PanelSeleccion panelJug1 = new PanelSeleccion();
	private PanelSeleccion panelJug2 = new PanelSeleccion();
	private JButton btnAtacar2;
	private JButton btnDefender1;
	private JButton btnAtacar1;
	private JButton btnDefender2;
	private ControladorBatallas cb = new ControladorBatallas();
	private JTextField txtEnergia2;
	private JTextField txtEnergia1;
	private JLabel lblVida2;
	private JLabel lblVida1;
	private JLabel lblEnergia1;
	private JLabel lblEnergia2;
	private JButton btnIniciarBatalla;
	private JButton btnReiniciar;
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
		frmBatalla = new JFrame();
		frmBatalla.setBounds(100, 100, 769, 536);
		frmBatalla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBatalla.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frmBatalla.setPreferredSize(new Dimension(700, 600));
		
		JPanel panelSouth = new JPanel();
		frmBatalla.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		btnIniciarBatalla = new JButton("Iniciar Batalla");
		btnIniciarBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				batalla();
			}
		});
		panelSouth.add(btnIniciarBatalla);
		frmBatalla.setPreferredSize(new Dimension(600, 400));
		addPanels();
	}
	
	private void addPanels(){
		panelJug1.setTitle("Jugador 1");
		panelJug2.setTitle("Jugador 2");
		frmBatalla.getContentPane().add(panelJug1, BorderLayout.EAST);
		frmBatalla.getContentPane().add(panelJug2, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		frmBatalla.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setMinimumSize(new Dimension(800, 800));
		
		btnAtacar2 = new JButton("Atacar");
		btnAtacar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atacar();
			}
		});
		btnAtacar2.setBounds(0, 65, 128, 23);
		panel.add(btnAtacar2);
		btnAtacar2.setEnabled(false);
		
		btnAtacar1 = new JButton("Atacar");
		btnAtacar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atacar();
			}
		});
		btnAtacar1.setBounds(140, 65, 121, 23);
		panel.add(btnAtacar1);
		btnAtacar1.setEnabled(false);
		
		btnDefender2 = new JButton("Defender");
		btnDefender2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defender();
			}
		});
		btnDefender2.setBounds(10, 278, 118, 23);
		panel.add(btnDefender2);
		btnDefender2.setEnabled(false);
		
		btnDefender1 = new JButton("Defender");
		btnDefender1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defender();
			}
		});
		btnDefender1.setBounds(140, 278, 121, 23);
		panel.add(btnDefender1);
		btnDefender1.setEnabled(false);
		
		lblVida2 = new JLabel("");
		lblVida2.setBounds(10, 173, 84, 14);
		panel.add(lblVida2);
		
		lblVida1 = new JLabel("");
		lblVida1.setBounds(180, 173, 81, 14);
		panel.add(lblVida1);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setBounds(0, 232, 75, 23);
		panel.add(txtEnergia2);
		txtEnergia2.setColumns(10);
		txtEnergia2.setEnabled(false);
		
		lblEnergia2 = new JLabel("");
		lblEnergia2.setBounds(10, 207, 106, 14);
		panel.add(lblEnergia2);
		
		txtEnergia1 = new JTextField();
		txtEnergia1.setBounds(174, 233, 75, 22);
		panel.add(txtEnergia1);
		txtEnergia1.setColumns(10);
		txtEnergia1.setEnabled(false);
		
		lblEnergia1 = new JLabel("");
		lblEnergia1.setBounds(155, 199, 106, 14);
		panel.add(lblEnergia1);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});
		btnReiniciar.setBounds(73, 377, 117, 45);
		panel.add(btnReiniciar);
		btnReiniciar.setVisible(false);
	}
	private void batalla(){
		if (!panelJug1.isSeleccionado() || !panelJug2.isSeleccionado()){
			informarError("Ambos jugadores deben seleccionar un personaje");
			return;
		}
		try{
			cb.setPersonaje1(panelJug1.getSeleccionado());
			cb.setPersonaje2(panelJug2.getSeleccionado());
			actualizarEstados();
		}
		catch(Exception ex){
		}
		setTurno(cb.generarTurno());		
	}
	
	private void informarError(String mensaje){
		JOptionPane.showMessageDialog(frmBatalla, mensaje, "Batallas", JOptionPane.ERROR_MESSAGE);
	}

	private void setTurno(int turno){
		if(turno==1){
			txtEnergia1.setEnabled(true);
			txtEnergia2.setEnabled(false);
			btnAtacar2.setEnabled(false);
			btnDefender2.setEnabled(false);
			btnAtacar1.setEnabled(true);
			btnDefender1.setEnabled(true);	
		}

		else{
			txtEnergia2.setEnabled(true);
			btnAtacar1.setEnabled(false);
			btnDefender1.setEnabled(false);
			btnAtacar2.setEnabled(true);
			btnDefender2.setEnabled(true);	
			txtEnergia1.setEnabled(false);
		}
		
		}
	
	//Despues de cada ataque/defensa hay que actualizar el estado de cada 
	//personaje en la interfaz
	private void atacar(){
		try{
			if(cb.getTurnoActual()==1){
				cb.ataque(Integer.valueOf(txtEnergia1.getText()));
			}
			else {
				cb.ataque(Integer.valueOf(txtEnergia2.getText()));
			}
			if(cb.isOver()){
				JOptionPane.showMessageDialog(frmBatalla, cb.getStatus());
				if(cb.getTurnoActual()==1){
					btnAtacar1.setEnabled(false);
					btnDefender1.setEnabled(false);
					txtEnergia1.setEnabled(false);
				}
				else{
					btnAtacar2.setEnabled(false);
					btnDefender2.setEnabled(false);
					txtEnergia2.setEnabled(false);
				}
				btnIniciarBatalla.setEnabled(false);
				btnReiniciar.setVisible(true);
				return;
			}
			setTurno(cb.cambioTurno());
			actualizarEstados();
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(frmBatalla, ex.getMessage());
		}
	}
	
	private void reiniciar(){
		Batalla b = new Batalla();
		frmBatalla.dispose();
		b.open();
	}
	private void defender(){
		cb.defensa();
		setTurno(cb.cambioTurno());
		actualizarEstados();
	}
	
	public void actualizarEstados(){
		Personaje p = new Personaje();
		p=cb.getPersonaje1();
		lblVida1.setText("Vida: " + p.getVidaBatalla());
		lblEnergia1.setText("Energia: " + p.getEnergiaBatalla());
		//ACTUALIZAR ENERGIA
		p=cb.getPersonaje2();
		lblVida2.setText("Vida: " + p.getVidaBatalla());
		lblEnergia2.setText("Energia: " + p.getEnergiaBatalla());
	}
	
	public void open(){
		frmBatalla.setVisible(true);
	}
}  

