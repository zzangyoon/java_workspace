/*	2.
	MVC 패턴이 적용된 JTable에서 사용되는 TableModel은 명칭으로는 마치 모델인 것처럼 보이지만
	그 역할로 본다면 컨트롤러이다

	JTable(View)	------------- TableModel(컨트롤러) ------------- 보여질 데이터(Model)
	
	MyModel이 보유한 모든 메서드의 호출자는? JTable이다!!!
*/
package day1106.db;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	
	//데이터 준비
	String[][] flower = {
			{"장미", "50000", "RED", "KOREA"},
			{"튤립", "70000", "PURPLE", "FRANCE"},
			{"안개꽃", "35000", "WHITE", "GERMANY"}
	};
	
	String[][] car = {
			{"BMW", "7000", "white"},
			{"Benz", "9500", "silver"},
			{"Audi", "8000", "black"}
	};

	//행의 갯수를 반환하는 메서드
	@Override
	public int getRowCount() {
		return car.length;
	}

	//열의 갯수를 반환하는 메서드
	@Override
	public int getColumnCount() {
		return car[0].length;
	}

	//지정한 좌표의 값을 반환
	@Override
	public Object getValueAt(int row, int col) {
		System.out.println("row : "+row+", col : "+col);
		return car[row][col];
	}
	
}
