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
	private JTextField textRaio;
	private JTextField textAngulo;
	private JTextField textDistancia;
	private JTextField textRobot;

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

	private double reta(int distancia) {
		return (distancia / 0.02) + 100;
	}

	private double curvarDireita(int raio, int angulo) {
		return ((raio * angulo) / 0.02) + 100;
	}

	private double curvarEsquerda(int raio, int angulo) {
		return ((raio * -angulo) / 0.02) + 100;
	}

	private double parar() {
		return 100;
	}

	private void initialize() {
		frmAd = new JFrame();
		frmAd.setTitle("GUI Trabalho Prático 1");
		frmAd.setBounds(100, 100, 684, 545);
		frmAd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAd.getContentPane().setLayout(null);

		JLabel lblRaio = new JLabel("Raio");
		lblRaio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRaio.setBounds(10, 10, 42, 29);
		frmAd.getContentPane().add(lblRaio);

		JLabel lblAngulo = new JLabel("Ângulo");
		lblAngulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAngulo.setBounds(129, 10, 59, 29);
		frmAd.getContentPane().add(lblAngulo);

		JLabel lblDistancia = new JLabel("Distância");
		lblDistancia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDistancia.setBounds(263, 10, 83, 29);
		frmAd.getContentPane().add(lblDistancia);

		JLabel lblRobot = new JLabel("Robot");
		lblRobot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRobot.setBounds(506, 10, 59, 29);
		frmAd.getContentPane().add(lblRobot);

		JLabel lblNumero = new JLabel("Número");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumero.setBounds(284, 221, 71, 29);
		frmAd.getContentPane().add(lblNumero);

		JLabel lblConsola = new JLabel("Consola");
		lblConsola.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsola.setBounds(10, 297, 77, 29);
		frmAd.getContentPane().add(lblConsola);

		textRaio = new JTextField();
		textRaio.setHorizontalAlignment(SwingConstants.CENTER);
		textRaio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textRaio.setText("20");
		textRaio.setBounds(55, 10, 48, 29);
		frmAd.getContentPane().add(textRaio);
		textRaio.setColumns(10);

		textAngulo = new JTextField();
		textAngulo.setHorizontalAlignment(SwingConstants.CENTER);
		textAngulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textAngulo.setText("90");
		textAngulo.setBounds(190, 11, 46, 28);
		frmAd.getContentPane().add(textAngulo);
		textAngulo.setColumns(10);

		textDistancia = new JTextField();
		textDistancia.setText("33");
		textDistancia.setHorizontalAlignment(SwingConstants.CENTER);
		textDistancia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDistancia.setColumns(10);
		textDistancia.setBounds(348, 11, 46, 28);
		frmAd.getContentPane().add(textDistancia);

		textRobot = new JTextField();
		textRobot.setText("Ze");
		textRobot.setHorizontalAlignment(SwingConstants.CENTER);
		textRobot.setFont(new Font("Tahoma	", Font.PLAIN, 18));
		textRobot.setColumns(10);
		textRobot.setBounds(567, 11, 90, 28);
		frmAd.getContentPane().add(textRobot);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 325, 668, 181);
		frmAd.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JCheckBox chckbxLigado = new JCheckBox("Ligar");
		chckbxLigado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxLigado.setBounds(567, 46, 71, 28);
		frmAd.getContentPane().add(chckbxLigado);

		JSpinner spinnerNumber = new JSpinner();
		spinnerNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinnerNumber.setBounds(358, 221, 42, 29);
		frmAd.getContentPane().add(spinnerNumber);

		JRadioButton rdbtnMovimentosAleatorios = new JRadioButton("Movimentos Aleatórios");
		rdbtnMovimentosAleatorios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMovimentosAleatorios.setBounds(422, 225, 216, 20);
		frmAd.getContentPane().add(rdbtnMovimentosAleatorios);

		JButton btnFrente = new JButton("FRENTE");
		btnFrente.setForeground(new Color(0, 0, 0));
		btnFrente.setBackground(new Color(128, 255, 128));
		btnFrente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reta(Integer.parseInt(textDistancia.getText()));
				textArea.append("O Rôbo andou " + textDistancia.getText() + " centimetros para a frente.\n");
			}
		});
		btnFrente.setBounds(259, 106, 133, 36);
		frmAd.getContentPane().add(btnFrente);

		JButton btnParar = new JButton("PARAR");
		btnParar.setBackground(new Color(217, 0, 5));
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parar();
				textArea.append("O Rôbo parou.\n");
			}
		});
		btnParar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnParar.setBounds(259, 140, 133, 36);
		frmAd.getContentPane().add(btnParar);

		JButton btnEsquerda = new JButton("ESQUERDA");
		btnEsquerda.setBackground(new Color(255, 255, 0));
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curvarEsquerda(Integer.parseInt(textRaio.getText()), Integer.parseInt(textAngulo.getText()));
				textArea.append("O Rôbo curvou para a esquerda num angulo de " + textAngulo.getText()
						+ " com um raio de " + textRaio.getText() + ".\n");
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
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curvarDireita(Integer.parseInt(textRaio.getText()), Integer.parseInt(textAngulo.getText()));
				textArea.append("O Rôbo curvou para a direita num angulo de " + textAngulo.getText()
						+ " com um raio de " + textRaio.getText() + ".\n");
			}
		});

		JButton btnTras = new JButton("TRÁS");
		btnTras.setBackground(new Color(192, 192, 192));
		btnTras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reta(-Integer.parseInt(textDistancia.getText()));
				textArea.append("O Rôbo andou " + textDistancia.getText() + " centimetros para trás.\n");
			}
		});
		btnTras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTras.setBounds(259, 174, 133, 36);
		frmAd.getContentPane().add(btnTras);
	}
}
