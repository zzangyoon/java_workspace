/*
자바도 다른 언어와 마찬가지로 배열을 지원한다
단, 자바는 인터프리터방식이 아닌 컴파일 기반의 응용프로그램으로서
배열 선언시 반드시 자료형을 선언해야 한다 (js 와는 다름)
*/

class ArrayTest1{
	public static void main(String[] args){
	//int형 배열 선언
	//var arr = new Array();	> js에서
	//자바스크립트와는 달리, 자바에서는 배열에 데이터형을 섞어 넣을 수 없고, 반드시 한 종류의 데이터타입만 담을 수 있다
	int[] arr = new int[3];	//반드시(must) 자료형 및 배열의 크기 명시해야함!!!
	arr[0]=7;
	arr[1]=23;
	arr[2]=9;

	for(int i=0; i<arr.length; i++){
		System.out.println(arr[i]);
	}

	//선언과 동시에 초기화
	//var arr = ["사과", "바나나", "딸기"];
	String[] fruit = {"사과", "바나나", "딸기"};	//자바에서는 중괄호로 쓴다
	System.out.println("과일의 갯수 "+fruit.length);
	for (int i=0; i<fruit.length; i++){
		System.out.println(fruit[i]);
	}

	}
}
