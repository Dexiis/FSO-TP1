public class DataProcessing implements IMovement {

	private int distance;
	private int angle;
	private int radius;

	private RobotLegoEV3 robot = new RobotLegoEV3();

	public DataProcessing() {

	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void turnOnRobot(String name) {
		robot.OpenEV3(name);
	}

	@Override
	public void calculateStraighLineDelay(int distance) {
		// (distance / 0.02) + 100);
	}

	public void moveRobotStraighLine(int distance) {
		robot.Reta(distance);
	}

	@Override
	public void calculateRightCurveDelay(int radius, int angle) {
		// ((radius*angle)/0.02) + 100

	}

	public void moveRobotRightCurve(int radius, int angle) {
		robot.CurvarDireita(radius, angle);
	}

	@Override
	public void calculateLeftCurveDelay(int radius, int angle) {
		// ((radius*-angle)/0.02) + 100

	}

	public void moveRobotLeftCurve(int radius, int angle) {
		robot.CurvarEsquerda(radius, -angle);
	}

	@Override
	public void stopRobot(boolean asynchronous) {
		// 100
	}

}
