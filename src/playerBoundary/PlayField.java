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
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.border.BevelBorder;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.FlowLayout;

import controllers.BackToMenuButtonController;
import controllers.DeselectButtonController;
import controllers.ResetButtonController;
import controllers.SubmitButtonController;
import controllers.UndoButtonController;
import entities.Model;

public class PlayField extends JFrame {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Model m;

	private JButton[][] tileArray;
	private JLabel wordLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Model model = new Model();
					PlayField frame = new PlayField(model);
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
	public PlayField(Model m) {
		this.m = m;
		setTitle("LetterCraze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel menuPanel = new JPanel();
		contentPane.add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));
		
		JButton backToMenuButton = new JButton("Exit Level");
		menuPanel.add(backToMenuButton);
		backToMenuButton.addActionListener(new BackToMenuButtonController(this));
		
		
		JPanel levelStarPanel = new JPanel();
		menuPanel.add(levelStarPanel);
		levelStarPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel levelNameLabel = new JLabel("Level Name/Theme");
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
		star1Label.setIcon(new ImageIcon(PlayField.class.getResource("/general/star.png")));
		starPanel.add(star1Label);
		
		JLabel star2Label = new JLabel("");
		star2Label.setIcon(new ImageIcon(PlayField.class.getResource("/general/star.png")));
		starPanel.add(star2Label);
		
		JLabel star3Label = new JLabel("");
		star3Label.setIcon(new ImageIcon(PlayField.class.getResource("/general/star.png")));
		starPanel.add(star3Label);
		
		JPanel bottomBarPanel = new JPanel();
		contentPane.add(bottomBarPanel, BorderLayout.SOUTH);
		bottomBarPanel.setLayout(new BoxLayout(bottomBarPanel, BoxLayout.X_AXIS));
		
		JPanel submissionPanel = new JPanel();
		submissionPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bottomBarPanel.add(submissionPanel);
		submissionPanel.setLayout(new BoxLayout(submissionPanel, BoxLayout.Y_AXIS));
		
		JPanel wordPanel = new JPanel();
		submissionPanel.add(wordPanel);
		
		wordLabel = new JLabel("WORD: _");
		wordPanel.add(wordLabel);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel submitWordPanel = new JPanel();
		submissionPanel.add(submitWordPanel);
		
		JButton submitButton = new JButton("Submit");
		submitWordPanel.add(submitButton);
		submitButton.setHorizontalAlignment(SwingConstants.LEADING);
		/*TODO: change constructor to SubmitButtonController if needed*/
		submitButton.addActionListener(new SubmitButtonController());

		JButton btnDeselectWord = new JButton("Deselect");
		submitWordPanel.add(btnDeselectWord);
		/*TODO: change constructor to SubmitButtonController if needed*/
		btnDeselectWord.addActionListener(new DeselectButtonController());
		
		JPanel taskPanel = new JPanel();
		taskPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FlowLayout flowLayout = (FlowLayout) taskPanel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setVgap(15);
		bottomBarPanel.add(taskPanel);
		
		JLabel timeLabel = new JLabel("Time:");
		taskPanel.add(timeLabel);
		
		JLabel timerLabel = new JLabel("99");
		taskPanel.add(timerLabel);
		
		JButton undoButton = new JButton("Undo");
		taskPanel.add(undoButton);
		/* TODO add constructor to UndoButtonController if needed*/
		undoButton.addActionListener(new UndoButtonController());
		
		JButton resetButton = new JButton("Reset");
		taskPanel.add(resetButton);
		/* TODO add constructor to ResetButtonController if needed*/
		resetButton.addActionListener(new ResetButtonController());

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
		boardPanel.setLayout(new GridLayout(6, 6, 0, 0));
		Random rng = new Random();
		String word = new String();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				tileArray[i][j] = new JButton("");
				tileArray[i][j].setPreferredSize(new Dimension(32, 32));
				tileArray[i][j].setOpaque(false);
				tileArray[i][j].setContentAreaFilled(false);
				tileArray[i][j].setBorderPainted(false);
				char letter = m.getBoard().getTile(i,j).getLetter();
				//char letter = (char) (rng.nextInt(26) + 65);
				System.out.println(letter);
				tileArray[i][j].setIcon(new ImageIcon(PlayField.class.getResource("/images/" + letter + ".png")));
				boardPanel.add(tileArray[i][j]);
			}
		}
		wordLabel.setText("WORD: " + word);
		wordLabel.setText("WORD: " + m.getSelectedWord().getWordString());
	}

	public void refreshBoard() {
		// TODO Auto-generated method stub
		wordLabel.setText("WORD: " + m.getSelectedWord().getWordString());
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				if (m.getBoard().getTile(x, y).isEnabled()) {
					char letter = m.getBoard().getTile(x, y).getLetter();
					if (!m.getBoard().getTile(x, y).isSelected()) {
						tileArray[x][y].setIcon(new ImageIcon(PlayField.class.getResource("/images/" + letter + ".png")));
					}
					else {
						tileArray[x][y].setIcon(new ImageIcon(PlayField.class.getResource("/images/pressedTiles/" + letter + ".png")));
					}
				}
			}
		}
		
	}
}
