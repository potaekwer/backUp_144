package manes;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.STConstants.EEditMenuItems;

public class STEditMenu extends JMenu{

	
	private JMenuItem copy;
	private JMenuItem cut;
	private JMenuItem delete;
	private JMenuItem paste;
	private JMenuItem group;
	private JMenuItem deleteGroup;

	public STEditMenu(String title) {
		super(title);

		for (EEditMenuItems e : EEditMenuItems.values()) {
			JMenuItem item = new JMenuItem(e.name());
			this.add(item);

		}
	}
}
