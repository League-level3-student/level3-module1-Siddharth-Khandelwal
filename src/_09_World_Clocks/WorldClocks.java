package _09_World_Clocks;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
	ClockUtilities clockUtil;
	Timer timer;
	TimeZone timeZone;
	HashMap<String, TimeZone> allCities = new HashMap<String, TimeZone>();
	JFrame frame;
	JPanel panel;
	JTextArea textArea;
	JButton button = new JButton("Add City");

	String city;
	String cit1;
	String dateStr;
	String timeStr;
	String jjjj = "";

	public WorldClocks() {
		clockUtil = new ClockUtilities();

		// The format for the city must be: city, country (all caps)
		city = JOptionPane.showInputDialog("Enter a City, then country, all caps. EX: CHICAGO, US");
		timeZone = clockUtil.getTimeZoneFromCityName(city);
		allCities.put(city, timeZone);

		Calendar calendar = Calendar.getInstance(timeZone);
		String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
				+ calendar.get(Calendar.YEAR);

		System.out.println(dateStr);

		// Sample starter program
		frame = new JFrame();
		panel = new JPanel();

		textArea = new JTextArea();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(100, 100);
		frame.setBackground(Color.DARK_GRAY);
		panel.setBackground(Color.BLACK);
		textArea.setBackground(Color.GRAY);
		textArea.setForeground(Color.white);
		frame.setTitle("WORLD CLOCK");
		frame.add(panel);
		panel.add(button);
		panel.add(textArea);
		button.addActionListener(this);
		textArea.setText(city + "\n" + dateStr);

		// This Timer object is set to call the actionPerformed() method every
		// 1000 milliseconds
		timer = new Timer(1000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == button) {
			JTextArea newTA = new JTextArea();

			cit1 = JOptionPane.showInputDialog("Enter a City, then country, all caps. EX: CHICAGO, US");
			timeZone = clockUtil.getTimeZoneFromCityName(cit1);
			allCities.put(cit1, timeZone);

		} else {
			panel.removeAll();
			panel.add(button);
			for (String lebron : allCities.keySet()) {

				Calendar c = Calendar.getInstance(allCities.get(lebron));
				String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
						+ c.get(Calendar.SECOND);
				String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":"
						+ c.get(Calendar.SECOND) + "]";
				timeStr = militaryTime + twelveHourTime;
				String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
				String dayOfWeek = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
				dateStr = dayOfWeek + " " + month + " " + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.YEAR);
				// System.out.println(timeStr);
				JTextArea mbappe = new JTextArea();
				mbappe.setText(lebron + "\n" + dateStr + "\n" + timeStr);
				panel.add(mbappe);
				mbappe.setBackground(Color.GRAY);
				mbappe.setForeground(Color.white);
			}
			frame.pack();
		}
		
	}
}
