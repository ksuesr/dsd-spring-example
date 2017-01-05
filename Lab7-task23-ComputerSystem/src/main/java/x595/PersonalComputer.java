package x595;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonalComputer implements IComputingDevice {
	
	@Autowired
	@Qualifier("windows")
	private IOperatingSystem os;
	
	@Autowired
	private IPrinter printer;

	@Override
	public void run(IProgram program) {
		// TODO Auto-generated method stub
		Logger.log("Running " + program.getName());
		os.runProgram(program);
	}

	@Override
	public void output(String str) {
		// TODO Auto-generated method stub
		Logger.log("Outputting...");
		printer.print(str);
	}

}
