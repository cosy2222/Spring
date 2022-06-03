package polymophism_4_2_2;

public class SKTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SKTV -- 傈盔 脑 ");
	}

	@Override
	public void powerOff() {
		System.out.println("SKTV -- 傈盔 阐 ");
	}

	@Override
	public void volumUp() {
		System.out.println("SKTV -- 家府 目咙");
	}

	@Override
	public void volumDown() {
		System.out.println("SKTV -- 家府 累酒咙 ");
	}
	
	

}
