package x595;

public class HumanDriver implements IDriver {
	
	private ICar car;
	
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
