import java.awt.*;
import javax.swing.*;

class MyFrame1 extends JFrame{ //JFrame을 상속받은 MyFrame1 정의
	private JPanel panel1, panel2, panel3; //panel1, 2, 3
	private JButton button1, button2, button3, button4, button5; //button1, 2, 3, 4, 5
	private JLabel label; //label
	
	public MyFrame1() {
		setTitle("호텔 예약 애플리케이션"); //프레임 제목 설정
		setSize(500, 200); //프레임 크기설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close 클릭시 전체프로그램 종료
		setLayout(new FlowLayout()); //배치관리자..?
		
		panel1 = new JPanel(); //panel1 객체 생성 
		panel2 = new JPanel(); //panel2 객체 생성
		panel3 = new JPanel(); //panel3 객체 생성
		
		label = new JLabel("자바 호텔에 오신 것을 환영합니다. 숙박일수를 입력하세요.");
		panel1.add(label); //panel1에 레이블 추가
		add(panel1);  //panel1를 프레임에 추가

		button1 = new JButton("1명"); //button1 객체 생성 후 프레임에 "1명"추가
		button2 = new JButton("2명"); //button2 객체 생성 후 프레임에 "2명"추가
		button3 = new JButton("3명"); //button3 객체 생성 후 프레임에 "3명"추가
		button4 = new JButton("4명"); //button4 객체 생성 후 프레임에 "4명"추가
		button5 = new JButton("5명"); //button5 객체 생성 후 프레임에 "5명"추가
		
		panel2.add(button1); //panel2에 button1추가
		panel2.add(button2); //panel2에 button2추가
		panel2.add(button3); //panel2에 button3추가
		panel2.add(button4); //panel2에 button4추가
		panel2.add(button5); //panel2에 button5추가
		add(panel2); //panel2를 프레임에 추가
		
		panel3.add(panel1); //panel3에 panel1추가
		panel3.add(panel2); //panel3에 panel2추가
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		add(panel3); //panel3을 프레임에 추가
		
		setVisible(true); //프레임을 화면에 나타나게 함
		
	}
}

public class Hotel_ordered {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame1(); //MyFrame1 객체 생성

	}

}
