//2.
package string;

class StringTest2{
	public static void main(String[] args){
		/*String은 불변(immutable)이다!!!*/
		String s1 = "korea";
		System.out.println(s1);	//korea

		s1 = s1 + " fighting...";
		System.out.println(s1);	//korea fighting...	
	
		//아래의 방법은 무려 101개의 문자열상수를 상수풀에 생성해버린다
		//왜? 문자열 상수는 수정불가이므로!!!
		/*
		String str="";
		for(int i=1; i<=100; i++){
			str += "줄넘기 "+i+"회\n";
		}
		System.out.println(str);		
		*/

		//해결책
		//수정가능한 문자열 처리 객체
		//StringBuffer, StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(int i=1; i<=100; i++){
			sb.append("줄넘기 "+i+"회\n");
		}
		System.out.println(sb);
	}
}
