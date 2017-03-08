package frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.STConstants;

import domain.STudent;
import frame.util.ConnectionFactory;
import manes.STMenuebar;
import frame.util.JdbcUtils;

public class STMainFrame extends JFrame implements ActionListener {

	private JPanel panel;
	private STMenuebar menuber;
	private JButton register, search, motify, print, delete;
	private GridBagConstraints cc;
	private Container ct;
	private STSearchFrame STS;
	private STRegisterFrame STR;
	private STMotifyFrame STM;
	private STDeleteFrame STD;
	private STPrintFrame STP;
	private ArrayList<STudent> stds;
	private STudent std;
	private ConnectionFactory factory;
	private JdbcUtils JdbcUtils;

	public STMainFrame(String title) {
		super(title);

		stds = new ArrayList<STudent>();
		panel = new JPanel();
		ct = getContentPane();
		ct.setLayout(new BorderLayout(5, 5));
		ct.add(panel, BorderLayout.CENTER);
	
		this.add(panel);
		menuber = new STMenuebar();
		this.setJMenuBar(menuber);

		GridBagLayout gridbag = new GridBagLayout();
		cc = new GridBagConstraints();
		cc.weightx = 3.0;
		cc.weighty = 2.0;
		cc.fill = GridBagConstraints.CENTER;

		register = new JButton("학생 등록");
		search = new JButton("학생 검색");
		motify = new JButton("학생 수정");
		print = new JButton("학생 출력");
		delete = new JButton("학생 삭제");

		panel.setLayout(gridbag);

		layout(register, 3, 0, 1, 1);
		layout(search, 3, 1, 1, 1);
		layout(motify, 3, 2, 1, 1);
		layout(print, 3, 3, 1, 1);
		layout(delete, 3, 4, 1, 1);

		register.addActionListener(this);
		search.addActionListener(this);
		motify.addActionListener(this);
		print.addActionListener(this);
		delete.addActionListener(this);

	}

	private void layout(Component obj, int x, int y, int width, int height) {

		cc.gridx = x; // 시작위치 x
		cc.gridy = y; // 시작위치 y
		cc.gridwidth = width; // 컨테이너 너비
		cc.gridheight = height; // 컨테이너 높이
		panel.add(obj, cc);
	}

	public void initalization() {
		this.setLocation(300, 350);
		this.setSize(STConstants.MAINframe_width, STConstants.MAINframe_height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		String s = e.getActionCommand();

		switch (s) {

		case "학생 등록":
			
			STR = new STRegisterFrame("등록");
			STR.initalization();
			break;
		case "학생 검색":
			STS = new STSearchFrame("검색");
			STS.initalization();

			break;
		case "학생 수정":
			STM = new STMotifyFrame("수정");
			STM.initalization();

			break;
		case "학생 출력":

			STP = new STPrintFrame("출력");
			STP.initalization();

			break;
		case "학생 삭제":
			STD = new STDeleteFrame("삭제");
			STD.initalization();
			break;

		}

	}

	

	

	

}
