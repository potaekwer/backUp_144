package manes;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class STMenuebar extends JMenuBar{

	
	
	private STFileMenu fileMenu;
	private STEditMenu editMenu;
	
	
	public STMenuebar(){
		
		fileMenu = new STFileMenu("����");
		editMenu = new STEditMenu("����");
		
		this.add(fileMenu);
		this.add(editMenu);
		
		
		
	}
}
