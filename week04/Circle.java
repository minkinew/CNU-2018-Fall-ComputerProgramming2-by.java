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
		Graphics2D g2 = (Graphics2D) g; //Graphics ��ü ������ Graphics2D Ÿ������ ����ȯ
		Random random = new Random(); //������ü ����
		Color[] color = new Color[7];
		ArrayList<Circle> circles = new ArrayList<Circle>(); //ArrayList�� ����Ͽ� Circle ��ü���� ����
		
		for (int i = 0; i < 7; i++) {
			int color1 = (int) (Math.random() * 255.0); //������ �����ϰ� ����
			int color2 = (int) (Math.random() * 255.0); //������ �����ϰ� ����
			int color3 = (int) (Math.random() * 255.0); //������ �����ϰ� ����
			color[i] = new Color(color1, color2, color3); //color��ü�� �������� ����
			Circle c1 = new Circle(color[i], random.nextInt(300), random.nextInt(500),
					random.nextInt(500));// ���� ũ�� ������
			circles.add(c1);// ��ü�� ���� ����
		}
		
		//circles�� ����� Circle ��ü���� ������ ȭ�鿡 �׷���
		for (Circle c : circles) 
			c.drawCircle(g2);
	}
}

public class Circle extends JFrame {
	int radius; // ���� ������
	int centerX, centerY; // ���� �߽� ��ǥ
	Color color; // ���� ����

	public Circle(Color c, int r, int cx, int cy) { //�־��� ���ڸ� �ʵ�� �ʱ�ȭ�ϴ� ������
		this.radius = r; //���� ������
		this.centerX = cx; //���� �߽� x��ǥ
		this.centerY = cy; //���� �߽� y��ǥ
		this.color = c; //���� ����
	}

	public Circle() { //������
		setSize(500, 500); //
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Color Test");
		setVisible(true);
		add(new MyPanel());
	}


	public void drawCircle(Graphics g) { //���� �׸��� �޼ҵ�
		g.setColor(color); //����� ����
		g.fillOval(centerX, centerY, radius, radius); //ä���� Ÿ�� �׸���
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Circle();
	}

	

}
