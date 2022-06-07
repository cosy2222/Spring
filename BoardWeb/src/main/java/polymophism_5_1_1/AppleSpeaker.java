package polymophism_5_1_1;

import org.springframework.stereotype.Component;

@Component("apple")  // Speaker 타입과 AppleSpeaker 타입을 모두 내포
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("AppleSpeaker 객체 생성");
	}

	@Override
	public void volumUp() {
		System.out.println("AppleSpeaker -- 소리 커짐");
		
	}

	@Override
	public void volumDown() {
		System.out.println("AppleSpeaker -- 소리 작아짐");
	}

}
