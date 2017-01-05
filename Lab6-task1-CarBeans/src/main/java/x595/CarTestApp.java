package x595;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTestApp {
	
	@SuppressWarnings("resource")
	public static void main(String... args) {
		ApplicationContext ctx;
		
		//xml config
//		ctx = new ClassPathXmlApplicationContext("beans.xml");
		//java config
		ctx = new AnnotationConfigApplicationContext(DriverConfiguration.class);
		
		IDriver driver = ctx.getBean(IDriver.class);
		driver.operate();
		
		
	}

}
