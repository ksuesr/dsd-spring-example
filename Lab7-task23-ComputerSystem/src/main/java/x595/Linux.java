package x595;

import org.springframework.stereotype.Component;

@Component
public class Linux implements IOperatingSystem {

	@Override
	public void runProgram(IProgram program) {
		// TODO Auto-generated method stub
		Logger.log("Executing " + program.getName());
		program.execute();
	}

}
