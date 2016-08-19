package interfaz;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import logica.ControladorPersonaje;
import entidades.Personaje;

import java.awt.BorderLayout;
import javax.swing.JTable;

public class Personajes {

	private JFrame frmPersonajes;
	private ControladorPersonaje ctrldorPer = new ControladorPersonaje();
	private JTable tablePersonajes;

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
		frmPersonajes.getContentPane().setLayout(null);
		
		tablePersonajes = new JTable();
		tablePersonajes.setBounds(315, 137, 1, 1);
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
			tablePersonajes.setModel(tableModel);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
