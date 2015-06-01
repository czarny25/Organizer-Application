package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 *  This class along with 
 *  	 
 *  	TextPanel class
 *  	EntryPanel class 
 *  
 *   create an example of how to communicate between custom components
 */

public class MainFrame extends JFrame{


	EntryPanel entryPanel;
	TextPanel textPanel;	
	JButton btnLoad;
	CustomEntryEvent entryEvent;
	ApplicationInfo marcinInfo;
	
	public MainFrame() throws HeadlessException {
		
		setTitle("Text area presentation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(700, 900));
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		

		entryPanel = new EntryPanel();
		textPanel = new TextPanel();
		btnLoad = new JButton("Load text");
		marcinInfo = new ApplicationInfo();
		
		entryPanel.setTextPanel(textPanel);
		
		add(entryPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
		add(setFooter(), BorderLayout.SOUTH);
		
		
		setJMenuBar(new ApplicationMenu());
		
		
		entryPanel.setEntryListener(new CustomEntryListener(){
			
			public void entryEventInitiated(CustomEntryEvent ev){
				
				String firstName = ev.getFirstName();
				String secondName = ev.getSecondName();
				String occupation = ev.getOccupation();
				String City = ev.getCity();
				
				textPanel.appendText(firstName + " " + secondName + " " + occupation + " " + City + "\n" );
			} 
		});
		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("This is button from main\n");
			}
		});
		
		
	}
	
	

	private JPanel setFooter() {

		JPanel footer = new JPanel();
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.RIGHT);
		footer.setLayout(layout);
		
		final JButton exit = new JButton("Exit");
		final JButton about = new JButton("About");
		
		footer.add(about);
		footer.add(exit);
		
		final JButton actionTaken = new JButton();
		
		actionTaken.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
								
				if(actionTaken == exit){
					
					System.exit(0);
					
		  }else if(actionTaken == about){
			  
			  marcinInfo.setVisible(true);
		  
		  }else{
			  // do nothing
		  }
				
				
				
			}
		});
		
		
		
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		return footer;
		
	}


	
	
	
	
	

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	              
	        	  try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					  MainFrame frame = new MainFrame();
					  frame.setVisible(true);
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	              
	          }
	      });
		
	}
	
}
