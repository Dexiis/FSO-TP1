import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;

public class GUI {

	private JFrame frmAd;
	private JTextField textRadius;
	private JTextField textAngle;
	private JTextField textDistance;
	private JTextField textRobotName;
	private JCheckBox chckbxOnOff;
	private JSpinner spinnerNumber;
	private JRadioButton rdbtnRandomMovements;

	private RobotController robotController = new RobotController();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmAd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		initialize();
		updateData();
	}

	public void updateData() {
		robotController.updateData(textRadius.getText(), textAngle.getText(), textDistance.getText(),
				textRobotName.getText(), spinnerNumber.getValue().toString(), rdbtnRandomMovements.isSelected(),
				chckbxOnOff.isSelected());
	}

	private void initialize() {
		frmAd = new JFrame();
		frmAd.setTitle("GUI Trabalho Prático 1");
		frmAd.setBounds(100, 100, 684, 545);
		frmAd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAd.getContentPane().setLayout(null);

		JLabel lblRadius = new JLabel("Radius");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRadius.setBounds(10, 10, 52, 29);
		frmAd.getContentPane().add(lblRadius);

		JLabel lblAngle = new JLabel("Angle");
		lblAngle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAngle.setBounds(148, 10, 48, 29);
		frmAd.getContentPane().add(lblAngle);

		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDistance.setBounds(283, 10, 71, 29);
		frmAd.getContentPane().add(lblDistance);

		JLabel lblRobot = new JLabel("Robot");
		lblRobot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRobot.setBounds(506, 10, 59, 29);
		frmAd.getContentPane().add(lblRobot);

		JLabel lblNumber = new JLabel("Number");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumber.setBounds(284, 221, 71, 29);
		frmAd.getContentPane().add(lblNumber);

		JLabel lblLogger = new JLabel("Logger");
		lblLogger.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogger.setBounds(10, 297, 77, 29);
		frmAd.getContentPane().add(lblLogger);

		textRadius = new JTextField();
		textRadius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});
		textRadius.setHorizontalAlignment(SwingConstants.CENTER);
		textRadius.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textRadius.setText("20");
		textRadius.setBounds(64, 10, 48, 29);
		frmAd.getContentPane().add(textRadius);
		textRadius.setColumns(10);

		textAngle = new JTextField();
		textAngle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});
		textAngle.setHorizontalAlignment(SwingConstants.CENTER);
		textAngle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textAngle.setText("90");
		textAngle.setBounds(198, 11, 46, 28);
		frmAd.getContentPane().add(textAngle);
		textAngle.setColumns(10);

		textDistance = new JTextField();
		textDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});
		textDistance.setText("33");
		textDistance.setHorizontalAlignment(SwingConstants.CENTER);
		textDistance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDistance.setColumns(10);
		textDistance.setBounds(356, 11, 46, 28);
		frmAd.getContentPane().add(textDistance);

		textRobotName = new JTextField();
		textRobotName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});
		textRobotName.setText("Ze");
		textRobotName.setHorizontalAlignment(SwingConstants.CENTER);
		textRobotName.setFont(new Font("Tahoma	", Font.PLAIN, 18));
		textRobotName.setColumns(10);
		textRobotName.setBounds(567, 11, 90, 28);
		frmAd.getContentPane().add(textRobotName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 325, 668, 181);
		frmAd.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		spinnerNumber = new JSpinner();
		spinnerNumber.setModel(new SpinnerNumberModel(Integer.valueOf(5), null, null, Integer.valueOf(1)));
		spinnerNumber.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				updateData();
			}
		});
		spinnerNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinnerNumber.setBounds(358, 221, 42, 29);
		frmAd.getContentPane().add(spinnerNumber);

		rdbtnRandomMovements = new JRadioButton("Random Movements");
		rdbtnRandomMovements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});
		rdbtnRandomMovements.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnRandomMovements.setBounds(422, 225, 187, 20);
		frmAd.getContentPane().add(rdbtnRandomMovements);

		chckbxOnOff = new JCheckBox("Turn On");
		chckbxOnOff.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxOnOff.setBounds(567, 46, 95, 28);
		frmAd.getContentPane().add(chckbxOnOff);
		chckbxOnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
				if (chckbxOnOff.isSelected())
					robotController.turnOnRobot();
				else
					robotController.turnOffRobot();
			}
		});

		JButton btnFoward = new JButton("FORWARD");
		btnFoward.setForeground(new Color(0, 0, 0));
		btnFoward.setBackground(new Color(128, 255, 128));
		btnFoward.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFoward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				robotController.moveFowards();
				textArea.append("O Rôbo andou " + textDistance.getText() + " centimetros para a frente.\n");
			}
		});
		btnFoward.setBounds(246, 106, 156, 36);
		frmAd.getContentPane().add(btnFoward);

		JButton btnStop = new JButton("STOP");
		btnStop.setBackground(new Color(217, 0, 5));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				robotController.stop();
				textArea.append("O Rôbo parou.\n");
			}
		});
		btnStop.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStop.setBounds(246, 140, 156, 36);
		frmAd.getContentPane().add(btnStop);

		JButton btnLeft = new JButton("LEFT");
		btnLeft.setBackground(new Color(255, 255, 0));
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				robotController.moveLeftCurve();
				textArea.append("O Rôbo curvou para a esquerda num angulo de " + textAngle.getText()
						+ " com um raio de " + textRadius.getText() + ".\n");
			}
		});
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLeft.setBounds(91, 140, 156, 36);
		frmAd.getContentPane().add(btnLeft);

		JButton btnRight = new JButton("RIGHT");
		btnRight.setBackground(new Color(0, 128, 192));
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRight.setBounds(401, 140, 156, 36);
		frmAd.getContentPane().add(btnRight);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				robotController.moveRightCurve();
				textArea.append("O Rôbo curvou para a direita num angulo de " + textAngle.getText() + " com um raio de "
						+ textRadius.getText() + ".\n");
			}
		});

		JButton btnBackwards = new JButton("BACKWARDS");
		btnBackwards.setBackground(new Color(192, 192, 192));
		btnBackwards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				robotController.moveBackwards();
				textArea.append("O Rôbo andou " + textDistance.getText() + " centimetros para trás.\n");
			}
		});
		btnBackwards.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackwards.setBounds(246, 174, 156, 36);
		frmAd.getContentPane().add(btnBackwards);
	}
}