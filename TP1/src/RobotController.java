
public class RobotController {

	private final Data data = new Data(0, 0, 0, 0, null);
	private final RobotLegoEV3 robot = new RobotLegoEV3();

	private final RandomMovements randomMovements = new RandomMovements(this);
	private final Thread randomMovementsThread;

	public RobotController() {
		this.randomMovementsThread = new Thread(randomMovements);
		this.randomMovementsThread.start();
	}

	public void updateData(String radius, String angle, String distance, String name, String actionNumber) {
		data.setRadius(Integer.parseInt(radius));
		data.setAngle(Integer.parseInt(angle));
		data.setDistance(Integer.parseInt(distance));
		data.setName(name);
		data.setActionNumber(Integer.parseInt(actionNumber));
	}

	public void updateData(int radius, int angle, int distance) {
		data.setRadius(radius);
		data.setAngle(angle);
		data.setDistance(distance);
	}

	public void turnOnRobot() {
		robot.OpenEV3(data.getName());
	}

	public void turnOffRobot() {

	}

	public void moveForwards() {
		robot.Reta(data.getDistance());
		robot.Parar(false);
	}

	public void moveBackwards() {
		robot.Reta(-data.getDistance());
		robot.Parar(false);
	}

	public void moveRightCurve() {
		robot.CurvarDireita(data.getRadius(), data.getAngle());
		robot.Parar(false);
	}

	public void moveLeftCurve() {
		robot.CurvarEsquerda(data.getRadius(), data.getAngle());
		robot.Parar(false);
	}

	public void randomMovements() {
		// System.out.println("Action number" + data.getActionNumber());
		randomMovements.setActionNumber(data.getActionNumber());
		randomMovements.setToExecute();
	}

	public void stopRandomMovements() {
		randomMovements.setToInterrupt();
	}

	public void stopMovement() {
		robot.Parar(true);
	}

	public int getDelayStraightLine() {
		return data.getDelayStraightLine();
	}

	public int getDelayCurve() {
		return data.getDelayCurve();
	}

}