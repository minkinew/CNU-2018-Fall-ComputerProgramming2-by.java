import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		java.util.HashSet<String> list = new java.util.HashSet<>();
		int cnt = 0;
		int tryCount = 0;

		try {
			BufferedReader in = new BufferedReader(new FileReader("sample.txt"));
			String line = in.readLine();

			while (line != null) {
				list.add(line);
				line = in.readLine();
			}
		} catch (IOException e) {
			System.exit(0);
		}

		Random r = new Random();
		Object[] hangman = list.toArray();
		String word = (String) hangman[r.nextInt(hangman.length)];
		String[] word2 = word.split("");
		String[] correct = new String[word2.length];

		System.out.println("��� ����!");
		System.out.println("(���� Ƚ���� " + (2 * correct.length) + "���Դϴ�. )");

		for (int i = 0; i < word2.length; i++)
			correct[i] = "_ ";

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("���� ���� : ");
			for (int i = 0; i < word2.length; i++)
				System.out.print(correct[i]);

			System.out.println();
			System.out.print("���ڸ� �Է����ּ���(�ѱ���) : ");
			String input = sc.nextLine();

			if (input.length() != 1) {
				System.out.println("�ѱ��ڸ� �Է°����մϴ�.");
				continue;
			}

			tryCount++;
			System.out.println();

			for (int j = 0; j < word2.length; j++) {
				if (word2[j].equalsIgnoreCase(input)) {
					correct[j] = word2[j];
					cnt++;
				}
			}

			if (cnt == word2.length) {
				System.out.println("������ �������ϴ�");
				System.exit(0);
			}
			if (tryCount == (2 * word2.length)) {
				System.out.println("������ ������ ���߽��ϴ�.");
				for (int k = 0; k < word2.length; k++)
					System.out.print(word2[k]);
				System.exit(0);
			}
		}
	}
}