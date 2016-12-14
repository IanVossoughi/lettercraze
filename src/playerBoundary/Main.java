package playerBoundary;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ContinueButtonController;

public class Main extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main(){
		setTitle("LetterCraze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 700, 600);
	
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		
		JLabel teamName = new JLabel("LetterCraze - Team Chromium");
		contentPane.add(teamName);
		
		JLabel chromiumIcon = new JLabel("");
		chromiumIcon.setIcon(new ImageIcon(PlayField.class.getResource("/general/lettercraze_logo.png")));
		contentPane.add(chromiumIcon);
		
		JButton openLevelSelect = new JButton("Continue");
		openLevelSelect.addActionListener(new ContinueButtonController(this));		
		contentPane.add(openLevelSelect);
	}
}
