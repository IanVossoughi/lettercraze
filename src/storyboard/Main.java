package storyboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame{
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
		setBounds(100, 100, 640, 480);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		
		JLabel teamName = new JLabel("LetterCraze - Team Chromium");
		teamName.setIcon(new ImageIcon(PlayField.class.getResource("/images/chromium.png")));
		contentPane.add(teamName);
		
		JLabel chromiumIcon = new JLabel("");
		chromiumIcon.setIcon(new ImageIcon(PlayField.class.getResource("/storyboard/chromium-periodic-table.png")));
		contentPane.add(chromiumIcon);
		
		JButton openLevelSelect = new JButton("Continue");
		openLevelSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuField().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		contentPane.add(openLevelSelect);
	}
}
