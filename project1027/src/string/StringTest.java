//1.

package string;

class StringTest{
	public static void main(String[] args){
		/*
		String은 클래스다!!!
		하지만 우리 인간은 String을 너무 압도적으로 많이 사용하기 때문에
		new 연산자에 의해 스트링을 생성하는 것은 너무 불편하다!
		따라서 String 한해서는 마치 일반 데이터타입처럼 new 쓰지 않는 표현식을 지원해준다
		이러한 String의 생성방법을 암시적, 묵시적(implicit) 생성법
		묵시적 생성법에 의한 String은 상수풀(Constant Pool)에 의해 관리되어 지는데,
		상수풀에선 중복여부를 따진다
		*/

		/*아래 코드의 수행결과 예측해보기*/
		String s1 = "apple";
		String s2 = "apple";
		System.out.println(s1==s2);	//뭐가 나올까? 직접 해보자 > true : 주소값비교
		
		//String은 시작문자가 대문자인 것으로 보아 분명 객체형이다!
		//우리의 개발환경에서 String.class가 어딘가에 있어야 하는데, 보이지 않는다...
		//java se의 모든 api가 모여있는 압축된 파일... C:\Program Files\Java\jdk1.8.0_261\jre\lib\rt.jar

		//아래와 같이 new 연산자에 의해 스트링 생성법을 명시적(explicit) 생성법이라 하며,
		//명시적 생성법은 상수풀에 생성되지 않으므로, new할때마다 중복여부를 따지지 않고 무조건 생성된다!
		String s3 = new String("korea");
		String s4 = new String("korea");
		System.out.println(s3==s4);	//뭐가 나올까? 직접 해보자 > false : 주소값비교 - 주소값 다르다

		
		//주소비교가 아닌, 객체 동일성 비교하는 법
		String k1 = "orange";
		String k2 = "orange";
		System.out.println(k1==k2);				//주소 비교
		System.out.println(k1.equals(k2));	//내용 비교

	}
}
