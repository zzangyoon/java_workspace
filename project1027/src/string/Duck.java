//3.
package string;

/*
자바의 모든~ 객체는 절대 피할수 없는 최상위 객체를 두고 있다
Object 객체
*/

class Duck{
	String name="오리";
	
	/* 아래의 메서드는 Object 클래스로부터 상속받은 메서드이며,
		이 메서드는 객체를 스트링으로 반환하고자 할때 동작한다!!! 
		즉, 아래의 메서드는 객체를 출력하고자 할때 등에 자동으로 동작한다
		
		아래의 메서드는 Object의 메서드이지만, ~필기!!!!!!!!
		*/

	public String toString(){
		System.out.println("toString() 메서드 동작합니다");
		return "";
	}
	
	public static void main(String[] args){
		Duck d = new Duck();

		//System.out.println(d);	//오리 자체가 아니라, 오리의 주소값 : string.Duck@15db9742
		System.out.println(new Duck());	//오리 자체를 출력!
	}
}
