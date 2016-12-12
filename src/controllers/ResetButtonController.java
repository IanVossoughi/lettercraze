package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.Model;
import playerBoundary.PlayField;

public class ResetButtonController implements ActionListener {

private PlayField playField;
private Model m;

public ResetButtonController(PlayField playField, Model m) {
this.playField = playField;
this.m = m;
}
@Override
public void actionPerformed(ActionEvent e) {
Object[] options = {"Reset Level",
"Cancel"};
int n = JOptionPane.showOptionDialog(new JFrame(),
"Are you sure you want to reset? All progress will be lost.",
"Yes or No",
JOptionPane.YES_NO_OPTION,
JOptionPane.WARNING_MESSAGE,
null,
options,
options[0]);
if(n == 0){
// INSERT CODE TO RESET EVERYTHING BUT TIMER
JOptionPane.showMessageDialog(new JFrame(),"Level reset.");
}
}
}
