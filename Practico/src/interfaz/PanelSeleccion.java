package interfaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Personaje;
import logica.ControladorPersonaje;
import javax.swing.SpringLayout;

public class PanelSeleccion extends JPanel {
	private JTextField txtEnergia;
	private JTextField txtVida;
	private JTextField txtEvasion;
	private JTextField txtDefensa;
	private JTextField txtPuntos;
	
	private ArrayList<Personaje> personajes = new ArrayList<Personaje>(); //Este array lo uso para mantener los personajes en memoria
	private Personaje personajeSeleccionado = null;
	
	private ControladorPersonaje ctrldorPer;
	private JComboBox comboPersonajes;
	private JButton btnSeleccionar;
	private JLabel lblTitle;

	/**
	 * Create the panel.
	 */
	public PanelSeleccion() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		this.setPreferredSize(new Dimension(248, 414));
		
		lblTitle = new JLabel("title");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblTitle, 92, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblTitle, -31, SpringLayout.EAST, this);
		add(lblTitle);
		
		comboPersonajes = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboPersonajes, 55, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, comboPersonajes, 80, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, comboPersonajes, 209, SpringLayout.WEST, this);
		comboPersonajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		comboPersonajes.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        selectionChanged();
		    }
		});
		add(comboPersonajes);
		
		JLabel lblEnergia = new JLabel("Energia:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEnergia, 114, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblEnergia, 8, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblEnergia, 72, SpringLayout.WEST, this);
		add(lblEnergia);
		
		txtEnergia = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnergia, 112, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtEnergia, 80, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtEnergia, 209, SpringLayout.WEST, this);
		add(txtEnergia);
		txtEnergia.setColumns(10);
		txtEnergia.setEnabled(false);
		
		JLabel lblVida = new JLabel("Vida:");
		springLayout.putConstraint(SpringLayout.NORTH, lblVida, 166, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblVida, 36, SpringLayout.WEST, this);
		add(lblVida);
		
		txtVida = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtVida, 164, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtVida, 80, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtVida, 209, SpringLayout.WEST, this);
		add(txtVida);
		txtVida.setColumns(10);
		txtVida.setEnabled(false);
		
		JLabel lblEvasion = new JLabel("Evasion:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEvasion, 218, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblEvasion, 13, SpringLayout.WEST, this);
		add(lblEvasion);
		
		txtEvasion = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEvasion, 216, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtEvasion, 80, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtEvasion, 209, SpringLayout.WEST, this);
		add(txtEvasion);
		txtEvasion.setColumns(10);
		txtEvasion.setEnabled(false);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		springLayout.putConstraint(SpringLayout.NORTH, lblDefensa, 270, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblDefensa, 8, SpringLayout.WEST, this);
		add(lblDefensa);
		
		txtDefensa = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtDefensa, 268, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtDefensa, 80, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtDefensa, 209, SpringLayout.WEST, this);
		add(txtDefensa);
		txtDefensa.setColumns(10);
		txtDefensa.setEnabled(false);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPuntos, 322, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPuntos, 17, SpringLayout.WEST, this);
		add(lblPuntos);
		
		txtPuntos = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPuntos, 320, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtPuntos, 80, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtPuntos, 209, SpringLayout.WEST, this);
		add(txtPuntos);
		txtPuntos.setColumns(10);
		txtPuntos.setEnabled(false);
		
		btnSeleccionar = new JButton("Seleccionar");
		springLayout.putConstraint(SpringLayout.NORTH, btnSeleccionar, 372, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnSeleccionar, 80, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSeleccionar, 209, SpringLayout.WEST, this);
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionar();
			}
		});
		add(btnSeleccionar);
		loadCombos();
	}
	
	private void loadCombos(){		
		ctrldorPer = new ControladorPersonaje();
		
		try {
			personajes=ctrldorPer.todosPersonajes();
			for(int i=0; i<personajes.size(); i++){
				comboPersonajes.addItem(personajes.get(i));
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void selectionChanged(){
		mapearPersonaje(mapearDeCombo());
	}
	
	private Personaje buscarPersonaje(Personaje per){
		return (personajes.get(personajes.indexOf(per)));
	}
	
	private void mapearPersonaje(Personaje per){
		txtVida.setText(String.valueOf(per.getVida()));
		txtEnergia.setText(String.valueOf(per.getEnergia()));
		txtEvasion.setText(String.valueOf(per.getEvasion()));
		txtDefensa.setText(String.valueOf(per.getDefensa()));
		txtPuntos.setText(String.valueOf(per.getPtosTotales()));
	}
	
	private Personaje mapearDeCombo(){
		Personaje p = new Personaje();
		p.setNombre(String.valueOf(comboPersonajes.getSelectedItem()));
		p=buscarPersonaje(p);
		return p;
	}
	
	private void seleccionar(){
		personajeSeleccionado=mapearDeCombo();
		lockControls();
	}
	private void lockControls(){
		comboPersonajes.setEnabled(false);
		btnSeleccionar.setEnabled(false);
	}
	
	public Personaje getSeleccionado(){
		return personajeSeleccionado;
	}
	
	public boolean isSeleccionado(){
		if(personajeSeleccionado!=null){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setTitle(String titulo){
		lblTitle.setText(titulo);
	}
}
