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

		System.out.println("행맨 게임!");
		System.out.println("(제한 횟수는 " + (2 * correct.length) + "번입니다. )");

		for (int i = 0; i < word2.length; i++)
			correct[i] = "_ ";

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("현재 상태 : ");
			for (int i = 0; i < word2.length; i++)
				System.out.print(correct[i]);

			System.out.println();
			System.out.print("문자를 입력해주세요(한글자) : ");
			String input = sc.nextLine();

			if (input.length() != 1) {
				System.out.println("한글자만 입력가능합니다.");
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
				System.out.println("정답을 맞혔습니다");
				System.exit(0);
			}
			if (tryCount == (2 * word2.length)) {
				System.out.println("정답을 맞추지 못했습니다.");
				for (int k = 0; k < word2.length; k++)
					System.out.print(word2[k]);
				System.exit(0);
			}
		}
	}
}