package interfaz;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import logica.ControladorPersonaje;
import util.Validate;
import entidades.Personaje;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Personajes {

	/* Los botones están solamente presentados.
	 * Hay que agrupar los textbox del formulario. 
	 * Ver como manejar en el código cuando un personaje es nuevo y cuando se editó uno existente.
	 * Para saber si se tiene que insertar en la BD o modificar uno existente.
	 * */
	
	private JFrame frmPersonajes;
	private ControladorPersonaje ctrldorPer = new ControladorPersonaje();
	private Personaje personaje = new Personaje();
	private JTable tablePersonajes;
	private JTextField textNombre;
	private JTextField textVida;
	private JTextField textEvasion;
	private JTextField textEnergia;
	private JTextField textDefensa;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JLabel lblTotal;
	
	private Validate validate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personajes window = new Personajes();
					window.frmPersonajes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Personajes() {
		initialize();
		cargarPersonajes();
		noEditable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPersonajes = new JFrame();
		frmPersonajes.setTitle("Personajes");
		frmPersonajes.setBounds(100, 100, 747, 540);
		frmPersonajes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tablePersonajes = new JTable();
		tablePersonajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				actualizarFormulario();
			}
		});
		tablePersonajes.setBounds(1, 1, 634, 0);
		frmPersonajes.getContentPane().add(tablePersonajes);
	}
	
	private void cargarPersonajes(){
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		String[] columnas = {"Codigo","Nombre","Energia","Vida","Evasion","Defensa","Puntos"};
		DefaultTableModel tableModel = new DefaultTableModel();
		
		try{
			personajes=ctrldorPer.todosPersonajes();
			tableModel.setColumnIdentifiers(columnas);			
			Object[] fila = new Object[tableModel.getColumnCount()];
			for (int i = 0; i < personajes.size(); i++) {

				fila[0] = personajes.get(i).getCodigo();
				fila[1] = personajes.get(i).getNombre();
				fila[2] = personajes.get(i).getEnergia();
				fila[3] = personajes.get(i).getVida();
				fila[4] = personajes.get(i).getEvasion();
				fila[5] = personajes.get(i).getDefensa();
				fila[6] = personajes.get(i).getPtosTotales();
				tableModel.addRow(fila);
				}
			frmPersonajes.getContentPane().setLayout(null);
			tablePersonajes.setModel(tableModel);
			JScrollPane js = new JScrollPane(tablePersonajes);
			js.setBounds(66, 11, 636, 276);
			frmPersonajes.getContentPane().add(js);
			
			JPanel panel = new JPanel();
			panel.setBounds(45, 322, 411, 179);
			frmPersonajes.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(38, 34, 41, 14);
			panel.add(lblNombre);
			
			textNombre = new JTextField();
			textNombre.setBounds(89, 31, 193, 20);
			panel.add(textNombre);
			textNombre.setColumns(10);
			
			JLabel lblVida = new JLabel("Vida:");
			lblVida.setBounds(80, 68, 34, 14);
			panel.add(lblVida);
			
			textVida = new JTextField();
			textVida.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent arg0) {
				}
				public void inputMethodTextChanged(InputMethodEvent arg0) {
					actualizarTotal();
				}
			});
			textVida.setBounds(118, 65, 34, 20);
			panel.add(textVida);
			textVida.setColumns(10);
			
			JLabel lblDefensa = new JLabel("Defensa:");
			lblDefensa.setBounds(69, 107, 50, 14);
			panel.add(lblDefensa);
			
			textDefensa = new JTextField();
			textDefensa.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}
				public void inputMethodTextChanged(InputMethodEvent event) {
					actualizarTotal();
				}
			});
			textDefensa.setBounds(118, 104, 34, 20);
			panel.add(textDefensa);
			textDefensa.setColumns(10);
			
			JLabel lblEvasion = new JLabel("Evasion:");
			lblEvasion.setBounds(197, 68, 59, 14);
			panel.add(lblEvasion);
			
			textEvasion = new JTextField();
			textEvasion.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}
				public void inputMethodTextChanged(InputMethodEvent event) {
					actualizarTotal();
				}
			});
			textEvasion.setBounds(249, 65, 34, 20);
			panel.add(textEvasion);
			textEvasion.setColumns(10);
			
			JLabel lblEnergia = new JLabel("Energia:");
			lblEnergia.setBounds(197, 107, 59, 14);
			panel.add(lblEnergia);
			
			textEnergia = new JTextField();
			textEnergia.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}
				public void inputMethodTextChanged(InputMethodEvent event) {
					actualizarTotal();
				}
			});
			textEnergia.setBounds(249, 104, 34, 20);
			panel.add(textEnergia);
			textEnergia.setColumns(10);
			
			lblTotal = new JLabel("Total = 200");
			lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTotal.setBounds(312, 93, 89, 14);
			panel.add(lblTotal);
			
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guardar();
				}
			});
			btnGuardar.setBounds(207, 140, 89, 23);
			panel.add(btnGuardar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelar();
				}
			});
			btnCancelar.setBounds(63, 140, 89, 23);
			panel.add(btnCancelar);
			
			JButton btnNuevo = new JButton("Nuevo");
			btnNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nuevo();
				}
			});
			btnNuevo.setBounds(494, 411, 89, 23);
			frmPersonajes.getContentPane().add(btnNuevo);
			
			JButton btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					editar();
				}
			});
			btnEditar.setBounds(494, 351, 89, 23);
			frmPersonajes.getContentPane().add(btnEditar);
			}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	// CODIGO DE LOS EVENTOS DE LOS BOTONES //
	private void guardar(){
		if (!validarDatos()){ //El mismo método informa el error
			return; 
		}		
		personaje.setDefensa(Integer.valueOf(textDefensa.getText()));
		personaje.setEnergia(Double.valueOf(textEnergia.getText()));
		personaje.setEvasion(Integer.valueOf(textEvasion.getText()));
		personaje.setNombre(textNombre.getText());
		personaje.setVida(Double.valueOf(textVida.getText()));
		try{
			ctrldorPer.modificarPersonaje(personaje);
			noEditable();
			limpiarFormulario();
			informar("El personaje fue guardado correctamente");						
		}
		catch(Exception ex){
			informarError(ex.getMessage());
		}
		
	}
	
	private void cancelar(){
		limpiarFormulario();
		noEditable();
	}
	
	private void nuevo(){
		limpiarFormulario();
		editable();
		personaje.setCodigo(0);
		personaje.setPtosTotales(0);
	}
	
	private void editar(){
		editable();
		//ESTO ASI NO ME GUSTA MUCHOO
		int fila=tablePersonajes.getSelectedRow();
		personaje.setCodigo(Integer.valueOf(String.valueOf(tablePersonajes.getValueAt(fila, 0))));
		personaje.setPtosTotales(Integer.valueOf((String)tablePersonajes.getValueAt(fila, 6)));
	}
	 //HASTA ACA//
	
	private void actualizarFormulario(){
		int fila;
		fila=tablePersonajes.getSelectedRow();
		textNombre.setText(String.valueOf(tablePersonajes.getValueAt(fila, 1)));
		textEnergia.setText(String.valueOf(tablePersonajes.getValueAt(fila, 2)));
		textVida.setText(String.valueOf(tablePersonajes.getValueAt(fila, 3)));
		textEvasion.setText(String.valueOf(tablePersonajes.getValueAt(fila, 4)));
		textDefensa.setText(String.valueOf(tablePersonajes.getValueAt(fila, 5)));					
	}
	
	private void limpiarFormulario(){
		textNombre.setText("");
		textEnergia.setText("");
		textVida.setText("");
		textEvasion.setText("");
		textDefensa.setText("");
	}
	
	private void noEditable(){
		textNombre.setEnabled(false);
		textEnergia.setEnabled(false);
		textVida.setEnabled(false);
		textEvasion.setEnabled(false);
		textDefensa.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}
	
	private void editable(){
		textNombre.setEnabled(true);
		textEnergia.setEnabled(true);
		textVida.setEnabled(true);
		textEvasion.setEnabled(true);
		textDefensa.setEnabled(true);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
	}
	
	private void actualizarTotal(){
		int total = 0;
		total = Integer.valueOf(textEnergia.getText()) + Integer.valueOf(textVida.getText()) + Integer.valueOf(textEvasion.getText()) + Integer.valueOf(textDefensa.getText());
		lblTotal.setText("Total= " + String.valueOf(200-total));	
		}
	
	private void informarError(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private void informar(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private Boolean validarDatos(){
		//Valido que los textboxs contengan solamente números!
		validate = new Validate();
		if(!validate.numeroDecimal(textDefensa.getText()) || !validate.numeroDecimal(textEnergia.getText()) || !validate.numeroDecimal(textEvasion.getText()) || !validate.numeroDecimal(textVida.getText())){			
			informarError("Los datos deben ser númericos");
			return false;
		}
		//El nombre no puede estar vacío
		if (!validate.notEmpty(textNombre.getText())) {
			informarError("Debe ingresar un nombre");
			return false;
		}
		return true;
	}
}
