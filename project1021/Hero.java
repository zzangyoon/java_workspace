//3 ���۹���Ǯ�� - java - 5.�޼���ȣ�� - 1������
public class Hero {
	int hp=10;
	boolean fly=false;
	String name="�ް���";	//has a ���� ������, ���� �󵵼��� ������ �׳� �Ϲ��ڷ���ó�� ����
	Bullet bullet;	//��ü���̹Ƿ�, has a ����
	
	public void setHp(int hp) { //(��) : hp ���� �����ϰ� �ʹ� 
		this.hp=hp;
	}
	public void setFly(boolean fly) {//(��) : fly ���� �����ϰ� �ʹ�
		this.fly=fly;
	}
	public void setName(String name) {//(��) : name ���� �����ϰ� �ʹ�	
		this.name=name;	
	}
	public void fire(Bullet bullet){//(��) : bullet �� �ٸ� ����� �����ϰ� �ʹ�
		this.bullet=bullet;
	}

	public static void main(String[] args) {
		Hero hero = new Hero();
		hero.setHp(500);			//call by reference(X) -> call by value
		hero.setFly(true);			//call by reference(X) -> call by value
		hero.setName("�����");	//call by reference(O) ��Ʈ���� ��ü�̹Ƿ�...
		hero.fire(new Bullet());	//call by reference(O)
	}	
}