//2.
package string;

class StringTest2{
	public static void main(String[] args){
		/*String�� �Һ�(immutable)�̴�!!!*/
		String s1 = "korea";
		System.out.println(s1);	//korea

		s1 = s1 + " fighting...";
		System.out.println(s1);	//korea fighting...	
	
		//�Ʒ��� ����� ���� 101���� ���ڿ������ ���Ǯ�� �����ع�����
		//��? ���ڿ� ����� �����Ұ��̹Ƿ�!!!
		/*
		String str="";
		for(int i=1; i<=100; i++){
			str += "�ٳѱ� "+i+"ȸ\n";
		}
		System.out.println(str);		
		*/

		//�ذ�å
		//���������� ���ڿ� ó�� ��ü
		//StringBuffer, StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(int i=1; i<=100; i++){
			sb.append("�ٳѱ� "+i+"ȸ\n");
		}
		System.out.println(sb);
	}
}
