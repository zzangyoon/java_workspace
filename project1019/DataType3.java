class DataType3{
	public static void main(String[] args) {
	short s1 = 3;	//(��)
	short s2 = 4;	//(��)

	int a1 = 3;		//(��)
	int a2 = 4;		//(��)

	//������ ������࿡�� ���� ������ ����� �Ǵ� �����Ͱ� int������ ���� �ڷ����� ��� (byte, short)
	//����ӵ��� ���̱� ����, ���꿡 ����ȭ�� �ڷ����� int������ �ڵ����� ����ȯ�� ����Ų��
	short sum = s1+s2;		//(��)
	//������ ����
	//�ذ�å 1) int sum ���� �ٲ۴�
	//�ذ�å 2) short sum = (short)(s1+s2)	: ���� ����ȯ
	//(short) ������ �Ұ�ȣ�� cast �����ڶ� �Ѵ�
	int result = a1+a2;		//(��)

	long k1=5;
	int k2=9;

	long k3 = k1+k2;
}

}
