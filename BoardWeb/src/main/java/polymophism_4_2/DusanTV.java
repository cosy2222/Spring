package polymophism_4_2;

public class DusanTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("�λ�TV -- ������ �Ҵ�");

	}

	@Override
	public void powerOff() {
		System.out.println("�λ�TV -- ������ ����");
	}

	@Override
	public void volumUp() {
		System.out.println("�λ�TV -- �Ҹ��� Ŀ��");
	}

	@Override
	public void volumDown() {
		System.out.println("�λ�TV -- �Ҹ��� �۾���");
	}

}