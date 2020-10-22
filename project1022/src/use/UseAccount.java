/*6. use 패키지에서 Account 계좌클래스에 접근해본다*/

/* 질문) 현재 클래스는 public으로 공개해야할까 말아야할까?
현재클래스는 사용을 당하는 클래스인가 사용하려는 클래스인가?
사용을 하려는 쪽은 공개가 될 필요가 없다.. 사용당하는 쪽만 공개하면된다
결론은 이 클래스는 공개할 필요가 없다
UseAccount(사용하려는 객체) --> Account(사용당할 객체):공개되어야 함
*/
package use;
//사용하려는 클래스의 위치 알려준다
import bank.Account;	//bank 이전의 경로는 이미 classpath에 등록되어 있다
class UseAccount{
	public static void main(String[] args){
		Account acc = new Account();	//계좌 클래스 생성(public 이라 여기까지는 무조건 가능함)

		//이제 접근 제한자 별로 접근한다

		//bank 은행명은 public으로 선언되어 있으므로 무조건 접근이 가능하다
		System.out.println(acc.bank);	//잘 나온다.. public 이므로

		//customer는 protected로 선언되어 있으므로 상속관계에 있거나, 같은 패키지인 경우에만 접근 가능하다
		//현재 UseAccount는 Account와 상속관계가 없고 서로 다른 패키지이므로 데이터 접근이 불가능할것이다
		//System.out.println(acc.customer);

		//계좌번호 num변수는, 개발자가 아무것도 명시하지 않았는데 이러한 접근제한자를 default 접근제한자라 하고
		//내가 default 라는 키워드를 명시해서는 안된다. 그냥 놔둬야 한다
		//default 접근제한자는 같은 패키지에 있는 클래스끼리만 접근을 허용해주므로, protected보다 한단계 더 까다롭다
		//(즉 상속관계에 있어도, 같은 패키지가 아니라면 접근 불가)
		//System.out.println(acc.num);
		//num is not public in Account, cannot be accessed from outside package
		//"공개되어 있지 않으므로 외부에서 접근이 불가능합니다"하는 메시지가 나옴
		//우리가 지금까지 실습했던 모든~ 클래스가 사실 default였고, 우리는 같은 디렉토리에서 실습을 해왔기 때문에
		//지금까지 이런 에러를 만나지 않았던 것이다. 이제 패키지를 사용하기 때문에 접근제한자를 조금 알아야 한다

		//계좌 잔액 balance 테스트
		//balance는 가장 강력한 접근제한자인 private 적용되어 있으므로, Account 클래스 스스로만 접근이 가능하다
		//따라서 우리는 Account 자신이 아니라서 절대절대 사용하지 못한다 완전 폐쇄적
		//System.out.println(acc.balance);
		//balance has private access in Account(private 접근제한자가 적용되어 있다는 의미)

		//공부할때는 public은 그냥 빼고 공부하자. 퍼블릭은 보안 자체가 없으므로
		//public은 너무 강력해서 아무도 못쓰는데 그럼 왜 만든걸까?
		//-> 만두그림

		//acc.balance = 10;	//이 방법은 직접 접근이므로 불가능
		acc.setBalance(10);	//10원으로 수정, 이 방법은 메서드를 통한 접근이므로 가능
		//이제 잔고가 수정이 되었는데, 수정된 잔고를 어떻게 확인할까? 변수에 접근을 막았으니...
		//잔고 수정이 아니라, 잔고에 접근하려는것 또한 메서드를 제공해줘야 한다
		//마치 리모콘에서 채널 전환버튼만 있는게 아니라, 현재 채널 확인버튼도 있듯이

		//잔고를 확인한다
		System.out.println(acc.getBalance());
	
	}
}
