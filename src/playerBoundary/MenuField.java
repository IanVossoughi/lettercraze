package playerBoundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import controllers.ExitButtonController;
import controllers.LevelSelectMenuTabPaneController;
import controllers.OpenLevelButtonController;
import controllers.PlayButtonController;
import entities.Model;

import java.awt.Color;
import javax.swing.JTabbedPane;

public class MenuField extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Model m;
	private JPanel contentPane;
	//private int unlocked;
	private ProgressIO progress;
	private String levelType;
	private JLabel levelTypeLabel;
	private JLabel lblLevelName;
	private JLabel highScoreNumLabel;
	private JLabel star1Label;
	private JLabel star2Label;
	private JLabel star3Label;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuField frame = new MenuField();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//public int getUnlocked(){return this.unlocked;}
	public JLabel getHighScoreLabel(){return highScoreNumLabel;}
	public String getLevelType(){return this.levelType;}
	public JLabel getLevelTypeLabel(){return this.levelTypeLabel;}
	public JLabel getStar1Label(){return this.star1Label;}
	public JLabel getStar2Label(){return this.star2Label;}
	public JLabel getStar3Label(){return this.star3Label;}

	/**
	 * Create the frame.
	 */
	public MenuField() {
		this.m = new Model();
		//m.writeHighScore();
		m.readHighScore();
		//m.writeStars();
		m.readStars();
		System.out.print(Integer.toString(m.readHighScore()));
		
		progress = new ProgressIO();

		levelTypeLabel = new JLabel("PUZZLE");

		m.setUnlocked(progress.loadUnlockedNum());

		setTitle("LetterCraze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setPreferredSize(getMaximumSize());

		JPanel menuPanel = new JPanel();
		contentPane.add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));

		JPanel levelStarPanel = new JPanel();
		menuPanel.add(levelStarPanel);
		levelStarPanel.setLayout(new BorderLayout(0, 0));

		JLabel letterCrazeLabel = new JLabel("LetterCraze");
		letterCrazeLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
		letterCrazeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelStarPanel.add(letterCrazeLabel, BorderLayout.NORTH);

		JPanel starPanel = new JPanel();
		levelStarPanel.add(starPanel, BorderLayout.SOUTH);

		JLabel selectLabel = new JLabel("Please select a level to play using the tabs below.");
		starPanel.add(selectLabel);

		JPanel bottomBarPanel = new JPanel();
		contentPane.add(bottomBarPanel, BorderLayout.SOUTH);

		JButton playButton = new JButton("Play");
		bottomBarPanel.add(playButton);
		playButton.addActionListener(new PlayButtonController(this, m));


		JButton exitButton = new JButton("Exit");
		bottomBarPanel.add(exitButton);
		exitButton.addActionListener(new ExitButtonController(this));


		JPanel boardPanel = new JPanel();
		boardPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(boardPanel, BorderLayout.CENTER);
		boardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		boardPanel.add(tabbedPane);

		int i;
		for (i = 1; i < 16; i++) {
			JPanel levelListPanel = new JPanel();
			tabbedPane.addTab(Integer.toString(i), null, levelListPanel, null);

			levelListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			levelListPanel.setLayout(new BoxLayout(levelListPanel, BoxLayout.Y_AXIS));

			JPanel levelNumPanel = new JPanel();
			levelListPanel.add(levelNumPanel);

			JLabel levelNumLabel = new JLabel(Integer.toString(i));
			if(i > m.getUnlocked()) levelNumLabel.setIcon(new ImageIcon(MenuField.class.getResource("/general/padlock_locked.png")));
			else levelNumLabel.setIcon(new ImageIcon(MenuField.class.getResource("/general/padlock_unlocked.png")));
			levelNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
			levelNumPanel.add(levelNumLabel);

			JPanel levelNamePanel = new JPanel();
			levelListPanel.add(levelNamePanel);

			// I put lblLevelName definition above tabbedPane listener
			OpenLevelButtonController.loadLevel("levels/1", m, null);
			lblLevelName = new JLabel(m.getTitle());
			levelNamePanel.add(lblLevelName);
			lblLevelName.setHorizontalAlignment(SwingConstants.CENTER);


			switch (i % 3) {
			case 0:
				levelType = "THEME";
				break;
			case 1:
				levelType = "PUZZLE";
				break;
			default:
				levelType = "LIGHTNING";
				break;
			}

			levelTypeLabel = new JLabel("- " + levelType);
			levelNamePanel.add(levelTypeLabel);

			JPanel scorePanel = new JPanel();
			levelListPanel.add(scorePanel);

			JLabel highScoreLabel = new JLabel("High Score - ");
			scorePanel.add(highScoreLabel);

			m.readHighScore();
			highScoreNumLabel = new JLabel(m.getHighScores()[0] + "");
			scorePanel.add(highScoreNumLabel);

			tabbedPane.addChangeListener(new LevelSelectMenuTabPaneController(this, 
					playButton, tabbedPane, m.getUnlocked(), m, lblLevelName, highScoreNumLabel));


			ImageIcon star = new ImageIcon(MenuField.class.getResource("/general/star.png"));
			ImageIcon starGray = new ImageIcon(MenuField.class.getResource("/general/star_gray.png"));

			star1Label = new JLabel("");
			scorePanel.add(star1Label);

			star2Label = new JLabel("");
			scorePanel.add(star2Label);

			star3Label = new JLabel("");
			scorePanel.add(star3Label);
			
			if(m.getStarStatus(i-1) == 0){
				
				star1Label.setIcon(starGray);

				star2Label.setIcon(starGray);
				star3Label.setIcon(starGray);
			}
			else if(m.getStarStatus(i-1) == 1){
				star1Label.setIcon(star);
				star2Label.setIcon(starGray);
				star3Label.setIcon(starGray);
			}
			else if(m.getStarStatus(i-1) == 2){
				star1Label.setIcon(star);
				star2Label.setIcon(star);
				star3Label.setIcon(starGray);
			}
			else{
				star1Label.setIcon(star);
				star2Label.setIcon(star);
				star3Label.setIcon(star);

			}
		}
		//default level type
		levelTypeLabel.setText("PUZZLE");

	}

	public void setLevelNameLabel(String string) {
		this.lblLevelName.setText(string);
	}
	
	public JTabbedPane getTabbedPane() {
		return this.tabbedPane;
	}


}


