//3.
package string;

/*
�ڹ��� ���~ ��ü�� ���� ���Ҽ� ���� �ֻ��� ��ü�� �ΰ� �ִ�
Object ��ü
*/

class Duck{
	String name="����";
	
	/* �Ʒ��� �޼���� Object Ŭ�����κ��� ��ӹ��� �޼����̸�,
		�� �޼���� ��ü�� ��Ʈ������ ��ȯ�ϰ��� �Ҷ� �����Ѵ�!!! 
		��, �Ʒ��� �޼���� ��ü�� ����ϰ��� �Ҷ� � �ڵ����� �����Ѵ�
		
		�Ʒ��� �޼���� Object�� �޼���������, ~�ʱ�!!!!!!!!
		*/

	public String toString(){
		System.out.println("toString() �޼��� �����մϴ�");
		return "";
	}
	
	public static void main(String[] args){
		Duck d = new Duck();

		//System.out.println(d);	//���� ��ü�� �ƴ϶�, ������ �ּҰ� : string.Duck@15db9742
		System.out.println(new Duck());	//���� ��ü�� ���!
	}
}
