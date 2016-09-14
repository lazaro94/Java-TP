package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Personaje;
import logica.ControladorPersonaje;

public class Batalla {

	private JFrame frmBatalla;
	private JTable tablePlayers1;
	private JTable tablePlayers2;
	private ControladorPersonaje ctrldorPer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Batalla window = new Batalla();
					window.frmBatalla.setVisible(true);
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
		loadTables();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBatalla = new JFrame();
		frmBatalla.setBounds(100, 100, 850, 513);
		frmBatalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBatalla.getContentPane().setLayout(null);
		
		JLabel lblJugador_1 = new JLabel("JUGADOR 2");
		lblJugador_1.setBounds(620, 36, 109, 14);
		frmBatalla.getContentPane().add(lblJugador_1);
		
		tablePlayers1 = new JTable();
		tablePlayers1.setBounds(63, 316, 109, -244);
		frmBatalla.getContentPane().add(tablePlayers1);
		tablePlayers2 = new JTable();
		tablePlayers2.setBounds(550, 279, -89, -202);
		frmBatalla.getContentPane().add(tablePlayers2);
	}
	
	private void loadTables(){
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		ctrldorPer = new ControladorPersonaje();
		String[] columnas = {"Codigo","Nombre","Energia","Vida","Evasion","Defensa","Puntos"};
		DefaultTableModel tableModel = new DefaultTableModel();
		
		try {
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
			frmBatalla.getContentPane().setLayout(null);
			tablePlayers1.setModel(tableModel);
			tablePlayers2.setModel(tableModel);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
