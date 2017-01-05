package x595;

import org.springframework.context.annotation.*;

@Configuration
public class WeatherConf {

	@Bean
	public IWeatherStation getStation() {
		return new WeatherStation(getProvider(), getDisplay());
	}
	
	@Bean
	public IWeatherProvider getProvider() {
		return new RandomWeatherProvider();
	}
	
	@Bean
	public IDisplay getDisplay() {
		return new ConsoleDisplay();
	}
	
}
