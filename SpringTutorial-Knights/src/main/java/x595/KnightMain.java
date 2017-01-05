package x595;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightMain {

	public static void main(String... args) {
		
		//ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("xml file");
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(KnightConf.class);
		
		Knight knight = ctx.getBean(Knight.class);
		knight.embarkOnQuest();
		
		
	}
}
