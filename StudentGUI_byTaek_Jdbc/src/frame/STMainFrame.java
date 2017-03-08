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

		register = new JButton("�л� ���");
		search = new JButton("�л� �˻�");
		motify = new JButton("�л� ����");
		print = new JButton("�л� ���");
		delete = new JButton("�л� ����");

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

		cc.gridx = x; // ������ġ x
		cc.gridy = y; // ������ġ y
		cc.gridwidth = width; // �����̳� �ʺ�
		cc.gridheight = height; // �����̳� ����
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

		case "�л� ���":
			
			STR = new STRegisterFrame("���");
			STR.initalization();
			break;
		case "�л� �˻�":
			STS = new STSearchFrame("�˻�");
			STS.initalization();

			break;
		case "�л� ����":
			STM = new STMotifyFrame("����");
			STM.initalization();

			break;
		case "�л� ���":

			STP = new STPrintFrame("���");
			STP.initalization();

			break;
		case "�л� ����":
			STD = new STDeleteFrame("����");
			STD.initalization();
			break;

		}

	}

	

	

	

}
