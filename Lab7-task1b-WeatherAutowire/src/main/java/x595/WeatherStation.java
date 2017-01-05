package x595;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WeatherStation implements IWeatherStation {
	
	@Autowired
	@Qualifier("randomWeatherProvider")
	private IWeatherProvider provider;
	
	@Autowired
	@Qualifier("consoleDisplay")
	private IDisplay display;
	
	public WeatherStation() {}
	

	public void setProvider(IWeatherProvider p) { this.provider = p; }
	
	public void setDisplay(IDisplay d) { this.display = d; }
	
	
	@Override
	public void showForecast(String city) {
		// TODO Auto-generated method stub
		display.display(provider.getForeCast(city));
	}

}
