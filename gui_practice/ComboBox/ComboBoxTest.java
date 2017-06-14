/*Use ComboBox to set different
 * format for the current date
 * */
package gui_practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import java.util.*;

public class ComboBoxTest extends JPanel implements ActionListener{
	
	//fields
	private JLabel result;
	private String currentFormat;
	
	//constructor
	public ComboBoxTest(){
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		String[] formats = {
                 "dd MMMMM yyyy",
                 "dd.MM.yy",
                 "MM/dd/yy",
                "yyyy.MM.dd G 'at' hh:mm:ss z",
                "EEE, MMM d, ''yy",
                "h:mm a",
               "H:mm:ss:SSS",
                "K:mm a,z",
                 "yyyy.MMMMM.dd GGG hh:mm aaa"
                };
		currentFormat = formats[0];
		
		//Create two labels specifying the combobox
		JLabel formatLabel1 = new JLabel("Enter a value");
		JLabel formatLabel2 = new JLabel("Or choose one from the dropdown list");
		
		JComboBox box = new JComboBox(formats);
		
		//Set the combobox to be editable so value can be entered
		box.setEditable(true);
		box.addActionListener(this);
		
		result = new JLabel();
		result.setForeground(Color.GREEN);
		result.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.YELLOW),BorderFactory.createEmptyBorder(5,5,5,5)));
		
		//create a label for result label
		JLabel resultLabel = new JLabel("Current Date:", JLabel.CENTER);
		
		//Create panel for formats
		JPanel formatPanel = new JPanel();
		formatPanel.setLayout(new BoxLayout(formatPanel,BoxLayout.PAGE_AXIS));
		formatPanel.add(formatLabel1);
		formatPanel.add(formatLabel2);
		//formatPanel.add(box);
		//set the item in the dropdown list align to the left
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		formatPanel.add(box);
		
		//Create panel for display
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(0,2));
		displayPanel.add(resultLabel);
		displayPanel.add(result);
		
		displayPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		formatPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		add(formatPanel);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(displayPanel);
		
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		reformat();

	}
	
	//Member function that formats the displaying date
	public void reformat(){
		Date today = new Date();
		
		//Set up the formatter
		SimpleDateFormat formatter = new SimpleDateFormat(currentFormat);
		
		try{
			String dateString = formatter.format(today);
			result.setText(dateString);
			result.setForeground(Color.GREEN);
		}
		catch(IllegalArgumentException e){
			result.setText("Error"+e.getMessage());
			result.setForeground(Color.RED);
		}
	}
	
	
	public void actionPerformed(ActionEvent e){
		JComboBox cbox = (JComboBox)(e.getSource());
		String format = (String)(cbox.getSelectedItem());
		currentFormat = format;
		reformat();
	}
	
	public static void main(String[] args){
		JFrame mainFrame = new JFrame("Test ComboBox for date formatting");
		mainFrame.setDefaultLookAndFeelDecorated(true);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ComboBoxTest boxTest = new ComboBoxTest();
		boxTest.setOpaque(true);
		mainFrame.setContentPane(boxTest);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
