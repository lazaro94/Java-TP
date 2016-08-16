package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AltaPersonaje {

	private JFrame frame;
	private JTextField textVida;
	private JTextField textDefensa;
	private JTextField textEvasion;
	private JTextField textEnergia;
	private JLabel lblTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPersonaje window = new AltaPersonaje();
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
	public AltaPersonaje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTotal = new JLabel("Total: 200");
		lblTotal.setBounds(333, 11, 67, 14);
		frame.getContentPane().add(lblTotal);
		
		textVida = new JTextField();
		textVida.setText("0");
		textVida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				actualizarTotal();
			}
		});
		textVida.setBounds(85, 27, 86, 20);
		frame.getContentPane().add(textVida);
		textVida.setColumns(10);
		
		JLabel lblVida = new JLabel("Vida:");
		lblVida.setBounds(29, 30, 46, 14);
		frame.getContentPane().add(lblVida);
		
		textDefensa = new JTextField();
		textDefensa.setText("0");
		textDefensa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarTotal();
			}
		});
		textDefensa.setBounds(85, 76, 86, 20);
		frame.getContentPane().add(textDefensa);
		textDefensa.setColumns(10);
		
		JLabel lblDefens = new JLabel("Defensa:");
		lblDefens.setBounds(29, 79, 46, 14);
		frame.getContentPane().add(lblDefens);
		
		JLabel lblEvasion = new JLabel("Evasion:");
		lblEvasion.setBounds(29, 127, 46, 14);
		frame.getContentPane().add(lblEvasion);
		
		textEvasion = new JTextField();
		textEvasion.setText("0");
		textEvasion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarTotal();
			}
		});
		textEvasion.setBounds(85, 124, 86, 20);
		frame.getContentPane().add(textEvasion);
		textEvasion.setColumns(10);
		
		JLabel lblEnergia = new JLabel("Energia:");
		lblEnergia.setBounds(29, 169, 46, 14);
		frame.getContentPane().add(lblEnergia);
		
		textEnergia = new JTextField();
		textEnergia.setText("0");
		textEnergia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarTotal();
			}
		});
		textEnergia.setBounds(85, 166, 86, 20);
		frame.getContentPane().add(textEnergia);
		textEnergia.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clickGuardar();
			}
		});
		btnGuardar.setBounds(254, 212, 89, 23);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(99, 212, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
	
	private void validarDatos(){
		if (!textDefensa.getText().matches("[0-9]*") || !textEnergia.getText().matches("[0-9]*") || !textEvasion.getText().matches("[0-9]*")
		|| !textVida.getText().matches("[0-9]*")){
			informarError("Los datos deben ser n�mericos");
		}
	}
	
	private void informarError(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private void clickGuardar(){
		validarDatos();
	}
	
	private void actualizarTotal(){
		int parcial=0;
		parcial= Integer.parseInt(textEnergia.getText()) + Integer.parseInt(textVida.getText()) + Integer.parseInt(textEvasion.getText())
		+ Integer.parseInt(textDefensa.getText());
		if((200-parcial)>0){
			lblTotal.setText("Total: "+Integer.toString((200-parcial)));
		}
		else {
			informarError("No puede asignar mas de 200 puntos");
		}
		
	}
}
