package polymophism_5_1_1;

import org.springframework.stereotype.Component;

//@Component("tv")
public class LgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LgTV -- ������ �Ҵ�");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV -- ������ ����");
	}

	@Override
	public void volumUp() {
		System.out.println("LgTV--�Ҹ� Ŀ��");
	}

	@Override
	public void volumDown() {
		System.out.println("LgTV--�Ҹ� �۾���");
	}

}
