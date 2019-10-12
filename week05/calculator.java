import java.awt.FlowLayout; //back이랑 예외처리
import java.awt.GridLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class calculator extends JFrame {
	private JTextField text; // 텍스트 객체변수
	private JPanel p1, p2, p3; // 패널 객체변수
	private JButton bC, b7, b8, b9, bdivide, b4, b5, b6, bmul, b1, b2, b3, bminus, b0, bback, bequal, bplus; // 버튼 객체변수
	private String str = ""; // 텍스트 필드에 출력될 값
	private String num1, num2; // 첫번쨰, 두번쨰 숫자
	private String cal; // 연산자 저장 변수
	private double result; // 연산결과 저장

	public calculator() {
		p1 = new JPanel(); // p1 객체생성
		p2 = new JPanel(); // p2 객체생성
		p3 = new JPanel(); // p3 객체생성

		text = new JTextField(25); // 텍스트 객체생성
		bC = new JButton("C"); // C버튼 생성
		bC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(""); // 텍스트 필드에 출력된 값을 초기화
				str = "";
			}
		});
		bback = new JButton("back"); // back버튼 생성
		bback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 
					text.setText("");
					str = "";
				
			}
		});
		bplus = new JButton("+"); // '+' 버튼 생성
		bplus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num1 = text.getText().toString(); // 첫번째 입력된 숫자를 텍스트 필드에 보여줌
				text.setText("");
				str = "";
				cal = "+"; // +연산자 저장
			}
		});
		bminus = new JButton("-"); // '-' 버튼 생성
		bminus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num1 = text.getText().toString(); // 첫번째 입력된 숫자를 텍스트 필드에 보여줌
				text.setText("");
				str = "";
				cal = "-"; // -연산자 저장
			}
		});
		bmul = new JButton("*"); // '*' 버튼 생성
		bmul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num1 = text.getText().toString(); // 첫번째 입력된 숫자를 텍스트 필드에 보여줌
				text.setText("");
				str = "";
				cal = "*"; // *연산자 저장
			}
		});
		bdivide = new JButton("/"); // '/' 버튼 생성
		bdivide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num1 = text.getText().toString(); // 첫번째 입력된 숫자를 텍스트 필드에 보여줌
				text.setText("");
				str = "";
				cal = "/"; // '/' 연산자 저장
			}
		});
		bequal = new JButton("="); // '=' 버튼 생성
		bequal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num2 = text.getText().toString(); // 두번쨰 숫자 저장
				switch (cal) {
				case "+":
					result = Integer.parseInt(num1) + Integer.parseInt(num2);
					text.setText(result + ""); // 덧셈결과 출력
					break;
				case "-":
					result = Integer.parseInt(num1) - Integer.parseInt(num2);
					text.setText(result + ""); // 뺄셈결과 출력
					break;
				case "*":
					result = Integer.parseInt(num1) * Integer.parseInt(num2);
					text.setText(result + ""); // 곱셈결과 출력
					break;
				case "/":
					try {
						result = Integer.parseInt(num1) / Integer.parseInt(num2);
						text.setText(result + ""); // 나눗셈결과 출력
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
		b0 = new JButton("0"); // '0' 버튼 생성
		b0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "0"; // 0이 텍스트 필드에 출력
				text.setText(str);
			}
		});
		b1 = new JButton("1"); // '1' 버튼 생성
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "1"; // 0이 텍스트 필드에 출력
				text.setText(str);
			}
		});
		b2 = new JButton("2"); // '2' 버튼 생성
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "2"; // 0이 텍스트 필드에 출력
				text.setText(str);
			}
		});
		b3 = new JButton("3"); // '3' 버튼 생성
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "3"; // 3이 텍스트 필드에 출력
				text.setText(str);
			}
		});
		b4 = new JButton("4"); // '4' 버튼 생성
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "4"; // 4이 텍스트 필드에 출력
				text.setText(str);
			}
		});
		b5 = new JButton("5"); // '5' 버튼 생성
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "5"; // 5이 텍스트 필드에 출력
				text.setText(str);
			}
		});
		b6 = new JButton("6"); // '6' 버튼 생성
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "6"; // 0이 텍스트 필드에 출력
				text.setText(str);
			}
		});
		b7 = new JButton("7"); // '0' 버튼 생성
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "7"; // 7이 텍스트 필드에 출력
				text.setText(str);
			}
		});
		b8 = new JButton("8"); // '8' 버튼 생성
		b8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "8"; // 8이 텍스트 필드에 출력
				text.setText(str);
			}
		});
		b9 = new JButton("9"); // '0' 버튼 생성
		b9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = str + "9"; // 9이 텍스트 필드에 출력
				text.setText(str);
			}
		});

		// 텍스트필드 추가
		p1.add(text);

		// 버튼 추가
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

		add(p1); // p1패널을 프레임에 추가
		add(p2); // p2패널을 프레임에 추가
		add(p3); // p3패널을 프레임에 추가
		p1.setLayout(new GridLayout(1, 1, 5, 5));
		p2.setLayout(new GridLayout(1, 1, 5, 5));
		p3.setLayout(new GridLayout(4, 4, 5, 5));

		setTitle("계산기");
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
