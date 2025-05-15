package _08_California_Weather;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("   -  Search For A City  -   ");
	JButton button2 = new JButton("   -  Specify A Weather Condition  -   ");
	JButton button3 = new JButton("   -  Enter a Temperature Range  -   ");

	void start() {
		HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

		// All city keys have the first letter capitalized of each word
		String cityName = Utilities.capitalizeWords("National City");
		WeatherData datum = weatherData.get(cityName);

		if (datum == null) {
			System.out.println("Unable to find weather data for: " + cityName);
		} else {
			System.out.println(
					cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}
	}

	public void setup() {
		frame.add(panel);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		frame.setTitle("California Weather App");
		frame.setBackground(Color.CYAN);
		panel.setBackground(Color.DARK_GRAY);
		button.setBackground(Color.LIGHT_GRAY);
		button2.setBackground(Color.LIGHT_GRAY);
		button3.setBackground(Color.LIGHT_GRAY);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressed = (JButton) e.getSource();
		if (pressed == button) {
			String city = JOptionPane.showInputDialog("Enter a City");
			String bob = Utilities.capitalizeWords(city);
			WeatherData ciudad = Utilities.getWeatherData().get(bob);
			Double give = ciudad.temperatureF;
			JOptionPane.showMessageDialog(null,
					"The temperature in " + bob + ", California is " + give + " degrees Farenheit.");

		}
		if (pressed == button2) {
			String condition = JOptionPane.showInputDialog("Enter a Weather Condition");

		}
		if (pressed == button3) {
			String minName = JOptionPane.showInputDialog("Enter a Minimum Temperature");
			String maxName = JOptionPane.showInputDialog("Enter a Maximum Temperature");

			int minimum = Integer.parseInt(minName);
			int maximum = Integer.parseInt(maxName);
		}
	}
}
