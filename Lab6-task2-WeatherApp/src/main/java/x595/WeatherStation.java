package x595;

public class WeatherStation implements IWeatherStation {
	
	private IWeatherProvider provider;
	private IDisplay display;
	
	public WeatherStation(IWeatherProvider p, IDisplay d) {
		this.provider = p;
		this.display = d;
	}

	@Override
	public void showForecast(String city) {
		// TODO Auto-generated method stub
		display.display(provider.getForeCast(city));
	}

}
