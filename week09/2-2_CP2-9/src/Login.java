import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
	public static void main(String[] args) throws IOException {

		ArrayList<String> ID = new ArrayList<String>();
		ArrayList<String> PW = new ArrayList<String>();

		BufferedReader ID_in = new BufferedReader(new FileReader("ID.txt"));
		BufferedReader PW_in = new BufferedReader(new FileReader("PW.txt"));

		String line1 = ID_in.readLine();
		String line2 = PW_in.readLine();

		while (line1 != null && line2 != null) {
			ID.add(line1);
			PW.add(line2);
			line1 = ID_in.readLine();
			line2 = PW_in.readLine();
		}

		String new_ID;
		String new_PW;

		while (true) {
			System.out.print("로그인 하거나 ID가 없으면 회원가입을 하세요. (1. 로그인 2. 회원가입 3. 종료) : ");
			Scanner sc = new Scanner(System.in);
			int number_big = sc.nextInt();

			switch (number_big) {
			case 1:
				System.out.print("ID를 입력하세요 : ");
				new_ID = sc.next();
				ONE: {
					for (int i = 0; i < ID.size(); i++) {
						if (new_ID.equals(ID.get(i))) {
							System.out.print("비밀번호를 입력하세요 : ");
							new_PW = sc.next();
							if (new_PW.equals(PW.get(i))) {
								System.out.println("로그인 되었습니다.");
								System.out.print("1. 비밀번호 수정 2. 종료 : ");
								int num_login = sc.nextInt();
								if (num_login == 1) {
									System.out.print("본인의 ID를한번 더 입력하세요 : ");
									new_ID = sc.next();
									if (new_ID.equals(ID.get(i))) {
										System.out.print("비밀번호를 입력하세요 : ");
										new_PW = sc.next();
										if (new_PW.equals(PW.get(i))) {
											System.out.println("확인 되었습니다.");
											System.out.print("새로운 비밀번호를 입력하세요 : ");
											new_PW = sc.next();
											PW.set(i, new_PW);
											break ONE;
										} else {
											System.out.println("비밀번호가 올바르지 않습니다.");
											break ONE;
										}
									} else {
										System.out.println("ID가 올바르지 않습니다.");
										break ONE;
									}
								} else if (num_login == 2) {
									break ONE;
								} else {
									System.out.println("잘못된 숫자를 입력하였습니다.");
									break ONE;
								}
							} else {
								System.out.println("비밀번호가 올바르지 비밀번호입니다.");
								break ONE;
							}
						}
					}
					System.out.println("존재하지않는 ID입니다.");
					break;
				}
				break;

			case 2:
				if (ID.isEmpty()) {
					System.out.print("새로운 ID를 입력하세요 : ");
					new_ID = sc.next();
					ID.add(0, new_ID);
					System.out.print("비밀번호를 입력하세요 : ");
					new_PW = sc.next();
					PW.add(0, new_PW);
					break;
				} else
					TWO: {
						System.out.print("새로운 ID를 입력하세요 : ");
						for (int i = 0; i < ID.size(); i++) {
							new_ID = sc.next();
							for (int j = 0; j < ID.size(); j++) {
								if (new_ID.equals(ID.get(j))) {
									System.out.println("존재하는 ID입니다.");
									break TWO;
								}
							}
							ID.add(i, new_ID);
							System.out.print("비밀번호를 입력하세요 : ");
							new_PW = sc.next();
							PW.add(i, new_PW);
							break;
						}
					}
				break;

			case 3:
				PrintWriter ID_out = new PrintWriter(new FileWriter("ID.txt"));
				PrintWriter PW_out = new PrintWriter(new FileWriter("PW.txt"));

				for (int i = 0; i < ID.size(); i++) {
					ID_out.println(ID.get(i));
					PW_out.println(PW.get(i));
				}
				ID_out.flush();
				PW_out.flush();

				if (ID_in != null)
					ID_in.close();
				if (ID_out != null)
					ID_out.close();
				if (PW_in != null)
					PW_in.close();
				if (PW_out != null)
					PW_out.close();
				System.out.println("종료");
				System.exit(0);
				break;
			default:
				continue;
			}
		}
	}
}