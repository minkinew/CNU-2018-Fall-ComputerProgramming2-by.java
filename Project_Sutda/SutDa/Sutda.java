import java.awt.*;
import javax.swing.*;
import java.util.HashSet;
import java.util.Random;
import java.util.*;
import sun.audio.*;
import java.io.*;
import java.awt.event.*;
import java.io.*;

class A extends Thread{
	A(){	
	}
}

public class Sutda extends JPanel implements ActionListener
{	
	
	//1ī��(5���� ī����ġ)  //������1,���ʾƷ�2, ����3, �����ʾƷ�4, ��������5
	int locate_x[] = {40, 40, 380, 715, 715};	
	int locate_y[] = {10, 220, 460, 220, 10};
	
	//2ī��   //������1,���ʾƷ�2, ����3, �����ʾƷ�4, ��������5
	int locate_x2[] = {180, 180, 520, 855, 855};	
	int locate_y2[] = {10, 220, 460, 220, 10};
	
	int random_num_Array[] = new int[20];	//1~20���� ������������
	int a=0;
	Image hide_img;	//ȭ���ޱ׸�
	Image card_img[] = new Image[10];
	Image select_img[] = new Image[6];
	
	int u_money;	//õ����		//���߿� ���Ϸ� ���� �ҷ��ð���.
	int before_money = u_money;
	int cal_money = 0; //���ӿ� �������� �̵� Ȥ�� �ս� �ݾ�.
	int pan_money = 100; //�ǵ�
	int bet_money = 20; //���þ�
		
	int pe=1; //��ư�� ���������� 1������, pe�� 3�̵Ǹ� ī�带 ��� ��������.
	int po=2; //g.drawImage�޼ҵ嶧������(?) ����������Ǵ°��� ��ó�ϱ� ���� ���.
	int user_add_money=0;
	Font Win_Font = new Font("Serif", Font.BOLD, 30);
	
	//���ӿ� ����� ��ư��
	JButton bt1 = new JButton("����");
	JButton bt2 = new JButton("üũ");
	JButton bt3 = new JButton("��");
	JButton bt4 = new JButton("��");
	JButton bt5 = new JButton("����");
	JButton bt6 = new JButton("�ƽ�");
	int exit=0;
	int key=0; //������ ���ư�� ���������� ���� ���ù� �Ҹ��� ���õ�.
	int end=11; //��� ������ ������ ��ư�� ������ �ҿ������
	//Graphics g;
	int state;	//state�� ���� ��Ȳ�� �ٲ��.
	
	int player[]= new int[5];
	int player_order[] = new int[5];
	String class_name[] = new String[5];
	String s1, s2, s4, s5;
	int sun;	//��		���߿� ���Ϸ� ���� �ҷ��ð���.
	int re_bet = 0;
	int connect =0;
	
	Sutda(){
		
	}
	
	Sutda(int money, int order){	//������.
		u_money = money;
		sun = order;
		state = 0;	//�����Ҷ� state�� 0�̴�.
		u_money-=bet_money;	//�ǵ��� ���� �����Ѵ�.
		
		playSound("rj1.wav");	//��������.
		HashSet set = new HashSet();	//�ߺ�����üũ
		Random rand = new Random();
		int num;	//�������� �Է¹��� ��
		
		//20���� ���ڸ� �ߺ����� �����ϴ� �κ�.
		for(int i=0; i < 20; i++){
			num = Math.abs(rand.nextInt())%20 + 1;
			boolean setChanged = set.add(new Integer(num));
			if(setChanged == false)i--;	//�ߺ��̸� �ٽ�
			else random_num_Array[i] = num; //�ߺ��ƴϸ� ����.
		}	//����Ϸ�
		
		
		
		repaint();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		//������ ���߱�.
		g.drawLine(0, 440, 1000, 440);
		g.drawLine(330, 0, 330, 690);
		g.drawLine(670, 0, 670, 690);
		
		//��� ���߱�.
		g.drawRect(200, 450, 120, 204);
		g.drawLine(270, 450, 270, 654);
		for(int i=0; i< 12; i++){
			g.drawLine(200, 467+(17*i), 320, 467+(17*i));
		}
		//��� �۾���.
		g.drawString("1.���ȱ���", 205, 464);
		g.drawString("2.��", 205, 481);
		g.drawString("3.�˸�", 205, 498);
		g.drawString("4.����", 205, 515);
		g.drawString("5.����", 205, 532);
		g.drawString("6.���", 205, 549);
		g.drawString("7.���", 205, 566);
		g.drawString("8.���", 205, 583);
		g.drawString("9.����", 205, 600);
		g.drawString("10.��,����", 205, 617);
		g.drawString("�籸,������", 205, 634);
		g.drawString("������", 205, 651);
		
		//����
		g.drawString("���� : " + (sun+1) +"p", 10, 460);
		g.drawString("==========================", 10, 480);
		g.drawString("* ���常 üũ�� ���� �Ҽ� ����.", 10, 500);
		g.drawString("* ���̸� ������ ��� ��ٷ� �ּ���.", 10, 520);
		g.drawString("* 1~2������ �ų� �ƽ�����", 10, 540);
		
		
		
		//ī�� �ޱ׸� �ҷ�����.
		hide_img = Toolkit.getDefaultToolkit().getImage("�߸�ȭ��.png");
		//5���� �� ī�� 10�� �ҷ�����.(���ٴ� 20���� 10�常 �����.)
		for(int i=0; i<10; i++){
			card_img[i] = Toolkit.getDefaultToolkit().getImage
			("" + random_num_Array[i] + ".png");
		}
		
		
		
		if(state!=10){	//state10 ������ �������ʿ����.
			//�÷��̾�
			g.drawString("1p", 10, 90);
			g.drawString("2p", 10, 300);
			g.drawString("3p", 345, 540);
			g.drawString("4p", 685, 300);
			g.drawString("5p", 685, 90);
			
			
			//5���� ó�� 5���� �����ش�.
			for(int i=0; i<5; i++){
				if(i==2){	//����
					g.drawImage(card_img[2], locate_x[2], locate_y[2], this);
					continue;
				}	//��ǻ��
				g.drawImage(hide_img, locate_x[i], locate_y[i], this);
	
			}
		}
		for(int i=0 ; i<5; i++){
			player[i] = what_class(random_num_Array[i], random_num_Array[i+5]);
			player_order[i] = i;
		}
		//re_bet==1���� �п� �´� ������ �ϴµ� �׸��� �µ���..
		if(key==1)money_change1(454);
		else if(key==2){		//üũ����
			
			g.setColor(Color.pink);			//��ũ��
			g.fillRect(339, 70, 30, 30);	//�׸�׸�
			g.setColor(Color.BLACK);		//������
			if(re_bet==0){g.drawString( "�ƽ�", 341, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s1, 341, 90);}
			
			g.setColor(Color.pink);
			g.fillRect(339, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 341, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s2, 341, 300);}
			
			g.setColor(Color.pink);	
			g.fillRect(490, 405, 30, 30);
			g.setColor(Color.BLACK);
			g.drawString("üũ", 492, 425);
			
			
			g.setColor(Color.pink);
			g.fillRect(630, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s4, 632, 300);}
			
			g.setColor(Color.pink);
			g.fillRect(630, 70, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s5, 632, 90);}
			//����
			
		}else if(key==3){		//�ݼ���
			
			g.setColor(Color.pink);			//��ũ��
			g.fillRect(339, 70, 30, 30);	//�׸�׸�
			g.setColor(Color.BLACK);		//������
			if(re_bet==0){g.drawString( "�ƽ�", 341, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s1, 341, 90);}
			
			g.setColor(Color.pink);
			g.fillRect(339, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 341, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s2, 341, 300);}
			
			g.setColor(Color.pink);	
			g.fillRect(490, 405, 30, 30);
			g.setColor(Color.BLACK);
			g.drawString("  �� ", 492, 425);
			
			g.setColor(Color.pink);
			g.fillRect(630, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s4, 632, 300);}
			
			g.setColor(Color.pink);
			g.fillRect(630, 70, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s5, 632, 90);}
			
			
			
		}else if(key==4){			//�漱��
			
			g.setColor(Color.pink);			//��ũ��
			g.fillRect(339, 70, 30, 30);	//�׸�׸�
			g.setColor(Color.BLACK);		//������
			if(re_bet==0){g.drawString( "�ƽ�", 341, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s1, 341, 90);}
			
			g.setColor(Color.pink);
			g.fillRect(339, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 341, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s2, 341, 300);}
			
			g.setColor(Color.pink);	
			g.fillRect(490, 405, 30, 30);
			g.setColor(Color.BLACK);
			g.drawString("  �� ", 492, 425);
			
			g.setColor(Color.pink);
			g.fillRect(630, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s4, 632, 300);}
			
			g.setColor(Color.pink);
			g.fillRect(630, 70, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s5, 632, 90);}
			
			
			
		}else if(key==5){			//���缱��
			
			g.setColor(Color.pink);			//��ũ��
			g.fillRect(339, 70, 30, 30);	//�׸�׸�
			g.setColor(Color.BLACK);		//������
			if(re_bet==0){g.drawString( "�ƽ�", 341, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s1, 341, 90);}
			
			g.setColor(Color.pink);
			g.fillRect(339, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 341, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s2, 341, 300);}
			
			g.setColor(Color.pink);	
			g.fillRect(490, 405, 30, 30);
			g.setColor(Color.BLACK);
			g.drawString("����", 492, 425);
			
			
			g.setColor(Color.pink);
			g.fillRect(630, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s4, 632, 300);}
			
			g.setColor(Color.pink);
			g.fillRect(630, 70, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s5, 632, 90);}
			
			
		}else if(key==6){			//�ƽ�����
			
			g.setColor(Color.pink);			//��ũ��
			g.fillRect(339, 70, 30, 30);	//�׸�׸�
			g.setColor(Color.BLACK);		//������
			if(re_bet==0){g.drawString( "�ƽ�", 341, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s1, 341, 90);}
			
			g.setColor(Color.pink);
			g.fillRect(339, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 341, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s2, 341, 300);}
			
			g.setColor(Color.pink);
			g.fillRect(490, 405, 30, 30);
			g.setColor(Color.BLACK);
			g.drawString( "�ƽ�", 492, 425);//+2, +20	//�ƽ�����

			g.setColor(Color.pink);
			g.fillRect(630, 280, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 300); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s4, 632, 300);}
			
			
			g.setColor(Color.pink);
			g.fillRect(630, 70, 30, 30);
			g.setColor(Color.BLACK);
			if(re_bet==0){g.drawString( "�ƽ�", 632, 90); }//+2, +20	//�ƽ�����
			else{g.drawString(""+s5, 632, 90);}
			
		}
		
		if(state==6){
			if(key==1)money_change1(454);
			else if(key==2){		//üũ����
				//max();max();check();max();max();
				money_change6();money_change6();money_change2(454);money_change6();money_change6();
			}else if(key==3){		//�ݼ���
				//max();max();call();max();max();
				money_change6();money_change6();money_change3(454);money_change6();money_change6();
			}else if(key==4){			//�漱��
				//max();max();bbing();max();max();
				money_change6();money_change6();money_change4(454);money_change6();money_change6();
			}else if(key==5){			//���缱��
				//max();max();dadang();max();max();
				money_change6();money_change6();money_change5(454);money_change6();money_change6();
			}else if(key==6){			//�ƽ�����
				//max();max();max();max();max();
				money_change6();money_change6();money_change6(454);money_change6();money_change6();
			}
			
			
			
			pe++;
			if(pe==3){state=7;}
			
		}	//state == 6	//�ι������.
		
		if(state >=7){
			//player[i] = what_class(random_num_Array[i], random_num_Array[i+5]);
			//ǥ���� ��޿� �´� ���� ĥ�ϱ�.
			int draw_sign=100;
			if(player[2] == 10000) draw_sign =0;
			else if(player[2] ==9999  || 
					(player[2]<=101 && player[2] >=92 ) ){draw_sign =1;}
			else if(player[2] == 90) draw_sign =2;
			else if(player[2] == 89) draw_sign =3;
			else if(player[2] == 88) draw_sign =4;
			else if(player[2] == 87) draw_sign =5;
			else if(player[2] == 86) draw_sign =6;
			else if(player[2] == 85) draw_sign =7;
			else if(player[2] == 80) draw_sign =8;
			else if(player[2] <= 78 && player[2] >= 1) draw_sign =9;
			else if(player[2] == 91 || player[2] ==102 || player[2]==1002) draw_sign =10;
			else if(player[2] == 1003) draw_sign =11;
						
			g.setColor(Color.red);
			for(int i=0; i<12 ; i++){
				if(draw_sign == i){
					g.fillRect(271, 451+(17*i), 49, 16);
				}
			}
			g.setColor(Color.BLACK);
		}
		
		
		
		
		//pe�� 3�� �Ǿ���, �׷��Ƿ� state�� 7�̵�. ��� ī�带 �޴ºκ�.
		if(state==7){	

			//������ �޴� �ι�°ī��, for�ȿ� �δ� �ʰ� �׷����� �ۿ� �ξ���.
			g.drawImage(card_img[7], locate_x2[2], locate_y2[2], this);
			for(int i=0; i<5; i++){
				if(i==2){
					continue;
				}	
				//�ι�° ī����� �׷��ش�.(�ޱ׸�)
				g.drawImage(hide_img, locate_x2[i], locate_y2[i], this);
			}
			//�׸��� �׷����׷���(??�ֱ׷���) state7�κ��� ������ ����Ǿ�.
			po--;  	//�̷��κ��� �־���.
			if(po==0)po=1;	//�ᱹ�� po�� 1�� �ȴ�. 
			
			//System.out.println("po" + po);	//���� Ȯ��.
			//�̻��¿��� ��ư�� �ѹ��� ������ state�� 9�� �ȴ�.
			//���⼭ �ٷ� if(po==1)state=9; �̷��� �Ѿ�� �Ѵٸ�,
			//�и� �����ֱ����� �ι� �����̵ȴ�.
		}		//state==7
		if(state==9){	
			re_bet++;	//�̰��� ó�� ����ȴٸ�, 0=>1; �Ǹ�, ���� ���ù���ó���̴�.
			
			
			if(key==1)money_change1(454);
			else if(key==2){		//üũ����
				//���� ���ڸ� �־����� ���п����� Ȯ���� �����Ͽ� ������ �õ�.
				s1 = betting(player[0], player_order[0]);
				s2 = betting(player[1], player_order[1]);
				money_change2(454);
				s4 = betting(player[3], player_order[3]);
				s5 = betting(player[4], player_order[4]);
				//max();max();check();max();max();
				//money_change6();money_change6();money_change2();money_change6();money_change6();
			}else if(key==3){		//�ݼ���
				s1 = betting(player[0], player_order[0]);
				s2 = betting(player[1], player_order[1]);
				money_change3(454);
				s4 = betting(player[3], player_order[3]);
				s5 = betting(player[4], player_order[4]);
				//max();max();call();max();max();
				//money_change6();money_change6();money_change3(454);money_change6();money_change6();
			}else if(key==4){			//�漱��
				s1 = betting(player[0], player_order[0]);
				s2 = betting(player[1], player_order[1]);
				money_change4(454);
				s4 = betting(player[3], player_order[3]);
				s5 = betting(player[4], player_order[4]);
				//max();max();bbing();max();max();
				//money_change6();money_change6();money_change4(454);money_change6();money_change6();
			}else if(key==5){			//���缱��
				s1 = betting(player[0], player_order[0]);
				s2 = betting(player[1], player_order[1]);
				money_change5(454);
				s4 = betting(player[3], player_order[3]);
				s5 = betting(player[4], player_order[4]);
				//max();max();dadang();max();max();
				//money_change6();money_change6();money_change5(454);money_change6();money_change6();
			}else if(key==6){			//�ƽ�����
				s1 = betting(player[0], player_order[0]);
				s2 = betting(player[1], player_order[1]);
				money_change6(454);
				s4 = betting(player[3], player_order[3]);
				s5 = betting(player[4], player_order[4]);
				//max();max();max();max();max();
				//money_change6();money_change6();money_change6(454);money_change6();money_change6();
			}
			
			
			state=10;		//ī�带 �����ϴ� state10����
		}	//state==9
		
		//ī�����
		if(state==10){	//���ī�带 �����ش�.
			
			
			//ī�带 �׸��� "����"�� �Ȱ��� ������ �����ش�.
			for(int i=0; i<5; i++){
				if(s1 == "����" && i ==0){
					g.drawImage(hide_img, locate_x[0], locate_y[0], this);
					g.drawImage(hide_img, locate_x2[0], locate_y2[0], this);
					continue;
				}else if(s2 == "����" && i ==1){
					g.drawImage(hide_img, locate_x[1], locate_y[1], this);
					g.drawImage(hide_img, locate_x2[1], locate_y[1], this);
					continue;
				}else if(s4 == "����" && i ==3){
					g.drawImage(hide_img, locate_x[3], locate_y[3], this);
					g.drawImage(hide_img, locate_x2[3], locate_y2[3], this);
					continue;
				}else if(s5 == "����" && i ==4){
					g.drawImage(hide_img, locate_x[4], locate_y[4], this);
					g.drawImage(hide_img, locate_x2[4], locate_y2[4], this);
					continue;
				}
				g.drawImage(card_img[i], locate_x[i], locate_y[i], this);
				g.drawImage(card_img[i+5], locate_x2[i], locate_y2[i], this);
			}
			
			
			//�� ���� �־����� ��������� ��ȯ�ϴ� ���� �Լ� ȣ��.
			
			for(int i=0 ; i<5; i++){
				player[i] = what_class(random_num_Array[i], random_num_Array[i+5]);
				player_order[i] = i;
				class_name[i] = what_class_name(player[i]);
			}
			
			
			g.setFont(new Font("Serif", Font.BOLD, 18));
			if(s1!="����") g.drawString("" +class_name[0], 140, 200);
			else{ player[0] =0;}	//"����"��� ��꿡�� ���ܵȴ�.0�� ������.
			if(s2!="����") g.drawString("" +class_name[1], 140, 410);
			else{ player[1] =0;}	//"����"���
			//3g.drawString("" +class_name[1], 140, 410);
			if(s4!="����") g.drawString("" +class_name[3], 800, 410);
			else{player[3] =0; }	//"����"���
			if(s5!="����") g.drawString("" +class_name[4], 800, 200 );
			else{ player[4] =0;}	//"����"���
			
			//���� ������� ����
			int p_temp;
			int p_o_temp;
			String c_n_temp;
			for(int i=0; i<=3 ; i++){
				for(int j=i+1; j<=4 ; j++){
					if(player[i]<player[j]){
						p_temp = player[i];
						player[i] = player[j];
						player[j] = p_temp;
						
						p_o_temp = player_order[i];
						player_order[i] = player_order[j];
						player_order[j] = p_o_temp;
						
						c_n_temp = class_name[i];
						class_name[i] = class_name[j];
						class_name[j] = c_n_temp;
					}
				}
			}
			
			
			//System.out.println(player[0] + " " + player[1] + " " + player[2] + " " +player[3] + " " +player[4]);
			//System.out.println(player_order[0] + " " + player_order[1] + " " + player_order[2] + " " +player_order[3] + " " +player_order[4]);
			
			g.setFont(Win_Font);
			/*
			player[0] = 10000;
			player_order[0] = 2;
			class_name[0] = "���ȱ���";
			*/
			a++;
			////////////////////������ ũ�⸦ ������ ���и� �¿�.
			if(player[0]==10000){			//���ȱ��� �̸�
				if(player_order[0]==2)user_add_money++;
				g.drawString("**" +class_name[0] +"**", 400, 60);
				g.drawString(""+(player_order[0]+1)+ "p�� �¸�", 400, 100);
				sun = player_order[0];
				if(a==1)v_38kwang3();
				//System.out.println(player_order[0] + "�� �¸�");
			}else if(player[0]==9999){		//���� �̸�
				if(player_order[0]==2)user_add_money++;
				g.drawString("**" +class_name[0] +"**", 400, 60);
				g.drawString("" + (player_order[0]+1)+ "p�� �¸�", 400, 100);
				sun = player_order[0];
				if(a==1)v_kwang1();
				//System.out.println(player_order[0] + "�� �¸�");
			}else if(player[0]==1003){		//������ �̰�
				
				if(player[1]==101){			//player[1]��  �嶯�̸�
					if(player_order[0]==2)user_add_money++;
					g.drawString("**" +class_name[0] +"**", 400, 60);
					g.drawString(""+ (player_order[0]+1)+ "p�� �¸�", 400, 100);
					sun = player_order[0];
					//System.out.println(player_order[0] + "�� �¸�");
				}else if(player[1] == 102){	//player[1]�� ���ֱ����籸 �̸�
					g.drawString("**" +class_name[0] +"**", 400, 60);
					g.drawString("�� ��� ��� ����", 400, 100);
					//System.out.println("�� ��� ��� ����");
				}else if(player[1]<=100 && player[1]>=92){	//player[1]�� �涯~�����̸�
					if(player_order[1]==2)user_add_money++;
					g.drawString("**" +class_name[1] +"**", 400, 60);
					g.drawString(""+ (player_order[1]+1)+ "p�� �¸�", 400, 100);
					sun = player_order[1];
					//System.out.println(player_order[1] + "�� �¸�");
				}else if(player[1] == 91){
					g.drawString("**" +class_name[1] +"**", 400, 60);
					g.drawString("�� ��� ��� ����", 400, 100);
					//System.out.println("�� ��� ��� ����");
				}else if(player[1] <=90 && player[1]>=85){	//player[1]�� �˸� �����̰�
															//����̻��̸�
					if(player[1]==player[2]){	
						g.drawString("**" +class_name[1] +"**", 400, 60);
						g.drawString(""+(player_order[1]+1) +"p��"+ (player_order[2]+1)+"p�� ����", 400, 100);
						//System.out.println(player_order[1] +"��"+ player_order[2]+"�� ����");
					}else{				
						if(player_order[1]==2)user_add_money++;
						g.drawString("**" +class_name[1] +"**", 400, 60);
						g.drawString(""+(player_order[1]+1)+ "p�� �¸�", 400, 100);
						sun = player_order[1];
						//System.out.println(player_order[1] + "�� �¸�");
					}
				}else if(player[1] <=80){		//���������̸�
					if(player[1]==player[2]){	
						if(player[2] == player[3]){
							if(player[3] == player[4]){
								g.drawString("**" +class_name[1] +"**", 400, 60);
								g.drawString(""+(player_order[1]+1)+ "p��"+ (player_order[2]+1)+"p��"+ (player_order[3]+1)+"p��"+ (player_order[4]+1)+"p�� ����", 400, 100);
								//System.out.println(player_order[1]+ player_order[2]+player_order[3]+player_order[4] +"�� ����");
							}else{
								g.drawString("**" +class_name[1] +"**", 400, 60);
								g.drawString(""+(player_order[1]+1)+ "p��"+ (player_order[2]+1)+"p��"+ (player_order[3]+1)+"p�� ����", 400, 100);
								//System.out.println(player_order[1] +"��"+ player_order[2]+player_order[3]+"�� ����");
							}
						}else{
							g.drawString("**" +class_name[1] +"**", 400, 60);
							g.drawString(""+(player_order[1]+1)+ "p��"+ (player_order[2]+1)+"p�� ����", 400, 100);
							//System.out.println(player_order[1] +"��"+ player_order[2]+"�� ����");
						}
					}else{
						if(player_order[1]==2)user_add_money++;
						g.drawString("**" +class_name[1] +"**", 400, 60);
						g.drawString(""+(player_order[1]+1)+ "p�� �¸�", 400, 100);
						sun = player_order[1];
						//System.out.println(player_order[1] + "�� �¸�");
					}
				}	
			// ������
			}else if(player[0]==1002){	//��ĥ������ �̸�
				if(player[1]==101){
					if(player_order[1]==2)user_add_money++;
					g.drawString("**" +class_name[1] +"**", 400, 60);
					g.drawString(""+(player_order[1]+1)+ "p�� �¸�", 400, 100);
					sun = player_order[1];
					//System.out.println(player_order[1] + "�� �¸�");
				}else if(player[1]<=100 && player[1]>=92){
					if(player_order[0]==2)user_add_money++;
					g.drawString("**" +class_name[0] +"**", 400, 60);
					g.drawString(""+(player_order[0]+1)+ "p�� �¸�", 400, 100);
					sun = player_order[0];
					//System.out.println(player_order[0] + "�� �¸�");
				}else if(player[1] == 91 || player[1] == 102){
					g.drawString("**" +class_name[1] +"**", 400, 60);
					g.drawString("�� ��� ��� ����", 400, 100);
					//System.out.println("�� ��� ��� ����");
				}else if(player[1] <=90 && player[1]>=85){	//player[1]�� �˸� �����̰�
															//����̻��̸�
					if(player[1]==player[2]){
						g.drawString("**" +class_name[1] +"**", 400, 60);
						g.drawString(""+(player_order[1]+1)+ "p��"+ (player_order[2]+1)+"p�� ����", 400, 100);
						//System.out.println(player_order[1] +"��"+ player_order[2]+"�� ����");
					}else{		
						if(player[1]==2)user_add_money++;
						g.drawString("**" +class_name[1] +"**", 400, 60);
						g.drawString(""+(player_order[1]+1)+ "p�� �¸�", 400, 100);
						sun = player_order[1];
						//System.out.println(player_order[1] + "�� �¸�");
					}
				}else if(player[1] <=80){		//���������̸�
					if(player[1]==player[2]){	
						if(player[2] == player[3]){
							if(player[3] == player[4]){
								g.drawString("**" +class_name[1] +"**", 400, 60);
								g.drawString(""+(player_order[1]+1)+ "p��"+ (player_order[2]+1)+"p��"+ (player_order[3]+1)+"p��"+ (player_order[4]+1)+"p�� ����", 400, 100);
								//System.out.println(player_order[1]+ player_order[2]+player_order[3]+player_order[4] +"�� ����");
							}else{
								g.drawString("**" +class_name[1] +"**", 400, 60);
								g.drawString(""+(player_order[1]+1)+ "p��"+ (player_order[2]+1)+"p��"+ (player_order[3]+1)+"p�� ����", 400, 100);
								//System.out.println(player_order[1] +"��"+ player_order[2]+player_order[3]+"�� ����");
							}
						}else{
							g.drawString("**" +class_name[1] +"**", 400, 60);
							g.drawString(""+(player_order[1]+1)+ "p��"+ (player_order[2]+1)+"p�� ����", 400, 100);
							//System.out.println(player_order[1] +"��"+ player_order[2]+"�� ����");
						}
						
					}else{
						if(player_order[1]==2)user_add_money++;
						g.drawString("**" +class_name[1] +"**", 400, 60);
						g.drawString(""+(player_order[1]+1)+ "p�� �¸�", 400, 100);
						sun = player_order[1];
						//System.out.println(player_order[1] + "�� �¸�");
					}
				}
			// ��ĥ������
			}else if(player[0]==102){		//���ֱ����籸
				g.drawString("**" +class_name[0] +"**", 400, 60);
				g.drawString("�� ��� ��� ����", 400, 100);
				//System.out.println("�� ��� ��� ����");
			}else if(player[0]==91){		//����籸
				g.drawString("**" +class_name[0] +"**", 400, 60);
				g.drawString("�� ��� ��� ����", 400, 100);
				//System.out.println("�� ��� ��� ����");
			}else if(player[0] <=101 && player[0]>=92){	//���̸�//�������� �ϳ��� ���ü� ����.
				if(player_order[0]==2)user_add_money++;
				g.drawString("**" +class_name[0] +"**", 400, 60);
				g.drawString(""+(player_order[0]+1)+ "p�� �¸�", 400, 100);
				sun = player_order[0];
				//System.out.println(player_order[0] + "�� �¸�");
				
			}else if(player[0] <=90 && player[0]>=85){	//�˸� �����̰�
														//����̻��̸�
				if(player[0]==player[1]){	//�˸�~����� �����а� �ι������� ���ü� ����.
					g.drawString("**" +class_name[0] +"**", 400, 60);
					g.drawString(""+(player_order[0]+1)+ "p��"+ (player_order[1]+1)+"p�� ����", 400, 100);
					//System.out.println(player_order[0] +"��"+ player_order[1]+"�� ����");
				}else{	
					if(player[0]==2)user_add_money++;
					g.drawString("**" +class_name[0] +"**", 400, 60);
					g.drawString(""+(player_order[0]+1)+ "p�� �¸�", 400, 100);
					sun = player_order[0];
					//System.out.println(player_order[0] + "�� �¸�");
				}
				
			}else if(player[0] <=80){		//���������̸�
				if(player[0]==player[1]){	
					if(player[1] == player[2]){
						if(player[2] == player[3]){
							if(player[3] == player[4]){
								g.drawString("**" +class_name[0] +"**", 400, 60);
								g.drawString(""+(player_order[0]+1)+ "p��"+ (player_order[1]+1)+"p��"+ (player_order[2]+1)+"p��"+ (player_order[3]+1)+(player_order[4]+1)+"p�� ����", 400, 100);
								//System.out.println(player_order[0]+ player_order[1]+player_order[2]+player_order[3]+player_order[4] +"�� ����");
							}else{
								g.drawString("**" +class_name[0] +"**", 400, 60);
								g.drawString(""+(player_order[0]+1)+ "p��"+ (player_order[1]+1)+"p��"+ (player_order[2]+1)+"p��"+ (player_order[3]+1)+"p�� ����", 400, 100);
								//System.out.println(player_order[0]+ player_order[1]+player_order[2]+player_order[3] +"�� ����");
							}							
						}else{
							g.drawString("**" +class_name[0] +"**", 400, 60);
							g.drawString(""+(player_order[0]+1)+ "p��"+ (player_order[1]+1)+"p��"+ (player_order[2]+1)+"p�� ����", 400, 100);
							//System.out.println(player_order[0] +"��"+ player_order[1]+player_order[2]+"�� ����");
						}
					}else{
						g.drawString("**" +class_name[0] +"**", 400, 60);
						g.drawString(""+(player_order[0]+1) +"p��"+ (player_order[1]+1)+"p�� ����", 400, 100);
						//System.out.println(player_order[0] +"��"+ player_order[1]+"�� ����");
					}
					
				}else{
					if(player_order[0]==2)user_add_money++;
					g.drawString("**" +class_name[0] +"**", 400, 60);
					g.drawString(""+(player_order[0]+1)+ "p�� �¸�", 400, 100);
					sun = player_order[0];
					//System.out.println(player_order[0] + "�� �¸�");
				}
			}
			////////////////////������ ũ�⸦ ������ ���и� �¿�.
			
			
			
			
			
			
			if(user_add_money==1){	//�̱�� ���� ����.
				//��� = (�ѹ���) - (���þ�)
				//��� = (ó����  + �ǵ�) - (ó���� - ������ ó����)
				u_money = (before_money + pan_money)-(before_money -u_money);
				System.out.println("u_money = " + u_money);
				
				
				
				//FileOutputStream fos = new FileOutputStream("read.txt");
				//DataOutputStream dos = new DataOutputStream(fos);
				
				//dos.writeInt(10000000);
				//dos.writeByte(0);
				//fos.close();
			}
			
			connect =11;
			end=10;	//end�� 10�̵Ǹ� ��ư�� ������ ��������
		}	//state==10
		
		
		
		//	������, �̵�ս�, �Ѿ�, ���þ� //repaint�� �Ź� �׷�����.
		g.setColor(Color.BLACK);
		g.setFont(new Font("Serif", Font.BOLD, 19));
		g.drawString("" + u_money, 550, 635);
		
		g.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
		g.setColor(Color.RED);
		g.drawString("" + cal_money, 550, 655);
		
		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD, 23));
		g.drawString("��      ��  :     " + pan_money, 380, 360);
		
		g.setFont(new Font("Serif", Font.CENTER_BASELINE, 23));
		g.drawString("�� �� ��  :     " + bet_money, 380, 400);
		
		
			
		if(state ==0){	//ó���� state�� 0�̴�.
			//��ư�� ��ġ �� ũ�� ����.
			bt1.setBounds(700, 480, 80, 60);
			bt2.setBounds(790, 480, 80, 60);
			bt3.setBounds(880, 480, 80, 60);
			bt4.setBounds(700, 550, 80, 60);
			bt5.setBounds(790, 550, 80, 60);
			bt6.setBounds(880, 550, 80, 60);
			
			//��ư�� �����ʿ� �߰�
			bt1.addActionListener(this);
			bt2.addActionListener(this);
			bt3.addActionListener(this);
			bt4.addActionListener(this);
			bt5.addActionListener(this);
			bt6.addActionListener(this);
			
			//�ǳڿ� ��ư ���̱�.
			this.add(bt1);	
			this.add(bt2);
			this.add(bt3);
			this.add(bt4);
			this.add(bt5);
			this.add(bt6);
			
		}	//state == 0
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
		
		if(sun == 2){		//����ڰ� ���϶�
			if(ae.getSource()==bt1){	//����
				if(end!=10){
					 connect =11;
					 end=10;
				}
			}else if(ae.getSource()==bt2){	//üũ
				if(end!=10){
					key=2;
					if(state==0)state=6;	//�ƽ��� ������������ state6����
					if(po==1)state=9;		//���ī�带 ������ po1�̵ȴ�.
											//state9���� ������������, state10����..
					repaint();
				}
				
			}else if(ae.getSource()==bt3){	//��
				if(end!=10){
					key=3;
					if(state==0)state=6;	//�ƽ��� ������������ state6����
					if(po==1)state=9;		//���ī�带 ������ po1�̵ȴ�.
											//state9���� ������������, state10����..
					repaint();
				}
			}else if(ae.getSource()==bt4){	//��
				if(end!=10){
					key=4;
					if(state==0)state=6;	//�ƽ��� ������������ state6����
					if(po==1)state=9;		//���ī�带 ������ po1�̵ȴ�.
											//state9���� ������������, state10����..
					repaint();
				}
			}else if(ae.getSource()==bt5){	//����
				if(end!=10){
					key=5;
					if(state==0)state=6;
					if(po==1)state=9;
					repaint();
				}
				
			}else if(ae.getSource()==bt6){	//�ƽ�
				if(end!=10){
					key=6;
					if(state==0)state=6;	//�ƽ��� ������������ state6����
					if(po==1)state=9;		//���ī�带 ������ po1�̵ȴ�.
											//state9���� ������������, state10����..
					repaint();
				}
			}
		}else{			//����ڰ� ���� �ƴҶ�
			if(ae.getSource()==bt1){	//����
				if(end!=10){
					connect =11;
					end=10;
				}
			}else if(ae.getSource()==bt3){	//��
				if(end!=10){
					key=3;
					if(state==0)state=6;	//�ƽ��� ������������ state6����
					if(po==1)state=9;		//���ī�带 ������ po1�̵ȴ�.
											//state9���� ������������, state10����..
					repaint();
				}
			}else if(ae.getSource()==bt5){	//����
				if(end!=10){
					key=5;
					if(state==0)state=6;
					if(po==1)state=9;
					repaint();
				}
				
			}else if(ae.getSource()==bt6){	//�ƽ�
				if(end!=10){
					key=6;
					if(state==0)state=6;	//�ƽ��� ������������ state6����
					if(po==1)state=9;		//���ī�带 ������ po1�̵ȴ�.
											//state9���� ������������, state10����..
					repaint();
				}
			}
		}
		
		
		
			
	}
	
	////////��ǻ�� ����
	public void money_change0(){	//�Ĵ���
		die();
		//�����ϸ� ���~�ȴ�.
	}
	
	
	public void money_change2(){	//üũ
		check();
	}
	
	public void money_change3(){	//��
		call();
		pan_money = pan_money + bet_money;	//+bet
	}
	public void money_change4(){	//��
		bbing();
		bet_money += 20;			//20���߰�
		pan_money = pan_money + bet_money;	
	}
	public void money_change5(){	//����
		dadang();
		bet_money += (bet_money/2);	// ���þ� bet/2��
		pan_money = pan_money + bet_money;	
	}
	
	public void money_change6(){	//�ƽ�
		max();
		bet_money *= 2;	// ���þ� 2��
		pan_money = pan_money + bet_money;	
	}
	////////��ǻ�� ����
	
	///////����� ����
	public void money_change1(int user){	//����
		die();
		//connect=11;
						//��������
	}
	public void money_change2(int user){	//üũ
		check();
	}
	public void money_change3(int user){	//��
		call();
		u_money -= bet_money;	//�ڱ� = �ڱ� - ���þ�
		pan_money = pan_money + bet_money;	//+bet
		
	}
	public void money_change4(int user){	//��
		bbing();
		bet_money += 20;			//20���߰�
		pan_money = pan_money + bet_money;	
	}
	public void money_change5(int user){	//����
		dadang();
		
		bet_money += (bet_money/2);	// ���þ� bet/2��
		u_money -= bet_money;	
		pan_money = pan_money + bet_money;	
	}
	public void money_change6(int user){	//�ƽ�
		max();
		
		bet_money *= 2;	// ���þ� 2��
		u_money -= bet_money;	
		pan_money = pan_money + bet_money;	
	}
	///////����� ����
	
	//���üҸ���
	public void die(){
		playSound("����.wav");
		try{
			Thread.sleep(400);	//�����̽ð�.
		}catch(Exception e){}
	}
	public void check(){	
		playSound("üũ.wav");
		try{
			Thread.sleep(400);	//�����̽ð�.
		}catch(Exception e){}
		
	}
	public void bbing(){
		playSound("��.wav");
		try{
			Thread.sleep(400);
		}catch(Exception e){}
		
	}
	public void call(){
		playSound("��.wav");
		try{
			Thread.sleep(400);
		}catch(Exception e){}
		
	}
	public void dadang(){
		playSound("����.wav");
		try{
			Thread.sleep(400);
		}catch(Exception e){}
		
	}
	public void max(){
		playSound("�ƽ�.wav");
		try{
			Thread.sleep(400);//
		}catch(Exception e){}
		
	}
	public void v_38kwang3(){
		playSound("v_38kwang3.wav");
	}
	public void v_kwang1(){
		playSound("v_kwang1.wav");
	}
	
	public int what_class(int num1, int num2){
		int result=0;
		
		if(num1>num2){
			int temp;
			temp=num1;
			num1=num2;
			num2=temp;
		}
		//System.out.println("num1 = "+num1);
		//System.out.println("num2 = "+num2);
		if(num1 ==5 && num2 == 15){
			result = 10000;	//38����
		}else if( (num1 ==1 && num2 ==5) || (num1==1 && num2 ==15)){
			result = 9999;	//����
		}else if(num1 == 19 && num2 == 20){
			result = 101;		//�嶯
		}else if(num1 == 17 && num2 == 18){
			result = 100;		//����
		}else if(num1 == 15 && num2 == 16){
			result = 99;		//�ȶ�
		}else if(num1 == 13 && num2 == 14){
			result = 98;		//ĥ��
		}else if(num1 == 11 && num2 == 12){
			result = 97;		//����
		}else if(num1 == 9 && num2 == 10){
			result = 96;		//����
		}else if(num1 == 7 && num2 == 8){
			result = 95;		//�綯
		}else if(num1 == 5 && num2 == 6){
			result = 94;		//�ﶯ
		}else if(num1 == 3 && num2 == 4){
			result = 93;		//�̶�
		}else if(num1 == 1 && num2 == 2){
			result = 92;		//�涯////////////////////////
		}else if( (num1 ==7 && num2 ==18) || (num1==8 && num2 ==18) ){
			result = 91;		//����籸(�����籸)
		}else if( (num1 ==7 && num2 ==17) || (num1==8 && num2 ==17) ){
			result = 102;		//���ֱ����籸(�����籸)
		}else if(num1 == 5 && num2 == 13){
			result = 1002;	//��ĥ������
		}else if(num1 == 7 && num2 == 13){
			result = 1003;	//������/////////////////////
		}else if( (num1 ==1 && num2 ==3) || (num1==1 && num2 == 4) ||
				  (num1 ==2 && num2 ==3) || (num1==2 && num2 == 4) ){
			result = 90;		//�˸�
		}else if( (num1 ==1 && num2 ==7) || (num1==1 && num2 == 8) ||
				  (num1 ==2 && num2 ==7) || (num1==2 && num2 == 8) ){
			result = 89;		//����
		}else if( (num1 ==1 && num2 ==17) || (num1==1 && num2 == 18) ||
				  (num1 ==2 && num2 ==17) || (num1==2 && num2 == 18) ){
			result = 88;		//����
		}else if( (num1 ==1 && num2 ==19) || (num1==1 && num2 == 20) ||
				  (num1 ==2 && num2 ==19) || (num1==2 && num2 == 20) ){
			result = 87;		//���
		}else if( (num1 ==7 && num2 ==19) || (num1==7 && num2 == 20) ||
				  (num1 ==8 && num2 ==19) || (num1==8 && num2 == 20) ){
			result = 86;		//���
		}else if( (num1 ==7 && num2 ==11) || (num1==7 && num2 == 12) ||
				  (num1 ==8 && num2 ==11) || (num1==8 && num2 == 12) ){
			result = 85;		//���
		}
		
		if(result <85){
			if(num1 %2 ==1) num1++;
			if(num2 %2 ==1) num2++;
			int num3 = (num1/2)+(num2/2);
			if(num3 >= 10)num3 = num3 - 10; //10�� ���ش�.
			
			if (num3 == 9){
				result = 80;		//����
			}else if (num3 == 8){
				result = 78;		//������
			}else if (num3 == 7){
				result = 77;		//�ϰ���
			}else if (num3 == 6){
				result = 76;		//������
			}else if (num3 == 5){
				result = 75;		//�ټ���
			}else if (num3 == 4){
				result = 74;		//�ײ�
			}else if (num3 == 3){
				result = 73;		//����
			}else if (num3 == 2){
				result = 72;		//�β�
			}else if (num3 == 1){
				result = 71;		//�Ѳ�
			}else if (num3 == 0){
				result = 1;		//����
			}
		}
		
		return result;
	}
	
	public String what_class_name(int number){
		String name = "";
		
		if(number == 10000){
			name = "���ȱ���";
		}else if(number == 9999){
			name = "����";
		}else if(number == 1003){
			name = "������";
		}else if(number == 1002){
			name = "��ĥ������";
		}else if(number == 102){
			name = "���ֱ����籸";
		}else if(number == 101){
			name = "�嶯";
		}else if(number == 100){
			name = "����";
		}else if(number == 99){
			name = "�ȶ�";
		}else if(number == 98){
			name = "ĥ��";
		}else if(number == 97){
			name = "����";
		}else if(number == 96){
			name = "����";
		}else if(number == 95){
			name = "�綯";
		}else if(number == 94){
			name = "�ﶯ";
		}else if(number == 93){
			name = "�̶�";
		}else if(number == 92){
			name = "�϶�";
		}else if(number == 91){
			name = "�籸";
		}else if(number == 90){
			name = "�˸�";
		}else if(number == 89){
			name = "����";
		}else if(number == 88){
			name = "����";
		}else if(number == 87){
			name = "���";
		}else if(number == 86){
			name = "���";
		}else if(number == 85){
			name = "���";
		}else if(number == 80){
			name = "����";
		}else if(number == 78){
			name = "������";
		}else if(number == 77){
			name = "�ϰ���";
		}else if(number == 76){
			name = "������";
		}else if(number == 75){
			name = "�ټ���";
		}else if(number == 74){
			name = "�ײ�";
		}else if(number == 73){
			name = "����";
		}else if(number == 72){
			name = "�β�";
		}else if(number == 71){
			name = "�Ѳ�";
		}else if(number == 1){
			name = "����";
		}
		//����
		//else if(number == 0){
		//	name = "����";
		//}
		
		return name;
	}
	
	//re_bet==1���� �п� �´� ������ �ϴµ� �׸��� �µ���..
	//draw_betting(player[0]);
	//draw_betting(player[1]);
	//draw_betting(player[2]);
	//draw_betting(player[3]);
	//draw_betting(player[4]); ������ ���ٰ� ��ȯ��.
	public String betting(int num, int user_num){	//��ǻ���� ���� ����
		String what_choice="";
		int probability;
		Random rand = new Random();
		probability = Math.abs(rand.nextInt())%100 + 1;	//1~100�� �ϳ�
		if(re_bet == 1 && sun == user_num){	//��ǻ���� ���� �Ҽ� �ִ� ����
			if(num == 1003){					//������
				if(probability <=70){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�	70%
				}else if(probability <=90){
					what_choice ="��";
					money_change3();	//��		20%
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����	10%
				}						
			}else if(num ==1002){				//��ĥ������
				if(probability <=80){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=95){
					what_choice ="��";
					money_change3();	//��	
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}		
			}else if(num == 102){				//���ֱ����籸
				if(probability <=50){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=80){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <=84){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability <= 87){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 90){
					what_choice ="��";
					money_change4();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num == 91){				//�籸
				if(probability <=40){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=70){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <=74){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability <= 77){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 80){
					what_choice ="��";
					money_change4();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=10000 && num >= 99){	//���ȱ������� �ȶ�����
				if(probability <=96){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability ==97){
					what_choice ="��";
					money_change3();	//��
				}else if(probability ==98){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability == 99){
					what_choice ="����";
					money_change5();	//����
				}else if(probability == 100){
					what_choice ="��";
					money_change4();	//��
				}						//���̴� ����
				
			}else if(num <=98 && num >=96){					//ĥ��~��������
				if(probability <=96){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability ==97){
					what_choice ="��";
					money_change3();	//��
				}else if(probability ==98){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability == 99){
					what_choice ="����";
					money_change5();	//����
				}else if(probability == 100){
					what_choice ="��";
					money_change4();	//��
				}						//���̴� ����
			}else if(num <=95 && num >=92){		//�綯~�涯����
				if(probability <=90){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=94){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <=96){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability <= 98){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 100){
					what_choice ="��";
					money_change4();	//��
				}
			}else if(num <=90 && num >= 88){	//�˸�~����
				if(probability <=75){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=89){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <=93){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability <= 96){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 99){
					what_choice ="��";
					money_change4();	//��
				}else if(probability == 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=87 && num >= 85){	//���~���
				if(probability <=44){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=86){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <=90){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability <= 93){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 96){
					what_choice ="��";
					money_change4();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=80 && num >= 78){	//����~������
				if(probability <=11){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=61){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <=65){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability <= 68){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 71){
					what_choice ="��";
					money_change4();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=77 && num >= 75){	//�ϰ���~�ټ���
				if(probability <=4){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=17){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <=21){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability <= 24){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 27){
					what_choice ="��";
					money_change4();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=74 && num >= 1){	//�ײ�~����
				if(probability <=2){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=10){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <=14){
					what_choice ="üũ";
					money_change2();	//üũ
				}else if(probability <= 17){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 20){
					what_choice ="��";
					money_change4();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}
		}else{			//��ǻ���� ���� ���� �ƴ� ��
			if(num == 1003){					//������
				if(probability <=70){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=90){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change5();	//����
				}
			}else if(num ==1002){				//��ĥ������
				if(probability <=80){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=95){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change5();	//����
				}
			}else if(num == 102){				//���ֱ����籸
				if(probability <=54){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=87){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 90){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num == 91){				//�籸
				if(probability <=44){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=77){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 80){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=10000 && num >= 99){	//���ȱ������� �ȶ�����
				if(probability <=97){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=99){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change5();	//����
				}
			}else if(num <=98 && num >=96){					//ĥ��~��������
				if(probability <=97){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=99){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change5();	//����
				}
			}else if(num <=95 && num >=92){		//�綯~�涯����
				if(probability <=92){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=98){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 100){
					what_choice ="����";
					money_change5();	//����
				}
			}else if(num <=90 && num >= 88){	//�˸�~����
				if(probability <=79){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=96){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <=99){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <=100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=87 && num >= 85){	//���~���
				if(probability <=48){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=93){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 96){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=80 && num >= 78){	//����~������
				if(probability <=15){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=68){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 71){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=77 && num >= 75){	//�ϰ���~�ټ���
				if(probability <=8){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=24){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 27){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}else if(num <=74 && num >= 1){	//�ײ�~����
				if(probability <=6){
					what_choice ="�ƽ�";
					money_change6();	//�ƽ�
				}else if(probability <=17){
					what_choice ="��";
					money_change3();	//��
				}else if(probability <= 20){
					what_choice ="����";
					money_change5();	//����
				}else if(probability <= 100){
					what_choice ="����";
					money_change0();	//����
				}
			}
		}
		return what_choice;
	}
	
	public int getu_money(){
		return u_money;
	}
	public int get_connect(){
		return connect;
	}
	public int get_sun(){
		return sun;
	}
	
	//����  �޼ҵ�.
	public void playSound(String file_url)
	{
		try{
			File file = new File(file_url);
			FileInputStream fis = new FileInputStream(file);
			AudioStream as = new AudioStream(fis);
			AudioPlayer.player.start(as);
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("sound exception");
		}
	}
	public static void main(String[] args) throws IOException{
		
		while(true){
			boolean available = false;
			Sutda su;
			
			JFrame f = new JFrame("Sutda"); //JFrame�� �ϳ� ������ ��
			FileInputStream fis = new FileInputStream("read.txt");
			DataInputStream dis = new DataInputStream(fis);
			int money = dis.readInt();
			int order = dis.read();
			dis.close();
			su = new Sutda(money, order); //JPanel�� ��ӹ��� SwingImage ��ü ����
				
			f.setTitle("����");
			f.getContentPane().add(su); //ContentPane�� SwingImage  ��ü�� �ֽ��ϴ�.
			f.setSize(1000, 700);
			f.show();
				
			while(true){
					if(su.get_connect() == 11) {available =true;break;}
					else{	//state 11�� �ƴϸ�
						
							
							try{
								Thread.sleep(1000);	//�����̽ð�.
							}catch(Exception e){}
							
						
					}
			}
				
			if(available == true){
				FileOutputStream fos = new FileOutputStream("read.txt");
				DataOutputStream dos = new DataOutputStream(fos);
				
				dos.writeInt(su.getu_money());
				dos.writeByte(su.get_sun());
				fos.close();
			}
			try{
				Thread.sleep(3500);	//�����̽ð�.
			}catch(Exception e){}
			f.dispose();

		}
		
		
		
	}
	
}


