package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton addName = new JButton("Add Name");
		JButton show = new JButton("View Names");
		int numOfNames = 0;
		String[] listOfNames = new String[numOfNames];
		/*
		 * Create a GUI with two buttons. One button reads "Add Name" and the other
		 * button reads "View Names". When the add name button is clicked, display
		 * an input dialog that asks the user to enter a name. Add that name to an
		 * ArrayList. When the "View Names" button is clicked, display a message
		 * dialog that displays all the names added to the list. Format the list as
		 * follows:		
		 * Guest #1: Bob Banders
		 * Guest #2: Sandy Summers
		 * Guest #3: Greg Ganders
		 * Guest #4: Donny Doners
		 */
		public void run() {
		// TODO Auto-generated method stub
		
		
		frame.add(panel);
		panel.add(addName);
		panel.add(show);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		addName.addActionListener(this);
		show.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// This code will be executed when the button is clicked
JButton buttonClicked = (JButton)e.getSource();
if(buttonClicked==addName) {
	 String name = JOptionPane.showInputDialog("Please enter a name to add to the Guest Book");
	 numOfNames++;
	 listOfNames[numOfNames] = name;
}
if(buttonClicked==show) {
	for (int i = 0; i < listOfNames.length; i++) {
		JOptionPane.showMessageDialog(null,"Guest #"+numOfNames+" "+listOfNames[i]);
	}
}
		
	}
	
}
