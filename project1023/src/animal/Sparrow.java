/*3. 참새를 정의한다*/
package animal;

public class Sparrow extends Bird{

	String name = "난 참새";

	public void jjack(){
		System.out.println("짹짹");
	}
	//자식클래스에서 부모와 100% 동일한 메서드를 정의하는 기법을 오버라이딩이라 한다 (Overriding)
	//왜 지원하는가? 부모의 메서드를 자식에서 기능을 변경, 추가하는 등의 업그레이드 하고싶을때
	/*
	!!!주의!!!
		오버로딩 vs 오버라이딩
		오버로딩은 같은 클래스내에서... 기능이 비슷한 메서들명을 굳이 새로 만들지 말고
		매개변수 갯수와 자료형으로 구분하면 중복정의를 인정해주겠다
		오버라이딩은 상속관계에서... 자식이 부모의 메서드를 재정의하는 기법
	*/

	public void fly(){
		System.out.println("참새가 날아요");
	}
	
	public static void main(String[] args){
		Sparrow sp = new Sparrow();
		sp.fly();		//참새의 메서드 호출

		Bird bird = new Bird();
		bird.fly();	//새의 메서드 호출

		Bird bird2 = new Sparrow();
		bird2.fly();

	}
}
