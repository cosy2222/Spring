package polymophism_5_1_1;

import org.springframework.stereotype.Component;

//@Component("tv")
public class LgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LgTV -- 전원을 켠다");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV -- 전원을 끈다");
	}

	@Override
	public void volumUp() {
		System.out.println("LgTV--소리 커짐");
	}

	@Override
	public void volumDown() {
		System.out.println("LgTV--소리 작아짐");
	}

}
