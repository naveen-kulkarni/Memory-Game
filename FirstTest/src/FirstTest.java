import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class FirstTest extends MIDlet implements CommandListener {

	private Command exit;
	public FirstTest() {
		// TODO Auto-generated constructor stub
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub

		
		Canvas canvas=new MyGameCanvas(false);
		Display display=Display.getDisplay(this);
		display.setCurrent(canvas);
		
		exit = new Command("Exit", Command.EXIT, 1);
		canvas.addCommand(exit);
		canvas.setCommandListener(this);
	}

	public void exitMIDlet() {
	    try {
			destroyApp(true);
		} catch (MIDletStateChangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    notifyDestroyed();
	  }

	public void commandAction(Command arg0, Displayable arg1) {
		// TODO Auto-generated method stub
		if (arg0 == exit) {
			exitMIDlet();
		    }
	}
}
