package x595;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WeatherApp {
	

	public static void main(String... args) {
//		ctx = new ClassPathXmlApplicationContext("weatherconf.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(WeatherConf.class);
		
		IWeatherStation station = ctx.getBean(WeatherStation.class);
		station.showForecast("Suwon");
		station.showForecast("Incheon");
		
		ctx.close();
	}

}
