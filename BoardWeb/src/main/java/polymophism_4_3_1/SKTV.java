package polymophism_4_3_1;

public class SKTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SKTV -- ���� �� ");
	}

	@Override
	public void powerOff() {
		System.out.println("SKTV -- ���� �� ");
	}

	@Override
	public void volumUp() {
		System.out.println("SKTV -- �Ҹ� Ŀ��");
	}

	@Override
	public void volumDown() {
		System.out.println("SKTV -- �Ҹ� �۾��� ");
	}
	
	

}
