/*10. ������â�� ������� �߻��� �� �ִ� �̺�Ʈ�� �����ϴ� ������ �����ϱ�*/
package event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindowListener implements WindowListener{

	public void windowActivated(WindowEvent e){	//���� â�� Ȱ��ȭ��ų�� (��, Ŀ���� ���� â�� �ö�� ������϶�)
		System.out.println("windowActivated ȣ��");
	}
	public void windowClosed(WindowEvent e){		//â�� ������
		System.out.println("windowClosed ȣ��");
	}
	public void windowClosing(WindowEvent e){		//�ݱ� ��ư�� ������(â�� �������� ����)
		System.out.println("windowClosing ȣ��");
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("windowDeactivated ȣ��");
	}
	public void windowDeiconified(WindowEvent e){	//�ּ�ȭ ��ư�� ���� ������ȭ ��ų��
		System.out.println("windowDeiconified ȣ��");
	}
	public void windowIconified(WindowEvent e){		//������ȭ�� �ݴ�
		System.out.println("windowIconified ȣ��");
	}
	public void windowOpened(WindowEvent e){		//â�� �� ��
		System.out.println("windowOpened ȣ��");
	}
}
