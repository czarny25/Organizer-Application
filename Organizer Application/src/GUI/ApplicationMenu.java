package GUI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ApplicationMenu extends JMenuBar{

	
	public ApplicationMenu(){
		
		// 1 item
		JMenu mnFile = new JMenu("File");
		add(mnFile);
				
			JMenuItem mntmNew = new JMenuItem("New");
			mnFile.add(mntmNew);
					
			JMenuItem mntmOpen = new JMenuItem("Open...");
			mnFile.add(mntmOpen);
			
			JMenuItem mntmSave = new JMenuItem("Save");
			mnFile.add(mntmSave);
	
			JMenuItem mntmSaveAs = new JMenuItem("SaveAs");
			mnFile.add(mntmSaveAs);
	
		// 4 item
		JMenu mnView = new JMenu("View");
		add(mnView);
			
			
	    // 5 item
		JMenu mnHelp = new JMenu("Help");
		add(mnHelp);
	
	
	}
}
