
package use;
//����� ����... �Ʒ�ó�� ����ϸ�, C: ��ζ����� ������ �߻�
//�� �ڹ� �ڵ�� ������, ������, �ƿ��� ��� ����Ǿ�� �ϹǷ� ��θ� Ư�� OS�� �������� ��η� ����ϸ� �ȵȴ�
//import C:\workspace\java_workspace\project1021\bin\fashion\Pants;	//������ ���ؼ���... ����ϰ���� Ŭ������ ��ġ ���! src(X), bin(O)
import fashion.down.Pants;
//os ȯ�溯�� : path �����ϰ���� ������ ����� ��ġ
//				   classpath �����ϰ���� Ŭ���������� ����� ��ġ

class UsePants{
	public static void main(String[] args){
		//���� Ŭ�����ʹ� ���������� �������ִ�, �� �ٸ� ��Ű���� ����ִ� Ŭ���� ����غ���
		//js : <script src="���/���ϸ�"></script>
		Pants p = new Pants();	//ã������
		System.out.println(p);
	}
}
