/*3. ������ �����Ѵ�*/
package animal;

public class Sparrow extends Bird{

	String name = "�� ����";

	public void jjack(){
		System.out.println("±±");
	}
	//�ڽ�Ŭ�������� �θ�� 100% ������ �޼��带 �����ϴ� ����� �������̵��̶� �Ѵ� (Overriding)
	//�� �����ϴ°�? �θ��� �޼��带 �ڽĿ��� ����� ����, �߰��ϴ� ���� ���׷��̵� �ϰ������
	/*
	!!!����!!!
		�����ε� vs �������̵�
		�����ε��� ���� Ŭ����������... ����� ����� �޼������ ���� ���� ������ ����
		�Ű����� ������ �ڷ������� �����ϸ� �ߺ����Ǹ� �������ְڴ�
		�������̵��� ��Ӱ��迡��... �ڽ��� �θ��� �޼��带 �������ϴ� ���
	*/

	public void fly(){
		System.out.println("������ ���ƿ�");
	}
	
	public static void main(String[] args){
		Sparrow sp = new Sparrow();
		sp.fly();		//������ �޼��� ȣ��

		Bird bird = new Bird();
		bird.fly();	//���� �޼��� ȣ��

		Bird bird2 = new Sparrow();
		bird2.fly();

	}
}
