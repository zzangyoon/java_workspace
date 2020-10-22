//4
package study;
import pet.Cat;	//pet 이전 경로는 클래스패스에 이미 등록되어 있음
//import pet.*;	이렇게도 가능하다
//주의점) 반드시 클래스명만이 * 대상이 된다. 따라서 import * 이런거 안된다
class UseCat{
	public static void main(String[] args){
		Cat c = new Cat();
		//고양이를 사용하려면, classpath 상에서의 고양이의 위치를 명시해야 한다
		//classpath에 bin까지 등록되어있으므로 그 이하의 경로를 import에 명시한다
		c.eat();
	}
}
