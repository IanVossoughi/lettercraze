package builderBoundary;

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
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;

import controllers.AddButtonController;
import controllers.BuilderClickTileController;
import controllers.BuilderLevelTypeController;
import controllers.DeleteLevelButtonController;
import controllers.ExitBuilderController;
import controllers.ExitButtonController;
//import controllers.FilePicker;
import controllers.GenerateController;
import controllers.LevelNameListener;
import controllers.LimitEditController;
import controllers.SaveLevelButtonController;
import controllers.TimerEditController;
import controllers.NewLevelBuilderController;
import controllers.OpenLevelButtonController;
import controllers.OpenStarWindowController;
import controllers.PreviewButtonController;
import controllers.RemoveButtonController;
import controllers.ResetBuilderController;
import entities.Model;
import entities.Tile;
import general.IconMap;
import playerBoundary.PlayField;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListModel;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class BuildField extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField timeField;
	private JTextField levelNameField;
	private JTextField wordEntryField;
	private JList<String> wordList;
	private JButton removeWordButton;
	private JButton generateButton;
	private Model m;
	private JButton[][] tileArray;
	private JComboBox<String> levelTypeCombo;
	private JPanel boardPanel;
	
	private ImageIcon greenIcon = new ImageIcon(PlayField.class.getResource("/images/green-square.png"));
 	private ImageIcon whiteIcon = new ImageIcon(PlayField.class.getResource("/images/white-square.png"));
 	private IconMap iconMap = new IconMap();
 	private JTextField wordLimitField;
	private JComponent timeLabel;
	private JComponent wordLimitLabel;

	public JPanel getContentPane() { return contentPane; }
	public JComboBox<String> getLevelTypeCombo(){return levelTypeCombo;}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildField frame = new BuildField();
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
	public BuildField() {
		// Initialize Model
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.m = new Model();
		m.setType(2);
		setTitle("LetterCraze Builder");
		setBounds(100, 100, 550, 400);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewLevel = new JMenuItem("New Level");
		mntmNewLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewLevel);
		mntmNewLevel.addActionListener(new NewLevelBuilderController(this, m));
		
		JMenuItem mntmResetLevel = new JMenuItem("Reset Level");
		mntmResetLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmResetLevel);
		mntmResetLevel.addActionListener(new ResetBuilderController(this));

		BuildField realThis = this;
		
		JMenuItem mntmOpenLevel = new JMenuItem("Open Level");
		mntmOpenLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmOpenLevel);
		mntmOpenLevel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new SaveSelectionWindow(m, "open", new OpenLevelButtonController(m, contentPane, realThis)).setVisible(true);;
				
			}
			
		});

		JMenuItem mntmSaveLevel = new JMenuItem("Save Level");
		mntmSaveLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmSaveLevel);
		
		mntmSaveLevel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new SaveSelectionWindow(m, "save", new SaveLevelButtonController(m)).setVisible(true);;
				
			}
			
		});
		
		JMenuItem mntmDeleteLevel = new JMenuItem("Delete Level");
		mntmDeleteLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmDeleteLevel);
		
		mntmDeleteLevel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new SaveSelectionWindow(m, "Delete", new DeleteLevelButtonController(m,realThis)).setVisible(true);
				
			}
			
		});

		JMenuItem mntmExitBuilder = new JMenuItem("Exit Builder");
		mntmExitBuilder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmExitBuilder);
		mntmExitBuilder.addActionListener(new ExitBuilderController(this));
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel menuPanel = new JPanel();
		contentPane.add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));

		JPanel levelStarPanel = new JPanel();
		menuPanel.add(levelStarPanel);
		levelStarPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		levelStarPanel.add(panel, BorderLayout.CENTER);

		JLabel levelNameLabel = new JLabel("Level Name/Description:");
		levelNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel.add(levelNameLabel);

		levelNameField = new JTextField();
		panel.add(levelNameField);
		levelNameField.setColumns(10);
		//levelNameField.addActionListener(new LevelNameListener(levelNameField, m));
		levelNameField.addKeyListener(new LevelNameListener(levelNameField, m));

		JPanel starPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) starPanel.getLayout();
		levelStarPanel.add(starPanel, BorderLayout.SOUTH);

		JLabel levelTypeLabel = new JLabel("Level Type:");
		levelTypeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		levelTypeLabel.setIcon(null);
		starPanel.add(levelTypeLabel);

		levelTypeCombo = new JComboBox<String>();
		levelTypeCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Puzzle", "Lightning", "Theme"}));
		levelTypeCombo.setSelectedIndex(2);
		starPanel.add(levelTypeCombo);
		levelTypeCombo.addActionListener(new BuilderLevelTypeController(this, m));
		m.setType(levelTypeCombo.getSelectedIndex());

		generateButton = new JButton("Generate");
		// controller linked below
		starPanel.add(generateButton);
		

		JButton starThresholdButton = new JButton("Set Star Points");
		starPanel.add(starThresholdButton);
		starThresholdButton.addActionListener(new OpenStarWindowController(m));
		
		JPanel bottomBarPanel = new JPanel();
		contentPane.add(bottomBarPanel, BorderLayout.SOUTH);
		
		wordLimitLabel = new JLabel("Word Limit:");
		bottomBarPanel.add(wordLimitLabel);
		wordLimitLabel.setVisible(false);
		
		wordLimitField = new JTextField();
		wordLimitField.setEnabled(true);
		wordLimitField.setColumns(5);
		bottomBarPanel.add(wordLimitField);
		wordLimitField.setVisible(false);
		wordLimitField.addKeyListener(new LimitEditController(wordLimitField, m));

		timeLabel = new JLabel("Time:");
		bottomBarPanel.add(timeLabel);
		timeLabel.setVisible(false);

		timeField = new JTextField();
		timeField.setEnabled(false);
		bottomBarPanel.add(timeField);
		timeField.setColumns(5);
		timeField.addKeyListener(new TimerEditController(timeField, m));
		timeField.setVisible(false);

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ResetBuilderController(this));
		bottomBarPanel.add(resetButton);
		
		JButton previewButton = new JButton("Preview");
		previewButton.addActionListener(new PreviewButtonController(m, this));
		bottomBarPanel.add(previewButton);
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBorder(new EmptyBorder(10,10,10,10));

		contentPane.add(sidebarPanel, BorderLayout.EAST);
		sidebarPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane wordListPanel = new JScrollPane();
		sidebarPanel.add(wordListPanel, BorderLayout.CENTER);

		wordList = new JList<String>();
		wordList.setModel(m.getWordListModel());

		wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wordList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		wordListPanel.setViewportView(wordList);

		JLabel wordListLabel = new JLabel("Word List");
		wordListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordListPanel.setColumnHeaderView(wordListLabel);

		JPanel addRemoveWordPanel = new JPanel();
		sidebarPanel.add(addRemoveWordPanel, BorderLayout.SOUTH);

		JButton enterWordButton = new JButton("Add");
		enterWordButton.addActionListener(new AddButtonController(this, m));
		addRemoveWordPanel.add(enterWordButton);

		wordEntryField = new JTextField();
		addRemoveWordPanel.add(wordEntryField);
		addRemoveWordPanel.getRootPane().setDefaultButton(enterWordButton);
		wordEntryField.setColumns(10);

		removeWordButton = new JButton("Remove");
		removeWordButton.setEnabled(false);
		removeWordButton.addActionListener(new RemoveButtonController(this, m));
		addRemoveWordPanel.add(removeWordButton);

		boardPanel = new JPanel();
		boardPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(boardPanel, BorderLayout.WEST);
		tileArray = new JButton[6][6];
		boardPanel.setLayout(new GridLayout(6, 6, 0, 0));
		
		m.getBoard().fillBoard();
		populateBoardPanel();
	}
	
	protected void exitBuilder(WindowEvent event) {
        new ExitBuilderController(this).actionPerformed(null);
	}
	
	private void populateBoardPanel() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				tileArray[i][j] = new JButton("");
				tileArray[i][j].setPreferredSize(new Dimension(20, 20));
				tileArray[i][j].setOpaque(false);
				tileArray[i][j].setContentAreaFilled(false);
				tileArray[i][j].setBorderPainted(false);
				Tile tile = m.getBoard().tiles[i][j];
	
				if(tile.isEnabled()){
					tileArray[i][j].setIcon(iconMap.getIcon((char)tile.getLetter().charAt(0)));
				} else {
					tileArray[i][j].setIcon(greenIcon);
				}
				tileArray[i][j].addActionListener(new BuilderClickTileController(m, this, i, j));
					
				tileArray[i][j].setPreferredSize(new Dimension(32, 32));
				boardPanel.add(tileArray[i][j]);
			}
		}
		
		generateButton.addActionListener(new GenerateController(m, this, tileArray));
	}

	public void refreshBoard(){
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				JButton tile = tileArray[x][y];
				if(m.getBoard().tiles[x][y].isEnabled()){
					if(m.getType() != 2) {
						tile.setIcon(greenIcon);
					}
					else {
						tile.setIcon((iconMap.getIcon((char)m.getBoard().getTile(x, y).getLetter().charAt(0))));
					}
				} 
				else {
					tile.setIcon(whiteIcon);
				}
			}
		}
		
	}
	
	public String getWordEntry() {
		return this.wordEntryField.getText();
	}
	
	public void setWordEntry(String entry) {
		this.wordEntryField.setText(entry);
	}
	
	public JTextField getWordEntryField() {
		return this.wordEntryField;
	}
	
	public void setWordEntryField(JTextField entryField) {
		this.wordEntryField = entryField;
	}
	
	
	public void setWordListSelected(int index) {
		this.wordList.setSelectedIndex(index);
	}
	
	public JList<String> getWordList() {
		return this.wordList;
	}
	
	public void setWordList(JList<String> theWordList) {
		this.wordList = theWordList;
	}
	
	public JButton getRemoveButton() {
		return this.removeWordButton;
	}
	
	public void setRemoveButton(JButton RemoveButton) {
		this.removeWordButton = RemoveButton;
	}
	
	public JTextField getTimeField() {
		return this.timeField;
	}
	
	public void setTimeField (JTextField TimeField) {
		this.timeField = TimeField;
	}

	public JComboBox<String> getlevelTypeCombo() {
		return levelTypeCombo;
	}

	public JTextField getlevelNameField() {
		return this.levelNameField;
	}
	
	public JButton getGenerateButton() {
		return this.generateButton;
	}
	
	public void setGenerateButton (JButton genButt) {
		this.generateButton = genButt;
	}
	public JComponent getTimeLabel() {
		return this.timeLabel;
	}
	public JTextField getWordLimitField() {
		return this.wordLimitField;
	}
	public JComponent getWordLimitLabel() {
		return this.wordLimitLabel;
	}
}
