package storyboard;

//Test commit by Andrew
//Hello

import java.awt.EventQueue;

import javax.swing.JFrame;

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
		
	}
}
