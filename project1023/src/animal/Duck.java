//2
package animal;

public class Duck extends Bird{
	/*Duck is a Bird*/
	/*Duck형은 Bird형이다*/
	/*오리는 새다*/
	String name = "나는 오리";

	public void quack(){
		System.out.println("꽥꽥");
	}

	public static void main(String[] args){
		Duck d1 = new Duck();
		Duck d2 = new Duck();

		Bird b = new Bird();

		//b = d1;	가능
		//b = new Duck();	가능
		/*
		byte k = 5;
		short s = 8;
		k=s;	//불가 : 작은자료형으로 큰 자료형으로 받으려고 하므로... 손실이 발생하게됨
				//해결책1) k를 short 이상의 크기를 가진 자료형으로 변경
				//해결책2) 손실을 감안하고 강행함(강제형변환) : k = (byte)s;
				//	demotion
		*/
		//객체자료형도 자료형이다!!!
		Duck a = new Duck();
		Bird r = new Bird();
		r = a;	//작은자료형을 큰 자료형에 넣으려고 하니까 가능 (큰 <- 작)
		a = r;	//큰자료형을 작은자료형에 넣으려고 하니까 불가능 (작 <- 큰)		:	down casting
					//해결책) a = (Duck)r;

		r = (Bird)a;	//작은자료형에서 큰 자료형으로 올라감		:	up casting

		//결론 : 객체자료형도 자료형이므로, 기본자료형의 원칙이 상당부분 그대로 적용되고 있다
	}
}
