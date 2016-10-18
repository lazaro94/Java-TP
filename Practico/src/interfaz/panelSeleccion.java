package interfaz;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import entidades.Personaje;
import logica.ControladorPersonaje;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panelSeleccion extends JPanel {
	private JTextField txtEnergia;
	private JTextField txtVida;
	private JTextField txtEvasion;
	private JTextField txtDefensa;
	private JTextField txtPuntos;
	
	private ArrayList<Personaje> personajes = new ArrayList<Personaje>(); //Este array lo uso para mantener los personajes en memoria
	private Personaje personajeSeleccionado=null;
	
	private ControladorPersonaje ctrldorPer;
	private JComboBox comboPersonajes;
	private JButton btnSeleccionar;
	private JLabel lblTitle;

	/**
	 * Create the panel.
	 */
	public panelSeleccion() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		lblTitle = new JLabel("title");
		add(lblTitle, "4, 2");
		
		comboPersonajes = new JComboBox();
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
		add(comboPersonajes, "4, 6, fill, default");
		
		JLabel lblEnergia = new JLabel("Energia:");
		add(lblEnergia, "2, 10");
		
		txtEnergia = new JTextField();
		add(txtEnergia, "4, 10, fill, default");
		txtEnergia.setColumns(10);
		txtEnergia.setEnabled(false);
		
		JLabel lblVida = new JLabel("Vida:");
		add(lblVida, "2, 14, right, default");
		
		txtVida = new JTextField();
		add(txtVida, "4, 14, fill, default");
		txtVida.setColumns(10);
		txtVida.setEnabled(false);
		
		JLabel lblEvasion = new JLabel("Evasion:");
		add(lblEvasion, "2, 18, right, default");
		
		txtEvasion = new JTextField();
		add(txtEvasion, "4, 18, fill, top");
		txtEvasion.setColumns(10);
		txtEvasion.setEnabled(false);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		add(lblDefensa, "2, 22, right, default");
		
		txtDefensa = new JTextField();
		add(txtDefensa, "4, 22, fill, default");
		txtDefensa.setColumns(10);
		txtDefensa.setEnabled(false);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		add(lblPuntos, "2, 26, right, default");
		
		txtPuntos = new JTextField();
		add(txtPuntos, "4, 26, fill, default");
		txtPuntos.setColumns(10);
		txtPuntos.setEnabled(false);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionar();
			}
		});
		add(btnSeleccionar, "4, 30");
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
