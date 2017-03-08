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

import javax.swing.JFrame;

import domain.STudent;
import frame.util.ConnectionFactory;
import frame.util.JdbcUtils;

public class STMotifyFrame extends JFrame implements ActionListener {

	private TextField txtShoolNum;
	private Label lblName, lblSearchNum, lblShoolNum, lblKor, lblEng, lblMath;
	private TextField txtName, txtSearchNum, txtKor, txtEng, txtMath;
	private Button btnSubmit, btnSearch, btnCancel;
	private STudent std;
	private STMainFrame main;
	private TextArea txtArea;
	private String search;
	private ArrayList<STudent> stds;
	private ConnectionFactory factory;
	
	

	public STMotifyFrame(String title) {
		super(title);
		setLayout(null);

		factory = ConnectionFactory.getInstance();
		main = new STMainFrame("수정");
		lblSearchNum = new Label("수정학생학번  :");
		txtSearchNum = new TextField(20);
		btnSearch = new Button("검색");
		txtArea = new TextArea();
		lblName = new Label("이름 :");
		lblShoolNum = new Label("학번 :");
		lblKor = new Label("국어 :");
		lblEng = new Label("영어 :");
		lblMath = new Label("수학 :");

		lblSearchNum.setBounds(0, 30, 90, 20);
		txtSearchNum.setBounds(90, 30, 150, 20);
		btnSearch.setBounds(240, 30, 110, 20);
		this.add(lblSearchNum);
		this.add(txtSearchNum);
		this.add(btnSearch);

		txtArea.setRows(5);
		txtArea.setColumns(15);
		txtArea.setBounds(20, 50, 350, 150);
		this.add(txtArea);

		lblName.setBounds(0, 230, 50, 20);
		lblShoolNum.setBounds(180, 230, 50, 20);
		lblKor.setBounds(0, 260, 50, 20);
		lblEng.setBounds(0, 290, 50, 20);
		lblMath.setBounds(0, 320, 50, 20);

		this.add(lblName);
		this.add(lblShoolNum);
		this.add(lblKor);
		this.add(lblEng);
		this.add(lblMath);

		txtName = new TextField(20);
		txtShoolNum = new TextField(20);
		txtKor = new TextField(20);
		txtEng = new TextField(20);
		txtMath = new TextField(20);

		btnCancel = new Button("취소");
		btnSubmit = new Button("수정");
		btnCancel.setSize(60, 40);
		btnSubmit.setSize(60, 40);

		txtName.setBounds(50, 230, 120, 20);
		txtShoolNum.setBounds(230, 230, 150, 20);
		txtKor.setBounds(50, 260, 120, 20);
		txtEng.setBounds(50, 290, 120, 20);
		txtMath.setBounds(50, 320, 120, 20);

		btnSubmit.setBounds(120, 400, 60, 40);
		btnCancel.setBounds(220, 400, 60, 40);

		add(txtName);
		add(txtShoolNum);
		add(txtKor);
		add(txtEng);
		add(txtMath);
		add(btnSubmit);
		add(btnCancel);

		btnSubmit.addActionListener(this);
		btnCancel.addActionListener(this);
		btnSearch.addActionListener(this);
		
		
		
		
	}

	public void initalization() {
		this.setLocation(600, 600);
		this.setSize(370, 500);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void print(String search){
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
	
	
	
	public void motify() {	
		
		std = new STudent();		
		std.setName(txtName.getText());
		std.setShoolNumber(txtShoolNum.getText());
		std.setKor(Integer.parseInt(txtKor.getText()));
		std.setEng(Integer.parseInt(txtEng.getText()));
		std.setMath(Integer.parseInt(txtMath.getText()));
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("update STUDENT_TB set NAME = ?,ENGLISH =?, KOREA = ?, MATH =? where shoolnum = ?");
			pstmt.setString(1, std.getName());
			pstmt.setInt(2, std.getKor());
			pstmt.setInt(3, std.getEng());
			pstmt.setInt(4, std.getMath());
			pstmt.setString(5, std.getShoolNumber());
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			JdbcUtils.closeResource(conn, pstmt);// 가변 파라미터
		}
		
		txtArea.setText("수정되었습니다.\n");

		
	}

	public void clean(){
		txtShoolNum.setText("");
		txtName.setText("");
		txtKor.setText("");
		txtEng.setText("");
		txtMath.setText("");
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		switch (s) {
		case "수정":			
			motify();
			clean();
			break;

		case "검색":
			search = txtSearchNum.getText();
			txtShoolNum.setText(search);
			print(search);				
			break;

		case "취소":
			this.setVisible(false);
			break;

		}

	}

}
