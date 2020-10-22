/*8. 트럭을 정의한다*/
package car;

public class Truck extends Car{	//2) 이 한줄로, 우리는 Car를 상속받게되고, 지금부터 Car의 자원들에 접근이 가능하다.. 마치 내것처럼
	//1) 트럭에도 move 메서드를 둬야 할까?
	//우리가 원하는건 예전에 작성했던 비슷한 코드를 또 작성 안하고자 하는게 목적이다
	//이때 사용되는 기술이 상속이다.. js와 똑같다
	//이제는 트럭만이 갖는 특징을 작성하면 된다... 
	public void dump(){
		System.out.println("물건을 대량으로 옮깁니다");
	}

}
