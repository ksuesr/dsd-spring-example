package x595;

import java.util.Random;

public class RandomWeatherProvider implements IWeatherProvider {
	
	private String[] forecasts = {
		"Sunny",
		"Rainy",
		"Cloudy",
		"Snow",
		"Fog",
		"Haze",
		"Thunderstorm"
	};

	@Override
	public String getForeCast(String city) {
		// TODO Auto-generated method stub
		Random rand = new Random(System.currentTimeMillis());
		int index = rand.nextInt(forecasts.length);
		
		return forecasts[index] + " at " + city;
	}

}
