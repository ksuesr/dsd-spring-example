package x595;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SportsCar implements ICar {

	private IEngine engine;
	
	public SportsCar() {}
	
	@Autowired
	public SportsCar(IEngine e) {
		this.engine = e;
	}
	
	@Override
	public void goFaster() {
		// TODO Auto-generated method stub
		
		System.out.println("[" + getClass().getName() + "] Acceleration pedal engaged");
		engine.accelerate();
	}

	@Override
	public void brake() {
		// TODO Auto-generated method stub
		
		System.out.println("[" + getClass().getName() + "] Brake pedal engaged");
		engine.decelerate();
	}

	@Override
	public void steer() {
		// TODO Auto-generated method stub
		System.out.println("[" + getClass().getName() + "] Steering wheel turned");
	}

}
