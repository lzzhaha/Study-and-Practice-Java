/*Practice list manipulation in
 * swing, including adding elments,
 * removing elements and initializing 
 * a list. Inner class concept is also
 * included. 		
 * */
package gui_practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//Main class that test the list functionality
public class ListTest extends JPanel implements ListSelectionListener{
	
	private JList ls;
	private DefaultListModel lsModel;
	
	public final String delString = "Delete Student";
	public final String addString = "Add Student";
	private JButton delButton, addButton;
	private JTextField student_names;
	
	public ListTest(){
		super(new BorderLayout());
		//the data of list is hold by the list Model
		lsModel = new DefaultListModel();		
		lsModel.addElement("Tom");
		lsModel.addElement("Ken");
		lsModel.addElement("Sam");
		lsModel.addElement("Amy");
		lsModel.addElement("James");
		
		//populate the list with the data in the list Model
		ls = new JList(lsModel);
		ls.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		ls.setSelectedIndex(0);
		ls.addListSelectionListener(this);
		ls.setVisibleRowCount(5);
		
		//create a scroll pane to hold the list item
		JScrollPane namePane = new JScrollPane(ls);
		
		//Create a JButton to perform name-addition
		addButton = new JButton(addString);
		AdditionListener al = new AdditionListener();
		addButton.addActionListener(al);
		addButton.setEnabled(false);
		
		//Create a JButton to perform name-deletion
		JButton delButton = new JButton(delString);
		DeletionListener dl = new DeletionListener();
		delButton.addActionListener(dl);
		
		//Create a text field for name addition
		this.student_names = new JTextField(20);
		this.student_names.addActionListener(al);
		this.student_names.getDocument().addDocumentListener(al);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane,BoxLayout.PAGE_AXIS));
		buttonPane.add(addButton);
		buttonPane.add(Box.createHorizontalStrut(4));
		buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
		buttonPane.add(Box.createHorizontalStrut(4));
		buttonPane.add(student_names);
		buttonPane.add(Box.createHorizontalStrut(2));
		buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
		buttonPane.add(Box.createHorizontalStrut(2));
		buttonPane.add(delButton);
		buttonPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		add(namePane,BorderLayout.CENTER);
		add(buttonPane,BorderLayout.SOUTH);
	}
	
	public void valueChanged(ListSelectionEvent e){
		if(!e.getValueIsAdjusting()){
			if(ls.getSelectedIndex() == -1){
				this.delButton.setEnabled(false);
			}else{
				this.delButton.setEnabled(true);
			}
		}
	}


	//Inner class that handles the Addition event
	class AdditionListener implements ActionListener,DocumentListener{
	
		
		//Constructor that register the listener to the button parameter
		public AdditionListener(){
			
		}
		
		public void actionPerformed(ActionEvent e){
			String name = student_names.getText();
			if(lsModel.contains(name)){
				//if the name already exists in the name list
				JOptionPane.showMessageDialog(null,"The student already exists!","Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int insertIndex = ls.getSelectedIndex()+1;
			
			lsModel.insertElementAt(student_names.getText(), insertIndex);
			student_names.setText("");
			//Select and display the newly inserted item
			ls.setSelectedIndex(insertIndex);
			ls.ensureIndexIsVisible(insertIndex);
		}
		
		public void changedUpdate(DocumentEvent d){
			if(d.getDocument().getLength()<=0){
				addButton.setEnabled(false);
			}else{
				addButton.setEnabled(true);
			}
		}
		
		public void removeUpdate(DocumentEvent d){
			if(d.getDocument().getLength()<=0){
				addButton.setEnabled(false);
			}else{
				addButton.setEnabled(true);
			}
		}
		
		public void insertUpdate(DocumentEvent d){
			addButton.setEnabled(true);
		}
	}

	//Inner class that handles the deletion event
	class DeletionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int delIndex = ls.getSelectedIndex();
			if(delIndex == -1){
				//No item is selected
				return;
			}
			
			lsModel.remove(delIndex);
			
			int size = lsModel.getSize();
			
			if(size == 0){
				//No item left, disable the delButton
				delButton.setEnabled(false);
			}else{
				if(delIndex == lsModel.getSize()){
					delIndex--;
				}
			}
			
			ls.setSelectedIndex(delIndex);
			ls.ensureIndexIsVisible(delIndex);
		}
	}
	
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ListTest li = new ListTest();
		li.setOpaque(true);
		frame.setContentPane(li);
		
		frame.pack();
		frame.setVisible(true);
	}

	
	
	
	
	
}