//1
class Car{
	String name = "Benz";
	int price = 500;
	String color = "red";
	Wheel wheel=null;		//�� �ڵ尡 ������ ���� ����? -> Ŭ���� �ȿ��� �ڷ����� �� �� �ִµ�, �ڹ��� �ڷ����� �� 4���̴�
	//���� �� Ŭ���� �ȿ��� ����, ����, ���� �̿ܿ� ��ü���� �� �� �ִ�. ��ü�ڷ����� �ڷ����̴ϱ�...

	//Ŭ������� ������ �̸��� �޼��带 ������ �����ڶ� �ϰ�, 
	//�����ڴ� �̸������� �� �� �ֵ���, ��ü�� ����Ÿ�ӿ� ���� �ʱ�ȭ �۾��� ������ �۾��� �����ϴ� �뵵�� �޼����̴�
	public Car(){
		//this.wheel = new Wheel();	//this�� ��������
		wheel = new Wheel();
	}
	public static void main(String[] args){

		Car c = new Car();	//�ڵ����� �����ϰ�,
		System.out.println(c.name);		//�� �ڵ����� �̸� ����ϰ�, 
		//�� �ڵ����� �귣��, ����, ������ ��±��� �Ͻÿ�
		//c.wheel = new Wheel();	//but... �ڵ��� ���� ���Ŀ� ���� ������ ���� �����ϴ� ����
		System.out.println(c.wheel.brand);

	}

}
