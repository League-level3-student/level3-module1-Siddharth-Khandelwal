package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> things = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Add User");
	JButton button2 = new JButton("Search for a User");
	JButton button3 = new JButton("Display Users");
	JButton button4 = new JButton("Remove User");

	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry
	 * 
	 * When this button is clicked, use an input dialog to ask the user to enter an
	 * ID number. After an ID is entered, use another input dialog to ask the user
	 * to enter a name. Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

	void setup() {
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) e.getSource();
		if (clicked == button1) {
			String enteredID = JOptionPane.showInputDialog("Enter an ID number.");
			String name = JOptionPane.showInputDialog("Enter a name.");
			int ID = Integer.parseInt(enteredID);
			things.put(ID, name);
		}
		if (clicked == button2) {
			String search = JOptionPane.showInputDialog("Enter an ID.");
			int lookFor = Integer.parseInt(search);
			if (things.containsKey(lookFor)) {
				JOptionPane.showMessageDialog(null, things.get(lookFor));
			} else {
				JOptionPane.showMessageDialog(null, "User with the ID number " + lookFor + "does not exist.");
			}
		}
		if (clicked == button3) {

			String names = "";
			for (int key : things.keySet()) {
				names += "ID: " + key + " Name: " + things.get(key);
			}
			JOptionPane.showMessageDialog(null, names);
		}
		if (clicked == button4) {

			String enteredIDD = JOptionPane.showInputDialog("Enter an ID number.");
			int removedWant = Integer.parseInt(enteredIDD);
			if (things.containsKey(removedWant)) {
				things.remove(removedWant);
			} else {
				JOptionPane.showMessageDialog(null, "User with the ID number " + removedWant + "does not exist.");
			}

		}

	}
}
