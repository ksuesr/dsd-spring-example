package x595;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTestApp {
	
	public static void main(String... args) {
		
		//xml config
//		ctx = new ClassPathXmlApplicationContext("beans.xml");
		//java config
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DriverConfiguration.class);
		
		IDriver driver = ctx.getBean(IDriver.class);
		driver.operate();
		
		ctx.close();
	}

}
