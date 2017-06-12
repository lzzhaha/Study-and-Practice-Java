package gui_practice;
/*
 *Implement a simple button and action listener
 *as well as the activation and deactivation
 **/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ButtonPracticePanel extends JPanel implements ActionListener{
	protected JButton button1;
	protected JButton button2;
	protected JButton button3;

	//Constructor
	public ButtonPracticePanel(){
		//get the image icon for three buttons respectively
		ImageIcon image1 = new ImageIcon("C:\\Users\\HAHA\\"
				+ "workspace\\Practice\\src\\gui_practice\\button1.png");
		ImageIcon image2 = new ImageIcon("C:\\Users\\HAHA\\"
				+ "workspace\\Practice\\src\\gui_practice\\button2.png"); 	
		ImageIcon image3 = new ImageIcon("C:\\Users\\HAHA\\"
				+ "workspace\\Practice\\src\\gui_practice\\button3.jpg");
		
		//create the button1 for deactivation
		button1 = new JButton("DeactivateMiddle", image1);
		button1.setVerticalTextPosition(AbstractButton.CENTER);
		button1.setHorizontalTextPosition(AbstractButton.CENTER);
		//set the shortcut key of this button to alt+L
		button1.setMnemonic(KeyEvent.VK_L);
		//set the actionCommand of this button to allow
		//the actionListener distinguish each button
		button1.setActionCommand("disable");
		button1.addActionListener(this);
		
		button2 = new JButton("Middle",image2);
		button2.setVerticalTextPosition(AbstractButton.CENTER);
		button2.setHorizontalTextPosition(AbstractButton.CENTER);
		//set the shortcut key of this button to alt+M
		button2.setMnemonic(KeyEvent.VK_M);
		button2.setActionCommand("enlarge");
		
		//create the button1 for deactivation
		button3 = new JButton("ActiveMiddle", image3);
		button3.setVerticalTextPosition(AbstractButton.CENTER);
		button3.setHorizontalTextPosition(AbstractButton.CENTER);
		//set the shortcut key of this button to alt+R
		button3.setMnemonic(KeyEvent.VK_R);
		//set the actionCommand of this button to allow
		//the actionListener distinguish each button
		button3.setActionCommand("enable");
		button3.addActionListener(this);
		
		//set the tip text for each buttton
		button1.setToolTipText("Pressing this button will deactivate the middle button");
		button2.setToolTipText("Pressing this button will enlarge the frame");
		button3.setToolTipText("Pressing this button will activate the middle button");
		
		//add the button to the panel
		add(button1);
		add(button2);
		add(button3);
	}
	
	public void setListenerForM(ActionListener a){
		button2.addActionListener(a);
	}
	
	public void actionPerformed(ActionEvent event){
		if("disable".equals(event.getActionCommand())){
			button2.setEnabled(false);
		}else if("enable".equals(event.getActionCommand())){
			button2.setEnabled(true);
		}
	}
	
	
	public static void main(String args[]){
		MyFrame frame = new MyFrame("Test Panel");
	}
	
	
}

//the frame that holds the panel and listen to the 
//action of middle button of ButtonPracticePanel
class MyFrame extends JFrame implements ActionListener{
	//Construtor
	private ButtonPracticePanel panel;
	public MyFrame(String title){
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//add the panel
		panel = new ButtonPracticePanel();
		Border b = BorderFactory.createLineBorder(Color.RED);
		panel.setBorder(b);
		panel.setListenerForM(this);
		this.setContentPane(panel);
		this.pack();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if("enlarge".equals(e.getActionCommand())){
			this.setSize(this.getWidth()+10, this.getHeight()+10);
		}
	}
	
	
}



