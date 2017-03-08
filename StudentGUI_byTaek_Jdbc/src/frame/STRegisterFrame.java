package frame;

import java.awt.Button;

import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;

import domain.STudent;

import frame.util.JdbcUtils;
import frame.util.ConnectionFactory;

class STRegisterFrame extends JFrame implements ActionListener {

	private Label lblName, lblShoolNum, lblKor, lblEng, lblMath;
	private TextField txtName, txtShoolNum, txtKor, txtEng, txtMath;
	private Button btnSubmit, btnCancel;
	private STudent std;
	private STMainFrame main;
	private ConnectionFactory factory;

	public STRegisterFrame(String title) {
		super(title);
		main = new STMainFrame("등록");
		factory = ConnectionFactory.getInstance();

		setLayout(null);

		lblName = new Label("이름 :");
		lblShoolNum = new Label("학번 :");
		lblKor = new Label("국어 :");
		lblEng = new Label("영어 :");
		lblMath = new Label("수학 :");

		lblName.setBounds(20, 50, 100, 20);
		lblShoolNum.setBounds(20, 80, 100, 20);
		lblKor.setBounds(20, 110, 100, 20);
		lblEng.setBounds(20, 140, 100, 20);
		lblMath.setBounds(20, 170, 100, 20);

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
		btnSubmit = new Button("등록");
		btnCancel.setSize(30, 20);
		btnSubmit.setSize(30, 20);

		txtName.setBounds(120, 50, 150, 20);
		txtShoolNum.setBounds(120, 80, 150, 20);
		txtKor.setBounds(120, 110, 150, 20);
		txtEng.setBounds(120, 140, 150, 20);
		txtMath.setBounds(120, 170, 150, 20);

		Panel paButton = new Panel();

		paButton.add(btnSubmit);
		paButton.add(btnCancel);
		paButton.setBounds(100, 230, 200, 200);
		add(txtName);
		add(txtShoolNum);
		add(txtKor);
		add(txtEng);
		add(txtMath);
		add(paButton);

		btnSubmit.addActionListener(this);
		btnCancel.addActionListener(this);

	}

	public void clean() {

		txtName.setText("");
		txtShoolNum.setText("");
		txtKor.setText("");
		txtEng.setText("");
		txtMath.setText("");

	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		switch (s) {
		case "등록":	
			std = new STudent();
			std.setName(txtName.getText());
			std.setShoolNumber(txtShoolNum.getText());
			std.setKor(Integer.parseInt(txtKor.getText()));
			std.setEng(Integer.parseInt(txtEng.getText()));
			std.setMath(Integer.parseInt(txtMath.getText()));
			
			insert(std);
			clean();

			break;
		case "취소":
			System.out.println("취소");
			this.setVisible(false);
			break;
		}
	}

	public void initalization() {
		this.setLocation(400, 350);
		this.setSize(370, 370);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void insert(STudent st) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("insert into student_tb values(?,?,?,?,?)");
			pstmt.setString(1, st.getShoolNumber());
			pstmt.setString(2, st.getName());
			pstmt.setInt(3, st.getKor());
			pstmt.setInt(4, st.getEng());
			pstmt.setInt(5, st.getMath());
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			JdbcUtils.closeResource(conn, pstmt);// 가변 파라미터
		}

	}

}
