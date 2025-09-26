public class RobotController {

	Data data = new Data(0, 0, 0, 0, null, false, false);

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
		robot.CurvarDireita(data.getRadius(), -data.getAngle());
	}

	public void stop() {
		robot.Parar(true);
	}
}