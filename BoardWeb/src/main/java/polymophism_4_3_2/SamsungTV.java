package polymophism_4_3_2;

public class SamsungTV implements TV{
	
	
	
	private Speaker speaker;   // Speaker 인터페이스 : SonySpeaker , AppleSpeaker 
	private int price ;    
	
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker메소드 호출");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice()호출 : setter 호출");
		this.price = price;
		
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
