//	Project By Juan Torres Gómez

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Ascensor {

	Controlador control = new Controlador();
	private JFrame frmElevator;
	
	////////	Solo he hecho público los elementos que realmente voy a utilizar.
	static JPanel panel = new JPanel();//Panel que contiene la planta actual
	static JLabel label = new JLabel("0");	//Muestra la planta. Tambi�n es el texto animado.	
	static JLabel imgCabin = new JLabel();	//Dibujo del ascensor en miniatura. Es inicializado m�s adelante.
	static JLabel lblStatusMovement = new JLabel("Subiendo...");	//Estado de movimiento.
	static JLabel lblStatusDoor = new JLabel("Puertas cerrada");	//Estado de puerta.
	static JPanel panelFooter = new JPanel();	//Footer
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ascensor window = new Ascensor();
					window.frmElevator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ascensor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmElevator = new JFrame();
		frmElevator.setResizable(false);
		frmElevator.getContentPane().setBackground(new Color(240, 248, 255));
	frmElevator.setTitle("Elevator");
	frmElevator.setBounds(100, 100, 518, 366);
	frmElevator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmElevator.getContentPane().setLayout(null);
	
		////////	Inicializa el dibujo del ascensor	/////
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("cabin.png").getImage().getScaledInstance(26, 32, Image.SCALE_DEFAULT));
		imgCabin.setIcon(imageIcon);
		
		ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("cabin.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		frmElevator.setIconImage(imageIcon3.getImage());
		////////////////////////////////////////////////////
		
		
		JButton button = new JButton("0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.Ir(0);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(10, 229, 59, 39);
		frmElevator.getContentPane().add(button);
		
		JButton button_1 = new JButton("-1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Ir(-1);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(10, 269, 59, 39);
		frmElevator.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("1");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Ir(1);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBounds(10, 189, 59, 39);
		frmElevator.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Ir(2);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_3.setBounds(10, 148, 59, 39);
		frmElevator.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("3");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Ir(3);
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_4.setBounds(10, 108, 59, 39);
		frmElevator.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("4");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Ir(4);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_5.setBounds(10, 67, 59, 39);
		frmElevator.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("5");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Ir(5);
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_6.setBounds(10, 24, 59, 39);
		frmElevator.getContentPane().add(button_6);
		
		
		panel.setBackground(new Color(51, 102, 102));
		panel.setBounds(144, 67, 236, 217);
		frmElevator.getContentPane().add(panel);
		panel.setLayout(null);
		label.setBounds(0, 0, 236, 217);
		
		
		label.setForeground(new Color(255, 255, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 90));
		panel.add(label);
		
		
		imgCabin.setBounds(70, 229, 26, 39);
		frmElevator.getContentPane().add(imgCabin);
		
		
		panelFooter.setBackground(new Color(51, 153, 0));
		panelFooter.setBounds(0, 311, 515, 26);
		frmElevator.getContentPane().add(panelFooter);
		
		
		panelFooter.add(lblStatusDoor);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panelFooter.add(panel_2);
		
		
		panelFooter.add(lblStatusMovement);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(92, 0, 423, 235);
		frmElevator.getContentPane().add(lblNewLabel_1);
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("header.png").getImage().getScaledInstance(423, 235, Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(imageIcon2);
	}
}
