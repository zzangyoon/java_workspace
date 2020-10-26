//5.
package event;

import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.Choice;

class MyWin extends Frame{
					/*MyWin is a Frame*/
	Button bt;	//MyWin has a bt
	TextField t;
	Choice ch;	//html������ select�ڽ��� ����

	public MyWin(){
		bt = new Button("�� ������");
		t = new TextField(15);
		ch = new Choice();

		//ch�� ������ ä���
		ch.add("Java Programming");
		ch.add("JSP Programming");
		ch.add("Android Programming");
		ch.add("Spring Framework");
		ch.add("Mybatis Framework");


		this.setLayout(new FlowLayout());
		//��ư�� �����쿡 ����!
		this.add(bt);	//�������� ����Ʈ�� BorderLayout�̹Ƿ�, ���Ϳ����� ũ�� ��������
		this.add(t);
		this.add(ch);

		bt.addActionListener(new MyListener());	//��ư�� ������ ����!
		t.addKeyListener(new MyKey());				//�ؽ�Ʈ�ڽ��� ������ ����!
		this.addMouseListener(new MyMouse());	//�����Ӱ� ������ ����!
		ch.addItemListener(new MyItem());			//���̽��� ������ ����!
		this.addWindowListener(new MyWindowListener());

		this.setSize(300,400);
		this.setVisible(true);
		
	}
	public static void main(String[] args){
		new MyWin();
	}
}
