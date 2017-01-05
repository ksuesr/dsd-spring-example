package x595;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Professor implements IUser {
	
	@Autowired
	private IComputingDevice computer;
	
	@Autowired
	private IProgram program;

	@Override
	public void useDevice() {
		// TODO Auto-generated method stub
		Logger.log("Running a program...");
		computer.run(program);
		
		Logger.log("Testing output...");
		computer.output("Hello Spring!");
	}

}
