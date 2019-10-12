import java.awt.*;
import javax.swing.*;

class MyFrame1 extends JFrame{ //JFrame�� ��ӹ��� MyFrame1 ����
	private JPanel panel1, panel2, panel3; //panel1, 2, 3
	private JButton button1, button2, button3, button4, button5; //button1, 2, 3, 4, 5
	private JLabel label; //label
	
	public MyFrame1() {
		setTitle("ȣ�� ���� ���ø����̼�"); //������ ���� ����
		setSize(500, 200); //������ ũ�⼳��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close Ŭ���� ��ü���α׷� ����
		setLayout(new FlowLayout()); //��ġ������..?
		
		panel1 = new JPanel(); //panel1 ��ü ���� 
		panel2 = new JPanel(); //panel2 ��ü ����
		panel3 = new JPanel(); //panel3 ��ü ����
		
		label = new JLabel("�ڹ� ȣ�ڿ� ���� ���� ȯ���մϴ�. �����ϼ��� �Է��ϼ���.");
		panel1.add(label); //panel1�� ���̺� �߰�
		add(panel1);  //panel1�� �����ӿ� �߰�

		button1 = new JButton("1��"); //button1 ��ü ���� �� �����ӿ� "1��"�߰�
		button2 = new JButton("2��"); //button2 ��ü ���� �� �����ӿ� "2��"�߰�
		button3 = new JButton("3��"); //button3 ��ü ���� �� �����ӿ� "3��"�߰�
		button4 = new JButton("4��"); //button4 ��ü ���� �� �����ӿ� "4��"�߰�
		button5 = new JButton("5��"); //button5 ��ü ���� �� �����ӿ� "5��"�߰�
		
		panel2.add(button1); //panel2�� button1�߰�
		panel2.add(button2); //panel2�� button2�߰�
		panel2.add(button3); //panel2�� button3�߰�
		panel2.add(button4); //panel2�� button4�߰�
		panel2.add(button5); //panel2�� button5�߰�
		add(panel2); //panel2�� �����ӿ� �߰�
		
		panel3.add(panel1); //panel3�� panel1�߰�
		panel3.add(panel2); //panel3�� panel2�߰�
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		add(panel3); //panel3�� �����ӿ� �߰�
		
		setVisible(true); //�������� ȭ�鿡 ��Ÿ���� ��
		
	}
}

public class Hotel_ordered {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame1(); //MyFrame1 ��ü ����

	}

}
