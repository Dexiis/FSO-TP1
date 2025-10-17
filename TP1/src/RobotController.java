
public class RobotController {

	private final Data data = new Data(0, 0, 0, 0, null);
	private final RobotLegoEV3 robot = new RobotLegoEV3();

	private final RandomMovements randomMovements = new RandomMovements(this);
	private final Thread randomMovementsThread;
	private Buffer buffer = new Buffer();
	private Movement movement;

	private ILogger logger;
	

	public RobotController() {
		this.randomMovementsThread = new Thread(randomMovements);
		this.randomMovementsThread.start();
	}

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	private void log(String message) {
		if (logger != null) {
			logger.logMessage(message);
		}
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
		// robot.CloseEV3();
	}

	public void moveForward() {
		buffer.input(new Movement(robot, MovementEnum.FORWARD, data.getDistance()));
		log("O robô andou para a frente " + data.getDistance() + " centímetros.\n");
	}

	public void moveBackwards() {
		buffer.input(new Movement(robot, MovementEnum.BACKWARDS, -data.getDistance()));
		log("O robô andou para trás " + data.getDistance() + " centímetros.\n");
	}

	public void moveRightCurve() {
		buffer.input(new Movement(robot, MovementEnum.RIGHT, data.getRadius(), data.getAngle()));
		log("O robô curvou à direita com um ângulo de " + data.getAngle() + " graus e com um raio de "
				+ data.getRadius() + " centímetros.\n");
	}

	public void moveLeftCurve() {
		buffer.input(new Movement(robot, MovementEnum.LEFT, data.getRadius(), data.getAngle()));
		log("O robô curvou à esquerda com um ângulo de " + data.getAngle() + " graus e com um raio de "
				+ data.getRadius() + " centímetros.\n");
	}
	
	public void getBuffer() {
		buffer.get().doMovement();
	}

	public void startRandomMovements() {
		randomMovements.setActionNumber(data.getActionNumber());
		randomMovements.setWorking(true);
	}

	public void stopRandomMovements() {
		randomMovements.setWorking(false);
	}

	public void stopMovement() {
		robot.Parar(true);
		log("O robô parou.\n");
	}
	
	public void stopMovementSync() {
		robot.Parar(false);
	}

	public int getDelayStraightLine() {
		return data.getDelayStraightLine();
	}

	public int getDelayCurve() {
		return data.getDelayCurve();
	}

}