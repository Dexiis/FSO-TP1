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

	private boolean turnedOn = false;
	private boolean interrupt = false;

	private int actionNumber = 0;
	private long timeToWait = 0;
	private long timeStamp = 0;
	private int actionsLeft = actionNumber;

	private RobotController robotController = new RobotController();
	private Random random = new Random();

	public RandomMovements() {
	}

	public void run() {
		while (true) {
			switch (STATE) {
			case IDLE:
				if (turnedOn) {
					this.turnedOn = false;
					actionsLeft = this.actionNumber;
					STATE = WAIT;
				}
				break;

			case WAIT:
				if (interrupt || actionsLeft <= 0) {
					this.interrupt = false;
					STATE = IDLE;
				}
				if (System.currentTimeMillis() - timeStamp >= timeToWait)
					STATE = EXECUTE;
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

	public void setToExecute() {
		this.turnedOn = true;
	}

	public void setToInterrupt() {
		this.interrupt = true;
	}

	public void setActionNumber(int actionNumber) {
		this.actionNumber = actionNumber;
	}

}
