//4
package day1116.pubapi;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MountainModel extends AbstractTableModel{
	/*	이차원 배열이 아니라 Vector를 선언해서 데이터와 컬럼명을 처리한다
		벡터는 컬렉션 프레임웍이니 배열처럼 생성시 크기를 명시하지 않아도 된다... 그만큼 유연하다는 뜻!
	*/

	Vector<Mountain> data = new Vector<Mountain>();	//근데 제너릭타입이 아니라 뭔가 허전하다..
													//제너릭타입으로 알맞는 자료형이 뭘까? (우리는 지금 산을 가져와서 테이블에 출력할 예정이다) 그럼 산이 들어와야 한다
	
	//컬럼 제목 정보를 담는 벡터
	Vector<String> columnName = new Vector<String>();
	
	//컬럼제목을 구성할 벡터 요소는 생성자에서 채운다
	public MountainModel() {
		//컬럼 구성
		columnName.add("ID");		//산 아이디
		columnName.add("산이름");	//산이름 
		columnName.add("소재지");	//산 소재지
		columnName.add("높이");	//산 높이
	
		//데이터 거짓말로 구성해보기 (테스트를 위해 @-1)
		Mountain mt = new Mountain();
		mt.setMntnid(1);
		mt.setMntnnm("설악산");
		mt.setMntninfopoflc("강원도");
		mt.setMntninfohght(1000);
		data.add(mt);	//산 1개를 벡터에 넣기
		
	}
	
	@Override
	//이제 레코드 수(행의 수)는 벡터의 길이에서 가져오면 된다
	public int getRowCount() {
		return data.size();
	}

	@Override
	//이제 컬럼의 수는 벡터의 길이에서 가져오면 된다
	public int getColumnCount() {
		return columnName.size();
	}

	//컬럼 제목을 출력하기 위한 메서드 오버라이드
	@Override
	public String getColumnName(int col) {
		return columnName.get(col);	//배열이 아니므로 get(인덱스)로 가져와야 한다
	}

	@Override
	//이차원배열이나 벡터는 모두 배열구조이므로 지금까지는 [row][col] 형태로 데이터를 추출했다!
	//하지만, 이제 벡터에 들어있는 데이터는 VO이므로 [row]에 대한 접근은 가능하지만 [col]에 대한 접근은 불가하다!
	public Object getValueAt(int row, int col) {
		//해결책! 조건문 쓰기!!!
		//즉, col이 0일때는 산의 아이디, 1일때 이름, 2일때 소재지..등등으로 우리가 조건을 달아야 한다
		System.out.println("row = "+row+"col 값 = "+col);	//호출시 컬럼값 확인하기!
		//현재는 data의 사이즈가 0이어서 이 메서드를 호출하지 않으므로 거짓말로 데이터를 넣어보자 (위에서-27번라인 @-1)
		Mountain mt = data.get(row);	//row번째에서 산을 하나 끄집어 낸다
		//거짓말 데이터가 아니라, 실제 데이터를 가져와야 하므로 xml 파싱을 진행해야 한다
		//xml 파싱 핸들러 열어서 MountainHandler.java 진행

		String obj = null;	//각 조건에 따라 반환될 데이터 (@-3)
		
		if(col==0) {	//이때는 산의 아이디를 반환
			obj = Integer.toString(mt.getMntnid());	//int
		}else if(col == 1) {	//산의 이름
			obj = mt.getMntnnm();
		}else if(col == 2) {	//산의 위치
			obj = mt.getMntninfopoflc();
		}else if(col == 3) {	//산의 높이
			obj = Integer.toString(mt.getMntninfohght());
		}
		
		//이 메서드의 반환형이 오브젝트형 이르모, 우리는 객체형(String, Integer 등)으로 반환해야 한다
		//근데 JTable에 들어가는 모든 데이터는 String 취급할 수 있으므로 String으로 반환하자 (65번라인 @-3)
		return obj;
	}

	
}
