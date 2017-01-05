package x595;

import org.springframework.context.annotation.*;

@Configuration
public class DriverConfiguration {

	@Bean
	public ICar getTargetCar(IEngine e) {
		return new SportsCar(e);
	}
	
	@Bean 
	public IDriver getDriver(ICar c) {
		return new HumanDriver(c);
	}
	
	@Bean
	public IEngine getEngine() {
		return new CombustionEngine();
	}
}
