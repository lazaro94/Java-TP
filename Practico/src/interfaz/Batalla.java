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
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Batalla {

	private JFrame frmBatalla;
	private ControladorPersonaje ctrldorPer;
	private JPanel panelWest;
	private JPanel panelEast;
	private panelSeleccion panelJug1 = new panelSeleccion();
	private panelSeleccion panelJug2 = new panelSeleccion();

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBatalla = new JFrame();
		frmBatalla.setBounds(100, 100, 850, 513);
		frmBatalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBatalla.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelWest = new JPanel();
		frmBatalla.getContentPane().add(panelWest, BorderLayout.WEST);
		
		panelEast = new JPanel();
		frmBatalla.getContentPane().add(panelEast, BorderLayout.EAST);
		addPanels();
	}
	
	private void addPanels(){
		panelJug1.setTitle("Jugador 1");
		panelJug2.setTitle("Jugador 2");
		panelWest.removeAll();
		panelWest.add(panelJug1);
		panelWest.revalidate();
		panelWest.repaint();
		panelEast.removeAll();
		panelEast.add(panelJug2);
		panelEast.revalidate();
		panelEast.repaint();
	}

}
