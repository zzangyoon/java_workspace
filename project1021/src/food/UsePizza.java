//5
class UsePizza{
	//피자를 먹는다
	public void eat(Pizza p){
		p.slice=3;
	}

	//갯수를 조정한다
	public void setSlice(int slice){
		slice=3;
	}

	public static void main(String[] args){
		Pizza p1 = new Pizza("피자헛");
		Pizza p2 = new Pizza("도미노");

		UsePizza up = new UsePizza();
		up.setSlice(5);	//피자는 영향을 받지 않음
		up.setSlice(p1.slice);	//p1이 전혀 영향 받지않음
		up.eat(p2);
		
	}
}
