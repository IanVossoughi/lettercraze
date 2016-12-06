package builderBoundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.StarScoreController;
import entities.Model;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class StarThresholdWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	protected Model m;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarThresholdWindow frame = new StarThresholdWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public StarThresholdWindow(Model m) {
		this.m = m;
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterStarThresholds = new JLabel("Enter the points required for each star:");
		panel.add(lblEnterStarThresholds);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JLabel label_1 = new JLabel("Star 1:");
		label_1.setIcon(new ImageIcon(StarThresholdWindow.class.getResource("/general/star.png")));
		panel_5.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_5.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel lblStar = new JLabel("Star 2:");
		lblStar.setIcon(new ImageIcon(StarThresholdWindow.class.getResource("/general/star.png")));
		panel_3.add(lblStar);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel label = new JLabel("Star 3:");
		label.setIcon(new ImageIcon(StarThresholdWindow.class.getResource("/general/star.png")));
		panel_4.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_4.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new StarScoreController(m, textField, textField_1, textField_2, this));
				
				
				/*new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});*/
		panel_2.add(btnDone);
		
		if(m.getScore() != null){
			textField.setText("" + m.getScore().starScores[0]);
			textField_1.setText("" + m.getScore().starScores[1]);
			textField_2.setText("" + m.getScore().starScores[2]);
		}
	}

}
