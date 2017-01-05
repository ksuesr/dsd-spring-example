package x595;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WeatherApp {
	
	@SuppressWarnings("resource")
	public static void main(String... args) {
		ApplicationContext ctx;
//		ctx = new ClassPathXmlApplicationContext("weatherconf.xml");
		ctx = new AnnotationConfigApplicationContext(WeatherConf.class);
		
		IWeatherStation station = ctx.getBean(IWeatherStation.class);
		station.showForecast("Suwon");
		station.showForecast("Incheon");
	}

}
