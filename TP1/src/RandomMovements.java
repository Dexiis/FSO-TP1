import java.util.Random;

public class RandomMovements extends Thread {

	private static final int FORWARD = 0;
	private static final int BACKWARDS = 1;
	private static final int RIGHT = 2;
	private static final int LEFT = 3;
	private int STATE = 0;
	private static final int IDLE = 0;
	private static final int WAIT = 1;
	private static final int EXECUTE = 2;

	private volatile boolean turnedOn = false;
	private volatile boolean interrupt = false;

	private volatile int actionNumber = 0;
	private long timeToWait = 0;
	private long timeStamp = 0;
	private volatile int actionsLeft = actionNumber;

	private RobotController robotController;
	private Random random = new Random();

	public RandomMovements(RobotController robotController) {
		this.robotController = robotController;
	}

	public void run() {
		this.interrupt = false;
		while (true) {
			switch (STATE) {
			case IDLE:
				if (this.turnedOn) {
					this.turnedOn = false;
					this.interrupt = false;
					actionsLeft = this.actionNumber;
					STATE = EXECUTE;
				}
				break;

			case WAIT:
				if (this.interrupt || actionsLeft <= 0) {
					this.interrupt = false;
					STATE = IDLE;
				}
				if (System.currentTimeMillis() - timeStamp >= timeToWait) {
					STATE = EXECUTE;
				}
				break;

			case EXECUTE:
				int direction = random.nextInt(3);
				robotController.updateData(random.nextInt(20) + 10, random.nextInt(70) + 20, random.nextInt(40) + 10);

				if (direction == FORWARD) {
					robotController.moveForwards();
					timeToWait = robotController.getDelayStraightLine();
				}
				if (direction == BACKWARDS) {
					robotController.moveBackwards();
					timeToWait = robotController.getDelayStraightLine();
				}
				if (direction == RIGHT) {
					robotController.moveRightCurve();
					timeToWait = robotController.getDelayCurve();
				}
				if (direction == LEFT) {
					robotController.moveLeftCurve();
					timeToWait = robotController.getDelayCurve();
				}

				actionsLeft--;
				STATE = WAIT;
				timeStamp = System.currentTimeMillis();
				break;
			}
		}
	}

	public synchronized void setToExecute() {
		this.turnedOn = true;
	}

	public synchronized void setToInterrupt() {
		this.interrupt = true;
	}

	public synchronized void setActionNumber(int actionNumber) {
		this.actionNumber = actionNumber;
	}

}
