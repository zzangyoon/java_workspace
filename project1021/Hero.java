//3 구글문제풀이 - java - 5.메서드호출 - 1번문제
public class Hero {
	int hp=10;
	boolean fly=false;
	String name="메가맨";	//has a 관계 맞지만, 워낙 빈도수가 높으니 그냥 일반자료형처럼 사용됨
	Bullet bullet;	//객체형이므로, has a 관계
	
	public void setHp(int hp) { //(가) : hp 값을 변경하고 싶다 
		this.hp=hp;
	}
	public void setFly(boolean fly) {//(나) : fly 값을 변경하고 싶다
		this.fly=fly;
	}
	public void setName(String name) {//(다) : name 값을 변경하고 싶다	
		this.name=name;	
	}
	public void fire(Bullet bullet){//(라) : bullet 을 다른 무기로 변경하고 싶다
		this.bullet=bullet;
	}

	public static void main(String[] args) {
		Hero hero = new Hero();
		hero.setHp(500);			//call by reference(X) -> call by value
		hero.setFly(true);			//call by reference(X) -> call by value
		hero.setName("히어로");	//call by reference(O) 스트링은 객체이므로...
		hero.fire(new Bullet());	//call by reference(O)
	}	
}