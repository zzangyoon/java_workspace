class Dog{
	String name = "����";
	int age = 5;
	static String color = "white";
	//�� ������ Ŭ�����κ��� ������ �ν��Ͻ��� ���� �ö��� ���� Ŭ���� ������ �� �޶�پ� �־��
	//�� �ν��Ͻ� �Ҽ��� �ƴ϶�, Ŭ���� �����Ҽ����� ����!!
	public void bark(){
		System.out.println("����");
	}

	public static void main(String[] args){	//java.exe �Ű�����
		//Dog.color = "black";	FM���� ǥ�����
		color = "black"	//���� static �����̾ ���� �׳� ������ �� �ִ�(������.color �� �Ƚᵵ�ȴ�)

		int a = 8;
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		boolean k = true;
	}
}
