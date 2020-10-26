/*1.
�����쿡 �� �� �ִ� ���� ������Ʈ �˾ƺ���
	ex) ��ư, �ؽ�Ʈ�ʵ�, �����ڽ�, üũ�ڽ�, ���̽�, �̹���, textarea...
*/
package gui;
import java.awt.Frame;	//����Ϸ��� Ŭ������ ��ġ ���
									//��򰡿� .class�� �����ϱ� ������ ��밡���� ���̴�
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Image;
import java.awt.Toolkit;

class App1{
	public static void main(String[] args){
	/*������ ����*/

	/* ����ó�� ���� Ŭ������ �������� ��ó��
		��ó�� 1) "����Ϸ��� Ŭ������ ���� � �������� �����Ǵ� ������ �� �뵵�� �ľ��ؾ� �Ѵ�"
		��ó�� 2) "�ڹ��� ��� ��ü�� �ᱹ 3���� �����ۿ� ����"
		��ó�� 3) "Ŭ������ ����� ���� ���̴�, ���� �޸𸮿� �ø��� ���� �˸�ȴ�"
			1. �Ϲ�Ŭ���� : new �ϸ� �ȴ�! new ���� ����������(api������ ����)
			2. �߻�Ŭ���� : new �Ұ��ϹǷ�, �ڽ��� �����ؼ� new�ϰų� �̹� ������ �ν��Ͻ��� �̿��ϸ� �ȴ� (api���� ����)
			3. �������̽� : new �Ұ��ϹǷ�, �ڽ��� �����ؼ� new�ϰų� �̹� ������ �ν��Ͻ��� �̿��ϸ� �ȴ� (api���� ����)
	*/

	//ó��������, �Ϲ��̱� ������ new ������ ���� �����ڸ� �����ؼ� ����ϸ��
		Frame frame = new Frame();	//�ڹ� ���������α׷��ֿ����� ������!
		//�������� ����Ʈ�� ���� ������ �ʴ� ������, ���� ���̵��� �޼��� ȣ��!
		frame.setVisible(true);	//Window ��ü�κ��� ��ӹ��� �޼���
		//�Ű������δ� ������ ����� �� �ִ�
		//�������� �ʺ�, ���̸� ������ �� �ִ� �޼��� ã��
		frame.setSize(300,400);	//api ã�ƺ���
		
		//�����찡 �����Ǿ����Ƿ�, ������ �ȿ� ��ġ�� ���� ������Ʈ �÷����ƺ���
		//��ư Button(�Ϲ�, �߻�, �������� ��, �Ϲ� new ����������)
		Button bt = new Button("����ư");	//��ư����

		//��ư�� �����ϱ� ����, ���̾ƿ� ��Ÿ���� �����ؾ� �ϴµ�, ���̾ƿ��� ���� �����̹Ƿ�
		//�ϴ� FlowLayout�� ����غ���
		FlowLayout flow= new FlowLayout();
		frame.setLayout(flow);

		frame.add(bt);	//��ư�� ������ �����̳ʿ� ����
		//add�޼����� �Ű������� Component���̹Ƿ�, Button�� Component�� �ڽ��̱� ������ ���� �ڷ����� �ش��Ͽ�,
		//add()�� �μ��� �� �� �ִ�!!!

		//html ������ input type = "text"�� �ڹٿ����� TextField �� �Ѵ�
		TextField t= new TextField("ȸ������", 10);
		frame.add(t);

		//Checkbox
		Checkbox ch1 = new Checkbox("����");
		Checkbox ch2 = new Checkbox("����");
		Checkbox ch3 = new Checkbox("��ǻ��");
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);

		//TextArea
		TextArea area = new TextArea(5,20);	//5��, 20��
		frame.add(area);

		//�׳� �ؽ�Ʈ
		Label la = new Label("ȸ������ ����Դϴ�");
		frame.add(la);

		//�̹��� �ֱ�
		//Image�� �߻�Ŭ�����̸�, �÷���(win, mac, linux)�� ������ ������� ���� �� �ִ�
		//�÷����� �°� ���������� DefaultToolkit Ŭ�����κ��� �ڿ��� ���� �Ѵ�
		Toolkit kit = Toolkit.getDefaultToolkit();	//static �޼���!! ���� Ŭ���������� ������ �� �ִ�
		//��Ŷ�� �̹����� ���û��� ��ηκ��� ���� �� �ִ�
		//��λ��� ������ �� : �������ô� ������os ������ ����ϴ� ǥ���̹Ƿ�,
		//���� �� �ڹ��ڵ尡 ��� os����Ƿ���, ��� �߸����� ��η� �����Ѵ� (���������� �������� �ٲ��ش�)
		Image img = kit.getImage("C:/workspace/java_workspace/project1026/res/1.png");
		System.out.println("�̹��� �ּҰ��� "+img);	//null������ �� �����°���

		//ȭ�鿡 ����ϴ� ������ ���� �Ұ�... ��?
		//���ݱ��� html������ �̹����� html������ ���ٿ��� ����������,
		//�ڹٿ� ���� �Ϲ����� ������ ����� ���α׷��� ������ ������(�����׸��� �۾�)�� �ؾ��ϱ� �����̴�
	}
}
