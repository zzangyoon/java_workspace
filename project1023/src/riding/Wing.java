/*7. 날개를 정의한다*/
package riding;

/*
인터페이스란? 메서드만을 보유한 기능 집합이다
즉 객체는 객체인데, 메서드만을 보유한 단위이므로 sun사에서 금지하고 있는 다중 상속을 우회하여 구현할 수 있게 해준다
*/

abstract public class Wing{
	//단 하나라도 추상메서드가 들어있을 경우, 전체가 추상클래스가 되버림
	abstract public void fly();


}
