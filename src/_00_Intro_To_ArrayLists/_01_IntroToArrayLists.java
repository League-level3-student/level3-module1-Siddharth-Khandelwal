package _00_Intro_To_ArrayLists;

import javax.swing.JOptionPane;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
String[] strings = new String[5];
        // 2. Add five Strings to your list
strings[0] = "bob";
strings[1] = "jeff";
strings[2] = "tom";
strings[3] = "jerry";
strings[4] = "tim";
        // 3. Print all the Strings using a standard for-loop
for (int i = 0; i < strings.length; i++) {
	JOptionPane.showMessageDialog(null, strings[i]);
}
        // 4. Print all the Strings using a for-each loop
for (String string : strings) {
	JOptionPane.showMessageDialog(null, string);
}
        // 5. Print only the even numbered elements in the list.
for (int i = 0; i < strings.length; i+=2) {
	JOptionPane.showMessageDialog(null, strings[i]);
}
        // 6. Print all the Strings in reverse order.
for (int i = strings.length-1; i >= 0; i--) {
	JOptionPane.showMessageDialog(null, strings[i]);
}
        // 7. Print only the Strings that have the letter 'e' in them.
        for (int i = 0; i < strings.length; i++) {
        	for (int j = 0; j < strings[i].length(); j++) {
				if(strings[i].charAt(j) == 'e') {
				JOptionPane.showMessageDialog(null, strings[i]);
			}
			
			}
		}
    }
}
