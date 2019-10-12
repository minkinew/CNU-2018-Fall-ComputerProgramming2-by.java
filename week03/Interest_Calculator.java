import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class MyFrame extends JFrame {
		private JPanel p1, p2, p3, p4;
		private TextField t1, t2, t3;
		private JButton b1;
		private JLabel l1, l2;
		public MyFrame() {
			setTitle("이자 계산기");
			setSize(400,200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			p1 = new JPanel(); //원금 패널생성
			p1.setLayout(new GridLayout(0, 2, 200, 5)); //0행 2열, 여백 100, 5 
			p2 = new JPanel(); //이율 패널생성
			p2.setLayout(new GridLayout(0, 2, 200, 5)); //0행 2열, 여백 100, 5
			p3 = new JPanel(); //결과 패널생성
			p3.setLayout(new BorderLayout());
			p4 = new JPanel(); //메인 패널생성
			p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS)); //Y축 정렬 
			
			t1 = new TextField(10); //원금 텍스트필드 생성
			t2 = new TextField(10); //이율 텍스트필드 생성
			t3 = new TextField(30); //결과 텍스트필드 생성
			
			b1 = new JButton("변환"); //버튼생성
			b1.setSize(10,10); //버튼사이즈
			b1.setAlignmentX(Component.CENTER_ALIGNMENT); //버튼 정렬
			
			l1 = new JLabel("원금을 입력하시오"); //원금 라벨생성
			l2 = new JLabel("이율을 입력하시오"); //이율 라벨생성
			
			//p1패널에 라벨,텍스트 추가
			p1.add(l1);
			p1.add(t1);
			//p2패널에 라벨,텍스트 추가
			p2.add(l2);
			p2.add(t2);
			
			p3.add(t3);//p3패널에 텍스트 추가
			p4.add(p1);//p4패널에 p1패널 추가
			p4.add(p2);//p4패널에 p2패널 추가
			p4.add(b1);//p4패널에 버튼추가
			p4.add(p3);//p4패널에 p3패널 추가
			
			add(p4);//p4패널을 프레임에 추가
			pack(); //프레임을 컴포넌트 크기에 맞춤
			setVisible(true);
		}
	}
public class Interest_Calculator {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
