import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

public class CalculatorDemo extends JFrame implements ActionListener {
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JButton bpm, bdot, bp, bm, bmulti, bd, bsqrt, bpercent, bx, bequal;
	private JButton bback, bc;
	private JTextField jtf;
	// 계산기에서 사용할 버튼과 텍스트 필드 객체 선언
	private String operand, operator;
	// 첫번째 오퍼란드 값을 저장할 operand와 오퍼레이터를 저장할 operator 선언
	GridBagConstraints cc;
	Container ct;
	JPanel jp1;

	public CalculatorDemo() {
		GridBagLayout gridbag = new GridBagLayout();
		cc = new GridBagConstraints();
		cc.weightx = 1.0;
		cc.weighty = 1.0;
		cc.fill = GridBagConstraints.BOTH;
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bpm = new JButton("+/-");
		bdot = new JButton(".");
		bp = new JButton("+");
		bm = new JButton("-");
		bmulti = new JButton("*");
		bd = new JButton("/");
		bsqrt = new JButton("sqrt");
		bpercent = new JButton("%");
		bequal = new JButton("=");
		// 모든 버튼 객체 생성
		jp1 = new JPanel();
		jp1.setLayout(gridbag);
		// 판넬 객체를 생성하고 레이아웃을 4행5열로 설정
		layout(b7, 0, 0, 1, 1);
		layout(b8, 1, 0, 1, 1);
		layout(b9, 2, 0, 1, 1);
		layout(bd, 3, 0, 1, 1);
		layout(bsqrt, 4, 0, 1, 1);
		layout(b4, 0, 1, 1, 1);
		layout(b5, 1, 1, 1, 1);
		layout(b6, 2, 1, 1, 1);
		layout(bmulti, 3, 1, 1, 1);
		layout(bpercent, 4, 1, 1, 1);
		layout(b1, 0, 2, 1, 1);
		layout(b2, 1, 2, 1, 1);
		layout(b3, 2, 2, 1, 1);
		layout(bm, 3, 2, 1, 1);
		layout(bp, 4, 2, 1, 2); // "+" 부분
		layout(b0, 0, 3, 1, 1);
		layout(bpm, 1, 3, 1, 1);
		layout(bdot, 2, 3, 1, 1);
		layout(bequal, 3, 3, 1, 1);
		jp1.setBorder(new TitledBorder("계산기 입력 버튼"));
		// 판넬을 표시하는 타이틀 경계선을 설정
		bback = new JButton("Backspace");
		bc = new JButton("C");
		// 두개의 버튼 객체 생성
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1, 2, 5, 5));
		jp2.add(bback);
		jp2.add(bc);
		jp2.setBorder(new TitledBorder("지우기 버튼"));
		// 판넬을 생성하고 레이아웃 설정, 객체 추가, 경계선 설정
		JPanel jp3 = new JPanel();
		jtf = new JTextField();
		// 텍스트필드 객체 생성
		jp3.setLayout(new GridLayout(1, 1, 5, 5));
		jp3.add(jtf);
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		// 텍스트 필드의 정렬을 오른쪽으로 설정
		jtf.setEditable(false);
		// 텍스트 필드 직접 조작 금지 설정
		jp3.setBorder(new TitledBorder("계산 결과 창"));
		// 경계선 설정
		ct = getContentPane();
		ct.setLayout(new BorderLayout(5, 5));
		ct.add(jp3, BorderLayout.NORTH);
		ct.add(jp2, BorderLayout.CENTER);
		ct.add(jp1, BorderLayout.SOUTH);
		// 프레임에 판넬 3개 추가
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bpm.addActionListener(this);
		bdot.addActionListener(this);
		bp.addActionListener(this);
		bm.addActionListener(this);
		bmulti.addActionListener(this);
		bd.addActionListener(this);
		bsqrt.addActionListener(this);
		bpercent.addActionListener(this);
		bequal.addActionListener(this);
		bback.addActionListener(this);
		bc.addActionListener(this);
		// 모든 버튼에 리스너 등록
	}

	public void layout(Component obj, int x, int y, int width, int height) {
		cc.gridx = x; // 시작위치 x
		cc.gridy = y; // 시작위치 y
		cc.gridwidth = width; // 컨테이너 너비
		cc.gridheight = height; // 컨테이너 높이
		jp1.add(obj, cc);
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		// 이벤트를 발생시킨 객체를 문자열 객체 s에 저장
		String jtfs = jtf.getText();
		// 이벤트 발생 당시의 텍스트 필드 내용을 문자열 jtfs에 저장
		if (s == "0" || s == "1" || s == "2" || s == "3" || s == "4" || s == "5" || s == "6" || s == "7" || s == "8"
				|| s == "9" || s == ".") {
			jtf.setText(jtfs + s);
		} // 숫자나 dot이면 문자열 뒤에 붙인다
		if (s == "+" || s == "-" || s == "*" || s == "/") {
			operand = jtfs;
			operator = s;
			jtf.setText("");
		} // 사칙연산이면 현재의 텍스트필드 값과 연산자를 operand와 operator 객체에 저장
		if (s == "C") {
			jtf.setText("");
		} // "C"이면 텍스트 필드의 내용을 지운다
		if (s == "Backspace") {
			String temp = jtf.getText();
			temp = temp.substring(0, temp.length() - 1);
			jtf.setText(temp);
		} // Backspace이면 문자열의 마지막 글자를 제외하고 다시 나타낸다
		double result;
		if (s == "%") {
			result = Double.parseDouble(operand) * Double.parseDouble(jtfs) / 100.0;
			jtf.setText("" + result);
		} // 두수의 곱을 100으로 나눈 값(퍼센트)를 구하여 나타낸다
		if (s == "sqrt") {
			result = Math.sqrt(Double.parseDouble(jtfs));
			jtf.setText("" + result);
		} // 루트값을 나타낸다
		if (s == "1/x") {
			result = 1 / (Double.parseDouble(jtfs));
			jtf.setText("" + result);
		} // 역수값을 나타낸다
		if (s == "+/-") {
			result = -1 * (Double.parseDouble(jtfs));
			jtf.setText("" + result);
		} // 현재의 값에 -1을 곱하여 부호를 반전시킨다
		if (s == "=") {
			char c = operator.charAt(0);
			switch (c) {
			case '+':
				result = Double.parseDouble(operand) + Double.parseDouble(jtfs);
				jtf.setText("" + result);
				break;
			case '-':
				result = Double.parseDouble(operand) - Double.parseDouble(jtfs);
				jtf.setText("" + result);
				break;
			case '*':
				result = Double.parseDouble(operand) * Double.parseDouble(jtfs);
				jtf.setText("" + result);
				break;
			case '/':
				result = Double.parseDouble(operand) / Double.parseDouble(jtfs);
				jtf.setText("" + result);
				break;
			} // "="일 경우 해당되는 연산자를 구분하여 해당 연산결과를 나타낸다
		}
	}

	public static void main(String[] args) {
		CalculatorDemo ccc = new CalculatorDemo();
		ccc.setTitle("Calculator");
		ccc.setSize(350, 300);
		ccc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ccc.setVisible(true);
	}
}
