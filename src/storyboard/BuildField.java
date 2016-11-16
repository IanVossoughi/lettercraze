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
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
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
		setTitle("LetterCraze Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewresetLevel = new JMenuItem("New/Reset Level");
		mntmNewresetLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewresetLevel);
		
		JMenuItem mntmOpenLevel = new JMenuItem("Open Level");
		mntmOpenLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmOpenLevel);
		
		JMenuItem mntmSaveLevel = new JMenuItem("Save Level");
		mntmSaveLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmSaveLevel);
		
		JMenuItem mntmResetLevel = new JMenuItem("Delete Level");
		mntmResetLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmResetLevel);
		
		JMenuItem mntmExitBuilder = new JMenuItem("Exit Builder");
		mntmExitBuilder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmExitBuilder);
		
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
		
		JPanel starPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) starPanel.getLayout();
		levelStarPanel.add(starPanel, BorderLayout.SOUTH);
		
		JLabel levelTypeLabel = new JLabel("Level Type:");
		levelTypeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		levelTypeLabel.setIcon(null);
		starPanel.add(levelTypeLabel);
		
		JComboBox<String> levelTypeCombo = new JComboBox<String>();
		levelTypeCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Puzzle", "Lightning", "Theme"}));
		starPanel.add(levelTypeCombo);
		
		JButton generateButton = new JButton("Generate");
		generateButton.setEnabled(false);
		starPanel.add(generateButton);
		
		JPanel bottomBarPanel = new JPanel();
		contentPane.add(bottomBarPanel, BorderLayout.SOUTH);
		
		JButton undoButton = new JButton("Undo");
		bottomBarPanel.add(undoButton);
		
		JLabel timeLabel = new JLabel("Time:");
		bottomBarPanel.add(timeLabel);
		
		timeField = new JTextField();
		bottomBarPanel.add(timeField);
		timeField.setColumns(5);
		
		JButton resetButton = new JButton("Reset");
		bottomBarPanel.add(resetButton);
		
		JButton btnStarThresholds = new JButton("Star Thresholds");
		btnStarThresholds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StarThresholdWindow thresholdWindow = new StarThresholdWindow();
				thresholdWindow.setVisible(true);
			}
		});
		// Star Threshold window open:
		
		bottomBarPanel.add(btnStarThresholds);
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBorder(new EmptyBorder(10,10,10,10));
		contentPane.add(sidebarPanel, BorderLayout.EAST);
		sidebarPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane wordListPanel = new JScrollPane();
		sidebarPanel.add(wordListPanel, BorderLayout.CENTER);
		
		JList<String> wordList = new JList<String>();
		wordList.setEnabled(false);
		wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wordList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		wordListPanel.setViewportView(wordList);
		
		JLabel wordListLabel = new JLabel("Word List");
		wordListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordListPanel.setColumnHeaderView(wordListLabel);
		
		JPanel addRemoveWordPanel = new JPanel();
		sidebarPanel.add(addRemoveWordPanel, BorderLayout.SOUTH);
		
		JButton enterWordButton = new JButton("Add");
		enterWordButton.setEnabled(false);
		addRemoveWordPanel.add(enterWordButton);
		
		wordEntryField = new JTextField();
		wordEntryField.setEnabled(false);
		addRemoveWordPanel.add(wordEntryField);
		wordEntryField.setColumns(10);
		
		JButton removeWordButton = new JButton("Remove");
		removeWordButton.setEnabled(false);
		addRemoveWordPanel.add(removeWordButton);
		JPanel boardPanel = new JPanel();
		boardPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(boardPanel, BorderLayout.CENTER);
		JButton[][] tileArray = new JButton[6][6];
		boardPanel.setLayout(new GridLayout(6, 6, 0, 0));
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				tileArray[i][j] = new JButton("");
				tileArray[i][j].setPreferredSize(new Dimension(20, 20));
				tileArray[i][j].setOpaque(false);
				tileArray[i][j].setContentAreaFilled(false);
				tileArray[i][j].setBorderPainted(false);
				if ((5-i) == j) {
					tileArray[i][j].setIcon(new ImageIcon(BuildField.class.getResource("/storyboard/square_32.png")));
				}
				else {
					tileArray[i][j].setIcon(new ImageIcon(BuildField.class.getResource("/storyboard/green-square.png")));					
				}
				tileArray[i][j].setPreferredSize(new Dimension(32, 32));
				boardPanel.add(tileArray[i][j]);
			}
		}
	}

}
