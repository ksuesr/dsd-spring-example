package x595;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
	
	public static void main(String... args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ComputerTestConfig.class);
		
		IUser prof = ctx.getBean(IUser.class);
		
		prof.useDevice();

	}

}
