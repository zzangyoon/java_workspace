//7
package event;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//Ű����� ������ �̺�Ʈ�� �߻��ϸ�, �ڹ� ����ӽ��� KeyListener���� KeyEvent �ν��Ͻ��� �����Ѵ�
//�� ���޵� �ν��Ͻ��� keyListener�� ������ �߻�޼��忡 ���޵Ǿ����Ƿ�,
//�����ڴ� �߻�޼��带 �������ϸ鼭 ���ϴ� ������ �ۼ��ϸ��!
public class MyKey implements KeyListener{
	//�������̵� �ϰ�, Ű���� ���������� ������? �޽��� ������ ó��
	
	//keyListener �� ��� �������� �޼��尡 ���� 3���� �ȴ�! (keyListener > method���� Ȯ��)
	public void keyPressed(KeyEvent e){
		//System.out.println("Ű�� ������, keyPressed called...");
	}
	public void keyReleased(KeyEvent e){
		System.out.println("Ű�� ������ �� ��, keyReleased called...");
	}
	public void keyTyped(KeyEvent e){
		//System.out.println("Ű�� ĥ��, keyTyped called...");
	}



}
