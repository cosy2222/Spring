package polymorphism_2_3_2;

import polymorphism_2_3_1.SamsungTV;

public class TVUser {

	public static void main(String[] args) {
		
		//SamsungTV tv = new SamsungTV();
		LgTV tv = new LgTV();
		
		tv.powerOn();
		tv.powerOff();
		tv.volumUp();
		tv.volumDown();

	}

}
