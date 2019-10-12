import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame1 extends JFrame {
	private JPanel p1, p2, p3;
	private TextField t1;
	private JButton bback, bequal, bplus, bminus, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bC, bdivide, bmulti;
	public MyFrame1() {
		setTitle("계산기");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel(); //계산 결과 창 패널생성
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS)); //y축 정렬
		t1 = new TextField(30); //텍스트필드 생성
		
		p2 = new JPanel(); //지우기 버튼 패널생성
		p2.setLayout(new GridLayout(0, 4, 5, 5)); //0행 4열 여백5
		p2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //패널간 여백 5
		
		p3 = new JPanel(); //계산기 입력 패널생성
		p3.setLayout(new GridLayout(0, 4, 5, 5));//0행 4열 여백5
		p3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //패널간 여백 5
		
		//버튼생성
		bback = new JButton("back");
		bequal = new JButton("=");
		bplus = new JButton("+");
		bminus = new JButton("-");
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
		bC = new JButton("C");
		bdivide = new JButton("/");
		bmulti = new JButton("*");
		
		//텍스트필드 추가
		p1.add(t1);
		//버튼 추가
		p2.add(bC);
		p3.add(b7);
		p3.add(b8);
		p3.add(b9);
		p3.add(bdivide);
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);
		p3.add(bmulti);
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(bminus);
		p3.add(b0);
		p3.add(bback);
		p3.add(bequal);
		p3.add(bplus);
		
		p1.add(p2); //p1패널에 p2패널 추가
		p1.add(p3); //p1패널에 p3패널 추가
		
		add(p1); //p1패널을 프레임에 추가
		pack(); //프레임크기를 컴포넌트 크기에 맞춤
		
	    setVisible(true);	
	}	
}

public class Calculator {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame1();
	}

}
