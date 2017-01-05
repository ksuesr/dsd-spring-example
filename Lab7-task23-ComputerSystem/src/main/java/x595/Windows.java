package x595;

import org.springframework.stereotype.Component;

@Component
public class Windows implements IOperatingSystem {

	@Override
	public void runProgram(IProgram program) {
		// TODO Auto-generated method stub
		Logger.log("Executing " + program.getName() + " from Windows Runtime");
		program.execute();
	}

}
