package polymophism_4_2_2;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("AppleSpeaker ��ü ����");
	}

	@Override
	public void volumUp() {
		System.out.println("AppleSpeaker -- �Ҹ� Ŀ��");
		
	}

	@Override
	public void volumDown() {
		System.out.println("AppleSpeaker -- �Ҹ� �۾���");
	}

}