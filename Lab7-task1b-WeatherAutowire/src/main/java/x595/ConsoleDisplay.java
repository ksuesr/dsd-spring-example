package x595;

import org.springframework.stereotype.Component;

@Component
public class ConsoleDisplay extends RandomWeatherProvider implements IDisplay {
	
	public ConsoleDisplay() {}

	@Override
	public void display(String str) {
		// TODO Auto-generated method stub
		System.out.println(str);
	}

}
