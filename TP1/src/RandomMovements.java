import java.util.Random;

public class RandomMovements extends Thread {

	private enum State {
		IDLE, WAIT, EXECUTE
	}

	private State STATE = State.IDLE;
	private MovementEnum lastDirection = null;

	private volatile boolean working = false;

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
				System.out.println("boas");
				if (this.working)
					STATE = State.EXECUTE;
				break;

			case EXECUTE:
				timeToWait = 0;
				
				System.out.println("1");
				for (int i = 0; i < this.actionNumber; i++) {
					MovementEnum[] movement = MovementEnum.values();
					System.out.println("2");
					int direction = random.nextInt(movement.length);

					if (lastDirection == movement[direction]) {
						i--;
						continue;
					}

					switch (movement[direction]) {
					case FORWARD:
						robotController.moveForward();
						timeToWait += robotController.getDelayStraightLine();
						break;
					case RIGHT:
						robotController.moveRightCurve();
						timeToWait += robotController.getDelayCurve();
						break;
					case LEFT:
						robotController.moveLeftCurve();
						timeToWait += robotController.getDelayCurve();
						break;
					default:
						i--;
						break;
					}

					robotController.updateData(random.nextInt(20) + 10, random.nextInt(70) + 20,
							random.nextInt(40) + 10);

					lastDirection = movement[direction];
				}
				robotController.getBuffer();
				STATE = State.WAIT;
				timeStamp = System.currentTimeMillis();
				break;

			case WAIT:
				if (System.currentTimeMillis() - timeStamp >= timeToWait) {
					if (this.working)
						STATE = State.EXECUTE;
					else
						STATE = State.IDLE;
				}
				break;

			}
		}
	}

	public synchronized void setWorking(boolean working) {
		this.working = working;
	}

	public synchronized void setActionNumber(int actionNumber) {
		this.actionNumber = actionNumber;
	}

}
