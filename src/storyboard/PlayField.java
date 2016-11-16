package storyboard;

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
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.border.BevelBorder;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.FlowLayout;

public class PlayField extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayField frame = new PlayField();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayField() {
		setTitle("LetterCraze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel menuPanel = new JPanel();
		contentPane.add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));
		
		JButton backToMenuButton = new JButton("Return");
		menuPanel.add(backToMenuButton);
		
		JPanel levelStarPanel = new JPanel();
		menuPanel.add(levelStarPanel);
		levelStarPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel levelNameLabel = new JLabel("Level Name");
		levelNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		levelNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelStarPanel.add(levelNameLabel, BorderLayout.NORTH);
		
		JPanel starPanel = new JPanel();
		levelStarPanel.add(starPanel, BorderLayout.SOUTH);
		
		JLabel scoreHeaderLabel = new JLabel("Score:");
		starPanel.add(scoreHeaderLabel);
		
		JLabel label = new JLabel("150");
		starPanel.add(label);
		
		JSeparator separator = new JSeparator();
		starPanel.add(separator);
		
		JLabel star1Label = new JLabel("");
		star1Label.setIcon(new ImageIcon(PlayField.class.getResource("/storyboard/star.png")));
		starPanel.add(star1Label);
		
		JLabel star2Label = new JLabel("");
		star2Label.setIcon(new ImageIcon(PlayField.class.getResource("/storyboard/star.png")));
		starPanel.add(star2Label);
		
		JLabel star3Label = new JLabel("");
		star3Label.setIcon(new ImageIcon(PlayField.class.getResource("/storyboard/star.png")));
		starPanel.add(star3Label);
		
		JPanel bottomBarPanel = new JPanel();
		contentPane.add(bottomBarPanel, BorderLayout.SOUTH);
		bottomBarPanel.setLayout(new BoxLayout(bottomBarPanel, BoxLayout.X_AXIS));
		
		JPanel submissionPanel = new JPanel();
		bottomBarPanel.add(submissionPanel);
		submissionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel wordLabel = new JLabel("WORD: F F F");
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		submissionPanel.add(wordLabel);
		
		JButton submitButton = new JButton("Submit");
		submissionPanel.add(submitButton);
		submitButton.setHorizontalAlignment(SwingConstants.LEADING);
		
		JPanel taskPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) taskPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		bottomBarPanel.add(taskPanel);
		
		JButton undoButton = new JButton("Undo");
		taskPanel.add(undoButton);
		
		JLabel timeLabel = new JLabel("Time:");
		taskPanel.add(timeLabel);
		
		JLabel timerLabel = new JLabel("99");
		taskPanel.add(timerLabel);
		
		JButton resetButton = new JButton("Reset");
		taskPanel.add(resetButton);
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBorder(new EmptyBorder(10,10,10,10));
		contentPane.add(sidebarPanel, BorderLayout.EAST);
		sidebarPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane wordListScrollPane = new JScrollPane();
		sidebarPanel.add(wordListScrollPane, BorderLayout.CENTER);
		
		JList<String> wordList = new JList<String>();
		wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wordList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		wordListScrollPane.setViewportView(wordList);
		
		JLabel wordListLabel = new JLabel("Word List");
		wordListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordListScrollPane.setColumnHeaderView(wordListLabel);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(boardPanel, BorderLayout.CENTER);
		JButton[][] tileArray = new JButton[6][6];
		//boolean[][] selectedArray = new boolean[6][6];
		boardPanel.setLayout(new GridLayout(6, 6, 0, 0));
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				tileArray[i][j] = new JButton("");
				tileArray[i][j].setPreferredSize(new Dimension(20, 20));
				tileArray[i][j].setOpaque(false);
				tileArray[i][j].setContentAreaFilled(false);
				tileArray[i][j].setBorderPainted(false);
				if (i > 2 && i < 5 && j > 2 && j < 5) {
					tileArray[i][j].setIcon(new ImageIcon(PlayField.class.getResource("/storyboard/F_pressed.png")));
				} else {
					tileArray[i][j].setIcon(new ImageIcon(PlayField.class.getResource("/storyboard/F.png")));
				}
				if (i == 3 && j == 3) {
					tileArray[i][j].setIcon(new ImageIcon(PlayField.class.getResource("/storyboard/F.png")));
				}
				tileArray[i][j].setPreferredSize(new Dimension(32, 32));
				boardPanel.add(tileArray[i][j]);
			}
		}
	}
}
