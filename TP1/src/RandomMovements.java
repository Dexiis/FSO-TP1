import java.util.Random;

public class RandomMovements extends Thread {

	private static final int FORWARD = 0;
	private static final int RIGHT = 1;
	private static final int LEFT = 2;
	private int STATE = 0;
	private static final int IDLE = 0;
	private static final int WAIT = 1;
	private static final int EXECUTE = 2;
	private int lastDirection = -1;

	private volatile boolean turnedOn = false;

	private volatile int actionNumber = 0;
	private long timeToWait = 0;
	private long timeStamp = 0;

	private RobotController robotController;
	private Random random = new Random();

	public RandomMovements(RobotController robotController) {
		this.robotController = robotController;
	}

	public void run() {
		while (true) {
			switch (STATE) {
			case IDLE:
				if (this.turnedOn) {
					STATE = EXECUTE;
				}
				break;

			case EXECUTE:
				timeToWait = 0;

				for (int i = 0; i < this.actionNumber; i++) {
					int direction = random.nextInt(3);
					robotController.updateData(random.nextInt(20) + 10, random.nextInt(70) + 20,
							random.nextInt(40) + 10);

					if (lastDirection == direction) {
						i--;
						continue;
					}

					if (direction == FORWARD) {
						robotController.moveForwards();
						timeToWait += robotController.getDelayStraightLine();
					}
					if (direction == RIGHT) {
						robotController.moveRightCurve();
						timeToWait += robotController.getDelayCurve();
					}
					if (direction == LEFT) {
						robotController.moveLeftCurve();
						timeToWait += robotController.getDelayCurve();
					}

					lastDirection = direction;
				}

				STATE = WAIT;
				timeStamp = System.currentTimeMillis();
				break;

			case WAIT:
				if (System.currentTimeMillis() - timeStamp >= timeToWait) {
					if (this.turnedOn) STATE = EXECUTE;
					else STATE = IDLE;
				}
				break;

			}
		}
	}

	public synchronized void setToExecute(boolean turnedOn) {
		this.turnedOn = turnedOn;
	}

	public synchronized void setActionNumber(int actionNumber) {
		this.actionNumber = actionNumber;
	}

}
