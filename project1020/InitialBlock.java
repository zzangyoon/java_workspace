/* �ʱ�ȭ �� */
class InitialBlock{
	int sum=0;

	//�ν��Ͻ��� �����ɶ� �ݺ����� ������ ������ �־��ְ� �ʹ�
	//Ŭ�������� ����, �޼��常 ������ �� �ִ�
	
	//��������ȿ� {����ȭ} ������ �� ���� �ǹ̴�?
	{
		for(int i=1; i<=10; i++){
			sum += i;
		}
		
		
		//�� Ŭ������ �ν��Ͻ��� �����ɶ����� �� ������ ȣ���ϰ� ��
		//�ν��Ͻ� �ʱ�ȭ ���̶� �Ѵ�
		System.out.println("�ν��Ͻ� �ʱ�ȭ �� ȣ��" + sum);
	}
	//static �ʱ�ȭ ��
	//main() �޼��忡 ���� ����Ǳ� ������, ����Ǵ� �ʱ�ȭ ��
	static{
		System.out.println("�����ϱ��� �ʱ�ȭ �� �����ϰڽ��ϴ�");
		System.out.println("A");
	}

	public static void main(String[] args){
		System.out.println("B");
		new InitialBlock();
		new InitialBlock();
		new InitialBlock();
		
		
		int a=3;
		//�׳� ��ȭ ���ѳ��� ����. Ȥ���� �� �ȿ� ������ �����ϸ� �ش� �� �������� ��ȿ�ϴ�
		/*
		{
			int b=5;
		}
		System.out.println(b);
		*/
		
	}
}
