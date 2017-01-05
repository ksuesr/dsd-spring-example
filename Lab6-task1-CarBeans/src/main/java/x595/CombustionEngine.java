package x595;

public class CombustionEngine implements IEngine {

	public CombustionEngine() {
		
	}
	
	@Override
	public void accelerate() {
		// TODO Auto-generated method stub
		System.out.println("[" + getClass().getName() + "] Burn more fuel to accelerate");
	}

	@Override
	public void decelerate() {
		// TODO Auto-generated method stub
		System.out.println("[" + getClass().getName() + "] Burn less fuel to decelerate");
	}

}
