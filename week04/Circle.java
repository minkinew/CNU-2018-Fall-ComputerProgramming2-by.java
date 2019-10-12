import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


class MyPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; //Graphics 객체 변수를 Graphics2D 타입으로 형변환
		Random random = new Random(); //랜덤객체 생성
		Color[] color = new Color[7];
		ArrayList<Circle> circles = new ArrayList<Circle>(); //ArrayList를 사용하여 Circle 객체들을 저장
		
		for (int i = 0; i < 7; i++) {
			int color1 = (int) (Math.random() * 255.0); //색깔을 랜덤하게 설정
			int color2 = (int) (Math.random() * 255.0); //색깔을 랜덤하게 설정
			int color3 = (int) (Math.random() * 255.0); //색깔을 랜덤하게 설정
			color[i] = new Color(color1, color2, color3); //color객체에 랜덤색깔 삽입
			Circle c1 = new Circle(color[i], random.nextInt(300), random.nextInt(500),
					random.nextInt(500));// 원의 크기 랜덤값
			circles.add(c1);// 객체를 만들어서 넣음
		}
		
		//circles에 저장된 Circle 객체들을 꺼내서 화면에 그려줌
		for (Circle c : circles) 
			c.drawCircle(g2);
	}
}

public class Circle extends JFrame {
	int radius; // 원의 반지름
	int centerX, centerY; // 원의 중심 좌표
	Color color; // 원의 색상

	public Circle(Color c, int r, int cx, int cy) { //주어진 인자를 필드로 초기화하는 생성자
		this.radius = r; //원의 반지름
		this.centerX = cx; //원의 중심 x좌표
		this.centerY = cy; //원의 중심 y좌표
		this.color = c; //원의 색상
	}

	public Circle() { //생성자
		setSize(500, 500); //
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Color Test");
		setVisible(true);
		add(new MyPanel());
	}


	public void drawCircle(Graphics g) { //원을 그리는 메소드
		g.setColor(color); //전경색 설정
		g.fillOval(centerX, centerY, radius, radius); //채워진 타원 그리기
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Circle();
	}

	

}
