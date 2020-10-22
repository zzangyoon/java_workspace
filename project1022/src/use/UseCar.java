//11
package use;
import car.Truck;	//사용하고자 하는 트럭 임포트
import car.Taxi;	//사용하고자 하는 택시 임포트
import car.Bus;	//사용하고자 하는 버스 임포트

//만일 위에서처럼 일일이 명시하는게 귀찮을 경우 한꺼번에 할 수도 있다
//import car.*;	//*의 대상이 될 수 있는건 패키지명이 아니라 클래스명이다
						//참고로 현업에서는 *를 잘 쓰지 않는다.. 
						//저렇게 해버리면 import에서 다루고자하는 기술이 무엇인지 빨리 해석이 안된다
						//따라서 따로따로 해주는 것이 좋다

class UseCar{
	public static void main(String[] args){
		//만일 택시를 사용하고 싶을때, 부모인 Car 클래스를 메모리에 별도로 new 해줘야 할까?
		//자식을 .new 하면 js와 같이 부모는 자동으로 인스턴스가 생성된다 
		Taxi t = new Taxi();		//택시의 인스턴스 생성, 얼핏보기엔 택시만 생성될 것 같지만 
										//택시보다 앞선 부모인 Car가 존재해야 택시도 존재할 수 있기때문에 
										//js 시절의 원리가 그대로 적용되어 Car인스턴스도 생성된다
		t.pass();	//택시 메서드 호출
		//그리고, 택시 클래스 코드 안에는 없지만 Car 클래스가 보유한 변수 메서드 호출해보자
		//만일 호출이 되면 Car인스턴스가 생성된게 증명되는 것이다
		t.move();	//분명 move() 메서드는 택시에 없는데도 이게 호출된다면 택시가 부모님것을 맘대로 접근한 것이다
	}
}
