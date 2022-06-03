package polymophism_4_2;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker;   // ��ü ���� ���� 
	
	public SamsungTV() {
		System.out.println("SamsungTV ��ü ����");
	}
	
	// SamsungTV �������� �Ű������� SonySpeaker ��ü�� DI(������ ����)
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("===> SamsungTV ��ü����2 : ������ ��ü����");
		this.speaker = speaker;
	}
	
	public void initMethod() {  // ��ü ���� ���Ŀ� ���ϸ��� ȣ�� �Ǵ� �޼ҵ�
		System.out.println("init �޼ҵ� ȣ�� : ��ü �ʱ�ȭ �Ϸ�");
	}
	
	public void destroyMethod() {	// ��ü ������ ȣ��Ǵ� �޼ҵ� 
		System.out.println("destroy �޼ҵ� ȣ��");
	}
	

	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- ���� �� ");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- ���� �� ");
	}

	
	// ������ ���� , ���α׷� ������ ��ü�� ������ ���  ���ο� ����� ����Ŀ�� ��ü�ҋ� �ڵ带 �����ؾ� �Ѵ� 
	
	@Override
	public void volumUp() {
		speaker = new SonySpeaker();   // SonySpeaker ��ü ����
		speaker.volumUp();
	}

	@Override
	public void volumDown() {
		speaker = new SonySpeaker();   // SonySpeaker ��ü ����
		speaker.volumDown();
	}

}
