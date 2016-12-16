package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import builderBoundary.BuildField;
import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

/**
 *  Controls all actions related to the Builder Preview Level Button, 
 *  This displays a preview of the level being built in its current form.
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class PreviewButtonController implements ActionListener{

	/** The highest level entity model.*/
	private Model m;
	/** Copy of model to use for preview.*/
	private Model mCopy;
	/** The builder boundary that we are manipulating and using to begin the action. */
	private BuildField b;
	
	/**
	 * PreviewButtonController constructor comment.
	 */
	public PreviewButtonController(Model m, BuildField b) {
		this.m = m;
		this.mCopy = m.copyModel();
		this.b = b;
	}

	
	/**
	 * Coordinate reaction to clicking the Preview Level button on the Builder
	 * <p>
	 * @param e controllers.PreviewButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		PlayField p1 = createPlay(e);
		p1.setVisible(false);
		p1.dispose();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				createPlay(e).toFront();
			}
		}, 2);
		b.refreshBoard();
	}
	
	private PlayField createPlay(ActionEvent e){
		mCopy = m.copyModel();
		// Before we open the PlayField, load the level into the model.
		m.setSelectedTab(m.getType());
		saveLevel();
		loadLevel();
		PlayField pf = new PlayField(mCopy);
		pf.hasTimer();
		pf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pf.getBackToMenuButton().setEnabled(false);
		pf.setVisible(true);
		return pf;
	}

	private void loadLevel() {
		// Get the selected index, convert to string
		int levelNum = (mCopy.getSelectedIndex() + 1);
		String filePath = "levels/temp";
		new OpenLevelButtonController(mCopy, null, null).loadLevel(filePath, m, null);
		m.setSelectedTab(m.getType());
		System.out.println(m.getType() + " CURR TYPE LOADED");
		// The last two parameters are null because we are not in the builder.
		// Shouldn't be a problem because the loadLevel method doesn't actually use them.
	}
	
	private void saveLevel() {
		// Get the selected index, convert to string
		String filePath = "levels/temp";
		new SaveLevelButtonController(mCopy).saveLevel(filePath);
		// The last two parameters are null because we are not in the builder.
		// Shouldn't be a problem because the loadLevel method doesn't actually use them.
	}

}
