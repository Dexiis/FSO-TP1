
public class RobotController {

	private final Data data = new Data(0, 0, 0, 0, null);
	private final RobotLegoEV3 robot = new RobotLegoEV3();

	private final RandomMovements randomMovements = new RandomMovements(this);
	private final Thread randomMovementsThread;
	
	private ILogger logger;

	public RobotController() {
		this.randomMovementsThread = new Thread(randomMovements);
		this.randomMovementsThread.start();
	}
	
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}
	
	private void log(String message) {
		if(logger != null) {
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
		//robot.CloseEV3();
	}

	public void moveForwards() {
		robot.Reta(data.getDistance());
		robot.Parar(false);
		log("O robô andou para a frente " + data.getDistance() + " centímetros.\n");
	}

	public void moveBackwards() {
		robot.Reta(-data.getDistance());
		robot.Parar(false);
		log("O robô andou para trás " + data.getDistance() + " centímetros.\n");
	}

	public void moveRightCurve() {
		robot.CurvarDireita(data.getRadius(), data.getAngle());
		robot.Parar(false);
		log("O robô curvou à direita com um ângulo de " + data.getAngle() + " graus e com um raio de " + data.getRadius() + " centímetros.\n");
	}

	public void moveLeftCurve() {
		robot.CurvarEsquerda(data.getRadius(), data.getAngle());
		robot.Parar(false);
		log("O robô curvou à esquerda com um ângulo de " + data.getAngle() + " graus e com um raio de " + data.getRadius() + " centímetros.\n");
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
		log("O robô parou.\n");
	}

	public int getDelayStraightLine() {
		return data.getDelayStraightLine();
	}

	public int getDelayCurve() {
		return data.getDelayCurve();
	}

}