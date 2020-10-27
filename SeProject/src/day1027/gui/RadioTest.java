/* 1.
		1. 글씨크기 조절 : ctrl + (- , +)
		2. 폰트바꾸기 : window > Preferences > General > Appearance > Colors and Fonts > Basic > Text Font >  Verdana
		3. 단축키 모음 :  ctrl + shift + L
		4. 자동 임포트 : ctrl + shift + O
		5. 코드 자동정렬 : ctrl + shift + F
		6.  api 문서보기 : 커서 위에 놓고 shift + F2 인터넷 연결이 전제..
		7. 출력 자동완성 : sout 입력 후에 ctrl + space
		8. code 이동 : Alt + 방향키 위, 아래
		9. 복사하기 :  cntl + alt + 방향키 아래
 */

package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

public class RadioTest extends Frame{
	//�ڹٿ����� üũ�ڽ��� ������ �����
	CheckboxGroup group;
	
	public RadioTest() {
		group = new CheckboxGroup();
		setLayout(new FlowLayout());
		this.add(new Checkbox("운동", group, false));
		this.add(new Checkbox("독서", group, false));
		this.add(new Checkbox("컴퓨터", group, false));
		this.add(new Checkbox("요리", group, false));
		this.add(new Checkbox("애견돌보기", group, false));
		
		setSize(300,400);
		setVisible(true);

	}
	
	public static void main(String[] args) {	
		System.out.println("겁나빠름");
		new RadioTest();
	}

}
