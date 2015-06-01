package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class EntryPanel extends JPanel implements ActionListener{
	
	
	// Field for components
	JTextField firstName;
	JTextField secondName;
	JTextField occupation;
	JTextField City;
	JButton entryLoad;
	JButton reset;
	TextPanel textPanel;
	String commaDelimiter;
	CustomEntryListener entryListener;
	private JButton viewText;
	private JButton clear;
	
	public EntryPanel(){
		
		//setting panel
		//size
		Dimension size = getPreferredSize();
		size.width = 200;
		
		setPreferredSize(size);
		
		// setting orders
		Border insideBorder = BorderFactory.createTitledBorder("Add entry");
		Border outsideBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		
		// components initialized
		firstName  = new JTextField(20);
		secondName = new JTextField(20);
		occupation = new JTextField(20);
		City       = new JTextField(20);
				
		commaDelimiter = ",";
		
		entryLoad = new JButton("Load Text ");
		reset     = new JButton("Reset Text");
		viewText  = new JButton("View text");
		clear     = new JButton("Clear all");
		
		
		entryLoad.addActionListener(this);
		    reset.addActionListener(this);
		     
		    
		setLayout(new FlowLayout());

		// components added to the panel
		add(firstName);
		add(secondName);
		add(occupation);
		add(City);
		add(entryLoad);
		add(reset);
		add(viewText);
		add(clear);
		
	}
	/*
	 *    ***   IMPORTAND  ***
	 *    Before attempt to communicate with another class component 
	 *    must create connection like set methods below
	 */
	
	
	public void setTextPanel(TextPanel textP){
		this.textPanel = textP;
		
	}

	public void actionPerformed(ActionEvent event) {
		
		JButton btnClicked = (JButton)event.getSource();
				
		if (btnClicked == entryLoad) {
			
			String fname = firstName.getText();
			String sname = secondName.getText();
			String occup = occupation.getText();
			String city  = City.getText();
			
			if((!fname.equals("") && !sname.equals(""))){
				
				CustomEntryEvent entryEvent = new CustomEntryEvent (this, fname, sname, occup, city);
				
				if(entryListener != null){
					entryListener.entryEventInitiated(entryEvent);
				}
				
			}else{
				// Instruct user to fill the data
				System.out.println("Fill all data");
			}			
		}else if (btnClicked == reset){			
			firstName.setText("");
			secondName.setText("");
			occupation.setText("");
			City.setText("");		
		}
	}
	public void setEntryListener(CustomEntryListener customEntryListener) {
		
		this.entryListener = customEntryListener;
	}
	
}















