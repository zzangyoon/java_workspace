//4
package study;
import pet.Cat;	//pet ���� ��δ� Ŭ�����н��� �̹� ��ϵǾ� ����
//import pet.*;	�̷��Ե� �����ϴ�
//������) �ݵ�� Ŭ�������� * ����� �ȴ�. ���� import * �̷��� �ȵȴ�
class UseCat{
	public static void main(String[] args){
		Cat c = new Cat();
		//����̸� ����Ϸ���, classpath �󿡼��� ������� ��ġ�� ����ؾ� �Ѵ�
		//classpath�� bin���� ��ϵǾ������Ƿ� �� ������ ��θ� import�� ����Ѵ�
		c.eat();
	}
}
