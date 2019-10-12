import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dice extends JFrame {
	// 이미지 로딩
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	BufferedImage img3 = null;
	BufferedImage img4 = null;
	BufferedImage img5 = null;
	BufferedImage img6 = null;

	public Dice() { // 생성자
		setSize(750, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("주사위 던지기 프로그램");
		add(new Mypaen1());
		setVisible(true);

		try { // 이미지를 읽음
			img1 = ImageIO.read(new File("dice1_1.png"));
			img2 = ImageIO.read(new File("dice2_2.png"));
			img3 = ImageIO.read(new File("dice3_3.png"));
			img4 = ImageIO.read(new File("dice4_4.png"));
			img5 = ImageIO.read(new File("dice5_5.png"));
			img6 = ImageIO.read(new File("dice6_6.png"));
		} catch (IOException e) { // 예외처리(오류 발생 시 프로그램 종료)
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	class Mypaen1 extends JPanel { // 필드 이미지를 사용하기 위해 패널을 내부클래스로 선언
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 주사위 사진 2개 중 첫번째 사진 x,y좌표 난수 설정
			int x1 = (int) (Math.random() * 100); // 0 ~ 99
			int y1 = (int) (Math.random() * 100); // 0 ~ 99

			// 주사위 사진 2개 중 두번째 사진 x,y좌표 난수 설정
			int x2 = (int) (Math.random() * 750) + (x1 + 1); // (0 + (x1 + 1) ~ 749 + (x1 + 1) ) => 100 ~ 849
			int y2 = (int) (Math.random() * 750) + (y1 + 1); // (0 + (y1 + 1) ~ 749 + (y1 + 1) ) => 100 ~ 849

			int pictures1 = (int) (Math.random() * 6); // 첫번째 사진에 1~6까지 이미지중 랜덤하게 난수 설정
			int pictures2 = (int) (Math.random() * 6); // 두번째 사진에 1~6까지 이미지중 랜덤하게 난수 설정

			if ((x1 != x2 && y1 != y2) && (x1 != y2 && y1 != x2)) { // 두개의 사진의 x,y좌표가 같지 않게 설정
				if ((x1 < 100 && y1 < 100) && // 두개의 사진이 겹치지 않게
						(x2 >= 100 && x2 <= 849 && y2 >= 100 && y2 <= 849)) {

					if (pictures1 == 1) // 난수가 1이면 첫번째 사진에 주사위1 이미지를 그림
						g.drawImage(img1, x1, y1, null);
					else if (pictures1 == 2) // 난수가 2이면 첫번째 사진 주사위2 이미지를 그림
						g.drawImage(img2, x1, y1, null);
					else if (pictures1 == 3) // 난수가 3이면 첫번째 사진 주사위3 이미지를 그림
						g.drawImage(img3, x1, y1, null);
					else if (pictures1 == 4) // 난수가 4이면 첫번째 사진 주사위4 이미지를 그림
						g.drawImage(img4, x1, y1, null);
					else if (pictures1 == 5) // 난수가 5이면 첫번째 사진 주사위5 이미지를 그림
						g.drawImage(img5, x1, y1, null);
					else if (pictures1 == 6) // 난수가 6이면 첫번째 사진 주사위6 이미지를 그림
						g.drawImage(img6, x1, y1, null);
					else
						return;

					if (pictures2 == 1) // 난수가 1이면 두번째 사진 주사위1 이미지를 그림
						g.drawImage(img1, x2, y2, null);
					else if (pictures2 == 2) // 난수가 2이면 두번째 사진 주사위2 이미지를 그림
						g.drawImage(img2, x2, y2, null);
					else if (pictures2 == 3) // 난수가 3이면 두번째 사진 주사위3 이미지를 그림
						g.drawImage(img3, x2, y2, null);
					else if (pictures2 == 4) // 난수가 4이면 두번째 사진 주사위4 이미지를 그림
						g.drawImage(img4, x2, y2, null);
					else if (pictures2 == 5) // 난수가 5이면 두번째 사진 주사위5 이미지를 그림
						g.drawImage(img5, x2, y2, null);
					else if (pictures2 == 6) // 난수가 6이면 두번째 사진 주사위6 이미지를 그림
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
