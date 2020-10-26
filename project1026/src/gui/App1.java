/*1.
윈도우에 들어갈 수 있는 여러 컴포넌트 알아보기
	ex) 버튼, 텍스트필드, 라디오박스, 체크박스, 초이스, 이미지, textarea...
*/
package gui;
import java.awt.Frame;	//사용하려는 클래스의 위치 등록
									//어딘가에 .class로 존재하기 때문에 사용가능할 것이다
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Image;
import java.awt.Toolkit;

class App1{
	public static void main(String[] args){
	/*윈도우 생성*/

	/* 난생처음 보는 클래스를 만났을때 대처법
		대처법 1) "사용하려는 클래스가 대충 어떤 목적으로 지원되는 것인지 그 용도를 파악해야 한다"
		대처법 2) "자바의 모든 객체는 결국 3가지 유형밖에 없다"
		대처법 3) "클래스는 쓰라고 만든 것이다, 따라서 메모리에 올리는 법을 알면된다"
			1. 일반클래스 : new 하면 된다! new 뒤의 생성자조사(api문서를 통해)
			2. 추상클래스 : new 불가하므로, 자식을 정의해서 new하거나 이미 구현한 인스턴스를 이용하면 된다 (api문서 통해)
			3. 인터페이스 : new 불가하므로, 자식을 정의해서 new하거나 이미 구현한 인스턴스를 이용하면 된다 (api문서 통해)
	*/

	//처음보지만, 일반이기 때문에 new 다음에 오는 생성자를 조사해서 사용하면됨
		Frame frame = new Frame();	//자바 윈도우프로그래밍에서의 윈도우!
		//프레임은 디폴트가 눈에 보이지 않는 상태임, 따라서 보이도록 메서드 호출!
		frame.setVisible(true);	//Window 객체로부터 상속받은 메서드
		//매개변수로는 논리값을 사용할 수 있다
		//윈도우의 너비, 높이를 지정할 수 있는 메서드 찾기
		frame.setSize(300,400);	//api 찾아보기
		
		//윈도우가 생성되었으므로, 윈도우 안에 배치할 각종 컴포넌트 올려놓아보자
		//버튼 Button(일반, 추상, 인터조사 후, 일반 new 생성자조사)
		Button bt = new Button("나버튼");	//버튼생성

		//버튼을 부착하기 전에, 레이아웃 스타일을 지정해야 하는데, 레이아웃은 추후 배울것이므로
		//일단 FlowLayout을 사용해보자
		FlowLayout flow= new FlowLayout();
		frame.setLayout(flow);

		frame.add(bt);	//버튼을 윈도우 컨테이너에 부착
		//add메서드의 매개변수는 Component형이므로, Button도 Component의 자식이기 때문에 같은 자료형에 해당하여,
		//add()의 인수로 올 수 있다!!!

		//html 에서의 input type = "text"는 자바에서는 TextField 라 한다
		TextField t= new TextField("회원정보", 10);
		frame.add(t);

		//Checkbox
		Checkbox ch1 = new Checkbox("독서");
		Checkbox ch2 = new Checkbox("수영");
		Checkbox ch3 = new Checkbox("컴퓨터");
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);

		//TextArea
		TextArea area = new TextArea(5,20);	//5행, 20열
		frame.add(area);

		//그냥 텍스트
		Label la = new Label("회원가입 양식입니다");
		frame.add(la);

		//이미지 넣기
		//Image는 추상클래스이며, 플랫폼(win, mac, linux)이 지정한 방식으로 얻을 수 있다
		//플랫폼에 맞게 가져오려면 DefaultToolkit 클래스로부터 자원을 얻어야 한다
		Toolkit kit = Toolkit.getDefaultToolkit();	//static 메서드!! 따라서 클래스명으로 접근할 수 있다
		//툴킷은 이미지를 로컬상의 경로로부터 얻어올 수 있다
		//경로사용시 주의할 점 : 역슬래시는 윈도우os 에서만 사용하는 표기이므로,
		//지금 이 자바코드가 모든 os실행되려면, 사실 중립적인 경로로 가야한다 (역슬래쉬를 슬래쉬로 바꿔준다)
		Image img = kit.getImage("C:/workspace/java_workspace/project1026/res/1.png");
		System.out.println("이미지 주소값은 "+img);	//null나오면 못 가져온것임

		//화면에 출력하는 수업은 오늘 불가... 왜?
		//지금까지 html에서는 이미지를 html문서에 덧붙여서 구현했으나,
		//자바와 같은 일반적인 컴파일 기반의 프로그래밍 언어에서는 랜더링(직접그리는 작업)을 해야하기 때문이다
	}
}
