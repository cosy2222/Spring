package polymophism_4_2_2;

public class SamsungTV implements TV {
	
	private Speaker speaker;   // Speaker �������̽� : SonySpeaker , AppleSpeaker 
	private int price ;    
	
	public SamsungTV() {
		System.out.println("SamsungTV ��ü ����");
	}
	
	// SamsungTV �������� �Ű������� SonySpeaker ��ü�� DI(������ ����)
	
	//������ : �Ű������� 1���� ������ 
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV ��ü����2 : ������ ��ü����");
		this.speaker = speaker;
	}
	
	// ������ �� �Ű������� 2���� ������
	public SamsungTV(SonySpeaker speaker , int price) {
			System.out.println("===> SamsungTV ��ü ���� 3 : �Ű����� 2���� ������ ȣ��");
			this.speaker = speaker;
			this.price = price ; 
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
