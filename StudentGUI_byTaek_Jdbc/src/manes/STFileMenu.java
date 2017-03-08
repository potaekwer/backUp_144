package manes;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.STConstants.EEditMenuItems;
import constants.STConstants.EFileMenuItems;

public class STFileMenu extends JMenu{

	
	private JMenuItem newFIle;
	private JMenuItem openFile;
	private JMenuItem save;
	private JMenuItem anotherSave;
	private JMenuItem close;
	
	
	public STFileMenu(String title){
		super(title);
		
		for(EEditMenuItems e : EEditMenuItems.values()){
			JMenuItem item = new JMenuItem(e.name());
			this.add(item);
		}
		
	}
	
}
