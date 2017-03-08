package frame;

import java.awt.Button;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import domain.STudent;
import frame.util.JdbcUtils;
import frame.util.ConnectionFactory;

public class STSearchFrame extends JFrame implements ActionListener {

	private Label lblShoolNum;
	private TextField txtShoolNum;
	private Button bntSearch;
	private List printList;
	private TextArea txtArea;
	private STMainFrame main;
	private String search;
	private ArrayList<STudent> stds;
	private ConnectionFactory factory;
	
	
	public STSearchFrame(String title) {
		super(title);
		setLayout(null);

		factory = ConnectionFactory.getInstance();
		lblShoolNum = new Label("학번 :");
		txtShoolNum = new TextField(20);
		bntSearch = new Button("검색");
		txtArea = new TextArea();
		main = new STMainFrame("출력");

		lblShoolNum.setBounds(40, 30, 30, 20);
		txtShoolNum.setBounds(80, 30, 150, 20);
		bntSearch.setBounds(230, 30, 120, 20);
		this.add(lblShoolNum);
		this.add(txtShoolNum);
		this.add(bntSearch);

		txtArea.setRows(5);
		txtArea.setColumns(15);
		// txtArea.setBorder(BorderFactory.createLoweredBevelBorder());
		txtArea.setBounds(50, 50, 300, 250);
		this.add(txtArea);

		bntSearch.addActionListener(this);
		
	
	}

	
	public void clean(){
		txtShoolNum.setText("");
	}
	
	public void print(String search) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.createConnection();

			pstmt = conn.prepareStatement("select shoolNum, name, korea, english, math from student_tb where shoolnum = ? ");
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				STudent std = new STudent();
				std.setShoolNumber((rs.getString("shoolNum")));
				std.setName((rs.getString("name")));
				std.setKor((rs.getInt("korea")));
				std.setEng((rs.getInt("english")));
				std.setMath((rs.getInt("math")));
				txtArea.append(std.toString()+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
	}


		
	public void initalization() {
		this.setLocation(500, 600);
		this.setSize(370, 370);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String s = e.getActionCommand();

		switch (s) {

		case "검색":			
			search = txtShoolNum.getText();
			print(search);
			break;

		}

	}

}
