package x595;

public final class Logger {
	
	public static void log(String message) {
		//intentionally throw exception for get class/method data from call stack!
		try {
			throw new Exception();
		} catch (Exception e) {
			//top of trace element is Logger.log itself, so I took next one
			StackTraceElement elem = e.getStackTrace()[1];
			
			System.out.println(elem.getClassName() + "." + elem.getMethodName() + "()> " + message);
		}
	}

}
