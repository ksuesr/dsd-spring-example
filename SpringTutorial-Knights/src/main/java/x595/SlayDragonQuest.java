package x595;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

	
	private PrintStream stream;
	
	public SlayDragonQuest(PrintStream stream) {
		super();
		this.stream = stream;
	}



	@Override
	public void embark() {
		// TODO Auto-generated method stub
		stream.println("Slaying a dragon..");
	}

}
