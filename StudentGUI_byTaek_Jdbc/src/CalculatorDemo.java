import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

public class CalculatorDemo extends JFrame implements ActionListener {
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JButton bpm, bdot, bp, bm, bmulti, bd, bsqrt, bpercent, bx, bequal;
	private JButton bback, bc;
	private JTextField jtf;
	// ���⿡�� ����� ��ư�� �ؽ�Ʈ �ʵ� ��ü ����
	private String operand, operator;
	// ù��° ���۶��� ���� ������ operand�� ���۷����͸� ������ operator ����
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
		// ��� ��ư ��ü ����
		jp1 = new JPanel();
		jp1.setLayout(gridbag);
		// �ǳ� ��ü�� �����ϰ� ���̾ƿ��� 4��5���� ����
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
		layout(bp, 4, 2, 1, 2); // "+" �κ�
		layout(b0, 0, 3, 1, 1);
		layout(bpm, 1, 3, 1, 1);
		layout(bdot, 2, 3, 1, 1);
		layout(bequal, 3, 3, 1, 1);
		jp1.setBorder(new TitledBorder("���� �Է� ��ư"));
		// �ǳ��� ǥ���ϴ� Ÿ��Ʋ ��輱�� ����
		bback = new JButton("Backspace");
		bc = new JButton("C");
		// �ΰ��� ��ư ��ü ����
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1, 2, 5, 5));
		jp2.add(bback);
		jp2.add(bc);
		jp2.setBorder(new TitledBorder("����� ��ư"));
		// �ǳ��� �����ϰ� ���̾ƿ� ����, ��ü �߰�, ��輱 ����
		JPanel jp3 = new JPanel();
		jtf = new JTextField();
		// �ؽ�Ʈ�ʵ� ��ü ����
		jp3.setLayout(new GridLayout(1, 1, 5, 5));
		jp3.add(jtf);
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		// �ؽ�Ʈ �ʵ��� ������ ���������� ����
		jtf.setEditable(false);
		// �ؽ�Ʈ �ʵ� ���� ���� ���� ����
		jp3.setBorder(new TitledBorder("��� ��� â"));
		// ��輱 ����
		ct = getContentPane();
		ct.setLayout(new BorderLayout(5, 5));
		ct.add(jp3, BorderLayout.NORTH);
		ct.add(jp2, BorderLayout.CENTER);
		ct.add(jp1, BorderLayout.SOUTH);
		// �����ӿ� �ǳ� 3�� �߰�
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
		// ��� ��ư�� ������ ���
	}

	public void layout(Component obj, int x, int y, int width, int height) {
		cc.gridx = x; // ������ġ x
		cc.gridy = y; // ������ġ y
		cc.gridwidth = width; // �����̳� �ʺ�
		cc.gridheight = height; // �����̳� ����
		jp1.add(obj, cc);
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		// �̺�Ʈ�� �߻���Ų ��ü�� ���ڿ� ��ü s�� ����
		String jtfs = jtf.getText();
		// �̺�Ʈ �߻� ����� �ؽ�Ʈ �ʵ� ������ ���ڿ� jtfs�� ����
		if (s == "0" || s == "1" || s == "2" || s == "3" || s == "4" || s == "5" || s == "6" || s == "7" || s == "8"
				|| s == "9" || s == ".") {
			jtf.setText(jtfs + s);
		} // ���ڳ� dot�̸� ���ڿ� �ڿ� ���δ�
		if (s == "+" || s == "-" || s == "*" || s == "/") {
			operand = jtfs;
			operator = s;
			jtf.setText("");
		} // ��Ģ�����̸� ������ �ؽ�Ʈ�ʵ� ���� �����ڸ� operand�� operator ��ü�� ����
		if (s == "C") {
			jtf.setText("");
		} // "C"�̸� �ؽ�Ʈ �ʵ��� ������ �����
		if (s == "Backspace") {
			String temp = jtf.getText();
			temp = temp.substring(0, temp.length() - 1);
			jtf.setText(temp);
		} // Backspace�̸� ���ڿ��� ������ ���ڸ� �����ϰ� �ٽ� ��Ÿ����
		double result;
		if (s == "%") {
			result = Double.parseDouble(operand) * Double.parseDouble(jtfs) / 100.0;
			jtf.setText("" + result);
		} // �μ��� ���� 100���� ���� ��(�ۼ�Ʈ)�� ���Ͽ� ��Ÿ����
		if (s == "sqrt") {
			result = Math.sqrt(Double.parseDouble(jtfs));
			jtf.setText("" + result);
		} // ��Ʈ���� ��Ÿ����
		if (s == "1/x") {
			result = 1 / (Double.parseDouble(jtfs));
			jtf.setText("" + result);
		} // �������� ��Ÿ����
		if (s == "+/-") {
			result = -1 * (Double.parseDouble(jtfs));
			jtf.setText("" + result);
		} // ������ ���� -1�� ���Ͽ� ��ȣ�� ������Ų��
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
			} // "="�� ��� �ش�Ǵ� �����ڸ� �����Ͽ� �ش� �������� ��Ÿ����
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
