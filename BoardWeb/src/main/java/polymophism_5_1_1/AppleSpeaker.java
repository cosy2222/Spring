package polymophism_5_1_1;

import org.springframework.stereotype.Component;

@Component("apple")  // Speaker Ÿ�԰� AppleSpeaker Ÿ���� ��� ����
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
