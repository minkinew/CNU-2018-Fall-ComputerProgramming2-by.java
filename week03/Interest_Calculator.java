import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class MyFrame extends JFrame {
		private JPanel p1, p2, p3, p4;
		private TextField t1, t2, t3;
		private JButton b1;
		private JLabel l1, l2;
		public MyFrame() {
			setTitle("���� ����");
			setSize(400,200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			p1 = new JPanel(); //���� �гλ���
			p1.setLayout(new GridLayout(0, 2, 200, 5)); //0�� 2��, ���� 100, 5 
			p2 = new JPanel(); //���� �гλ���
			p2.setLayout(new GridLayout(0, 2, 200, 5)); //0�� 2��, ���� 100, 5
			p3 = new JPanel(); //��� �гλ���
			p3.setLayout(new BorderLayout());
			p4 = new JPanel(); //���� �гλ���
			p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS)); //Y�� ���� 
			
			t1 = new TextField(10); //���� �ؽ�Ʈ�ʵ� ����
			t2 = new TextField(10); //���� �ؽ�Ʈ�ʵ� ����
			t3 = new TextField(30); //��� �ؽ�Ʈ�ʵ� ����
			
			b1 = new JButton("��ȯ"); //��ư����
			b1.setSize(10,10); //��ư������
			b1.setAlignmentX(Component.CENTER_ALIGNMENT); //��ư ����
			
			l1 = new JLabel("������ �Է��Ͻÿ�"); //���� �󺧻���
			l2 = new JLabel("������ �Է��Ͻÿ�"); //���� �󺧻���
			
			//p1�гο� ��,�ؽ�Ʈ �߰�
			p1.add(l1);
			p1.add(t1);
			//p2�гο� ��,�ؽ�Ʈ �߰�
			p2.add(l2);
			p2.add(t2);
			
			p3.add(t3);//p3�гο� �ؽ�Ʈ �߰�
			p4.add(p1);//p4�гο� p1�г� �߰�
			p4.add(p2);//p4�гο� p2�г� �߰�
			p4.add(b1);//p4�гο� ��ư�߰�
			p4.add(p3);//p4�гο� p3�г� �߰�
			
			add(p4);//p4�г��� �����ӿ� �߰�
			pack(); //�������� ������Ʈ ũ�⿡ ����
			setVisible(true);
		}
	}
public class Interest_Calculator {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
