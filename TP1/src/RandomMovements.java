import java.util.Random;

public class RandomMovements extends Thread {

	private int actionNumber;
	private int FORWARD = 0;
	private int BACKWARDS = 1;
	private int RIGHT = 2;
	private int LEFT = 3;

	private RobotController robotController = new RobotController();

	public RandomMovements(int actionNumber) {
		this.actionNumber = actionNumber;
	}

	public void run() {
		
		Random random = new Random();
		for (int i = 0; i < actionNumber; i++) {
			
			int direction = random.nextInt(3);
			robotController.updateData(random.nextInt(20) + 10, random.nextInt(70) + 20, random.nextInt(40) + 10);
			
			if (direction == FORWARD) {
				robotController.moveFowards();
				try {
					Thread.sleep(robotController.getDelayStraightLine());
				} catch (InterruptedException e) {
				}
				
			} else if (direction == BACKWARDS) {
				robotController.moveBackwards();
				try {
					Thread.sleep(robotController.getDelayStraightLine());
				} catch (InterruptedException e) {
				}
				
			} else if (direction == RIGHT) {
				robotController.moveRightCurve();
				try {
					Thread.sleep(robotController.getDelayCurve());
				} catch (InterruptedException e) {
				}
				
			} else if (direction == LEFT) {
				robotController.moveLeftCurve();
				try {
					Thread.sleep(robotController.getDelayCurve());
				} catch (InterruptedException e) {
				}
			}
			
			
		}
	}
}
