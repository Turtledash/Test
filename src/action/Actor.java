
package action;

import java.awt.AWTException;
import java.awt.Robot;

public class Actor {

	public void bet(double ammount) {
		 String string = String.format( "%.2f", ammount);
		 type(string);
//		 type("b");
	}

	public void call() {
		type("c");
	}
	
	public void fold() {
		type("f");
	}  

	private void type(String s)
	  {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {}
	    byte[] bytes = s.getBytes();
	    for (byte b : bytes)
	    {
	      int code = b;
	      // keycode only handles [A-Z] (which is ASCII decimal [65-90])
	      System.out.println(code);
	      if (code > 96 && code < 123) code = code - 32;
	      robot.delay(40);
	      robot.keyPress(code);
	      robot.keyRelease(code);
	    }
	  }
}
