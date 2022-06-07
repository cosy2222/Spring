package polymophism_5_2_1;

public class BeanFactory {
	
	// 객체를 생성하는 클래스 
	// Bean <== 객체를 뜻함 
	
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
