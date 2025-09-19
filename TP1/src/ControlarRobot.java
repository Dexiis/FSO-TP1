import java.util.ArrayList;

public class ControlarRobot extends Thread {
	
	ArrayList<String> commands;

	
	public ControlarRobot() {
		commands = new ArrayList<String>();
	}
	
	public void run() {
		ControlarRobot r1 = new ControlarRobot();
		r1.start();
	}
	
}
