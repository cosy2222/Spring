package polymophism_4_3_1;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("AppleSpeaker 按眉 积己");
	}

	@Override
	public void volumUp() {
		System.out.println("AppleSpeaker -- 家府 目咙");
		
	}

	@Override
	public void volumDown() {
		System.out.println("AppleSpeaker -- 家府 累酒咙");
	}

}
