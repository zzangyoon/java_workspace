class Shoes{
	String color;	//String�� ��ü�̹Ƿ� �����Ϸ��� ���� null
	int price;		//������ �����Ϸ��� ���� 0
	//�Ʒ��� �� �޼����, �Ӽ��� �����ϴ� �Ͱ�
	//�����ڿ� ���� �ʱ�ȭ�ϴ� �Ϳ� ������?
	//����� ����. ������ �� �޼���� �Ӽ��� �����ϸ�, �̹� �Ź��� �����, ���߿� �������� ����ǥ�� ���̴°Ͱ� ����
	public Shoes(String color, int price){
		this.color = color;
		this.price = price;
	}

	public void setColor(String color){	//������ �����ϴ� �޼���
		this.color = color;
	}
	
	public void setPrice(int price){	//������ �����ϴ� �޼���
		this.price = price;
	}

	public static void main(String[] args){
		Shoes s = new Shoes("red", 20000);
		//s.setColor("red");
		//s.setPrice(20000);

		System.out.println("�Ź��� ������ "+s.color+", ������ "+s.price);
	}
}
