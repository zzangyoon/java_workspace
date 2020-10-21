class Shoes{
	String color;	//String은 객체이므로 컴파일러에 의해 null
	int price;		//정수는 컴파일러에 의해 0
	//아래의 두 메서드로, 속성을 변경하는 것과
	//생성자에 의해 초기화하는 것에 차이점?
	//결과는 같다. 하지만 두 메서드로 속성을 변경하면, 이미 신발을 만들고, 나중에 빨간색과 가격표를 붙이는것과 같음
	public Shoes(String color, int price){
		this.color = color;
		this.price = price;
	}

	public void setColor(String color){	//색상을 변경하는 메서드
		this.color = color;
	}
	
	public void setPrice(int price){	//가격을 변경하는 메서드
		this.price = price;
	}

	public static void main(String[] args){
		Shoes s = new Shoes("red", 20000);
		//s.setColor("red");
		//s.setPrice(20000);

		System.out.println("신발의 색상은 "+s.color+", 가격은 "+s.price);
	}
}
