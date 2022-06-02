package polymorphism_2_3_2;

public class SamsumgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- Àü¿ø ÄÔ ");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- Àü¿ø ²û ");
	}

	@Override
	public void volumUp() {
		System.out.println("SamsungTV -- ¼Ò¸® Ä¿Áü");
	}

	@Override
	public void volumDown() {
		System.out.println("Samsung TV -- ¼Ò¸® ÀÛ¾ÆÁü ");
	}

}
