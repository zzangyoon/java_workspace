//2
package animal;

public class Duck extends Bird{
	/*Duck is a Bird*/
	/*Duck���� Bird���̴�*/
	/*������ ����*/
	String name = "���� ����";

	public void quack(){
		System.out.println("�в�");
	}

	public static void main(String[] args){
		Duck d1 = new Duck();
		Duck d2 = new Duck();

		Bird b = new Bird();

		//b = d1;	����
		//b = new Duck();	����
		/*
		byte k = 5;
		short s = 8;
		k=s;	//�Ұ� : �����ڷ������� ū �ڷ������� �������� �ϹǷ�... �ս��� �߻��ϰԵ�
				//�ذ�å1) k�� short �̻��� ũ�⸦ ���� �ڷ������� ����
				//�ذ�å2) �ս��� �����ϰ� ������(��������ȯ) : k = (byte)s;
				//	demotion
		*/
		//��ü�ڷ����� �ڷ����̴�!!!
		Duck a = new Duck();
		Bird r = new Bird();
		r = a;	//�����ڷ����� ū �ڷ����� �������� �ϴϱ� ���� (ū <- ��)
		a = r;	//ū�ڷ����� �����ڷ����� �������� �ϴϱ� �Ұ��� (�� <- ū)		:	down casting
					//�ذ�å) a = (Duck)r;

		r = (Bird)a;	//�����ڷ������� ū �ڷ������� �ö�		:	up casting

		//��� : ��ü�ڷ����� �ڷ����̹Ƿ�, �⺻�ڷ����� ��Ģ�� ���κ� �״�� ����ǰ� �ִ�
	}
}
