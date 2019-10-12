import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dice extends JFrame {
	// �̹��� �ε�
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	BufferedImage img3 = null;
	BufferedImage img4 = null;
	BufferedImage img5 = null;
	BufferedImage img6 = null;

	public Dice() { // ������
		setSize(750, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�ֻ��� ������ ���α׷�");
		add(new Mypaen1());
		setVisible(true);

		try { // �̹����� ����
			img1 = ImageIO.read(new File("dice1_1.png"));
			img2 = ImageIO.read(new File("dice2_2.png"));
			img3 = ImageIO.read(new File("dice3_3.png"));
			img4 = ImageIO.read(new File("dice4_4.png"));
			img5 = ImageIO.read(new File("dice5_5.png"));
			img6 = ImageIO.read(new File("dice6_6.png"));
		} catch (IOException e) { // ����ó��(���� �߻� �� ���α׷� ����)
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	class Mypaen1 extends JPanel { // �ʵ� �̹����� ����ϱ� ���� �г��� ����Ŭ������ ����
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// �ֻ��� ���� 2�� �� ù��° ���� x,y��ǥ ���� ����
			int x1 = (int) (Math.random() * 100); // 0 ~ 99
			int y1 = (int) (Math.random() * 100); // 0 ~ 99

			// �ֻ��� ���� 2�� �� �ι�° ���� x,y��ǥ ���� ����
			int x2 = (int) (Math.random() * 750) + (x1 + 1); // (0 + (x1 + 1) ~ 749 + (x1 + 1) ) => 100 ~ 849
			int y2 = (int) (Math.random() * 750) + (y1 + 1); // (0 + (y1 + 1) ~ 749 + (y1 + 1) ) => 100 ~ 849

			int pictures1 = (int) (Math.random() * 6); // ù��° ������ 1~6���� �̹����� �����ϰ� ���� ����
			int pictures2 = (int) (Math.random() * 6); // �ι�° ������ 1~6���� �̹����� �����ϰ� ���� ����

			if ((x1 != x2 && y1 != y2) && (x1 != y2 && y1 != x2)) { // �ΰ��� ������ x,y��ǥ�� ���� �ʰ� ����
				if ((x1 < 100 && y1 < 100) && // �ΰ��� ������ ��ġ�� �ʰ�
						(x2 >= 100 && x2 <= 849 && y2 >= 100 && y2 <= 849)) {

					if (pictures1 == 1) // ������ 1�̸� ù��° ������ �ֻ���1 �̹����� �׸�
						g.drawImage(img1, x1, y1, null);
					else if (pictures1 == 2) // ������ 2�̸� ù��° ���� �ֻ���2 �̹����� �׸�
						g.drawImage(img2, x1, y1, null);
					else if (pictures1 == 3) // ������ 3�̸� ù��° ���� �ֻ���3 �̹����� �׸�
						g.drawImage(img3, x1, y1, null);
					else if (pictures1 == 4) // ������ 4�̸� ù��° ���� �ֻ���4 �̹����� �׸�
						g.drawImage(img4, x1, y1, null);
					else if (pictures1 == 5) // ������ 5�̸� ù��° ���� �ֻ���5 �̹����� �׸�
						g.drawImage(img5, x1, y1, null);
					else if (pictures1 == 6) // ������ 6�̸� ù��° ���� �ֻ���6 �̹����� �׸�
						g.drawImage(img6, x1, y1, null);
					else
						return;

					if (pictures2 == 1) // ������ 1�̸� �ι�° ���� �ֻ���1 �̹����� �׸�
						g.drawImage(img1, x2, y2, null);
					else if (pictures2 == 2) // ������ 2�̸� �ι�° ���� �ֻ���2 �̹����� �׸�
						g.drawImage(img2, x2, y2, null);
					else if (pictures2 == 3) // ������ 3�̸� �ι�° ���� �ֻ���3 �̹����� �׸�
						g.drawImage(img3, x2, y2, null);
					else if (pictures2 == 4) // ������ 4�̸� �ι�° ���� �ֻ���4 �̹����� �׸�
						g.drawImage(img4, x2, y2, null);
					else if (pictures2 == 5) // ������ 5�̸� �ι�° ���� �ֻ���5 �̹����� �׸�
						g.drawImage(img5, x2, y2, null);
					else if (pictures2 == 6) // ������ 6�̸� �ι�° ���� �ֻ���6 �̹����� �׸�
						g.drawImage(img6, x2, y2, null);
					else
						return;

				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dice();
	}

}
