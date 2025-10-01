
public class RobotController {

	private Data data = new Data(0, 0, 0, 0, null);
	private RobotLegoEV3 robot = new RobotLegoEV3();
	
	private Thread randomMovementsThread;

	public RobotController() {
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
		randomMovementsThread = new Thread(new RandomMovements(data.getActionNumber()));
		randomMovementsThread.start();
	}
	
	@SuppressWarnings("deprecation")
	public void stopRandomMovements() {
		if (randomMovementsThread != null) randomMovementsThread.stop();
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