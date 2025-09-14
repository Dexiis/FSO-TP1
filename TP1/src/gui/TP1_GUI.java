package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class TP1_GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtZe;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TP1_GUI window = new TP1_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TP1_GUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Raio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(49, 10, 42, 29);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setText("20");
		textField.setBounds(94, 10, 48, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ângulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(191, 10, 59, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		textField_1.setText("90");
		textField_1.setBounds(252, 11, 46, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Distância");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(356, 10, 83, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setText("33");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(441, 11, 46, 28);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Robot");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(625, 10, 59, 29);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtZe = new JTextField();
		txtZe.setText("Ze");
		txtZe.setHorizontalAlignment(SwingConstants.CENTER);
		txtZe.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		txtZe.setColumns(10);
		txtZe.setBounds(686, 11, 90, 28);
		frame.getContentPane().add(txtZe);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ligar");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(684, 55, 92, 28);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("FRENTE");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(128, 255, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(320, 128, 133, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnParar = new JButton("PARAR");
		btnParar.setBackground(new Color(217, 0, 5));
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnParar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnParar.setBounds(320, 162, 133, 36);
		frame.getContentPane().add(btnParar);
		
		JButton btnEsquerda = new JButton("ESQUERDA");
		btnEsquerda.setBackground(new Color(255, 255, 0));
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEsquerda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEsquerda.setBounds(191, 162, 133, 36);
		frame.getContentPane().add(btnEsquerda);
		
		JButton btnDireita = new JButton("DIREITA");
		btnDireita.setBackground(new Color(0, 128, 192));
		btnDireita.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDireita.setBounds(452, 162, 133, 36);
		frame.getContentPane().add(btnDireita);
		
		JButton btnTrs = new JButton("TRÁS");
		btnTrs.setBackground(new Color(192, 192, 192));
		btnTrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTrs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTrs.setBounds(320, 196, 133, 36);
		frame.getContentPane().add(btnTrs);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinner.setBounds(383, 269, 42, 29);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_1_3 = new JLabel("Número");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(309, 269, 71, 29);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Movimentos Aleatórios");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(447, 273, 216, 20);
		frame.getContentPane().add(rdbtnNewRadioButton);
	}
}
