/* �޼��� */
class ReturnType{
	int price;	//0
	
	/* �޼��� �ۼ��� */
	public void setPrice(){	//void�� ��ȯ���� ����
		price = 500;
	}

	/* ��ȯ����, �ش� ��ȯ���� �ڷ����� �״�� �������ָ� �ȴ� */
	public int getPrice(){
		return price;
	}
	public boolean getBool(){
		return false;
	}
	public char getChar(){
		return 'A';
	}
	public double getNum(){
		return 89.765;
	}
	public static void main(String[] args){
		ReturnType rt = new ReturnType();
		System.out.println(rt.getNum());
	}
}