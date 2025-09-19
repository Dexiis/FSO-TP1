import java.util.ArrayList;

public class ControlRobot extends Thread {
	
	ArrayList<String> commands;

	
	public ControlRobot() {
		commands = new ArrayList<String>();
	}

	
	public void run() {
		ControlRobot r1 = new ControlRobot();
		r1.start();
	}
	
}
