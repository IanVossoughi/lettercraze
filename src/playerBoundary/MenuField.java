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
	private int unlocked;
	private ProgressIO progress;
	private String levelType;
	private JLabel levelTypeLabel;
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
	
	public int getUnlocked(){return this.unlocked;}
	public String getLevelType(){return this.levelType;}
	public JLabel getLevelTypeLabel(){return this.levelTypeLabel;}
	/**
	 * Create the frame.
	 */
	public MenuField() {
		this.m = new Model();
		m.writeHighScore();
		m.readHighScore(0);
		progress = new ProgressIO();
		
		levelTypeLabel = new JLabel("PUZZLE");
		//change to test
		progress.saveUnlockedNum(2);

		unlocked = progress.loadUnlockedNum();
		
		System.out.println("Unlocked: " + unlocked);
		
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
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			boardPanel.add(tabbedPane);
			tabbedPane.addChangeListener(new LevelSelectMenuTabPaneController(this, playButton, tabbedPane, unlocked));

			int i;
			for (i = 1; i < 16; i++) {
			JPanel levelListPanel = new JPanel();
			tabbedPane.addTab(Integer.toString(i), null, levelListPanel, null);
			
			levelListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			levelListPanel.setLayout(new BoxLayout(levelListPanel, BoxLayout.Y_AXIS));

			JPanel levelNumPanel = new JPanel();
			levelListPanel.add(levelNumPanel);

			JLabel levelNumLabel = new JLabel(Integer.toString(i));
			if(i > unlocked) levelNumLabel.setIcon(new ImageIcon(MenuField.class.getResource("/general/padlock_locked.png")));
			else levelNumLabel.setIcon(new ImageIcon(MenuField.class.getResource("/general/padlock_unlocked.png")));
			levelNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			
			// Only add padlock if it is unlocked
			levelNumPanel.add(levelNumLabel);

			JPanel levelNamePanel = new JPanel();
			levelListPanel.add(levelNamePanel);

			JLabel lblLevelName = new JLabel("Name");
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

			JLabel highScoreNumLabel = new JLabel("0");
			scorePanel.add(highScoreNumLabel);

			ImageIcon star = new ImageIcon(MenuField.class.getResource("/general/star.png"));
			JLabel star1Label = new JLabel("");
			scorePanel.add(star1Label);
			star1Label.setIcon(star);

			JLabel star2Label = new JLabel("");
			scorePanel.add(star2Label);
			star2Label.setIcon(star);

			JLabel star3Label = new JLabel("");
			star3Label.setIcon(star);
			scorePanel.add(star3Label);
			
			
			}

	}
	
}
