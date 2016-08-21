package interfaz;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import logica.ControladorPersonaje;
import entidades.Personaje;

import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.JButton;

public class Personajes {

	/*Los botones están solamente presentados.
	 *Hay que agrupar los textbox del formulario. 
	 * Ver como manejar en el código cuando un personaje es nuevo y cuando se editó uno existente.
	 * Para saber si se tiene que insertar en la BD o modificar uno existente.
	 * */
	
	private JFrame frmPersonajes;
	private ControladorPersonaje ctrldorPer = new ControladorPersonaje();
	private JTable tablePersonajes;
	private JTextField textNombre;
	private JTextField textVida;
	private JTextField textEvasion;
	private JTextField textEnergia;
	private JTextField textDefensa;

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
			
			textNombre = new JTextField();
			textNombre.setBounds(311, 327, 97, 20);
			textNombre.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(255, 330, 46, 14);
			
			JLabel lblVida = new JLabel("Vida:");
			lblVida.setBounds(206, 373, 59, 14);
			
			textVida = new JTextField();
			textVida.setBounds(266, 370, 86, 20);
			textVida.setColumns(10);
			frmPersonajes.getContentPane().add(js);
			frmPersonajes.getContentPane().add(textNombre);
			frmPersonajes.getContentPane().add(lblNombre);
			frmPersonajes.getContentPane().add(lblVida);
			frmPersonajes.getContentPane().add(textVida);
			
			textEvasion = new JTextField();
			textEvasion.setBounds(431, 370, 86, 20);
			frmPersonajes.getContentPane().add(textEvasion);
			textEvasion.setColumns(10);
			
			textEnergia = new JTextField();
			textEnergia.setBounds(431, 415, 86, 20);
			frmPersonajes.getContentPane().add(textEnergia);
			textEnergia.setColumns(10);
			
			textDefensa = new JTextField();
			textDefensa.setBounds(266, 415, 86, 20);
			frmPersonajes.getContentPane().add(textDefensa);
			textDefensa.setColumns(10);
			
			JLabel lblDefensa = new JLabel("Defensa:");
			lblDefensa.setBounds(189, 418, 76, 14);
			frmPersonajes.getContentPane().add(lblDefensa);
			
			JLabel lblEvasion = new JLabel("Evasion:");
			lblEvasion.setBounds(362, 373, 59, 14);
			frmPersonajes.getContentPane().add(lblEvasion);
			
			JLabel lblEnergia = new JLabel("Energia:");
			lblEnergia.setBounds(362, 418, 59, 14);
			frmPersonajes.getContentPane().add(lblEnergia);
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			horizontalStrut.setBounds(66, 309, 640, 18);
			frmPersonajes.getContentPane().add(horizontalStrut);
			
			JButton btnGuardar = new JButton("Guardar");
			btnGuardar.setBounds(472, 456, 89, 23);
			frmPersonajes.getContentPane().add(btnGuardar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(206, 456, 89, 23);
			frmPersonajes.getContentPane().add(btnCancelar);
			
			JButton btnEditar = new JButton("Editar");
			btnEditar.setBounds(332, 456, 89, 23);
			frmPersonajes.getContentPane().add(btnEditar);
			
			JButton btnNuevo = new JButton("Nuevo");
			btnNuevo.setBounds(91, 456, 89, 23);
			frmPersonajes.getContentPane().add(btnNuevo);
			}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	private void actualizarFormulario(){
		int fila;
		fila=tablePersonajes.getSelectedRow();
		textNombre.setText(String.valueOf(tablePersonajes.getValueAt(fila, 1)));
		textEnergia.setText(String.valueOf(tablePersonajes.getValueAt(fila, 2)));
		textVida.setText(String.valueOf(tablePersonajes.getValueAt(fila, 3)));
		textEvasion.setText(String.valueOf(tablePersonajes.getValueAt(fila, 4)));
		textDefensa.setText(String.valueOf(tablePersonajes.getValueAt(fila, 5)));					
	}
}
