package polymophism_5_2_1;

public class BeanFactory {
	
	// ��ü�� �����ϴ� Ŭ���� 
	// Bean <== ��ü�� ���� 
	
	public Object getBean (String beanName) {
		
		if(beanName.equals("Samsung")) {
			return new SamsungTV();
		}
		
		if(beanName.equals("Lg")) {
			return new LgTV();
		}
		
		if(beanName.equals("SKTV")) {
			return new SKTV();
		}
		
		return null;
	}
}
