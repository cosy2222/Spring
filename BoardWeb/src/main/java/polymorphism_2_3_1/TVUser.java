package polymorphism_2_3_1;

public class TVUser {

	public static void main(String[] args) {
		
//		SamsungTV tv = new SamsungTV();
//			// ������ ���� , (�����ڰ� ���� ���α׷� �ڵ峻���� ��ü�� ����)
//		tv.powerOn();
//		tv.powerOff();
//		tv.VolumeUP();
//		tv.VolumeDown();
		
		// ������� �䱸�� ���ؼ� Samsung TV���� LG tv �� ����
				// ��ü����  , �޼ҵ� �̸� ��κ��� 
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.turnOff();
		tv.soundUP();
		tv.soundDown();

	}

}
