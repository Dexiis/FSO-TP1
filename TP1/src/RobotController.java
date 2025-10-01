import java.util.ArrayList;
import java.util.Random;

public class RobotController extends Thread {

	Data data = new Data(0, 0, 0, 0, null, false, false);
	int FORWARD = 0;
	int BACKWARDS = 1;
	int RIGHT = 2;
	int LEFT = 3;

	public RobotController() {
	}

	private RobotLegoEV3 robot = new RobotLegoEV3();

	public void updateData(String radius, String angle, String distance, String name, String number,
			boolean randomMovements, boolean turnedOn) {
		data.setRadius(Integer.parseInt(radius));
		data.setAngle(Integer.parseInt(angle));
		data.setDistance(Integer.parseInt(distance));
		data.setName(name);
		data.setNumber(Integer.parseInt(number));
		data.setRandomMovements(randomMovements);
		data.setTurnedOn(turnedOn);
	}

	public void turnOnRobot() {
		robot.OpenEV3(data.getName());
	}

	public void turnOffRobot() {
		robot.CloseEV3();
	}

	public void moveFowards() {
		robot.Reta(data.getDistance());
	}

	public void moveBackwards() {
		robot.Reta(-data.getDistance());
	}

	public void moveRightCurve() {
		robot.CurvarDireita(data.getRadius(), data.getAngle());
	}

	public void moveLeftCurve() {
		robot.CurvarEsquerda(data.getRadius(), data.getAngle());
	}

	public void randomMovements() {
		Random random = new Random();
		ArrayList<RandomMovements> movements = new ArrayList<>();
		for (int i = 0; i < data.getNumber(); i++) {
			int direcao = random.nextInt(3);
			if (direcao == FORWARD)
				movements.add(new RandomMovements(FORWARD, 0, 0, random.nextInt(40) + 10));
			else if (direcao == RIGHT)
				movements.add(new RandomMovements(RIGHT, random.nextInt(20) + 10, random.nextInt(70) + 20, 0));
			else if (direcao == LEFT)
				movements.add(new RandomMovements(LEFT, random.nextInt(20) + 10, random.nextInt(70) + 20, 0));
			else if (direcao == BACKWARDS)
				movements.add(new RandomMovements(BACKWARDS, 0, 0, random.nextInt(40) - 50));
		}

		for (RandomMovements movement : movements) {
			if (movement.getDirection() == FORWARD || movement.getDirection() == BACKWARDS) {
				robot.Reta(movement.getDistance());
				try {
					Thread.sleep(movement.getDelayStraightLine());
				} catch (InterruptedException e) {
				}
			} else if (movement.getDirection() == RIGHT) {
				robot.CurvarDireita(data.getRadius(), data.getAngle());
				try {
					Thread.sleep(movement.getDelayCurve());
				} catch (InterruptedException e) {
				}
			} else if (movement.getDirection() == LEFT) {
				robot.CurvarEsquerda(data.getRadius(), data.getAngle());
				try {
					Thread.sleep(movement.getDelayCurve());
				} catch (InterruptedException e) {
				}
			}

		}
	}

	public void stopMovement() {
		robot.Parar(true);
	}
}