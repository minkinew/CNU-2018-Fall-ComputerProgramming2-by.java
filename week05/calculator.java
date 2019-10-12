import java.awt.FlowLayout; //back�̶� ����ó��
import java.awt.GridLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class calculator extends JFrame {
	private JTextField text; // �ؽ�Ʈ ��ü����
	private JPanel p1, p2, p3; // �г� ��ü����
	private JButton bC, b7, b8, b9, bdivide, b4, b5, b6, bmul, b1, b2, b3, bminus, b0, bback, bequal, bplus; // ��ư ��ü����
	private String str = ""; // �ؽ�Ʈ �ʵ忡 ��µ� ��
	private String num1, num2; // ù����, �ι��� ����
	private String cal; // ������ ���� ����
	private double result; // ������ ����

	public calculator() {
		p1 = new JPanel(); // p1 ��ü����
		p2 = new JPanel(); // p2 ��ü����
		p3 = new JPanel(); // p3 ��ü����

		text = new JTextField(25); // �ؽ�Ʈ ��ü����
		bC = new JButton("C"); // C��ư ����
		bC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(""); // �ؽ�Ʈ �ʵ忡 ��µ� ���� �ʱ�ȭ
				str = "";
			}
		});
		bback = new JButton("back"); // back��ư ����
		bback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 
					text.setText("");
					str = "";
				
			}
		});
		bplus = new JButton("+"); // '+' ��ư ����
		bplus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num1 = text.getText().toString(); // ù��° �Էµ� ���ڸ� �ؽ�Ʈ �ʵ忡 ������
				text.setText("");
				str = "";
				cal = "+"; // +������ ����
			}
		});
		bminus = new JButton("-"); // '-' ��ư ����
		bminus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num1 = text.getText().toString(); // ù��° �Էµ� ���ڸ� �ؽ�Ʈ �ʵ忡 ������
				text.setText("");
				str = "";
				cal = "-"; // -������ ����
			}
		});
		bmul = new JButton("*"); // '*' ��ư ����
		bmul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num1 = text.getText().toString(); // ù��° �Էµ� ���ڸ� �ؽ�Ʈ �ʵ忡 ������
				text.setText("");
				str = "";
				cal = "*"; // *������ ����
			}
		});
		bdivide = new JButton("/"); // '/' ��ư ����
		bdivide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num1 = text.getText().toString(); // ù��° �Էµ� ���ڸ� �ؽ�Ʈ �ʵ忡 ������
				text.setText("");
				str = "";
				cal = "/"; // '/' ������ ����
			}
		});
		bequal = new JButton("="); // '=' ��ư ����
		bequal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num2 = text.getText().toString(); // �ι��� ���� ����
				switch (cal) {
				case "+":
					result = Integer.parseInt(num1) + Integer.parseInt(num2);
					text.setText(result + ""); // ������� ���
					break;
				case "-":
					result = Integer.parseInt(num1) - Integer.parseInt(num2);
					text.setText(result + ""); // ������� ���
					break;
				case "*":
					result = Integer.parseInt(num1) * Integer.parseInt(num2);
					text.setText(result + ""); // ������� ���
					break;
				case "/":
					try {
						result = Integer.parseInt(num1) / Integer.parseInt(num2);
						text.setText(result + ""); // ��������� ���
					} catch (Exception ex) {
						text.setText("error");
					}
					break;
				default:
					break;
				}
				str = "";
			}
		});
		b0 = new JButton("0"); // '0' ��ư ����
		b0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "0"; // 0�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});
		b1 = new JButton("1"); // '1' ��ư ����
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "1"; // 0�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});
		b2 = new JButton("2"); // '2' ��ư ����
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "2"; // 0�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});
		b3 = new JButton("3"); // '3' ��ư ����
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "3"; // 3�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});
		b4 = new JButton("4"); // '4' ��ư ����
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "4"; // 4�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});
		b5 = new JButton("5"); // '5' ��ư ����
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "5"; // 5�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});
		b6 = new JButton("6"); // '6' ��ư ����
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "6"; // 0�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});
		b7 = new JButton("7"); // '0' ��ư ����
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "7"; // 7�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});
		b8 = new JButton("8"); // '8' ��ư ����
		b8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "8"; // 8�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});
		b9 = new JButton("9"); // '0' ��ư ����
		b9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "9"; // 9�� �ؽ�Ʈ �ʵ忡 ���
				text.setText(str);
			}
		});

		// �ؽ�Ʈ�ʵ� �߰�
		p1.add(text);

		// ��ư �߰�
		p2.add(bC);
		p3.add(b7);
		p3.add(b8);
		p3.add(b9);
		p3.add(bdivide);
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);
		p3.add(bmul);
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(bminus);
		p3.add(b0);
		p3.add(bback);
		p3.add(bequal);
		p3.add(bplus);

		add(p1); // p1�г��� �����ӿ� �߰�
		add(p2); // p2�г��� �����ӿ� �߰�
		add(p3); // p3�г��� �����ӿ� �߰�
		p1.setLayout(new GridLayout(1, 1, 5, 5));
		p2.setLayout(new GridLayout(1, 1, 5, 5));
		p3.setLayout(new GridLayout(4, 4, 5, 5));

		setTitle("����");
		setSize(305, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new calculator();
	}

}
