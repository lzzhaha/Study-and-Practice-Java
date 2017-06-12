package gui_practice;
//Practice creating a custom Frame in java

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;


public class FramePractice extends JFrame{
	public FramePractice(String title){
		
		//get the dimension of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		/*Since the JFrame is the topLevel components, setSize() 
		 should be used rather than setPreferredSize()
		*/
		setSize(screenSize.width/2, screenSize.height/2);
		
		setTitle(title);
		
		ImageIcon image = new ImageIcon("C:\\Users\\HAHA\\workspace\\Practice\\src\\gui_practice\\thCC3OEVM8.jpg");
		//Set the image icon for the frame
		setIconImage(image.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		//add a label to the frame
		JLabel label = new JLabel("Hello World!");
		label.setPreferredSize(new Dimension(screenSize.width/4, screenSize.height/4));
		
		//Create a border for the label
		Border border= BorderFactory.createLineBorder(Color.BLUE);
		
		
		label.setBorder(border);
		
		getContentPane().add(label, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	public static void main(String args[]){
		FramePractice frame = new FramePractice("Frame class!");
	}
}
