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

public class SaveSelectionWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<Integer> levelSelect;

	public SaveSelectionWindow(File file) {
		setTitle("LetterCraze Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JLabel header = new JLabel("Select level number to save as:");
		contentPane.add(header, BorderLayout.NORTH);
		
		levelSelect = new JComboBox<Integer>();
		for(int i = 1; i < 16; i++) levelSelect.addItem(i);
		
		contentPane.add(levelSelect, BorderLayout.CENTER);
		
		/*JButton save = new JButton(new AbstractAction("Save"){
			public void actionPerformed(ActionEvent ae){
				
			}
		});*/
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
			
		});
		
		contentPane.add(save, BorderLayout.SOUTH);
	}

}
