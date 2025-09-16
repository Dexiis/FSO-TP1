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
import javax.swing.JScrollPane;

public class TP1_GUI {

	private JFrame frmAd;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtZe;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TP1_GUI window = new TP1_GUI();
					window.frmAd.setVisible(true);
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
		frmAd = new JFrame();
		frmAd.setOpacity(2.0f);
		frmAd.setTitle("GUI Trabalho Prático 1");
		frmAd.setBounds(100, 100, 684, 545);
		frmAd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAd.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Raio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 42, 29);
		frmAd.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setText("20");
		textField.setBounds(55, 10, 48, 29);
		frmAd.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ângulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(129, 10, 59, 29);
		frmAd.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		textField_1.setText("90");
		textField_1.setBounds(190, 11, 46, 28);
		frmAd.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Distância");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(263, 10, 83, 29);
		frmAd.getContentPane().add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setText("33");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(348, 11, 46, 28);
		frmAd.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Robot");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(506, 10, 59, 29);
		frmAd.getContentPane().add(lblNewLabel_1_2);
		
		txtZe = new JTextField();
		txtZe.setText("Ze");
		txtZe.setHorizontalAlignment(SwingConstants.CENTER);
		txtZe.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		txtZe.setColumns(10);
		txtZe.setBounds(567, 11, 90, 28);
		frmAd.getContentPane().add(txtZe);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ligar");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(567, 46, 71, 28);
		frmAd.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("FRENTE");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(128, 255, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(259, 106, 133, 36);
		frmAd.getContentPane().add(btnNewButton);
		
		JButton btnParar = new JButton("PARAR");
		btnParar.setBackground(new Color(217, 0, 5));
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnParar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnParar.setBounds(259, 140, 133, 36);
		frmAd.getContentPane().add(btnParar);
		
		JButton btnEsquerda = new JButton("ESQUERDA");
		btnEsquerda.setBackground(new Color(255, 255, 0));
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEsquerda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEsquerda.setBounds(129, 140, 133, 36);
		frmAd.getContentPane().add(btnEsquerda);
		
		JButton btnDireita = new JButton("DIREITA");
		btnDireita.setBackground(new Color(0, 128, 192));
		btnDireita.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDireita.setBounds(391, 140, 133, 36);
		frmAd.getContentPane().add(btnDireita);
		
		JButton btnTrs = new JButton("TRÁS");
		btnTrs.setBackground(new Color(192, 192, 192));
		btnTrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTrs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTrs.setBounds(259, 174, 133, 36);
		frmAd.getContentPane().add(btnTrs);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinner.setBounds(358, 221, 42, 29);
		frmAd.getContentPane().add(spinner);
		
		JLabel lblNewLabel_1_3 = new JLabel("Número");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(284, 221, 71, 29);
		frmAd.getContentPane().add(lblNewLabel_1_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Movimentos Aleatórios");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(422, 225, 216, 20);
		frmAd.getContentPane().add(rdbtnNewRadioButton);
		
		JLabel lblConsola = new JLabel("Consola");
		lblConsola.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsola.setBounds(10, 297, 77, 29);
		frmAd.getContentPane().add(lblConsola);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 325, 668, 181);
		frmAd.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
