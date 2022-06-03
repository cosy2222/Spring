package polymophism_4_3_2;

public class SamsungTV implements TV{
	
	
	
	private Speaker speaker;   // Speaker �������̽� : SonySpeaker , AppleSpeaker 
	private int price ;    
	
	public SamsungTV() {
		System.out.println("SamsungTV ��ü ����");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker�޼ҵ� ȣ��");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice()ȣ�� : setter ȣ��");
		this.price = price;
		
	}
	
	
	
	public void initMethod() {  // ��ü ���� ���Ŀ� ���ϸ��� ȣ�� �Ǵ� �޼ҵ�
		System.out.println("init �޼ҵ� ȣ�� : ��ü �ʱ�ȭ �Ϸ�");
	}
	
	public void destroyMethod() {	// ��ü ������ ȣ��Ǵ� �޼ҵ� 
		System.out.println("destroy �޼ҵ� ȣ��");
	}
	

	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- ���� ��  (���� : " + price + " )");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- ���� �� ");
	}

	
	// ������ ���� , ���α׷� ������ ��ü�� ������ ���  ���ο� ����� ����Ŀ�� ��ü�ҋ� �ڵ带 �����ؾ� �Ѵ� 
	
	@Override
	public void volumUp() {
		speaker.volumUp();
	}

	@Override
	public void volumDown() {
		speaker.volumDown();
	}

}
