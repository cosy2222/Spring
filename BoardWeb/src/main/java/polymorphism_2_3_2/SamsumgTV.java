package polymorphism_2_3_2;

public class SamsumgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- ���� �� ");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- ���� �� ");
	}

	@Override
	public void volumUp() {
		System.out.println("SamsungTV -- �Ҹ� Ŀ��");
	}

	@Override
	public void volumDown() {
		System.out.println("Samsung TV -- �Ҹ� �۾��� ");
	}

}
