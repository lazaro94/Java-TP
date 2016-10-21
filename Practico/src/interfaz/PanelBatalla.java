package interfaz;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

import logica.ControladorBatallas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBatalla extends JPanel {
	private JTextField txtVida;
	private JTextField txtEvasion;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private ControladorBatallas cb;

	/**
	 * Create the panel.
	 */
	public PanelBatalla() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atacar();
			}
		});
		add(btnAtacar);
		
		JButton btnDefender = new JButton("Defender");
		btnDefender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defender();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAtacar, 0, SpringLayout.NORTH, btnDefender);
		springLayout.putConstraint(SpringLayout.EAST, btnAtacar, -32, SpringLayout.WEST, btnDefender);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDefender, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnDefender, -25, SpringLayout.EAST, this);
		add(btnDefender);
		
		txtVida = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtVida, 20, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtVida, 71, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtVida, -158, SpringLayout.EAST, this);
		add(txtVida);
		txtVida.setColumns(10);
		txtVida.setEnabled(false);
		
		txtEvasion = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEvasion, 15, SpringLayout.SOUTH, txtVida);
		add(txtEvasion);
		txtEvasion.setColumns(10);
		txtEvasion.setEnabled(false);
		
		JLabel lblVida = new JLabel("Vida:");
		springLayout.putConstraint(SpringLayout.NORTH, lblVida, 22, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblVida, -13, SpringLayout.WEST, txtVida);
		add(lblVida);
		
		JLabel lblEvasion = new JLabel("Evasion:");
		springLayout.putConstraint(SpringLayout.WEST, lblEvasion, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, txtEvasion, 2, SpringLayout.EAST, lblEvasion);
		springLayout.putConstraint(SpringLayout.NORTH, lblEvasion, 19, SpringLayout.SOUTH, lblVida);
		add(lblEvasion);
		
		txtEnergia = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnergia, 0, SpringLayout.NORTH, txtVida);
		springLayout.putConstraint(SpringLayout.EAST, txtEnergia, -35, SpringLayout.EAST, this);
		add(txtEnergia);
		txtEnergia.setColumns(10);
		txtEnergia.setEnabled(false);
		
		txtDefensa = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtDefensa, 0, SpringLayout.NORTH, txtEvasion);
		springLayout.putConstraint(SpringLayout.WEST, txtDefensa, 0, SpringLayout.WEST, txtEnergia);
		springLayout.putConstraint(SpringLayout.EAST, txtDefensa, -34, SpringLayout.EAST, this);
		add(txtDefensa);
		txtDefensa.setColumns(10);
		txtDefensa.setEnabled(false);
		
		JLabel lblEnergia = new JLabel("Energia:");
		springLayout.putConstraint(SpringLayout.WEST, txtEnergia, 6, SpringLayout.EAST, lblEnergia);
		springLayout.putConstraint(SpringLayout.NORTH, lblEnergia, 2, SpringLayout.NORTH, txtVida);
		springLayout.putConstraint(SpringLayout.WEST, lblEnergia, 22, SpringLayout.EAST, txtVida);
		add(lblEnergia);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		springLayout.putConstraint(SpringLayout.EAST, txtEvasion, -22, SpringLayout.WEST, lblDefensa);
		springLayout.putConstraint(SpringLayout.NORTH, lblDefensa, 2, SpringLayout.NORTH, txtEvasion);
		springLayout.putConstraint(SpringLayout.WEST, lblDefensa, 0, SpringLayout.WEST, lblEnergia);
		add(lblDefensa);
		
		JLabel lblEnergiaDisp = new JLabel("energia");
		springLayout.putConstraint(SpringLayout.WEST, lblEnergiaDisp, 0, SpringLayout.WEST, lblEvasion);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEnergiaDisp, -18, SpringLayout.NORTH, btnAtacar);
		add(lblEnergiaDisp);
		
		JLabel lblVidaDisp = new JLabel("vida");
		springLayout.putConstraint(SpringLayout.NORTH, lblVidaDisp, 0, SpringLayout.NORTH, lblEnergiaDisp);
		springLayout.putConstraint(SpringLayout.EAST, lblVidaDisp, -51, SpringLayout.EAST, this);
		add(lblVidaDisp);

	}
	
	private void atacar(){
		
	}
	
	private void defender(){
		
	}
}
