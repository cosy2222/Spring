package polymophism_4_2_2;

public class SamsungTV implements TV {
	
	private Speaker speaker;   // Speaker 인터페이스 : SonySpeaker , AppleSpeaker 
	private int price ;    
	
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}
	
	// SamsungTV 생성자의 매개변수로 SonySpeaker 객체를 DI(의존성 주입)
	
	//생성자 : 매개변수가 1개인 생성자 
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV 객체생성2 : 생성자 객체주입");
		this.speaker = speaker;
	}
	
	// 생성자 ㅣ 매개변수가 2개인 생성자
	public SamsungTV(SonySpeaker speaker , int price) {
			System.out.println("===> SamsungTV 객체 생성 3 : 매개변수 2개인 생성자 호출");
			this.speaker = speaker;
			this.price = price ; 
	}
	
	
	
	public void initMethod() {  // 객체 생성 직후에 제일먼저 호출 되는 메소드
		System.out.println("init 메소드 호출 : 객체 초기화 완료");
	}
	
	public void destroyMethod() {	// 객체 종료전 호출되는 메소드 
		System.out.println("destroy 메소드 호출");
	}
	

	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 켬  (가격 : " + price + " )");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- 전원 끔 ");
	}

	
	// 강결합 상태 , 프로그램 내에서 객체를 생성할 경우  새로운 기능의 스피커로 교체할떄 코드를 수정해야 한다 
	
	@Override
	public void volumUp() {
		speaker.volumUp();
	}

	@Override
	public void volumDown() {
		speaker.volumDown();
	}

}
