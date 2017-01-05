package x595;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrinter implements IPrinter {

	@Override
	public void print(String str) {
		// TODO Auto-generated method stub
		Logger.log(str);
	}

}
