/*
�ڹٵ� �ٸ� ���� ���������� �迭�� �����Ѵ�
��, �ڹٴ� ���������͹���� �ƴ� ������ ����� �������α׷����μ�
�迭 ����� �ݵ�� �ڷ����� �����ؾ� �Ѵ� (js �ʹ� �ٸ�)
*/

class ArrayTest1{
	public static void main(String[] args){
	//int�� �迭 ����
	//var arr = new Array();	> js����
	//�ڹٽ�ũ��Ʈ�ʹ� �޸�, �ڹٿ����� �迭�� ���������� ���� ���� �� ����, �ݵ�� �� ������ ������Ÿ�Ը� ���� �� �ִ�
	int[] arr = new int[3];	//�ݵ��(must) �ڷ��� �� �迭�� ũ�� ����ؾ���!!!
	arr[0]=7;
	arr[1]=23;
	arr[2]=9;

	for(int i=0; i<arr.length; i++){
		System.out.println(arr[i]);
	}

	//����� ���ÿ� �ʱ�ȭ
	//var arr = ["���", "�ٳ���", "����"];
	String[] fruit = {"���", "�ٳ���", "����"};	//�ڹٿ����� �߰�ȣ�� ����
	System.out.println("������ ���� "+fruit.length);
	for (int i=0; i<fruit.length; i++){
		System.out.println(fruit[i]);
	}

	}
}
