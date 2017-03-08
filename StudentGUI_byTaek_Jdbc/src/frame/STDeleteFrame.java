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

import javax.swing.JFrame;


import domain.STudent;
import frame.util.ConnectionFactory;
import frame.util.JdbcUtils;

public class STDeleteFrame extends JFrame implements ActionListener {

	private Label lblShoolNum;
	private TextField txtShoolNum;
	private Button btnSearch, btnDelete, btnCancel;
	private TextArea txtArea;
	private STMainFrame main;
	private ArrayList<STudent> stds;
	private String search;

	private ConnectionFactory factory;

	public STDeleteFrame(String title) {
		super(title);
		setLayout(null);

		lblShoolNum = new Label("학번 :");
		txtShoolNum = new TextField(20);
		btnSearch = new Button("검색");
		btnDelete = new Button("삭제");
		btnCancel = new Button("취소");
		txtArea = new TextArea();
		main = new STMainFrame("삭제");
		stds = new ArrayList<>();

		factory = ConnectionFactory.getInstance();

		lblShoolNum.setBounds(50, 30, 30, 20);
		txtShoolNum.setBounds(80, 30, 150, 20);
		btnSearch.setBounds(270, 30, 50, 20);
		this.add(lblShoolNum);
		this.add(txtShoolNum);
		this.add(btnSearch);

		txtArea.setRows(5);
		txtArea.setColumns(15);
		// txtArea.setBorder(BorderFactory.createLoweredBevelBorder());
		txtArea.setBounds(50, 50, 300, 130);
		this.add(txtArea);

		btnDelete.setBounds(120, 250, 60, 40);
		btnCancel.setBounds(220, 250, 60, 40);
		this.add(btnDelete);
		this.add(btnCancel);

		btnDelete.addActionListener(this);
		btnCancel.addActionListener(this);
		btnSearch.addActionListener(this);

	}

	public void delete(String shoolnum) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertCount = 0;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("delete from student_tb where shoolnum = ? ");
			pstmt.setString(1, shoolnum);
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			JdbcUtils.closeResource(conn, pstmt);// 가변 파라미터
		}
	}

	public void print() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.createConnection();

			pstmt = conn.prepareStatement("select shoolnum, name, korea, english, math from student_tb where shoolnum = ?   ");
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				STudent std = new STudent();
				std.setShoolNumber((rs.getString("shoolNum")));
				std.setName((rs.getString("name")));
				std.setKor((rs.getInt("korea")));
				std.setEng((rs.getInt("english")));
				std.setMath((rs.getInt("math")));

				stds.add(std);
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		
		for(STudent s :stds){
			txtArea.append(s.toString());
		}

		
	}

	public void initalization() {
		this.setLocation(500, 600);
		this.setSize(370, 370);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();

		switch (s) {

		case "검색":
			search = txtShoolNum.getText();
			print();
			break;

		case "삭제":
			delete(search);
			break;

		case "취소":
			this.setVisible(false);
			break;

		}

	}
}
