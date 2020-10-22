//5. 개발 툴은 project1022로 다시 돌아오기
package bank;	//원본소스용 bank 패키지는 직접 만들어야 한다

/*고객의 계좌를 정의한다 : 업무가 신중해짐.. 예민한 데이터를 많이 다룸*/
//패키지에 넣은 클래스를 public으로 공개하지 않으면, 다른 어떤 클래스도 이 클래스를 사용할 수 없다
//이건 보안이 아니라, 그냥 의미없는 일이다
//클래스는 쓰라고 만드는 것이기 때문에 public으로 공개하되, 그 안의 내용들에 대해 보안처리를 하면 된다
//따라서 public으로 공개한다
public class Account{
	/*계좌에 들어갈 속성을 정의한다*/
	/*아래의 멤버변수를 수정한다 - 접근제한자를 앞에 붙인다
	이 클래스의 접근제한자가 어떠한 작용을하는지, 외부의 클래스에서 데이터에 접근하는 실습을 한다
	저중에 특히 public은 보안이라고 말할 수 없으므록, 언제나 빼고 생각한다. public은 그냥 공개
	따라서 protected, default, private만 신경쓴다*/
	public String bank = "기업은행";	//은행명
	protected String customer;	//고객이름
	String num = "022-388-85465";	//계좌번호
	private int balance = 100000;	//금액	: 진짜중요한 변수


	//아무도 못쓰게 막았으니, 현재 Account 클래스 스스로만 접근할 수 있다
	//따라서 멤버메서드를 제공한다
	//아래의 메서드는 public 이므로 모든~ 객체가 접근할 수 있다
	//UseAccount에서 잔고를 수정하고, 출력도 해본다
	public void setBalance(int balance){
		this.balance = balance;
	}

	//잔고확인 메서드 정의
	//이와 같이 private으로 선언된 변수의 값을 리턴하는 메서드를 가리켜 getter라 한다
	//그리고 위와같이 setBalance 처럼 private한 변수의 값을 변경하는 메서드를 가리켜 setter라 한다
	//getter와 setter는 아주아주 유명한 메서드 정의 기법이다
	public int getBalance(){
		return balance;
	}
}
