package x595;

import org.springframework.stereotype.Component;

@Component
public class SpringToolSuite implements IProgram {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SpringToolSuite";
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Logger.log("Wiring beans with STS!");
	}

}
