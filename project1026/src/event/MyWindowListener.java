/*10. 윈도우창을 대상으로 발생할 수 있는 이벤트를 감지하는 리스너 구현하기*/
package event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindowListener implements WindowListener{

	public void windowActivated(WindowEvent e){	//현재 창을 활성화시킬때 (즉, 커서가 현재 창에 올라와 사용중일때)
		System.out.println("windowActivated 호출");
	}
	public void windowClosed(WindowEvent e){		//창이 닫히면
		System.out.println("windowClosed 호출");
	}
	public void windowClosing(WindowEvent e){		//닫기 버튼을 누르때(창이 닫히지는 않음)
		System.out.println("windowClosing 호출");
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("windowDeactivated 호출");
	}
	public void windowDeiconified(WindowEvent e){	//최소화 버튼을 눌러 아이콘화 시킬때
		System.out.println("windowDeiconified 호출");
	}
	public void windowIconified(WindowEvent e){		//아이콘화의 반대
		System.out.println("windowIconified 호출");
	}
	public void windowOpened(WindowEvent e){		//창이 뜰 때
		System.out.println("windowOpened 호출");
	}
}
