package builderBoundary;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.OpenLevelButtonController;
import controllers.SaveLevelButtonController;
import entities.Model;

public class SaveSelectionWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<Integer> levelSelect;
	private Model m;

	public SaveSelectionWindow(Model m, String action, ActionListener listener) {
		this.m = m;
		setTitle("LetterCraze Builder");
		setBounds(100, 100, 550, 100);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		JLabel header = new JLabel("Select level number to " + action + ":");
		contentPane.add(header);//, BorderLayout.NORTH);
		
		levelSelect = new JComboBox<Integer>();
		for(int i = 1; i < 16; i++) levelSelect.addItem(i);
		
		contentPane.add(levelSelect);//, BorderLayout.CENTER);
	
		
		JButton save = new JButton(action);
		save.addActionListener(listener);
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				m.setLevelSaverInt((Integer)levelSelect.getSelectedItem());
				setVisible(false);
				dispose();
			}
			
		});
		
		contentPane.add(save);//, BorderLayout.SOUTH);
	}

	public JComboBox<Integer> getCombo() {
		return this.levelSelect;
	}

}
