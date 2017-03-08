package frame;

import java.awt.Button;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;


import domain.STudent;
import frame.util.JdbcUtils;
import frame.util.ConnectionFactory;

public class STPrintFrame extends JFrame implements ActionListener {

	private ConnectionFactory factory;
	private Label lblShoolNum;
	private TextField txtShoolNum;
	private Button bntSearch, bntSetNum, bntSetScore;
	private List printList;
	private STMainFrame STM;
	private TextArea txtArea;
	private STMainFrame main;
	private String  search;
	private ArrayList<STudent> stds;

	public STPrintFrame(String title) {

		super(title);
		setLayout(null);

		factory = ConnectionFactory.getInstance();
		stds = new ArrayList<>();
		lblShoolNum = new Label("학번 :");
		txtShoolNum = new TextField(20);
		bntSearch = new Button("출력");
		bntSetNum = new Button("학번순 출력");
		bntSetScore = new Button("성적순 출력");
		search = new String();
		main = new STMainFrame("출력");

		lblShoolNum.setBounds(50, 190, 30, 20);
		txtShoolNum.setBounds(80, 190, 150, 20);
		bntSearch.setBounds(230, 190, 100, 20);
		bntSetNum.setBounds(50, 230, 100, 30);
		bntSetScore.setBounds(220, 230, 100, 30);
		this.add(lblShoolNum);
		this.add(txtShoolNum);
		this.add(bntSearch);
		this.add(bntSetScore);
		this.add(bntSetNum);

		txtArea = new TextArea();

		txtArea.setRows(5);
		txtArea.setColumns(15);
		// txtArea.setBorder(BorderFactory.createLoweredBevelBorder());
		txtArea.setBounds(30, 30, 300, 150);
		this.add(txtArea);

		bntSearch.addActionListener(this);
		bntSetScore.addActionListener(this);
		bntSetNum.addActionListener(this);

	}
	
	public void clean(){
		txtArea.setText("");
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		switch (s) {

		case "학번순 출력":
			clean();	
			selectByShoolnum();
					
			break;

		case "성적순 출력":
			clean();
			selectByScore();			
			break;

		case "출력":
		
			clean();
			search = txtShoolNum.getText();
			selectbySearch(search);
			
			
			
			
			break;

		}

	}
	
	public void selectByShoolnum() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.createConnection();

			pstmt = conn.prepareStatement("select shoolNum, name, korea, english, math from student_tb order by shoolnum ");
			
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
	public void selectByScore(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.createConnection();

			pstmt = conn.prepareStatement("select shoolNum, name, korea, english, math from student_tb order by  math+KOREA+ENGLISH DESC ");
			
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
	
	public void selectbySearch(String search){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.createConnection();

			pstmt = conn.prepareStatement("select shoolNum, name, korea, english, math from student_tb where shoolnum = ?");
			pstmt.setString(1,search);
			rs = pstmt.executeQuery();

			if(rs.next()) {
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

}
