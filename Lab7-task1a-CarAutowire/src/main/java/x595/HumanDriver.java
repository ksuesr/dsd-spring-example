package x595;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HumanDriver implements IDriver {
	
	private ICar car;
	
	public HumanDriver() {}
	
	@Autowired
	public HumanDriver(ICar car) {
		this.car = car;
	}

	@Override
	public void operate() {
		// TODO Auto-generated method stub
		System.out.println("[" + getClass().getName() + "] operate the car by calling...");
		car.goFaster();
		car.steer();
		car.brake();
	}

}
