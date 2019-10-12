import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DodgeGame extends JFrame {
	public DodgeGame() {
		JPanel panel = new Panel();
		setTitle("괴물 피하기 게임");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(panel);

		panel.requestFocus();
		panel.requestFocus();
	}

	class MonsterThread extends Thread {
		JLabel monsterRun;
		JLabel characterRun;

		MonsterThread(JLabel m_run, JLabel c_run) {
			this.monsterRun = m_run;
			this.characterRun = c_run;
		}

		public void run() {
			int x = monsterRun.getX();
			int y = monsterRun.getY();

			while (true) {
				if (characterRun.getX() < monsterRun.getX())
					x = monsterRun.getX() - 5;
				else
					x = monsterRun.getX() + 5;
				
				if (characterRun.getY() < monsterRun.getY())
					y = monsterRun.getY() - 5;
				else
					y = monsterRun.getY() + 5;

				monsterRun.setLocation(x, y);
				

				try {
					if (Math.abs((monsterRun.getX() - 7.5) - (characterRun.getX() - 7.5)) < 10
							&& Math.abs((monsterRun.getY() - 7.5) - (characterRun.getY() - 7.5)) < 10) {
						System.exit(0);
					}
					sleep(200);
				} catch (InterruptedException e) {
					System.exit(0);
					return;
				}
			}
		}
	}

	class Panel extends JPanel {
		JLabel character;
		JLabel monster;

		public Panel() {
			character = new JLabel("@");
			monster = new JLabel("M");
			setLayout(null);
			addKeyListener(new MyKeyListener());

			character.setSize(15, 15);
			character.setLocation(150, 150);
			character.setForeground(Color.RED);
			add(character);

			monster.setSize(15, 15);
			monster.setLocation(100, 50);
			add(monster);

			MonsterThread mt = new MonsterThread(monster, character);
			mt.start();
		}

		class MyKeyListener extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				int direction = e.getKeyCode();
				switch (direction) {
				case KeyEvent.VK_LEFT:
					character.setLocation(character.getX() - 10, character.getY());
					break;
				case KeyEvent.VK_RIGHT:
					character.setLocation(character.getX() + 10, character.getY());
					break;
				case KeyEvent.VK_UP:
					character.setLocation(character.getX(), character.getY() - 10);
					break;
				case KeyEvent.VK_DOWN:
					character.setLocation(character.getX(), character.getY() + 10);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		new DodgeGame();
	}
}