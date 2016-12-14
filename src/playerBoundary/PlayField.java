package playerBoundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.border.BevelBorder;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.FlowLayout;

import controllers.BackToMenuButtonController;
import controllers.DeselectButtonController;
import controllers.PlayerClickTileController;
import controllers.ResetButtonController;
import controllers.SubmitButtonController;
import controllers.SubmitWordMove;
import controllers.UndoButtonController;
import entities.Model;
import entities.Tile;
import general.IconMap;

public class PlayField extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Model m;
	private int levelType;
	private JButton[][] tileArray;
	private JLabel wordLabel;
	private JLabel scoreLabel;
	private JList<String> wordList;
	private IconMap iconMap;
	private ImageIcon disabledIcon;
	private JLabel timerLabel;
	private JLabel timeLabel;
	public JLabel getScoreLabel(){return scoreLabel;}
	public Timer timer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Model model = new Model();
					//MenuField menu = MenuField.frame;
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
		this.iconMap = new IconMap();
		this.disabledIcon = new ImageIcon(PlayField.class.getResource("/images/white-square.png"));
		levelType = m.getType();
		System.out.print(levelType);
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

		JLabel levelNameLabel = new JLabel(m.getTitle());
		levelNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		levelNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelStarPanel.add(levelNameLabel, BorderLayout.NORTH);

		JPanel starPanel = new JPanel();
		levelStarPanel.add(starPanel, BorderLayout.SOUTH);

		JLabel scoreHeaderLabel = new JLabel("Score:");
		starPanel.add(scoreHeaderLabel);

		scoreLabel = new JLabel("0");
		starPanel.add(scoreLabel);

		JSeparator separator = new JSeparator();
		starPanel.add(separator);

		JLabel star1Label = new JLabel(Integer.toString(m.getScore().getStarScoreIndex(2)));
		star1Label.setIcon(new ImageIcon(PlayField.class.getResource("/general/star.png")));
		starPanel.add(star1Label);

		JLabel star2Label = new JLabel(Integer.toString(m.getScore().getStarScoreIndex(0)));
		star2Label.setIcon(new ImageIcon(PlayField.class.getResource("/general/star.png")));
		starPanel.add(star2Label);

		JLabel star3Label = new JLabel(Integer.toString(m.getScore().getStarScoreIndex(1)));
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
		submitButton.addActionListener(new SubmitButtonController(m, this));

		JButton btnDeselectWord = new JButton("Deselect");
		submitWordPanel.add(btnDeselectWord);
		/*TODO: change constructor to SubmitButtonController if needed*/
		btnDeselectWord.addActionListener(new DeselectButtonController(m,this));

		JPanel taskPanel = new JPanel();
		taskPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FlowLayout flowLayout = (FlowLayout) taskPanel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setVgap(15);
		bottomBarPanel.add(taskPanel);

		timeLabel = new JLabel("Time:");
		taskPanel.add(timeLabel);

		timerLabel = new JLabel(Integer.toString(m.getTime()));
		taskPanel.add(timerLabel);

		JButton undoButton = new JButton("Undo");
		taskPanel.add(undoButton);
		/* TODO add constructor to UndoButtonController if needed*/
		undoButton.addActionListener(new UndoButtonController(m, this));

		JButton resetButton = new JButton("Reset");
		taskPanel.add(resetButton);
		/* TODO add constructor to ResetButtonController if needed*/
		resetButton.addActionListener(new ResetButtonController(this, m));

		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBorder(new EmptyBorder(10,10,10,10));
		contentPane.add(sidebarPanel, BorderLayout.EAST);
		sidebarPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane wordListScrollPane = new JScrollPane();
		sidebarPanel.add(wordListScrollPane, BorderLayout.CENTER);

		wordList = new JList<String>();
		wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wordList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		wordList.setPrototypeCellValue("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDE");
		wordListScrollPane.setViewportView(wordList);



		JLabel wordListLabel = new JLabel("Word List");
		wordListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordListScrollPane.setColumnHeaderView(wordListLabel);

		JPanel boardPanel = new JPanel();
		boardPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(boardPanel, BorderLayout.CENTER);
		tileArray = new JButton[6][6];
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
				tileArray[i][j].addActionListener(new PlayerClickTileController(m, this, i, j));
				char letter = m.getBoard().getTile(i,j).getLetter();
				//char letter = (char) (rng.nextInt(26) + 65);
				//System.out.println(letter);
				Tile tile = m.getBoard().getTile(i,  j);
				if (tile.isEnabled()) {
					tile.setLetter((tile.getLetter() + "").toUpperCase().charAt(0)); // this doesn't do anything, please delete.
					tileArray[i][j].setIcon(iconMap.getIcon(letter));
				}
				else {
					tileArray[i][j].setIcon(disabledIcon);
				}
				boardPanel.add(tileArray[i][j]);
			}
		}
		wordLabel.setText("WORD: " + word);
		wordLabel.setText("WORD: " + m.getSelectedWord().getWordString());

	}
	
	public void checkIfWon(){
		if(this.m.hasWon()){
			// Update the progress
			
			int currentProg = ProgressIO.loadUnlockedNum();
			int playingLevel = m.getSelectedIndex() + 1;
			//System.out.println("new level unlocked" + currentProg + " " + playingLevel);
			if(currentProg == playingLevel){
				
				ProgressIO.saveUnlockedNum(currentProg + 1);
				m.setUnlocked(currentProg + 1 );
			}
		}
	}
	public void hasTimer(){
		System.out.print("Play field understand that the level type is " + m.getType());
		if(m.getType() == 1){
			timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {

					m.setTime(m.getTime()-1);
					int newTime = m.getTime();
					timerLabel.setText(Integer.toString(newTime));
					if(newTime == 0){
						JOptionPane.showMessageDialog(new JFrame(), "Time's Up!");
						gameOver();
						this.cancel();

					}

				}

			}, 1000, 1000);
		}
		else{
			timerLabel.setVisible(false);
			timeLabel.setVisible(false);
		}
	}
	public void stopTimer(){
		if(timerLabel.isVisible()){
			this.timer.cancel();
		}
	}
	protected void gameOver() {
		this.setVisible(false);
		this.dispose();
		new MenuField().setVisible(true);

	}

	public void refreshBoard() {
		wordList.setModel(m.getWordListModel());

		wordLabel.setText("WORD: " + m.getSelectedWord().getWordString());
		//System.out.println(m.getSelectedWord().getWordString());
		m.setSelectedWord(m.getSelectedWord());
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				if (m.getBoard().getTile(x, y).isEnabled()) {
					char letter = m.getBoard().getTile(x, y).getLetter();

					if (!m.getBoard().getTile(x, y).isSelected()) {
						tileArray[x][y].setIcon(iconMap.getIcon(letter));
					}
					else {
						tileArray[x][y].setIcon(iconMap.getPressedIcon(letter));
					}
				}
				else {
					tileArray[x][y].setIcon(disabledIcon);
				}
				tileArray[x][y].setEnabled(m.getBoard().getTile(x, y).isEnabled());
			}
		}

	}

	public void refreshBoardUndo(Model newModel) {
		wordList.setModel(newModel.getWordListModel());

		wordLabel.setText("WORD: " + newModel.getSelectedWord().getWordString());
		//System.out.println(m.getSelectedWord().getWordString());
		newModel.setSelectedWord(newModel.getSelectedWord());
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				if (newModel.getBoard().getTile(x, y).isEnabled()) {
					char letter = newModel.getBoard().getTile(x, y).getLetter();

					if (!newModel.getBoard().getTile(x, y).isSelected()) {
						tileArray[x][y].setIcon(iconMap.getIcon(letter));
					}
					else {
						tileArray[x][y].setIcon(iconMap.getPressedIcon(letter));
					}
				}
				else {
					tileArray[x][y].setIcon(disabledIcon);
				}
				tileArray[x][y].setEnabled(newModel.getBoard().getTile(x, y).isEnabled());
			}
		}

	}
}
